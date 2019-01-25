package com.Flower;

public class Chamomile extends Flower {
    private int price  = 70;
    public Chamomile() {
        super("Chamomile");
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
