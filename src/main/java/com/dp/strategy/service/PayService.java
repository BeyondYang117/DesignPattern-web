package com.dp.strategy.service;

import com.dp.strategy.PayStrategy;
import com.dp.strategy.config.StrategyConfig;
import com.dp.strategy.context.PayContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 描述: 环境类，持有一个策略对象的引用，并根据不同的情况选择不同的策略执行
 *
 * @date 2023/9/17 14:56
 * @author caozp
 */
@Service
public class PayService {

    @Autowired
    private StrategyConfig strategyConfig;

    /**
     * 定义一个方法，用于执行策略对象的算法
     * @param amount
     * @return
     */
    public String pay(BigDecimal amount, String type) {
        // 根据支付方式获取对应的策略对象
        PayStrategy strategy = strategyConfig.getInstanceByType(type);
        PayContext payUtil = new PayContext(strategy);
        return payUtil.pay(amount);
    }
}
