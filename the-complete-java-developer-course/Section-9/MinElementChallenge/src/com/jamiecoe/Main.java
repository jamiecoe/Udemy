package com.jamiecoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter count number");
	    int count = scanner.nextInt();

	    int[] userInputedArray = readIntegers(count);
        System.out.println(Arrays.toString(userInputedArray));

	    int min = findMin(userInputedArray);
        System.out.println(min);

    }

    public static int[] readIntegers(int count) {
        int[] userInputArray = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter " + (count - i) + " more numbers");
            userInputArray[i] = scanner.nextInt();
        }

        return userInputArray;
    }

    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;
    }

//    public static int findMin(int[] array) {
//        int[] sortedArray = Arrays.copyOf(array, array.length);
//        boolean minFound = true;
//
//        while (minFound) {
//            minFound = false;
//
//            for (int i = 0; i < sortedArray.length - 1; i++) {
//                if (sortedArray[i] > sortedArray[i + 1]) {
//                    int tempVal = sortedArray[i];
//                    sortedArray[i] = sortedArray[i + 1];
//                    sortedArray[i + 1] = tempVal;
//                    minFound = true;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(sortedArray));
//        return sortedArray[0];
//    }
}
