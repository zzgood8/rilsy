package com.zbx.rilsy.system.service;

import com.sun.istack.internal.NotNull;
import com.zbx.rilsy.system.entity.po.UserGroupPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户分组映射表 服务类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
public interface IUserGroupService extends IService<UserGroupPo> {

    Set<Long> getGroupIdsByUserId(Long userId);

}
