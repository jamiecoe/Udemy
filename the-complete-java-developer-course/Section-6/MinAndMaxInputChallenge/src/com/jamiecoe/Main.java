package com.jamiecoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean validInt = true;

        int min = 0;
        int max = 0;

        while (validInt) {
            System.out.println("Enter number");

            validInt = scanner.hasNextInt();

            if (validInt) {
                int nextInt = scanner.nextInt();

                if (nextInt > max) {
                    max = nextInt;
                }

                if (nextInt < min || min == 0) {
                    min = nextInt;
                }

                scanner.nextLine();
            }
        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}
