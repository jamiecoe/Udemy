package com.jamiecoe;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("The application is running");

        System.out.println(Arrays.deepToString(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00},
        }));
    }
}
