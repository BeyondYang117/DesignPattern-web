package com.dp.delegate.pay;

import java.math.BigDecimal;

/**
 * 定义一个支付代理类，持有一个支付接口的引用
 */
public class PayProxy {

    private Pay pay;

    /**
     * 构造方法，传入一个支付接口的实现类
     * @param pay
     */
    public PayProxy(Pay pay) {
        this.pay = pay;
    }

    /**
     * 代理类实现支付接口的方法
     * @param amount
     */
    public String pay(BigDecimal amount) {
        // 1、判断权限
        // 2、执行逻辑
        return pay.pay(amount);
        // 3、记录日志
    }
}
