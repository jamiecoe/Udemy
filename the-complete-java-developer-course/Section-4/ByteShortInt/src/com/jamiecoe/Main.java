package com.jamiecoe;

public class Main {

    public static void main(String[] args) {

        // width refers to how much memory space is allocated to a variable

        // `int` data range = -2,147,483,648 to 2,147,483, 647 (2^31)
        // You can use underscores to make long numbers more readable
        // int has width of 32
        int myInt = 2_147_483_647;

        // `byte` data range = -128 to 127 (2^7)
        // byte has width of 8
        byte myByte = 10;

        // `short` data range = -32,768 to 32,767 (2^15)
        // short has width of 16
        short myShort = 30000;

        // `long` data range = -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (2^63)
        // you add an `L` on the end for long values
        // long has width of 64
        long myLong = 100L;

        // int, byte, short and long are the 4 data types for dealing with whole numbers


        byte myByteValue = 127;
        // weird thing Java does:
        // by default - when your making an assignment from an expression, Java will convert the returned value to an int
        // you can use `casting` to tell Java to treat value as byte still, where you put (byte) infront of the (expression)
        byte myNewByte = (byte)(myByteValue / 2);

        // works the same with other data types
        short myNewShort = (short)(myShort + 100);

        // Challenge

        byte cByte = 100;
        short cShort = 1000;
        int cInt = 5000;
        // You don't need to do any casting for `long` (as well as `int`)
        // the variables in the brackets will be automatically converted in type `int`
        // `long` will except type `int`
        long cLong = (5000L + 10L) * (cByte + cInt + cShort);

        System.out.println(cLong);
    }
}
