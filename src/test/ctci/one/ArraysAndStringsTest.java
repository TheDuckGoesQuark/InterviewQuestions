package test.ctci.one;

import main.ctci.arraysandstrings.ArraysAndStrings;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndStringsTest {

    @Test
    public void isUnique() {
        assertTrue(ArraysAndStrings.isUnique("abc"));
        assertTrue(ArraysAndStrings.isUnique("adsf"));
        assertTrue(ArraysAndStrings.isUnique("a"));
        assertFalse(ArraysAndStrings.isUnique("aabcsdf"));
        assertFalse(ArraysAndStrings.isUnique("aa"));
        assertFalse(ArraysAndStrings.isUnique("abbedfs"));
        assertFalse(ArraysAndStrings.isUnique("abbbeadfs"));
    }

    @Test
    public void checkPermutation() {
        assertTrue(ArraysAndStrings.checkPermutation("abc", "cba"));
        assertTrue(ArraysAndStrings.checkPermutation("racecar", "carrace"));

        assertFalse(ArraysAndStrings.checkPermutation("abc", "adc"));
        assertFalse(ArraysAndStrings.checkPermutation("a", "b"));
    }

    @Test
    public void URLify() {
        assertEquals("Mr%20John%20Smith", ArraysAndStrings.URLify("Mr John Smith    ".toCharArray()));
    }

    @Test
    public void palindromePermutation() {
        assertTrue(ArraysAndStrings.palindromePermutation("tact coa"));
    }

    @Test
    public void oneAway() {
        assertTrue(ArraysAndStrings.oneAway("pale", "ple"));
        assertTrue(ArraysAndStrings.oneAway("pales", "pale"));
        assertTrue(ArraysAndStrings.oneAway("pale", "bale"));
        assertTrue(ArraysAndStrings.oneAway("a", ""));
        assertTrue(ArraysAndStrings.oneAway("", ""));

        assertFalse(ArraysAndStrings.oneAway("pale", "bake"));
        assertFalse(ArraysAndStrings.oneAway("paleo", "pal"));
        assertFalse(ArraysAndStrings.oneAway("cat", "c"));
    }

    @Test
    public void rotateMatrix() {
        int[][] input, expected;

        input = new int[][]{{}};
        ArraysAndStrings.rotateMatrix(input);
        expected = new int[][]{{}};
        assertEquals(expected, input);

        input = new int[][]{{1, 2}, {4, 3}};
        ArraysAndStrings.rotateMatrix(input);
        expected = new int[][]{{4, 1}, {3, 2}};
        assertEquals(expected, input);

        input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        ArraysAndStrings.rotateMatrix(input);
        expected = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};
        assertEquals(expected, input);

        input = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        ArraysAndStrings.rotateMatrix(input);
        expected = new int[][]{
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}};
        assertEquals(expected, input);

        input = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        ArraysAndStrings.rotateMatrix(input);
        expected = new int[][]{
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4},
                {25, 20, 15, 10, 5}};
        assertEquals(expected, input);
    }
}