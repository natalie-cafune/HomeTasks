package com.Flower;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FlowersSaver {

    static void save(String path, ArrayList<String> arrayList  ) {

        try {
            FileWriter fileWriter = new FileWriter(path, false);
            for (String string : arrayList){
                fileWriter.write(string);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}