package com.Collections;

public class MyArrayList <T> {

    private final int SIZE = 10;
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
        return (T) array[index];
    }

    // removes item by index
    public void remove (int index){
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

