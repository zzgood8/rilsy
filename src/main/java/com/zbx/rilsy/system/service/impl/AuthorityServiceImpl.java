package com.zbx.rilsy.system.service.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbx.rilsy.system.entity.po.AuthorityPo;
import com.zbx.rilsy.system.dao.AuthorityDao;
import com.zbx.rilsy.system.entity.vo.MenuRouteVo;
import com.zbx.rilsy.system.service.IAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityDao, AuthorityPo> implements IAuthorityService {

    @Override
    public List<MenuRouteVo> getMenuRouteByAuthIds(Set<Long> authorityIds) {
        List<MenuRouteVo> menu = getAllMenuRouterTree(0L);
        return getMenuByIds(menu, authorityIds);
    }

    // 从给定树返回匹配的权限树
    public List<MenuRouteVo> getMenuByIds(List<MenuRouteVo> menu, Set<Long> authorityIds) {
        List<MenuRouteVo> temp = new ArrayList<>();
        menu.forEach(item -> {
           if (item.getChildren().size() > 0) {
               List<MenuRouteVo> res = getMenuByIds(item.getChildren(), authorityIds);
               if (res.size() > 0) {
                   item.setChildren(res);
                   temp.add(item);
               }
           } else {
               boolean b = authorityIds.contains(item.getId());
               if (b) temp.add(item);
           }
        });
        return temp;
    }

    // 获取指定层级及以下的MenuRoute树
    public List<MenuRouteVo> getAllMenuRouterTree(Long pid) {
        List<AuthorityPo> root = this.list(new QueryWrapper<AuthorityPo>().eq("pid", pid));
        List<MenuRouteVo> menuRouteList = new ArrayList<>();
        root.forEach(item -> {
            MenuRouteVo menuRoute = MenuRouteVo.setByAuthority(item);
            menuRoute.setChildren(getAllMenuRouterTree(menuRoute.getId()));
            menuRouteList.add(menuRoute);
        });
        return menuRouteList;
    }
}
