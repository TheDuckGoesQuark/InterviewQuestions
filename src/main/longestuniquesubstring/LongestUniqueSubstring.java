package main.longestuniquesubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer k and a string s, find the length of the longest substring
 * that contains at most k distinct characters.
 * <p>
 * For example, given s = "abcba" and k = 2,
 * the longest substring with k distinct characters is "bcb".
 */
public class LongestUniqueSubstring {

    /**
     * Retrieves the length of the longest substring that contains at most k distinct characters
     *
     * @param str string to analyse
     * @param k   maximum number of unique characters to appear in substring
     * @return the length of the longest substring that contains at most k distinct characters
     */
    public static int getLengthOfSubstringWithKUniqueCharacters(String str, int k) {
        int longestUniqueSubstring = 0;
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int currentStreak = 0;
            for (int j = i; j < str.length(); j++) {
                char current = str.charAt(j);
                seen.add(current);
                if (seen.size() <= k) currentStreak++;
            }

            longestUniqueSubstring = longestUniqueSubstring < currentStreak ? currentStreak : longestUniqueSubstring;
            seen.clear();
        }
        return longestUniqueSubstring;
    }

    /*
        Simple (backtracking)
        for each letter:
           count how many characters until more than k unique characters are found
           once >k characters found, backtrack to start character + 1
     */

}
