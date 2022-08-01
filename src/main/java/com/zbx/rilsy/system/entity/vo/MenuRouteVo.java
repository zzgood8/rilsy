package com.zbx.rilsy.system.entity.vo;

import com.zbx.rilsy.system.entity.po.AuthorityPo;
import lombok.Data;

import java.util.List;

/**
 * @日期 2022/8/1
 * @作者 zbx
 * @描述
 */
@Data
public class MenuRouteVo {

    private Long id;
    private Long pid;
    private String title;
    private String path;
    private String icon;
    private String type;
    private String component;
    private String menuType;
    private List<MenuRouteVo> children;

    public static MenuRouteVo setByAuthority(AuthorityPo authority) {
        MenuRouteVo menuRoute = new MenuRouteVo();
        menuRoute.setId(authority.getId());
        menuRoute.setPid(authority.getPid());
        menuRoute.setTitle(authority.getTitle());
        menuRoute.setPath(authority.getPath());
        menuRoute.setIcon(authority.getIcon());
        menuRoute.setType(authority.getType());
        menuRoute.setComponent(authority.getComponent());
        menuRoute.setMenuType(authority.getMenuType());
        return menuRoute;
    }

}
