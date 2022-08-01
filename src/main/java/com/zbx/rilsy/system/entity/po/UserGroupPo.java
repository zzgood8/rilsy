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
 * 用户分组映射表
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Getter
@Setter
  @TableName("system_user_group")
public class UserGroupPo implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 用户id
     */
      @TableField("user_id")
    private Long userId;

      /**
     * 分组id
     */
      @TableField("group_id")
    private Long groupId;

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


}
