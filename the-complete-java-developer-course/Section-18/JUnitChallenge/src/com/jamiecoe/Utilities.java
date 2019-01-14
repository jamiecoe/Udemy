package com.jamiecoe;

public class Utilities {

    // Returns a char array containing every nth char
    // When sourceArray.length < n, returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray.length < n || n == 1) return sourceArray;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= sourceArray.length; i++) {
            if (i % n == 0) {
                stringBuilder.append(sourceArray[i-1]);
            }
        }

        return stringBuilder.toString().toCharArray();
    }
}
