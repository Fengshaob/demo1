package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sfx_web_role")
public class RoleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 描述
     */
    @TableField("role_desp")
    private String roleDesp;

    /**
     * 状态:ENABLE启用，DISABLE禁用
     */
    @TableField("status")
    private String status;


    public static final String ID = "id";

    public static final String CREATE_TIME = "create_time";

    public static final String ROLE_NAME = "role_name";

    public static final String ROLE_DESP = "role_desp";

    public static final String STATUS = "status";

}
