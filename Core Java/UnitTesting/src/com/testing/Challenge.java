package com.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Challenge
{
    private Utilities util;

    @org.junit.jupiter.api.BeforeEach
    public void setup()
    {
        util = new Utilities();
    }

    @Test
    public void everynthChar()
    {
        char[] arr = "hello".toCharArray();
        assertArrayEquals(new char[]{'e', 'l'}, util.everynthChar(arr, 2));
        assertArrayEquals(arr, util.everynthChar(arr, 6));
    }

    @Test
    public void removePairs()
    {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull(util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @Test
    public void converter()
    {
        assertEquals(300, util.converter(10, 5));
        assertThrows(ArithmeticException.class, () -> util.converter(10, 0));
    }

    @Test
    public void nullIfOddLength()
    {
        assertNotNull(util.nullIfOddLength("test"));
        assertNull( util.nullIfOddLength("hello"));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testRemovePairs(String input, String output)
    {
        assertEquals(output, util.removePairs(input));
    }

    public static Stream<Arguments> testCases()
    {
        return Stream.of(
                Arguments.arguments("ABCDEFF", "ABCDEF"),
                Arguments.arguments("AB88EFFG", "AB8EFG"),
                Arguments.arguments("112233445566", "123456"),
                Arguments.arguments("ZYZQQB", "ZYZQB"),
                Arguments.arguments("A", "A")
        );
    }
}
