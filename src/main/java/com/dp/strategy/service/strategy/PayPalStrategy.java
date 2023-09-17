package com.dp.strategy.service.strategy;

import com.dp.strategy.PayStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 描述: PayPal支付策略类
 *
 * @date 2023/9/17 15:15
 * @author caozp
 */
@Service
public class PayPalStrategy implements PayStrategy {
    @Override
    public String pay(BigDecimal amount) {
        return "使用PayPal支付了" + amount + "元";
    }
}
