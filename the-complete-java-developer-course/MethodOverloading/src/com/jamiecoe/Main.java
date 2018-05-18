package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        // you've actually got two versions of calculateScore because of 'method-overloading'
        // 1st excepts two arguements, 2nd excepts one arguement
	    calculateScore("jamie", 500);
        calculateScore(88);

        calculateScore();

        calcFeetAndInchesToCentimeters(15);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    // Creating another method with the same name "calculateScore", but with a different number of arguements
    // This is called 'method overloading'
    public static int calculateScore(int score) {
        System.out.println("Un-named Player scored " + score + " points");
        return score * 1000;
    }

    // each new method has to have a unique signature - ie: function name, data types and number of paramenters
    // Note: just changing the data type of the return value won't change the overall signature
    public static int calculateScore() {
        System.out.println("no score");
        return 1000;
    }

    // Challenge

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        boolean isFeetValid = feet >= 0;
        boolean isInchesValid = inches >= 0 && inches <= 12;

        if (isFeetValid && isInchesValid) {
            return ((feet * 12) * 2.54) + (inches * 2.54);
        }

        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        boolean isInchesValid = inches >= 0;

        if (isInchesValid) {
            int feet = (int)(inches / 12);
            double remainingInches = inches % 12;
            System.out.println(feet);
            System.out.println(remainingInches);

            System.out.println(calcFeetAndInchesToCentimeters((double) feet, remainingInches));

        }

        return -1;
    }


}
