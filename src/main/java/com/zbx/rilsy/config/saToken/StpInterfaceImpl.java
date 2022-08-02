package com.zbx.rilsy.config.saToken;

import cn.dev33.satoken.stp.StpInterface;
import com.zbx.rilsy.system.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbx
 * @date 2022/8/2
 * @describe
 **/
@Component
public class StpInterfaceImpl implements StpInterface {

    private final IUserService userService;

    public StpInterfaceImpl(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        String username = (String) loginId;
        return userService.getAuthPathByUsername(username);
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }

}
