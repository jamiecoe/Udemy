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

    // Remove pairs of the same character that are next to each other
    // This is done by removing one occurence of the character.
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF"
    public String removePairs(String source){

        if (source.length() < 2) {
            return source;
        }

        char[] sourceLetters = source.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sourceLetters.length - 1; i++) {
            if (sourceLetters[i] != sourceLetters[i + 1]) {
                stringBuilder.append(sourceLetters[i]);
            }
        }

        stringBuilder.append(sourceLetters[sourceLetters.length - 1]);

        return stringBuilder.toString();
    }

    // perform a conversion based on some internal business rule.
    public int converter(int a, int b) {
        return (a/b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        return source.length() % 2 == 0 ? source : null;
    }
}
