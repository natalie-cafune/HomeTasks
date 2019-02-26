package com.ManyThreads.FirstTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {

        FutureTask futureTask = new FutureTask(new Calculator());
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            System.out.println(thread.getName());
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
