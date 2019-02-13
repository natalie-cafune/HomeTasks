package com.StoreFruit;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store {
    private static Gson gson = new Gson();
    private ArrayList<Fruit> storehouse = new ArrayList<Fruit>();

    // saves all deliveries
    public void save(String pathToJsonFile) throws IOException {
        FileWriter fileWriter = new FileWriter(pathToJsonFile);
        fileWriter.write(gson.toJson((Store.this).getFruits()));
        fileWriter.close();
    }

    // delete the current information from the warehouse and load the new one
    public void load(String pathToJsonFile) throws IOException {
        ArrayList<Fruit> arrayListFruit = new ArrayList<Fruit>();
        arrayListFruit.addAll(storehouse);
        storehouse.clear();
        setArrayList(arrayListFruit);
        addFruits(pathToJsonFile);
    }

    // adds delivery from json file
    public void addFruits(String pathToJsonFile) throws IOException {
        FileReader fileReader = new FileReader(pathToJsonFile);
        storehouse.addAll(gson.fromJson(fileReader, Store.class).getFruits());
        fileReader.close();
    }

    // returns warehouse
    public ArrayList<Fruit> getFruits() {
        return storehouse;
    }

    // returns the spoiled fruit to the specified date
    public List<Fruit> getSpoiled(Date date) {

        List<Fruit> list = new ArrayList<Fruit>();
        Date expirationDate = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            expirationDate.setTime(this.storehouse.get(i).getExpirationDate());
            if (date.after(expirationDate)) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    // returns a list of ready-to-sell products to the specified date
    public List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> list = new ArrayList<Fruit>();
        Date expirationDate = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            expirationDate.setTime(this.storehouse.get(i).getExpirationDate());
            if (date.before(expirationDate)) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    // returns the products that were delivered to the specified date
    public List<Fruit> getAddedFruits(Date date) {
        List<Fruit> list = new ArrayList<Fruit>();
        long longDelivery = date.getTime();
        Date dateOfDelivery = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            dateOfDelivery.setTime(this.storehouse.get(i).getDateOfDelivery());
            if (longDelivery == this.storehouse.get(i).getDateOfDelivery()) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    // returns the spoiled fruit to the specified type and date
    public List<Fruit> getSpoiledFruits(Date date, FruitType fruitType) {
        List<Fruit> list = new ArrayList<Fruit>();
        Date expirationDate = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            expirationDate.setTime(this.storehouse.get(i).getExpirationDate());
            if ((date.after(expirationDate)) && fruitType.equals(storehouse.get(i).getFruitType())) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    // returns a list of ready-to-sell products to the specified type and date
    public List<Fruit> getAvailableFruits(Date date, FruitType fruitType) {
        List<Fruit> list = new ArrayList<Fruit>();
        Date expirationDate = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            expirationDate.setTime(this.storehouse.get(i).getExpirationDate());
            if ((date.before(expirationDate)) && (fruitType.equals(storehouse.get(i).getFruitType()))) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    // returns the products that were delivered to the specified type and date
    public List<Fruit> getAddedFruits(Date date, FruitType fruitType) {
        List<Fruit> list = new ArrayList<Fruit>();
        long longDelivery = date.getTime();
        Date dateOfDelivery = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            dateOfDelivery.setTime(this.storehouse.get(i).getDateOfDelivery());
            if ((longDelivery == this.storehouse.get(i).getDateOfDelivery()) &&
                    (fruitType.equals(storehouse.get(i).getFruitType()))) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    public void setArrayList(ArrayList<Fruit> arrayList) {
        this.storehouse = arrayList;
    }

    // adds fruit to the leaf
    public void addFruit(Fruit fruit) {
        storehouse.add(fruit);
    }

}
