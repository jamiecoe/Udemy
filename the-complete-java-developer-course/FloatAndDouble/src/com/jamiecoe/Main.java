package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        // width of int = 32 (4 bytes)
	    int myIntValue = 5 / 2;
        // width of float = 32 (4 bytes)
	    float myFloatValue = 5f / 3f;
        // width of double = 64 (8 bytes)
	    double myDoubleValue = 5d / 3d;

	    // any decimals that aren't specified will be assumed to be a `double`
        double myNewDouble = myFloatValue + 5.5;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        // Challenge - pound to kg converter

        int pounds = 180;
        double conversionRate = 0.45359237d;
        double kg = pounds * conversionRate;

        System.out.println(kg);
    }
}
