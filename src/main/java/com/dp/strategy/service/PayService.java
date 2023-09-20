package com.dp.strategy.service;

import com.dp.strategy.PayStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 描述: 环境类，持有一个策略对象的引用，并根据不同的情况选择不同的策略执行
 *
 * @date 2023/9/17 14:56
 * @author abu
 */
@Service
public class PayService {

    /**
     * 策略对象
     */
    private PayStrategy strategy;

    /**
     * 定义一个方法，用于执行策略对象的算法
     * @param amount
     * @return
     */
    public String pay(BigDecimal amount) {
        return strategy.pay(amount);
    }

    public void setStrategy(PayStrategy strategy) {
        this.strategy = strategy;
    }
}
