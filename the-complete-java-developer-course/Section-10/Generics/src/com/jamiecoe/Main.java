package com.jamiecoe;

import java.util.ArrayList;

public class Main {

    // Generics allow us to create classes / interfaces / methods that take 'types' as parameters

    public static void main(String[] args) {
        // We specify that this ArrayList takes items which have the Type of Integer
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);

        printDouble(items);
    }

    private static void printDouble(ArrayList<Integer> n) {
        for (Integer i : n) {
            System.out.println(i * 2);
        }
    }
}
