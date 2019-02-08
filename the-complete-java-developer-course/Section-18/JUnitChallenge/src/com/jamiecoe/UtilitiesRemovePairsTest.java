package com.jamiecoe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UtilitiesRemovePairsTest {

    private Utilities utils;
    private String input;
    private String expected;

    public UtilitiesRemovePairsTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setup() {
        utils = new Utilities();
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }

    @Test
    public void removePairs() {
        assertEquals(expected, utils.removePairs(input));
    }
}

