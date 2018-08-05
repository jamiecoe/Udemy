package com.company;

public class Main {

    public static void main(String[] args) {
        String numberAsString = "2018";

        int number = Integer.parseInt(numberAsString);
        double doubleNumber = Double.parseDouble(numberAsString);

        printSquareStar(8);
    }

    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (i == j) {
                        System.out.print('*');
                    } else if (i == 0 || j == 0) {
                        System.out.print('*');
                    } else if (i == number - 1 || j == number - 1) {
                        System.out.print('*');
                    } else if (j == number - (i + 1)) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        }
    }
}
