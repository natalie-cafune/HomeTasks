package com.Flower;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <String> arrayList = new ArrayList<String>();
        int c,r,t;
        String path = "D://home//flow.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter chamomiles ");
        c = scanner.nextInt();
        System.out.print("Enter Rose ");
        r = scanner.nextInt();
        System.out.print("Enter Tulip ");
        t = scanner.nextInt();

        FlowerStore flowerStore = new FlowerStore();
        System.out.println(flowerStore.sell(c,r,t));
        arrayList = flowerStore.sell(c,r,t);
        System.out.println(flowerStore.purseCheck(c,r,t));
        FlowersSaver.save(path, arrayList);

        System.out.println(FlowerLoader.load(path));
    }
}
