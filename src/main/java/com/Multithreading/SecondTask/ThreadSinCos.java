package com.Multithreading.SecondTask;

import java.util.concurrent.Callable;

public class ThreadSinCos implements Callable<Double> {
    private CreateArray createArray;
    private double result;

    public ThreadSinCos(CreateArray createArray) {
        this.createArray = createArray;
    }

    @Override
    public Double call() throws Exception {

        for (int i = 0; i < createArray.getSize(); i++) {
            result += Math.sin(i) + Math.cos(i);
        }
        return result;
    }
}
