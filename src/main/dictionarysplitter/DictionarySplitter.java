package main.dictionarysplitter;

import java.util.*;

/**
 * Given a dictionary of words and a string made up of those words (no spaces),
 * return the original sentence in a list.
 * <p>
 * If there is more than one possible reconstruction,
 * return any of them.
 * <p>
 * If there is no possible reconstruction, then return null.
 * <p>
 * For example, given the set of words 'quick', 'brown', 'the', 'fox',
 * and the string "thequickbrownfox",
 * you should return ['the', 'quick', 'brown', 'fox'].
 * <p>
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond',
 * and the string "bedbathandbeyond",
 * return either ['bed', 'bath', 'and', 'beyond]
 * or ['bedbath', 'and', 'beyond'].
 * <p>
 * Assuming answers to questions given here
 * https://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem
 */
public class DictionarySplitter {

    /**
     * Splits the given string into words found in the given dictionary to restore original sentence.
     * <p>
     * If no solution, returns empty.
     *
     * @param str        original sentence with spaces between words removed
     * @param dictionary dictionary of possible words that could be in the string.
     *                   Assumed large, but small enough to fit in memory
     * @return original sentence as string array, or empty if no solution
     */
    public static Optional<String[]> reconstructSentence(String str, Set<String> dictionary) {
        final Stack<Integer> splitPoints = new Stack<>();

        if (determineSplitPoints(str, splitPoints, dictionary, new HashSet<>()))
            return Optional.ofNullable(splitSentence(str, splitPoints));
        else
            return Optional.empty();
    }

    /**
     * Recursively explore possible split points, recording failures in failed set
     *
     * @param str         string being split
     * @param splitPoints stack of possible split points, must be initialised with starting index
     * @param dictionary  set of words
     * @param failed      set of indices that have already failed as split points
     * @return false if unable to split string using dictionary, otherwise true
     */
    private static boolean determineSplitPoints(String str, Stack<Integer> splitPoints, Set<String> dictionary, Set<Integer> failed) {
        // dont explore if already known to fail from this point
        if (!splitPoints.isEmpty() && failed.contains(splitPoints.peek())) return false;

        // base case if last split point was end of string
        if (!splitPoints.empty() && splitPoints.peek() == str.length()) return true;

        // initialise start and end pointers
        int startIndex = splitPoints.isEmpty() ? 0 : splitPoints.peek();
        int endIndex = startIndex;

        // initialise string to current character
        final StringBuilder sb = new StringBuilder();

        while (endIndex < str.length()) {
            // add a character one at a time from string
            sb.append(str.charAt(endIndex));

            // if it forms a word
            if (dictionary.contains(sb.toString())) {
                // record split point
                int splitPoint = endIndex + 1;
                splitPoints.push(splitPoint);

                // check we can still form a sentence with the rest of the string
                if (determineSplitPoints(str, splitPoints, dictionary, failed))
                    return true;
                else {
                    // if not, record that we cant, then remove this split point
                    failed.add(splitPoint);
                    splitPoints.pop();
                }
            }

            // try the next character
            endIndex++;
        }

        // unable to create a sentence with the rest of the string
        return false;
    }

    /**
     * Splits string into string array at the indices given in the stack
     *
     * @param str         string to split
     * @param splitPoints stack of indices to split at from 0 to {@code str.length}
     * @return original string as array of strings split at given indices
     */
    private static String[] splitSentence(String str, Stack<Integer> splitPoints) {
        final String[] words = new String[splitPoints.size()];

        int start = 0;
        for (int i = 0; i < splitPoints.size(); i++) {
            int end = splitPoints.get(i);
            words[i] = str.substring(start, end);
            start = end;
        }

        return words;
    }
}
