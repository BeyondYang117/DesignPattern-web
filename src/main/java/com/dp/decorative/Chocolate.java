package com.dp.decorative;

//调味品
public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes("chocolate");
        setPrice(3.0f); //调味品价格
    }
}
