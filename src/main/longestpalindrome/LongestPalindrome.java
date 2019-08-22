package main.longestpalindrome;

/**
 * Given a string, find the longest palindromic contiguous substring.
 * If there are more than one with the maximum length, return any one.
 * <p>
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb".
 * The longest palindromic substring of "bananas" is "anana".
 */
public class LongestPalindrome {

    public static String findLongestPalindromicContiguousSubstring(String str) {
        int[] substringIndices = recursivelyFindLongestPalindrome(str.toCharArray(), 0, str.length());
        return str.substring(substringIndices[0], substringIndices[1]);
    }

    private static int[] recursivelyFindLongestPalindrome(char[] str, int start, int end) {
        int length = end - start;

        if (length == 1) {
            // length one is palindrome
            return new int[]{start, end};
        }
    }

}
