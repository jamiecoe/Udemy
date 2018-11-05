package com.jamiecoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birth year: ");
        boolean hasNextInt = scanner.hasNextInt(); // checks if the value entered is an int

        if (hasNextInt) {
            int birthyear = scanner.nextInt();
            // We have to have an additional nextLine() because of the Enter key
            // When we hit the Enter key for birthyear, scanner looks for a line seperator (eg: Enter key)
            // This line seperator is treated as a seperate value, and will automatically be used by the next nextLine()
            // Here, we assign Enter key to nothing as we just want to get rid of it
            scanner.nextLine();

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            int age = 2018 - birthyear;

            if (age >= 0 && age <= 100) {
                System.out.println("Your name is " + name);
                System.out.println("Your birth year is " + birthyear);
                System.out.println("Your age is " + age);
            } else {
                System.out.println("Your age range is out of bounds");
            }
        } else {
            System.out.println("You need to enter a whole number for your birthyear");
        }

        scanner.close();
    }
}
