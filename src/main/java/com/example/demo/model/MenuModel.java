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
@TableName("sfx_web_menu")
public class MenuModel implements Serializable {

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
    @TableField("menu_name")
    private String menuName;

    /**
     * 编码
     */
    @TableField("menu_code")
    private String menuCode;

    /**
     * 上级菜单id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 链接
     */
    @TableField("link_address")
    private String linkAddress;

    /**
     * 层级
     */
    @TableField("level")
    private Integer level;

    /**
     * 是否菜单
     */
    @TableField("is_menu")
    private String isMenu;

    /**
     * 顺序
     */
    @TableField("order_number")
    private Integer orderNumber;

    /**
     * 状态:enable启用，disable禁用
     */
    @TableField("status")
    private String status;


    public static final String ID = "id";

    public static final String CREATE_TIME = "create_time";

    public static final String MENU_NAME = "menu_name";

    public static final String MENU_CODE = "menu_code";

    public static final String PARENT_ID = "parent_id";

    public static final String LINK_ADDRESS = "link_address";

    public static final String LEVEL = "level";

    public static final String IS_MENU = "is_menu";

    public static final String ORDER_NUMBER = "order_number";

    public static final String STATUS = "status";

}
