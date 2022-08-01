package com.zbx.rilsy.system.api;

import cn.hutool.core.util.StrUtil;
import com.zbx.rilsy.common.res.Result;
import com.zbx.rilsy.system.entity.form.LoginForm;
import com.zbx.rilsy.system.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author zbx
 * @date 2022/8/1
 * @describe
 **/
@RestController
@Slf4j
@Validated
public class LoginController {

    private final ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    // 登录
    @PostMapping("/login")
    public Result<String> login(@Validated @RequestBody LoginForm loginForm, HttpServletRequest request) {
        loginForm.setLoginIp(request.getRemoteAddr());
        String token = loginService.login(loginForm);
        return Result.success(token);
    }

    // 登出
    @PostMapping("/logout")
    public Result<String> logout() {
        loginService.logout();
        return Result.success("logout success");
    }

    // 获取验证码
    @GetMapping("/captcha")
    public void generateCaptcha(@NotNull(message = "验证码id不能为空") String uuid,
                                HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            loginService.generateCaptcha(uuid, outputStream);
            outputStream.close();
        }catch (IOException e) {
            log.warn("发生异常：{}", e.getMessage());
        }
    }

    // 登录信息,菜单权限

}
