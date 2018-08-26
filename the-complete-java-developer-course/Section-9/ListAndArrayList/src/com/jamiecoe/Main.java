package com.jamiecoe;

import java.util.ArrayList;
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
                    processArrayList();
                    break;
                case 7:
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
        System.out.println("enter item");
        String item = scanner.nextLine();
        System.out.println("enter replacement item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(item, newItem);
    }

    public static void removeItem() {
        System.out.println("enter item you want to remove");
        String newItem = scanner.nextLine();
        groceryList.removeGroceryItem(newItem);
    }

    public static void searchForItem() {
        System.out.println("enter item to search for");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + " is not in shopping list");
        }
    }

    public static void processArrayList() {
        // different ways to make a copy of array list

        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        // you can also pass in the old arraylist into new arraylist constructor
        ArrayList<String> anotherNewArray = new ArrayList<String>(groceryList.getGroceryList());

        // convert arraylist into regular array
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
