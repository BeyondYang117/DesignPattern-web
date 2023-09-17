package com.dp.decorative;

public class CoffeeBar {

    public static void main(String[] args) {
        //点一份LonBlack
        Drink longBlack = new LongBlack();
        System.out.println(longBlack.cost());
        System.out.println(longBlack.getDes());
        //2 加入牛奶
        Milk milk = new Milk(longBlack);
        System.out.println(milk.cost());
        System.out.println(milk.getDes());

    }
}
