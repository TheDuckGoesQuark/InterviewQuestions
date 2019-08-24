package main.longestpalindrome;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Given a string, find the longest palindromic contiguous substring.
 * If there are more than one with the maximum length, return any one.
 * <p>
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb".
 * The longest palindromic substring of "bananas" is "anana".
 */
public class LongestPalindrome {

    private static int[] maxDifferenceArray(int[] a, int[] b) {
        return a[1] - a[0] > b[1] - b[0] ? a : b;
    }

    public static String findLongestPalindromicContiguousSubstring(String str) {
        if (str.length() == 1) return str;

        int[] longestIndices = new int[]{0, 0};

        // use each character as 'root' of palindrome
        for (int i = 0; i < str.length(); i++) {
            final Optional<int[]> result = findLongestPalindromeRecursively(str, i, i);

            if (result.isPresent()) {
                longestIndices = maxDifferenceArray(result.get(), longestIndices);
            }
        }

        return str.substring(longestIndices[0], longestIndices[1] + 1);
    }

    private static Optional<int[]> findLongestPalindromeRecursively(String str, int start, int end) {
        // can't go further
        if (start < 0 || end == str.length()) return Optional.empty();

        // no longer palindrome, go back
        if (str.charAt(start) != str.charAt(end))
            return Optional.empty();

        // try extending palindrome
        Optional<int[]> addLeft = findLongestPalindromeRecursively(str, start - 1, end);
        Optional<int[]> addRight = findLongestPalindromeRecursively(str, start, end + 1);
        Optional<int[]> addBoth = findLongestPalindromeRecursively(str, start - 1, end + 1);

        // return indices with biggest difference out of current, and deeper
        Set<int[]> toConsider = new HashSet<>();
        toConsider.add(new int[]{start, end});
        addLeft.ifPresent(toConsider::add);
        addRight.ifPresent(toConsider::add);
        addBoth.ifPresent(toConsider::add);
        return toConsider.stream().reduce(LongestPalindrome::maxDifferenceArray);
    }

}
