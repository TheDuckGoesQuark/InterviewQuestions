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
        int len = str.length();
        if (len == 1) return str;

        int[] longestIndices = new int[]{0, 0};

        int nCombinations = len * (len + 1) / 2;
        boolean[] tried = new boolean[nCombinations];

        // use each character as 'root' of palindrome
        for (int i = 0; i < len; i++) {
            final Optional<int[]> result = findLongestPalindromeRecursively(str, i, i, tried);

            if (result.isPresent()) {
                longestIndices = maxDifferenceArray(result.get(), longestIndices);
            }
        }

        return str.substring(longestIndices[0], longestIndices[1] + 1);
    }

    private static int getIndexInCache(int start, int end, int cacheSize) {
        // pairs combinations look like this
        //# 0 1 2 3 ...
        //0 T F F F
        //1   T F F
        //2     T F
        //3       T
        //...
        // so index is
        return 0; // TODO
        // https://stackoverflow.com/questions/27086195/linear-index-upper-triangular-matrix
    }

    private static Optional<int[]> findLongestPalindromeRecursively(String str, int start, int end, boolean[] tried) {
        // can't go further
        if (start < 0 || end == str.length()) return Optional.empty();

        // use memoized solution
        int cacheIndex = getIndexInCache(start, end, tried.length);

        // go no further if result already known
        if (tried[cacheIndex]) return Optional.empty();

        // no longer palindrome, go back
        if (str.charAt(start) != str.charAt(end))
            return Optional.empty();

        // add to cache
        tried[cacheIndex] = true;

        // try extending palindrome
        Optional<int[]> addLeft = findLongestPalindromeRecursively(str, start - 1, end, tried);
        Optional<int[]> addRight = findLongestPalindromeRecursively(str, start, end + 1, tried);
        Optional<int[]> addBoth = findLongestPalindromeRecursively(str, start - 1, end + 1, tried);

        // return indices with biggest difference out of current, and deeper
        Set<int[]> toConsider = new HashSet<>();
        toConsider.add(new int[]{start, end});
        addLeft.ifPresent(toConsider::add);
        addRight.ifPresent(toConsider::add);
        addBoth.ifPresent(toConsider::add);
        return toConsider.stream().reduce(LongestPalindrome::maxDifferenceArray);
    }

}
