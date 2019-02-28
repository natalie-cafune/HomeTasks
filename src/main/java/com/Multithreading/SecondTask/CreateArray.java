package com.Multithreading.SecondTask;

public class CreateArray {

    private int size;
    private double array[];

    public CreateArray(int size) {
        this.size = size;
        this.array = new double[size];
    }

    public int getSize() {
        return size;
    }
}
