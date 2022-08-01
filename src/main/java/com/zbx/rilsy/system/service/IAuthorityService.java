package com.zbx.rilsy.system.service;

import com.zbx.rilsy.system.entity.po.AuthorityPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbx.rilsy.system.entity.vo.MenuRouteVo;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
public interface IAuthorityService extends IService<AuthorityPo> {

    List<MenuRouteVo> getMenuRouteByAuthIds(Set<Long> authorityIds);

}
