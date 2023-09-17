package com.dp.adapterd.adapter;

/**
 * 描述: 支付适配器接口
 */
public interface PayAdapter {
    /**
     * 判断是否支持该支付方式
     * @param adapter
     * @return
     */
    boolean support(String adapter);

    String pay(String id, double amount, String adapter);
}
