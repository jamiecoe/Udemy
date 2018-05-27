package com.jamiecoe;

import java.util.Scanner;

public class Main {

    // Scanner and System.in allows you to input arguements into your program
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // create an array of int, with 10 elements
        // you can only have one type in an array
	    int[] myVar = new int[10];
        myVar[5] = 50;

        // you can intialise an array with elements like this (with {} braces)
        int[] myArray = { 1, 2, 3, 4, 5 };

        int[] myIntegers = getIntegers(5);


        for (int i = 0; i < myIntegers.length; i++) {
            System.out.println(myIntegers[i]);
        }

        double avg = getAverage(myIntegers);

        System.out.println(avg);

    }

    public static double getAverage(int[] array) {
        int total = 0;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        return (double)total / (double)array.length;
    }

    public static int[] getIntegers(int number) {
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            // scanner.nextInt() automatically accepts an integers from the console and returns it
            values[i] = scanner.nextInt();
        }

        return values;
    }
}
