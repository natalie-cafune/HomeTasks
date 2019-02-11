package com.StoreFruit;

// проверить метод addFruits . Не перезаписывает.
// также проверить методы save и load
// добавить методы с типом фрукта

import com.alibaba.fastjson.JSON;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        Calendar cDel = new GregorianCalendar(2018, 11, 22);

        Store store = new Store();
        Date dateDelivery = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-22");

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-11");
        Date dateExperation = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-04");
        Date dateExperation1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-20");
        Date dateExperation2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-15");
        Date dateExperation3 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-10");


        Fruit kiwi = new Fruit(FruitType.KIWI, dateExperation.getTime(), cDel.getTime().getTime(), 30);
        Fruit apple = new Fruit(FruitType.APPLE, dateExperation1.getTime(), cDel.getTime().getTime(), 45);
        Fruit apricot = new Fruit(FruitType.APRICOT, dateExperation2.getTime(), cDel.getTime().getTime(), 50);
        Fruit banana = new Fruit(FruitType.BANANA, dateExperation3.getTime(), cDel.getTime().getTime(), 22);

        store.addFruit(kiwi);
        store.addFruit(apple);
        store.addFruit(apricot);
        store.addFruit(banana);
        String jsString = JSON.toJSONString(store);

        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        byte[] bytes = jsString.getBytes();
        fileOutputStream.write(bytes);
        store.addFruits("First.json");
        store.addFruits("Second.json");
        //store.save("Store.json");
        //store.load("First.json");

        System.out.println(store.getAddedFruits(dateDelivery));
        System.out.println(store.getSpoiled(date));
        System.out.println(store.getAvailableFruits(date));

        store.save("B.json");

    }
}
