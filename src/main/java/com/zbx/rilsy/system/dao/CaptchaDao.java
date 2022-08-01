package com.zbx.rilsy.system.dao;

import com.zbx.rilsy.system.entity.po.CaptchaPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 验证码表 Mapper 接口
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Mapper
public interface CaptchaDao extends BaseMapper<CaptchaPo> {

}
