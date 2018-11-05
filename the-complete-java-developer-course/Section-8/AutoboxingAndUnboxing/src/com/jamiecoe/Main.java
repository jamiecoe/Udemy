package com.jamiecoe;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // ArrayLists can't hold primitive values, they can only hold a class
//        ArrayList<int> intArray = new ArrayList<int>(); // not allowed

        // We can wrap primitive values in wrapper class, in order to make a primitive value into a class
        Integer integer = new Integer(13);
        Double doubleClass = new Double(13.3);

        // We can now use them in an ArrayList
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        intArrayList.add(integer);

        for (int i = 0; i < 10; i++) {
            // Integer.valueOf() takes an int, and converts it into an instance of the Integer class
            // This is AUTOBOXING
            intArrayList.add(Integer.valueOf(i));
        }

        for (int i = 0; i < intArrayList.size(); i++) {
            // Integer.intValue() converts back into a primitive int
            // This is UNBOXING
            System.out.println(intArrayList.get(i).intValue());
        }

        // Java allows you to just set int to a Integer automatically
        // At compile time, it will do Autoboxing -> Integer.valueOf(56)
        Integer myIntValue = 56;
        // It will also do the reverse Unboxing -> Integer.intValue(myIntValue)
        int myInt = myIntValue;
    }
}
