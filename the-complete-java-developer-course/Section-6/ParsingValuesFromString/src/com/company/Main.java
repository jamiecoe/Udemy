package com.company;

public class Main {

    public static void main(String[] args) {
	    String numberAsString = "2018";

	    int number = Integer.parseInt(numberAsString);
	    double doubleNumber = Double.parseDouble(numberAsString);

        System.out.println(canPack(2, 1, 5));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int bigCountKg = bigCount * 5;
        int smallCountKg = smallCount;

        if (bigCountKg % (goal - smallCountKg) == 0) {
            return true;
        }

        return goal <= bigCountKg + smallCountKg;
    }
}
