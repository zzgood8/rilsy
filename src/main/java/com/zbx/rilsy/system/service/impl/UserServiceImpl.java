package com.zbx.rilsy.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import com.zbx.rilsy.system.entity.po.UserPo;
import com.zbx.rilsy.system.dao.UserDao;
import com.zbx.rilsy.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserPo> implements IUserService {

    @Override
    public List<String> getAuthPathByUsername(String username) {
        List<String> list = this.baseMapper.selectAuthPathByUsername(username);
        if (CollectionUtil.isEmpty(list)) return ListUtil.empty();
        return list;
    }
}
