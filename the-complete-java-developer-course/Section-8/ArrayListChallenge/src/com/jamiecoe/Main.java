package com.jamiecoe;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 1;

        while(!quit) {
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    printInstructions();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    mobilePhone.printContactList();
                    break;
            }

            System.out.println("Enter your choice ");
            choice = scanner.nextInt();
            scanner.nextLine(); // this will clear the input buffer
        }
    }

    private static void printInstructions() {
        System.out.println("0 = Quit\n1 = Print Instructions\n2 = Add new contact\n3 = Update existing contact\n4 = Remove contact\n5 = Search/find contact\n6 = print contact list");
    }

    private static void addNewContact() {
        System.out.println("Enter contact name");
        String name = scanner.nextLine();

        System.out.println("Enter contact number");
        String number = scanner.nextLine();

        mobilePhone.addNewContact(name, number);
    }

    private static void updateExistingContact() {
        System.out.println("Enter name you would like to update");
        String nameToUpdate = scanner.nextLine();

        System.out.println("Enter number you would like to update");
        String numberToUpdate = scanner.nextLine();

        System.out.println("Enter new name");
        String newName = scanner.nextLine();

        System.out.println("Enter new number");
        String newNumber = scanner.nextLine();

        mobilePhone.updateContact(nameToUpdate, numberToUpdate, newName, newNumber);
    }

    private static void removeContact() {
        System.out.println("Enter name you would like to remove");
        String nameToRemove = scanner.nextLine();

        System.out.println("Enter number you would like to remove");
        String numberToRemove = scanner.nextLine();

        mobilePhone.removeContact(nameToRemove, numberToRemove);
    }

    private static void searchForContact() {
        System.out.println("Enter name you would like to find");
        String nameToFind = scanner.nextLine();

        System.out.println("Enter number you would like to find");
        String numberToFind = scanner.nextLine();

        if (mobilePhone.doesContactExist(nameToFind, numberToFind)) {
            System.out.println("Contact found!");
        } else {
            System.out.println("Contact does not exist");
        }
    }
}
