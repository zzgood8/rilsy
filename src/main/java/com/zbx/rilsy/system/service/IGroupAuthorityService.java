package com.zbx.rilsy.system.service;

import com.zbx.rilsy.system.entity.po.GroupAuthorityPo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 分组权限映射表 服务类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
public interface IGroupAuthorityService extends IService<GroupAuthorityPo> {

    Set<Long> getAuthorityIdsByGroupIds(Set<Long> groupIds);
}
