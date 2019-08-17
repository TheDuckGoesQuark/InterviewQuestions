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
}