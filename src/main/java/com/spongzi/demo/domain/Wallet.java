package com.spongzi.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName wallet
 */
@TableName(value ="wallet")
@Data
public class Wallet implements Serializable {
    /**
     * 钱包id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 余额
     */
    @TableField(value = "balance")
    private BigDecimal balance;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}