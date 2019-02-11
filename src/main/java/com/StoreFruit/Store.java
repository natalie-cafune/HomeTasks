package com.StoreFruit;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store {
    private static Gson gson = new Gson();

    private ArrayList<Fruit> storehouse = new ArrayList<Fruit>();

    public void load(String pathToJsonFile) throws IOException {
        storehouse.clear();
        addFruits(pathToJsonFile);
    }

    // сохраняет все поставки
    public void save(String pathToJsonFile) throws IOException {
        FileWriter fileWriter = new FileWriter(pathToJsonFile);
        fileWriter.write(gson.toJson((Store.this).storehouse));
        fileWriter.close();

    }

    // добавляет поставку из формата json
    public void addFruits(String pathToJsonFile) throws IOException {
        FileReader fileReader = new FileReader(pathToJsonFile);
        storehouse.addAll(gson.fromJson(fileReader, Store.class).getFruits());
        fileReader.close();
    }

    // возвращает склад
    public ArrayList<Fruit> getFruits() {
        return storehouse;
    }

    // возвращает испорченные фрукты к заданной дате
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

    public List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> list = new ArrayList<Fruit>();

        Date expirationDate = new Date();
        Date dateOfDelivery = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            expirationDate.setTime(this.storehouse.get(i).getExpirationDate());
            dateOfDelivery.setTime(this.storehouse.get(i).getDateOfDelivery());
            if (date.before(expirationDate)) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    public List<Fruit> getAddedFruits(Date date) {
        List<Fruit> list = new ArrayList<Fruit>();

        long longDelivery = date.getTime();
        Date expirationDate = new Date();
        Date dateOfDelivery = new Date();
        for (int i = 0; i < storehouse.size(); i++) {
            expirationDate.setTime(this.storehouse.get(i).getExpirationDate());
            dateOfDelivery.setTime(this.storehouse.get(i).getDateOfDelivery());
            if (longDelivery == this.storehouse.get(i).getDateOfDelivery()) {
                list.add(storehouse.get(i));
            }
        }
        return list;
    }

    /* public Date getDate() {
        simpleDateFormat.format(date);
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        simpleDateFormat.format(date);
    }
*/
    public void setArrayList(ArrayList<Fruit> arrayList) {
        this.storehouse = arrayList;
    }


    public void addFruit(Fruit fruit) {
        storehouse.add(fruit);
    }

}
