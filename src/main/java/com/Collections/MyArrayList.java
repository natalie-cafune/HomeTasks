package com.Collections;

import java.util.ArrayList;

public class MyArrayList <T> {
    ArrayList arrayList = new ArrayList();

    private final int SIZE = 10;
    //private final int RATE = 4;
    private Object [] array = new Object[SIZE];
    private int point = 0;

    // adds an item
    public void add (T element){
        if(point == array.length-1)
            resize(array.length*2); // increases the size by twice, if reach the limits
        array[point++] = element;
    }

    //resizing of collection
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    // returns item by index
    public T get(int index){
            //написать проверку на отсутствие элемента в ммассиве
        return (T) array[index];
    }

    // removes item by index
    public void remove (int index){
        //if (!array[index]) написать проверку на отсутствие элемента в ммассиве
        for (int i = index; i < point; i++)
            array[i] = array[i+1];
        array[point] = null;
        point--;
    }

    // clears the collection
    public void clear(){
        for (int i = 0; i <= point;  i++){
            array [i] = null;
        }
        point = 0;
    }
    // returns the size of the collection
    public int size (){
        return point;
    }
}

