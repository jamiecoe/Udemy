package com.jamiecoe;

public class Series {
    public static long nSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int total = 1;

        for (int i = 1; i <= n; i++) {
            total *= i;
        }

        return total;
    }

    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
