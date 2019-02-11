package com.Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Person extends Thread {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new LibraryDoor());
    private Semaphore semaphore;
    private int num = 1;
    private int a;

    public Person(Semaphore semaphore, int a) {
        this.semaphore = semaphore;
        this.a = a;
    }


    public void run() {
        System.out.println(Thread.currentThread().getName() + " подошел к двери с улицы!");
        System.out.println(Thread.currentThread().getName() + " пришел ко входу в библиотеку");
        try {
            //Запрашиваем у семафора разрешение на выполнение
            semaphore.acquire();

            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " вошел в библиотеку");
            while (num <= a) {
                System.out.println(Thread.currentThread().getName() + " читает книгу");
                num++;
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " проходит через дверь наружу");
                sleep(500);

                System.out.println(Thread.currentThread().getName() + " прошел через дверь наружу");
                System.out.println(Thread.currentThread().getName() + " вышел из библиотеки");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getStackTrace());
        } catch (BrokenBarrierException e) {
            System.out.println(Thread.currentThread().getStackTrace());
            e.printStackTrace();
        }
    }
}



