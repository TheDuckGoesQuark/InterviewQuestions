package main.ctci.one;

import java.util.Arrays;

/**
 * Page 90,
 */
public class One {

    /**
     * Is Unique: Implement an algorithm to determine
     * if a string has all unique characters.
     * <p>
     * What if you cannot use additional data structures?
     */
    public static boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) return false;
        }

        return true;
    }

    /**
     * Check Permutation: Given two strings, write a method to decide if
     * one is a permutation of the other.
     */
    public static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        Arrays.sort(achars);
        Arrays.sort(bchars);

        for (int i = 0; i < achars.length; i++) {
            if (achars[i] != bchars[i]) return false;
        }

        return true;
    }

    /**
     * Write a method to replace all spaces in a string with '%20'.
     * <p>
     * You may assume that the string has sufficient space at the end to hold the additional characters,
     * and that you are given the "true" length of the string.
     * <p>
     * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
     */
    public static String URLify(char[] str) {
        int indexOfLastLetter = getIndexOfLastLetter(str);

        // if none non-whitespace, return original string
        if (indexOfLastLetter == -1)
            return String.valueOf(str);

        int currentWritableIndex = str.length - 1;
        while (indexOfLastLetter >= 0) {
            // if we hit whitespace, insert '%20' at current writeable index
            if (isWhitespace(str[indexOfLastLetter])) {
                str[currentWritableIndex] = '0';
                str[--currentWritableIndex] = '2';
                str[--currentWritableIndex] = '%';
            } else {
                // otherwise, copy this character to current writeable index and step back
                str[currentWritableIndex] = str[indexOfLastLetter];
            }

            currentWritableIndex--;
            indexOfLastLetter--;
        }

        return String.valueOf(str);
    }

    private static int getIndexOfLastLetter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (!isWhitespace(str[i])) return i;
        }

        return -1;
    }

    private static boolean isWhitespace(char c) {
        return c == ' ';
    }

    /**
     * Given a string, write a function to check if it is a permutation of a palin­
     * drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     * EXAMPLE
     * Input: Tact Coa
     * Output: True (permutations: "taco cat", "atco eta", etc.)
     */
    public static boolean palindromePermutation(String str) {
        int[] charCounts = new int[128]; // assume ascii

        for (char c : str.toCharArray()) {
            if (!isWhitespace(c)) charCounts[c]++;
        }

        boolean oddFound = false;
        for (int aChar : charCounts) {
            if (aChar % 2 == 1) {
                // track if we already found a character that appears an odd number of times
                if (oddFound) return false; // if we have then we've failed
                else oddFound = true;  // if we havent, record that we have now
            }
        }

        return true;
    }
}
