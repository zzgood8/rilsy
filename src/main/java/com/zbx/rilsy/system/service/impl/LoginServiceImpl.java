package com.zbx.rilsy.system.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbx.rilsy.common.exception.BaseException;
import com.zbx.rilsy.common.status.Status;
import com.zbx.rilsy.system.dao.*;
import com.zbx.rilsy.system.entity.form.LoginForm;
import com.zbx.rilsy.system.entity.po.CaptchaPo;
import com.zbx.rilsy.system.entity.po.UserPo;
import com.zbx.rilsy.system.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zbx
 * @date 2022/8/1
 * @describe
 **/
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    private final UserDao userDao;
    private final CaptchaDao captchaDao;

    public LoginServiceImpl(UserDao userDao,
                            CaptchaDao captchaDao) {
        this.userDao = userDao;
        this.captchaDao = captchaDao;
    }


    @Override
    public String login(LoginForm loginForm) {
        // 获取验证码
        CaptchaPo captchaPo = captchaDao.selectById(loginForm.getCaptcha_id());
        // 删除一次性验证码
        if (ObjectUtil.isNotNull(captchaPo)) captchaDao.deleteById(captchaPo);
        // 校验验证码
        if (ObjectUtil.isNull(captchaPo)
                || !StrUtil.equals(loginForm.getCaptcha(), captchaPo.getCode())
                || DateUtil.currentSeconds() >= captchaPo.getExpireTime()) {
            throw new BaseException(Status.CAPTCHA_IS_ERROR);
        }
        // 获取用户信息
        UserPo userPo = userDao.selectOne(new QueryWrapper<UserPo>().eq("username", loginForm.getUsername()));
        if (ObjectUtil.isNull(userPo)) {
            throw new BaseException(Status.USER_NOT_EXISTS);
        }
        // 校验是否锁定
        if (!userPo.getStatus()) {
            throw new BaseException(Status.USER_LOCKED);
        }
        // 验证是否封禁
        if (StpUtil.isDisable(userPo.getUsername())) {
            throw new BaseException(Status.ACCOUNT_IS_BAN);
        }
        // 校验密码
        String pass = SaSecureUtil.sha256(loginForm.getPassword());
        if (!StrUtil.equals(userPo.getPassword(), pass)) {
            UserPo fail = new UserPo();
            fail.setId(userPo.getId());
            fail.setLoginFailure(userPo.getLoginFailure() + 1);
            userDao.updateById(fail);
            throw new BaseException(Status.PASSWORD_ERROR);
        }
        // 多次失败提醒,超过5次,每次间隔5分钟
        if (userPo.getLoginFailure() > 5) {
            StpUtil.disable(userPo.getUsername(), 60 * 5); // 封禁五分钟
            log.warn("用户多次尝试登录失败,已尝试次数: {}", userPo.getLoginFailure());
        }
        // 登录成功
        try {
            StpUtil.login(userPo.getUsername());
        } catch (Exception e) {
            log.warn("登录发生异常: {}", e.getMessage());
            throw new BaseException(Status.LOGIN_FAILED);
        }
        // 记录登录信息
        UserPo success = new UserPo();
        success.setId(userPo.getId());
        success.setLoginFailure(0);
        success.setLastLoginIp(loginForm.getLoginIp());
        success.setLastLoginTime(LocalDateTime.now());
        userDao.updateById(success);
        // 返回token令牌
        log.info("用户: {} 登录成功", userPo.getUsername());
        return StpUtil.getTokenInfo().getTokenValue();
    }

    @Override
    public void logout() {
        if (StpUtil.isLogin()) {
            log.info("用户: {} 登出", StpUtil.getLoginIdAsString());
            StpUtil.logout();
        }
    }

    @Override
    public void generateCaptcha(String uuid, OutputStream out) {
        // 查询key是否存在,存在则删除
        CaptchaPo captchaPo = captchaDao.selectById(uuid);
        if (ObjectUtil.isNotNull(captchaPo)) {
            captchaDao.deleteById(captchaPo.getKey());
        }
        // 生成验证码
        GifCaptcha gifCaptcha = CaptchaUtil.createGifCaptcha(176,55);
        String code = gifCaptcha.getCode();
        // 保存验证码
        CaptchaPo captcha = new CaptchaPo();
        captcha.setKey(uuid);
        captcha.setCode(code);
        captcha.setCreateTime(DateUtil.currentSeconds());
        captcha.setExpireTime(DateUtil.offsetMinute(new Date(), 5).getTime()/1000); // 过期时间5分钟
        captchaDao.insert(captcha);
        // 写入验证码图片
        gifCaptcha.write(out);
    }

}
