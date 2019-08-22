package test;

import main.longestpalindrome.LongestPalindrome;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void findLongestPalindromicContiguousSubstring() {
        assertEquals("bcdcb", LongestPalindrome.findLongestPalindromicContiguousSubstring("aabcdcb"));
        assertEquals("anana", LongestPalindrome.findLongestPalindromicContiguousSubstring("bananas"));
    }
}