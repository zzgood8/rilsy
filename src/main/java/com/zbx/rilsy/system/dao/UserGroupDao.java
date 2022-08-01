package com.zbx.rilsy.system.dao;

import com.zbx.rilsy.system.entity.po.UserGroupPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户分组映射表 Mapper 接口
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Mapper
public interface UserGroupDao extends BaseMapper<UserGroupPo> {

}
