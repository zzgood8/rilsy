package com.zbx.rilsy.system.dao;

import com.zbx.rilsy.system.entity.po.UserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Mapper
public interface UserDao extends BaseMapper<UserPo> {

}
