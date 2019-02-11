package com.Threads;

import java.util.concurrent.Semaphore;

public class LibraryDoor extends Thread {
    private Semaphore SEMAPHORE = new Semaphore(1, true);

    public LibraryDoor() {
        this.SEMAPHORE = SEMAPHORE;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " подошел к двери изнутри");
        System.out.println(Thread.currentThread().getName() + " проходит через дверь внутрь");
        try {
            sleep(500);
            System.out.println(Thread.currentThread().getName() + " прошел через дверь внутрь");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
