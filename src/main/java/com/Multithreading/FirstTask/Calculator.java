package com.Multithreading.FirstTask;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Calculator implements Callable {

    private Scanner scanner;

    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public double calc() {
        double aNumber = getNumber();
        double bNumber = getNumber();
        char operation = getOperation();
        double result = 0;

        if ((operation == '=') || (operation == '>') || (operation == '<')) {
            boolOperation(aNumber, bNumber, operation);
        } else {
            switch (operation) {
                case '+':
                    result = aNumber + bNumber;
                    break;
                case '-':
                    result = aNumber - bNumber;
                    break;
                case '*':
                    result = aNumber * bNumber;
                    break;
                case '/':
                    if ((aNumber == 0) || (bNumber == 0)) {
                        System.out.println("Can not divide by zero");
                        System.out.println("Please try again.");
                        result = calc();
                    } else {
                        result = aNumber / bNumber;
                    }
                    break;
                case '%':
                    result = aNumber % bNumber;
                    break;
                default:
                    System.out.println("The operation is not recognized, please try again.");
                    result = calc();
            }
        }
        return result;
    }

    public void printResult() {
        System.out.print("Result is - ");
    }

    public boolean boolOperation(double a, double b, char op) {
        boolean boolResult = false;

        switch (op) {
            case '=':
                boolResult = (a == b);
                break;
            case '>':
                boolResult = (a > b);
                break;
            case '<':
                boolResult = (a < b);
                break;
        }
        printResult();
        return boolResult;
    }

    public double getNumber() {
        System.out.println("Enter a number : ");
        double number = scanner.nextInt();
        return number;
    }

    public char getOperation() {
        System.out.print(
                "Enter the symbol : " + "\n"
                        + "1. + " + "\n"
                        + "2. - " + "\n"
                        + "3. * " + "\n"
                        + "4. / " + "\n"
                        + "5. % " + "\n"
                        + "6. == " + "\n"
                        + "7. > " + "\n"
                        + "8. < " + "\n"
        );
        char operation = scanner.next().charAt(0);
        return operation;
    }

    @Override
    public Double call() throws Exception {
        return calc();
    }
}
