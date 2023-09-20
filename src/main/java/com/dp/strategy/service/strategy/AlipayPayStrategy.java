package com.dp.strategy.service.strategy;

import com.dp.strategy.PayStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 描述: 支付宝支付策略类
 *
 * @date 2023/9/17 15:15
 * @author caozp
 */
@Service("ALIPAY2")
public class AlipayPayStrategy implements PayStrategy {

        @Override
        public String pay(BigDecimal amount) {
            return "使用支付宝支付了" + amount + "元";
        }
}
