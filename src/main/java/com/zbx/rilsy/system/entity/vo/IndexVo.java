package com.zbx.rilsy.system.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @日期 2022/8/1
 * @作者 zbx
 * @描述
 */
@Data
public class IndexVo {

    private LoginInfoVo loginInfo;

    private List<MenuRouteVo> menuRoute;

}
