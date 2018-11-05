package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        // `char` can only be one character (including unicode characters)
        // it has a width of 16 (2bytes)
        char myChar = 'j';
        // for unicode characters, you to start with backslash + u before the code
        char myUnicodeChar = '\u00A9';
        System.out.println(myUnicodeChar);

        boolean myBoolean = true;

        // Challenge
        char registeredSymbol = '\u00AE';
        System.out.println(registeredSymbol);

    }
}
