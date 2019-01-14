package com.jamiecoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void everyNthChar_shouldReturnOriginalArrayIfLengthShorterThanN() {
        Utilities utilities = new Utilities();
        char[] inputArray = new char[]{ 'a', 'b', 'c' };
        assertArrayEquals(inputArray, utilities.everyNthChar(inputArray, 4));
    }

    @Test
    public void everyNthChar_shouldReturnOriginalArrayIfNIs1() {
        Utilities utilities = new Utilities();
        char[] inputArray = new char[]{ 'a', 'b', 'c' };
        assertArrayEquals(inputArray, utilities.everyNthChar(inputArray, 1));
    }

    @Test
    public void everyNthChar_shouldReturnNewArrayContainingEvery2ndCharacter() {
        Utilities utilities = new Utilities();
        char[] inputArray = new char[]{ 'a', 'b', 'c', 'd' };
        char[] expectedArray = new char[]{ 'b', 'd' };
        assertArrayEquals(expectedArray, utilities.everyNthChar(inputArray, 2));
    }

    @Test
    public void everyNthChar_shouldReturnNewArrayContainingEvery3rdCharacter() {
        Utilities utilities = new Utilities();
        char[] inputArray = new char[]{ 'a', 'b', 'c' };
        char[] expectedArray = new char[]{ 'c' };
        assertArrayEquals(expectedArray, utilities.everyNthChar(inputArray, 3));
    }
}
