package com.dp.adapterd.adapter.impl;

import com.dp.adapterd.adapter.PayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 描述: 微信支付的适配器
 */
@Component("WECHAT")
public class PayForWechatAdapter implements PayAdapter {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public boolean support(String adapter) {
        return applicationContext.getBean(adapter) instanceof PayForWechatAdapter;
    }

    @Override
    public String pay(String id, double amount, String adapter) {
        // 调用微信支付的API
        // 。。。。
        // 返回支付结果
        return "使用微信支付 " + amount + "元";
    }
}
