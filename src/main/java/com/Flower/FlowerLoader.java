package com.Flower;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class FlowerLoader  {

    static ArrayList<String> arrayList = new ArrayList<String>();

    static ArrayList <String> load (String path){

        try {
            FileReader fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);
            String [] strings = scanner.nextLine().split(" ");
            arrayList = new ArrayList(Arrays.asList(strings));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
