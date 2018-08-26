package com.jamiecoe;

import java.util.ArrayList;

public class GroceryList {
    // For an ArrayList, you say what type will be contained inside <>
    // ArrayLists are actually a class so you will need to call the constructor
    // You can set the initial length of the ArrayList inside the constructor
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        // adds `item` into ArrayList
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("size = " + groceryList.size());
        for (int i = 0; i < groceryList.size(); i++) {
            // use .get(index) method to access element in ArrayList
            System.out.println(groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String item, String newItem) {
        int index = findItem(item);

        if (index >= 0) {
            modifyGroceryItem(index, newItem);
        } else {
            System.out.println(item + " does not exist in shopping list");
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        // use .set(index, newValue) to update a value at a particular postion
        groceryList.set(position, newItem);
    }

    public void removeGroceryItem(String item) {
        int index = findItem(item);

        if (index >= 0) {
            removeGroceryItem(index);
        } else {
            System.out.println(item + " does not exist in shopping list");
        }
    }

    private void removeGroceryItem(int position) {
        // remove an item from an ArrayList with .remove(index)
        groceryList.remove(position);
    }

    private int findItem(String searchItem) {
        // returns boolean for whether ArrayList contains value
        // boolean exists = groceryList.contains(searchItem);

        // returns position of value, or -1 if value isn't present
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        int index = findItem(searchItem);
        return index >= 0;
    }
}
