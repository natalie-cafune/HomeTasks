package com.Threads;

import java.util.concurrent.TimeUnit;

public class LibraryDoor extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " подошел к двери изнутри");
        System.out.println(Thread.currentThread().getName() + " проходит через дверь внутрь");
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + " прошел через дверь внутрь");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
