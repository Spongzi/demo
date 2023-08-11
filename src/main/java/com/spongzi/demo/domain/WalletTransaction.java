package com.spongzi.demo.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName wallet_transaction
 */
@TableName(value ="wallet_transaction")
@Data
public class WalletTransaction implements Serializable {
    /**
     * 钱包转账交易id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 交易类型
     * 1 代表交易
     * 2 代表退款
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private LocalDateTime createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}