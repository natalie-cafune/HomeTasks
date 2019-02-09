package com.Collections;

import java.util.HashMap;

public class MyHashMap <K,V>{
    private final int SIZE = 16;
    private final float LOAD_FACTOR = 0.75f;


    MyNode newMyNode;
    MyNode last;
    MyNode array [];
    private int sizeArray = 0;

    public void put (K key, V value){

    }

    public MyHashMap() {
        this.array = new MyNode[SIZE];
    }

    public void clear(){
        sizeArray = 0;
        array = null;
        last = null;

    }
    public int size(){
        return sizeArray;
    }
}
