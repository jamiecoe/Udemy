package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
	    // Java also has ternary operators
        boolean isCar = true;
        boolean wasCar = isCar ? true : false;

        // Challenge
        double myDouble = 20;
        double mySecondDouble = 80;

        double myThirdDouble = (myDouble + mySecondDouble) * 25;
        double myFourthDouble = myThirdDouble % 40;

        if (myFourthDouble <= 20) {
            System.out.println("Total was over the limit");
        }
    }
}
