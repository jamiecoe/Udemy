package com.jamiecoe;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigits(1273));
    }

    public static int sumDigits(int num) {
        if (num < 10) return -1;

        String stringNum = String.valueOf(num);

        int total = 0;

//        for (int i = 0; i < stringNum.length(); i++) {
//            total += Character.getNumericValue(stringNum.charAt(i));
//        }

        while (num > 0) {
            int digit = num % 10;
            total += digit;

            num /= 10;
        }

        return total;
    }
}
