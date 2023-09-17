package com.dp.strategy.controller;

import com.dp.strategy.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/strategy")
public class StrategyController {

    // 策略模式是一种行为型设计模式，它定义了一系列的算法，并将它们封装起来，使它们可以相互善换，而不影响客户端的便用。
    // 策略模式的主要角色有三个：环境类（Context），抽索策略类（Strategy）机具体策略类（ConcreteStrategy）。
    // 环境类持有一个策略矿象的引用，那根据不同的情况迷择不同的袋略执行。
    // 抽象策略类定义了一个公共的接口，用于封装不同的算法。具体策略类实现了抽象策略类的接口，并提供具体的算法实现。

    @Autowired
    private PayService payService;

    /**
     * 描述: 支付方式 （WECHAT-微信 ALIPAY-支付宝 UNIONPAY-銀联 PAYPAL-PayPal）
     * @date 2023/9/17 17:50
     * @author caozp
     * @param amout
     * @param type
     */
    @GetMapping("/pay")
    public ResponseEntity<String> pay(@RequestParam("amout") BigDecimal amout, @RequestParam("type") String type) {
        return ResponseEntity.ok(payService.pay(amout, type));
    }
}
