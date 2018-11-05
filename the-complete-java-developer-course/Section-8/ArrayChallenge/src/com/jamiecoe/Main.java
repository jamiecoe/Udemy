package com.jamiecoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntArray = getIntegers(5);

        printArray(sortArray(myIntArray));
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean stillUnsorted = true;
        int tempInt;

        while (stillUnsorted) {
            stillUnsorted = false;
            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    tempInt = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = tempInt;
                    stillUnsorted = true;
                }
            }

        }

        return sortedArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] getIntegers(int capacity) {
        int[] values = new int[capacity];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }
}
