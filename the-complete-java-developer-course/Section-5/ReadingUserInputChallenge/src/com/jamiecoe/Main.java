package com.jamiecoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter number #" + i);
            boolean isInt = scanner.hasNextInt();

            if (isInt) {
                total += scanner.nextInt();
            } else {
                System.out.println("Invalid number");
            }
            scanner.nextLine(); // handle end of line (enter key)
        }
        scanner.close();
        System.out.println(total);

    }
}