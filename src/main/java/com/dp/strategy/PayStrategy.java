package com.dp.strategy;

import java.math.BigDecimal;

/**
 * 抽象策略类，定义了一个公共的接口，用于封装不同的算法
 */
public interface PayStrategy {

    /**
     * 描述: 定义一个方法，用于执行具体的支付操作
     * @date 2023/9/17 18:11
     * @author caozp
     * @param amount
     * @return java.lang.String
     */
    public String pay(BigDecimal amount);

}
