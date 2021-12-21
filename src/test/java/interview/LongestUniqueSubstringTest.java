package interview;

import interview.longestuniquesubstring.LongestUniqueSubstring;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestUniqueSubstringTest {

    @Test
    public void getLengthOfSubstringWithKUniqueCharacters() {
        // "bcb"
        assertEquals(3, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("abcba", 2));
        // "aaaa"
        assertEquals(4, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("aaaa", 4));
        // ""
        assertEquals(3, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("abcd", 3));
        // any
        assertEquals(1, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("abcd", 1));
        // "abc"
        assertEquals(3, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("abacbd", 2));
        // "bab" or "bcb
        assertEquals(3, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("cbabcb", 2));
        // "cbcbc"
        assertEquals(5, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("abacbcbc", 2));
        // "cbcbc"
        assertEquals(5, LongestUniqueSubstring.getLengthOfSubstringWithKUniqueCharacters("cbcbcaba", 2));
    }
}