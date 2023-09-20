package com.dp.delegate.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.dp.delegate.pay.PayProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 通过委派模式，定义一个支付控制器，用于接收支付请求
 */
@RestController
public class Pay2Controller {
    @GetMapping("/pay2")
    public String pay(@RequestParam String type, @RequestParam BigDecimal amount) {
        PayProxy payProxy = new PayProxy(SpringUtil.getBean(type));
        return payProxy.pay(amount);
    }
}
