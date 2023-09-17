package com.dp.decorative;


public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes("都将");
        setPrice(1.5f);
    }
}
