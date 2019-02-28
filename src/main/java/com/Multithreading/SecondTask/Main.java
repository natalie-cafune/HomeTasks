package com.Multithreading.SecondTask;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        CreateArray createArray = new CreateArray(80000000);


        Future future = service.submit(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите число повторений");
                int number = scanner.nextInt();

                for (int i = 0; i < number; i++) {
                    CreateArray createArray = new CreateArray(80000000);
                    ThreadSinCos sin = new ThreadSinCos(createArray);
                    FutureTask futureTaskArray = new FutureTask(sin);
                    Thread thread = new Thread(futureTaskArray);
                    thread.start();

                    try {
                        System.out.println(thread.getName());
                        System.out.println(futureTaskArray.get());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        service.shutdown();

    }
}
