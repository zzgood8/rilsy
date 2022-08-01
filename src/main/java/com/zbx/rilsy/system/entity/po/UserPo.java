package com.zbx.rilsy.system.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Getter
@Setter
  @TableName("system_user")
public class UserPo implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 用户名
     */
      @TableField("username")
    private String username;

      /**
     * 昵称
     */
      @TableField("nickname")
    private String nickname;

      /**
     * 头像
     */
      @TableField("avatar")
    private String avatar;

      /**
     * 邮箱
     */
      @TableField("email")
    private String email;

      /**
     * 手机
     */
      @TableField("mobile")
    private String mobile;

      /**
     * 登录失败次数
     */
      @TableField("login_failure")
    private Integer loginFailure;

      /**
     * 登录时间
     */
      @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

      /**
     * 登录IP
     */
      @TableField("last_login_ip")
    private String lastLoginIp;

      /**
     * 密码
     */
      @TableField("password")
    private String password;

      /**
     * 签名
     */
      @TableField("motto")
    private String motto;

      /**
     * 创建时间
     */
        @TableField(value = "create_time", fill = FieldFill.INSERT)
      private LocalDateTime createTime;

      /**
     * 创建人
     */
        @TableField(value = "create_by", fill = FieldFill.INSERT)
      private String createBy;

      /**
     * 更新时间
     */
        @TableField(value = "update_time", fill = FieldFill.UPDATE)
      private LocalDateTime updateTime;

      /**
     * 更新人
     */
        @TableField(value = "update_by", fill = FieldFill.UPDATE)
      private LocalDateTime updateBy;

      /**
     * 状态:0=禁用,1=启用
     */
      @TableField("status")
    private Boolean status;


}
