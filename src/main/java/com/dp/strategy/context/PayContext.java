package com.dp.strategy.context;

import com.dp.strategy.PayStrategy;

import java.math.BigDecimal;

/**
 * 描述: 环境类，持有一个策略对象的引用，并根据不同的情况选择不同的策略执行
 *
 * @date 2023/9/17 14:56
 * @author caozp
 */
public class PayContext {

    /**
     * 申明一个私有的策略对象
     */
    private PayStrategy strategy;

    /**
     * 持有一个具体的策略对象
     */
    public PayContext(PayStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 定义一个方法，用于执行策略对象的算法
     * @param amount
     * @return
     */
    public String pay(BigDecimal amount) {
        return strategy.pay(amount);
    }
}
