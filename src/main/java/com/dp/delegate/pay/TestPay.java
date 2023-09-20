package com.dp.delegate.pay;

import com.dp.delegate.pay.impl.Alipay;
import com.dp.delegate.pay.impl.WeChatPay;

import java.math.BigDecimal;

/**
 * 描述:
 * 委派模式是一种特味的静态代理，可以理解为全权代理。委派模式的基本作用是负责任务的调用和分配任务，
 * 将任务的分配和执行分离开来。委派模式解于行为型模式，不是GOF 23种设计模式之一。
 * 有些人认为委派模式是代理模式和策略模式的组合，因为它们都可以在运行时切换不同的对象或算法，但代理模式注重过程，而策略模式注重结果。
 * 委派模式也可以看作是一种使用了委托技术的策略模式。因为它们都可以通过聚合来替代继承，实现代码的复用和解藕。
 * @date 2023/9/20 17:01
 * @author abu
 */
public class TestPay {
    public static void main(String[] args) {
        PayProxy weChatPayProxy = new PayProxy(new WeChatPay());
        System.out.println(weChatPayProxy.pay(new BigDecimal(100)));
        PayProxy aliPayProxy = new PayProxy(new Alipay());
        System.out.println(aliPayProxy.pay(new BigDecimal(200)));
    }
}
