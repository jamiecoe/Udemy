package com.jamiecoe;

import java.util.Arrays;
import java.util.Scanner;

// ArrayLists are a descendant of Lists
// They seem similar to arrays but with much more flexibility - you can easily change the length

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        while(!quit) {
            System.out.println("Enter your choice ");
            choice = scanner.nextInt();
            scanner.nextLine(); // this will clear the input buffer

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("Can not be bothered");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        // scanner.nextLine will take whatever we type
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Enter item no ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter replacement item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo - 1, newItem);
    }

    public static void removeItem() {
        System.out.println("enter item position");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo - 1);
    }

    public static void searchForItem() {
        System.out.println("enter item to search for");
        String searchItem = scanner.nextLine();
        if (groceryList.findItem(searchItem) != null) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + " is not in shopping list");
        }

    }
}
