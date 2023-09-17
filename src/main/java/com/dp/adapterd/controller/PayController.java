package com.dp.adapterd.controller;

import com.dp.adapterd.service.PayForThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayForThirdService payForThirdService;

    /**
     * 通过适配器模式实现支付
     * 支付方法，接收用户id, 支付金额和支付方式
     * type: APLIPAY   WECHAT
     * @param id
     * @param amount
     * @param type
     * @return
     */
    @PostMapping("/payForThird")
    public ResponseEntity<String> payForThird(@RequestParam String id, @RequestParam BigDecimal amount, @RequestParam String type) {
        return ResponseEntity.ok(payForThirdService.payForThird(id, amount, type));
    }
}
