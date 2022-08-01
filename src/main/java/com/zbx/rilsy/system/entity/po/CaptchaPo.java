package com.zbx.rilsy.system.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 验证码表
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Getter
@Setter
  @TableName("system_captcha")
public class CaptchaPo implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 验证码Key
     */
        @TableId("`key`")
      private String key;

      /**
     * 验证码(加密后的,用于验证)
     */
      @TableField("`code`")
    private String code;

      /**
     * 创建时间
     */
        @TableField(value = "create_time", fill = FieldFill.INSERT)
      private Long createTime;

      /**
     * 过期时间
     */
      @TableField("expire_time")
    private Long expireTime;


}
