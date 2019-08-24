package test;

import main.longestpalindrome.LongestPalindrome;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void findLongestPalindromicContiguousSubstring() {
        assertEquals("a", LongestPalindrome.findLongestPalindromicContiguousSubstring("a"));
        assertEquals("aa", LongestPalindrome.findLongestPalindromicContiguousSubstring("aa"));
        assertEquals("aba", LongestPalindrome.findLongestPalindromicContiguousSubstring("aba"));
        assertEquals("dabad", LongestPalindrome.findLongestPalindromicContiguousSubstring("dabad"));
        assertEquals("bcdcb", LongestPalindrome.findLongestPalindromicContiguousSubstring("aabcdcb"));
        assertEquals("anana", LongestPalindrome.findLongestPalindromicContiguousSubstring("bananas"));
    }
}