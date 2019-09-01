package test.ctci.one;

import main.ctci.stringsandarrays.StringsAndArrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneTest {

    @Test
    public void isUnique() {
        assertTrue(StringsAndArrays.isUnique("abc"));
        assertTrue(StringsAndArrays.isUnique("adsf"));
        assertTrue(StringsAndArrays.isUnique("a"));
        assertFalse(StringsAndArrays.isUnique("aabcsdf"));
        assertFalse(StringsAndArrays.isUnique("aa"));
        assertFalse(StringsAndArrays.isUnique("abbedfs"));
        assertFalse(StringsAndArrays.isUnique("abbbeadfs"));
    }

    @Test
    public void checkPermutation() {
        assertTrue(StringsAndArrays.checkPermutation("abc", "cba"));
        assertTrue(StringsAndArrays.checkPermutation("racecar", "carrace"));

        assertFalse(StringsAndArrays.checkPermutation("abc", "adc"));
        assertFalse(StringsAndArrays.checkPermutation("a", "b"));
    }

    @Test
    public void URLify() {
        assertEquals("Mr%20John%20Smith", StringsAndArrays.URLify("Mr John Smith    ".toCharArray()));
    }

    @Test
    public void palindromePermutation() {
        assertTrue(StringsAndArrays.palindromePermutation("tact coa"));
    }

    @Test
    public void oneAway() {
        assertTrue(StringsAndArrays.oneAway("pale", "ple"));
        assertTrue(StringsAndArrays.oneAway("pales", "pale"));
        assertTrue(StringsAndArrays.oneAway("pale", "bale"));
        assertTrue(StringsAndArrays.oneAway("a", ""));
        assertTrue(StringsAndArrays.oneAway("", ""));

        assertFalse(StringsAndArrays.oneAway("pale", "bake"));
        assertFalse(StringsAndArrays.oneAway("paleo", "pal"));
        assertFalse(StringsAndArrays.oneAway("cat", "c"));
    }

    @Test
    public void rotateMatrix() {
        int[][] input, expected;

        input = new int[][]{{}};
        StringsAndArrays.rotateMatrix(input);
        expected = new int[][]{{}};
        assertEquals(expected, input);

        input = new int[][]{{1, 2}, {4, 3}};
        StringsAndArrays.rotateMatrix(input);
        expected = new int[][]{{4, 1}, {3, 2}};
        assertEquals(expected, input);

        input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        StringsAndArrays.rotateMatrix(input);
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
        StringsAndArrays.rotateMatrix(input);
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
        StringsAndArrays.rotateMatrix(input);
        expected = new int[][]{
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4},
                {25, 20, 15, 10, 5}};
        assertEquals(expected, input);
    }

    @Test
    public void spreadZeroes() {
        int[][] input;
        int[][] expected;

        input = new int[][]{
                {}
        };
        StringsAndArrays.zeroMatrix(input);
        expected = new int[][]{
                {}
        };
        assertEquals(expected, input);

        input = new int[][]{
                {1}
        };
        StringsAndArrays.zeroMatrix(input);
        expected = new int[][]{
                {1}
        };
        assertEquals(expected, input);

        input = new int[][]{
                {0}
        };
        StringsAndArrays.zeroMatrix(input);
        expected = new int[][]{
                {0}
        };
        assertEquals(expected, input);

        input = new int[][]{
                {1, 2, 3, 0},
                {1, 2, 3, 1},
                {1, 0, 3, 1}
        };
        StringsAndArrays.zeroMatrix(input);
        expected = new int[][]{
                {0, 0, 0, 0},
                {1, 0, 3, 0},
                {0, 0, 0, 0}
        };
        assertEquals(expected, input);

        input = new int[][]{
                {1, 2, 3, 4},
                {1, 0, 3, 1},
                {1, 4, 3, 1},
                {1, 8, 3, 1},
                {1, 9, 3, 1}
        };
        StringsAndArrays.zeroMatrix(input);
        expected = new int[][]{
                {1, 0, 3, 4},
                {0, 0, 0, 0},
                {1, 0, 3, 1},
                {1, 0, 3, 1},
                {1, 0, 3, 1}
        };
        assertEquals(expected, input);
    }
}