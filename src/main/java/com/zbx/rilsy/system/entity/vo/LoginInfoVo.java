package com.zbx.rilsy.system.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @日期 2022/8/1
 * @作者 zbx
 * @描述
 */
@Data
public class LoginInfoVo {

    private Long id;
    private String username;
    private String nickname;
    private String avatar;

}
