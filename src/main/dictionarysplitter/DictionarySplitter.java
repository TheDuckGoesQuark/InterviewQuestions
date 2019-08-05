package main.dictionarysplitter;

import java.util.Optional;
import java.util.Set;

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
        /*
        Preprocess dictionary into autocomplete tree

        Traverse tree for first match in str, add word to stack, recursively call for rest of string

        Return if whole string is consumed
        Else, backtrack

        Return empty if nothing found
         */
        return null;
    }

}
