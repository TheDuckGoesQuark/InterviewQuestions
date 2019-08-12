package main.editdistance;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The edit distance between two strings refers to
 * the minimum number of character insertions, deletions, and substitutions
 * required to change one string to the other.
 * <p>
 * For example, the edit distance between “kitten” and “sitting” is three:
 * substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
 * <p>
 * Given two strings, compute the edit distance between them.
 */
public class EditDistance {

    public static int getEditDistance(String a, String b) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        try {
            return recursivelyGetEditDistance(a, b, a.length(), b.length(), map);
        } finally {
            System.out.println("");
        }
    }

    private static int recursivelyGetEditDistance(String a, String b, int lengthA, int lengthB, Map<Integer, Map<Integer, Integer>> alreadyTried) {
        // if no more characters in string a, we need as many insertions as there are characters in string b
        if (lengthA == 0) {
            return lengthB;
        }

        // reverse of above
        if (lengthB == 0) {
            return lengthA;
        }

        // if characters are the same, then we don't need to do anything
        if (a.charAt(lengthA - 1) == b.charAt(lengthB - 1))
            return recursivelyGetEditDistance(a, b, lengthA - 1, lengthB - 1, alreadyTried);

        if (!alreadyTried.containsKey(lengthA)) alreadyTried.put(lengthA, new HashMap<>());
        // get insertion cost
        Map<Integer, Integer> knownCosts = alreadyTried.get(lengthA);
        if (!knownCosts.containsKey(lengthB - 1))
            knownCosts.put(lengthB - 1, recursivelyGetEditDistance(a, b, lengthA, lengthB - 1, alreadyTried));
        int insertion = knownCosts.get(lengthB - 1);

        if (!alreadyTried.containsKey(lengthA - 1)) alreadyTried.put(lengthA - 1, new HashMap<>());

        knownCosts = alreadyTried.get(lengthA - 1);
        if (!knownCosts.containsKey(lengthB))
            knownCosts.put(lengthB, recursivelyGetEditDistance(a, b, lengthA - 1, lengthB, alreadyTried));
        int deletion = knownCosts.get(lengthB);

        if (!knownCosts.containsKey(lengthB - 1))
            knownCosts.put(lengthB - 1, recursivelyGetEditDistance(a, b, lengthA - 1, lengthB - 1, alreadyTried));

        int substitution = knownCosts.get(lengthB - 1);

        return 1 + Integer.min(Integer.min(insertion, deletion), substitution);
    }
}
