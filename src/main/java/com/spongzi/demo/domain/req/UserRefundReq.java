package com.spongzi.demo.domain.req;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户退款请求参数
 *
 * @author spongzi
 * @date 2023/08/11
 */
@Data
public class UserRefundReq {
    private Integer userId;

    private String amount;
}
