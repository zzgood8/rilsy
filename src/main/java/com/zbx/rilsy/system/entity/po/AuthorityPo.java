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
 * 权限表
 * </p>
 *
 * @author zbx
 * @since 2022-08-01
 */
@Getter
@Setter
  @TableName("system_authority")
public class AuthorityPo implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * id
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 父id
     */
      @TableField("pid")
    private Long pid;

      /**
     * 权限名称
     */
      @TableField("title")
    private String title;

      /**
     * 权限路径
     */
      @TableField("path")
    private String path;

      /**
     * 图标
     */
      @TableField("icon")
    private String icon;

      /**
     * 权限类型
     */
      @TableField("type")
    private String type;

      /**
     * 视图组件
     */
      @TableField("component")
    private String component;

      /**
     * 菜单类型:tab=标准菜单,link=外部链接,3=内嵌iframe
     */
      @TableField("menu_type")
    private String menuType;

      /**
     * 权重(排序)
     */
      @TableField("weigh")
    private Integer weigh;

      /**
     * 备注
     */
      @TableField("remark")
    private String remark;

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
