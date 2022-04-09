package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 冯邵兵
 * @since 2022-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sfx_user_info")
public class UserInfoModel implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId("id")
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("modify_time")
    private Date modifyTime;

    /**
     * 用户类型：user用户、merchant特约商户
     */
    @TableField("user_type")
    private String userType;

    /**
     * 交易核心用户ID
     */
    @TableField("tx_user_id")
    private String txUserId;

    /**
     * 来源类型:fx，collection
     */
    @TableField("source_type")
    private String sourceType;

    /**
     * 来源用户id
     */
    @TableField("user_id_in3rd_sys")
    private String userIdIn3rdSys;

    /**
     * 商户号
     */
    @TableField("merchant_id")
    private String merchantId;

    /**
     * 状态:ENABLE启用，DISABLE禁用
     */
    @TableField("status")
    private String status;

    /**
     * 签约状态:NOSIGN 未签约, HAVESIGN 已经签约
     */
    @TableField("contract_status")
    private String contractStatus;

    /**
     * 支付密码，加密存储
     */
    @TableField("pay_password")
    private String payPassword;


    public static final String ID = "id";

    public static final String CREATE_TIME = "create_time";

    public static final String MODIFY_TIME = "modify_time";

    public static final String USER_TYPE = "user_type";

    public static final String TX_USER_ID = "tx_user_id";

    public static final String SOURCE_TYPE = "source_type";

    public static final String USER_ID_IN3RD_SYS = "user_id_in3rd_sys";

    public static final String MERCHANT_ID = "merchant_id";

    public static final String STATUS = "status";

    public static final String CONTRACT_STATUS = "contract_status";

    public static final String PAY_PASSWORD = "pay_password";

}
