package com.jamiecoe;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println("result = " + result);
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform divide");
        }
    }

    private static int divide() {
        int x;
        int y;

        try {
            x = getInt();
            y = getInt();

            System.out.println("x = " + x);
            System.out.println("y = " + y);

            return x / y;

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("no suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("cannot divide by zero");
        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                // go round again - Read past the end of line in the input first
                scanner.nextLine();
                System.out.println("Enter only digits");
            }
        }
    }
}
