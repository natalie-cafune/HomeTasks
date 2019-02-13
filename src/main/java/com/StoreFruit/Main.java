package com.StoreFruit;

import com.alibaba.fastjson.JSON;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {

        Store store = new Store();
        Store storeOne = new Store();

        Date dateDelivery = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-22");
        Date dateSpec = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-11");
        Date dateExperationOne = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-04");
        Date dateExperationTwo = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-20");
        Date dateExperationThree = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-15");
        Date dateExperationFour = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-10");
        Date dateExperationFive = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-31");


        Fruit kiwi = new Fruit(FruitType.KIWI, dateExperationOne.getTime(), dateDelivery.getTime(), 30);
        Fruit apple = new Fruit(FruitType.APPLE, dateExperationTwo.getTime(), dateDelivery.getTime(), 45);
        Fruit apricot = new Fruit(FruitType.APRICOT, dateExperationThree.getTime(), dateDelivery.getTime(), 50);
        Fruit banana = new Fruit(FruitType.BANANA, dateExperationFour.getTime(), dateDelivery.getTime(), 22);
        Fruit lime = new Fruit(FruitType.LIME, dateExperationFive.getTime(), dateDelivery.getTime(), 65);

        store.addFruit(kiwi);
        store.addFruit(apple);
        store.addFruit(apricot);
        store.addFruit(banana);
        storeOne.addFruit(lime);
        storeOne.addFruit(lime);

        String jsString = JSON.toJSONString(store);
        String jsStr = JSON.toJSONString(storeOne);

        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        byte[] bytes = jsString.getBytes();
        fileOutputStream.write(bytes);
        bytes = jsStr.getBytes();
        fileOutputStream.write(bytes);


        store.addFruits("FirstDel.json");
        storeOne.addFruits("SecondDel.json");
        System.out.println(store.getFruits());
        store.save("Store.json");
        store.load("FirstDel.json");

        System.out.println(store.getAddedFruits(dateDelivery));
        System.out.println(store.getSpoiled(dateSpec));
        System.out.println(store.getAvailableFruits(dateSpec));
    }
}
