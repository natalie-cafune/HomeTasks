package com.StoreFruit;

public class Fruit {

    private FruitType fruitType;
    private long expirationDate; //срок годности
    private long dateOfDelivery; //дата поставки
    private int price;

    public Fruit(FruitType fruitType, long expirationDate, long dateOfDelivery, int price) {
        this.fruitType = fruitType;
        this.expirationDate = expirationDate;
        this.dateOfDelivery = dateOfDelivery;
        this.price = price;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getDateOfDelivery() {
        return dateOfDelivery;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}





