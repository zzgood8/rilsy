package com.zbx.rilsy.system.service;

import com.zbx.rilsy.system.entity.po.UserPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
public interface IUserService extends IService<UserPo> {

    List<String> getAuthPathByUsername(String username);
}
