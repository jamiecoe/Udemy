package com.jamiecoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities utilities;

    @Before
    public void beforeEach() {
        utilities = new Utilities();
    }

    @Test
    public void everyNthChar_shouldReturnOriginalArrayIfLengthShorterThanN() {
        char[] inputArray = new char[]{ 'a', 'b', 'c' };
        assertArrayEquals(inputArray, utilities.everyNthChar(inputArray, 4));
    }

    @Test
    public void everyNthChar_shouldReturnOriginalArrayIfNIs1() {
        char[] inputArray = new char[]{ 'a', 'b', 'c' };
        assertArrayEquals(inputArray, utilities.everyNthChar(inputArray, 1));
    }

    @Test
    public void everyNthChar_shouldReturnNewArrayContainingEvery2ndCharacter() {
        char[] inputArray = new char[]{ 'a', 'b', 'c', 'd' };
        char[] expectedArray = new char[]{ 'b', 'd' };
        assertArrayEquals(expectedArray, utilities.everyNthChar(inputArray, 2));
    }

    @Test
    public void everyNthChar_shouldReturnNewArrayContainingEvery3rdCharacter() {
        char[] inputArray = new char[]{ 'a', 'b', 'c' };
        char[] expectedArray = new char[]{ 'c' };
        assertArrayEquals(expectedArray, utilities.everyNthChar(inputArray, 3));
    }

    @Test
    public void removePairs_shouldReturnSameStringIfLengthIsLessThan2() {
        String inputString = "A";
        assertEquals(inputString, utilities.removePairs(inputString));
    }

    @Test
    public void removePairs_shouldReturnSameStringIfNoDuplicates() {
        String inputString = "ABCDE";
        assertEquals(inputString, utilities.removePairs(inputString));
    }

    @Test
    public void removePairs_shouldRemoveDuplicatesNextToEachOther() {
        String inputString = "EFGGHI";
        String expectedString = "EFGHI";
        assertEquals(expectedString, utilities.removePairs(inputString));
    }

    @Test
    public void removePairs_shouldRemoveDuplicatesNextToEachOtherButKeepSeperatedDuplicates() {
        String inputString = "JKKLMJ";
        String expectedString = "JKLMJ";
        assertEquals(expectedString, utilities.removePairs(inputString));
    }

    @Test
    public void converter_shouldReturn300For10And5() {
        assertEquals(300, utilities.converter(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_shouldThrowArithmeticExceptionIfBIs0() throws Exception {
        utilities.converter(100, 0);
    }

    @Test
    public void nullIfOddLength_shouldReturnNullIfStringHasOddLength() {
        assertNull(utilities.nullIfOddLength("Hello"));
    }

    @Test
    public void nullIfOddLength_shouldNotReturnNullIfStringHasEvenLength() {
        assertNotNull(utilities.nullIfOddLength("Bell"));
    }
}
