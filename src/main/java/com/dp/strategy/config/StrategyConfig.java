package com.dp.strategy.config;

import com.dp.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class StrategyConfig {

    @Qualifier("alipayPayStrategy")
    @Autowired
    private PayStrategy alipayPayStrategy;

    @Qualifier("weChatPayStrategy")
    @Autowired
    private PayStrategy weChatPayStrategy;

    @Qualifier("unionPayPayStrategy")
    @Autowired
    private PayStrategy unionPayPayStrategy;

    @Qualifier("payPalStrategy")
    @Autowired
    private PayStrategy payPalStrategy;

    private Map<String, PayStrategy> selectors = new HashMap<String, PayStrategy>();

    @PostConstruct
    public void init() {
        selectors.put("ALIPAY", alipayPayStrategy);
        selectors.put("WECHAT", weChatPayStrategy);
        selectors.put("UNIONPAY", unionPayPayStrategy);
        selectors.put("PAYPAL", payPalStrategy);
    }

    public PayStrategy getInstanceByType(String code) {
        return selectors.get(code);
    }
}
