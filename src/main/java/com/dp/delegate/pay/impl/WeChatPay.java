package com.dp.delegate.pay.impl;

import com.dp.delegate.pay.Pay;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("WECHATPAY")
@Scope("prototype")
public class WeChatPay implements Pay {
    @Override
    public String pay(BigDecimal amount) {
        return "使用微信支付了" + amount + "元";
    }
}
