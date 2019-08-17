package test.ctci.one;

import main.ctci.one.One;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneTest {

    @Test
    public void isUnique() {
        assertTrue(One.isUnique("abc"));
        assertTrue(One.isUnique("adsf"));
        assertTrue(One.isUnique("a"));
        assertFalse(One.isUnique("aabcsdf"));
        assertFalse(One.isUnique("aa"));
        assertFalse(One.isUnique("abbedfs"));
        assertFalse(One.isUnique("abbbeadfs"));
    }

    @Test
    public void checkPermutation() {
        assertTrue(One.checkPermutation("abc", "cba"));
        assertTrue(One.checkPermutation("racecar", "carrace"));

        assertFalse(One.checkPermutation("abc", "adc"));
        assertFalse(One.checkPermutation("a", "b"));
    }

    @Test
    public void URLify() {
        assertEquals("Mr%20John%20Smith", One.URLify("Mr John Smith    ".toCharArray()));
    }

    @Test
    public void palindromePermutation() {
        assertTrue(One.palindromePermutation("tact coa"));
    }

    @Test
    public void oneAway() {
        assertTrue(One.oneAway("pale", "ple"));
        assertTrue(One.oneAway("pales", "pale"));
        assertTrue(One.oneAway("pale", "bale"));
        assertTrue(One.oneAway("a", ""));
        assertTrue(One.oneAway("", ""));

        assertFalse(One.oneAway("pale", "bake"));
        assertFalse(One.oneAway("paleo", "pal"));
        assertFalse(One.oneAway("cat", "c"));
    }

    @Test
    public void rotateMatrix() {
        int[][] input, expected;

        input = new int[][]{{}};
        One.rotateMatrix(input);
        expected = new int[][]{{}};
        assertEquals(expected, input);

        input = new int[][]{{1, 2}, {4, 3}};
        One.rotateMatrix(input);
        expected = new int[][]{{4, 1}, {3, 2}};
        assertEquals(expected, input);

        input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        One.rotateMatrix(input);
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
        One.rotateMatrix(input);
        expected = new int[][]{
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}};
        assertEquals(expected, input);
    }
}