package com.jamiecoe;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
	    // quick recap - 8 primitive data types:
        // byte
        // short
        // int
        // long
        // float
        // double
        // char
        // boolean

        // Strings are 9th data type, but you can't really call them primitive - they are actually a class
        // Java syntax lets us treat it as a data type
        // You must use doublequotes for strings, singlequotes are for chars
        String myString = "This is a string";
        String myCopyrightString = "Copyright \u00A9";

        System.out.println(myCopyrightString);

        String numberString = "45";
        numberString = numberString + "5";
        System.out.println(numberString);

        String numString = "50";
        int myInt = 50;
        numberString = numString + myInt;
        // when you add a string to an int, Java automatically coverts int to String
        // same thing happens for other primitive data types
        System.out.println(numberString); // 5050
    }
}
