package com.Threads;

public class LibraryDoor extends Thread {

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
