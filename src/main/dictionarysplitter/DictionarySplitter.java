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
        return reconstructSentenceRecursively(str, dictionary, new LinkedList<>(), 0);
    }

    // TODO add dynamic programming optimisation
    private static Optional<String[]> reconstructSentenceRecursively(String str, Set<String> dictionary, LinkedList<Integer> splitPoints, int currentIndex) {
        if (currentIndex == str.length()) {
            return Optional.of(splitStringAtIndices(str, splitPoints));
        }

        final StringBuilder currentWord = new StringBuilder();
        while (currentIndex < str.length()) {
            currentWord.append(str.charAt(currentIndex));

            if (dictionary.contains(currentWord.toString())) {
                splitPoints.addLast(currentIndex + 1);
                Optional<String[]> branchResult =
                        reconstructSentenceRecursively(str, dictionary, splitPoints, currentIndex + 1);

                if (branchResult.isPresent()) {
                    return branchResult;
                } else {
                    splitPoints.removeLast();
                }
            }

            currentIndex++;
        }

        return Optional.empty();
    }

    private static String[] splitStringAtIndices(String str, LinkedList<Integer> splitPoints) {
        final String[] arr = new String[splitPoints.size()];

        int prev = 0, next;
        for (int i = 0; splitPoints.size() > 0; i++) {
            next = splitPoints.removeFirst();
            arr[i] = str.substring(prev, next);
            prev = next;
        }

        return arr;
    }

}
