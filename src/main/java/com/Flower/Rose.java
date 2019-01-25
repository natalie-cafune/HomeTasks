package com.Flower;

public class Rose extends Flower {
    private int price  = 100;

    public int getPrice() {
        return price;
    }

    public Rose () {

        super("Rose");
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
