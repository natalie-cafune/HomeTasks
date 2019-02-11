package com.Threads;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во людей: ");
        int peopleCount = scanner.nextInt();
        System.out.print("Введите максимальное кол-во : ");
        int maxAmount = scanner.nextInt();

        Semaphore sem = new Semaphore(maxAmount);
        for (int i = 0; i < peopleCount; i++) {
            new Person(sem, maxAmount).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

