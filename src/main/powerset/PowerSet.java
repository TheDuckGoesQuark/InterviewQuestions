package main.powerset;

import java.util.HashSet;
import java.util.Set;

/**
 * The power set of a set is the set of all its subsets.
 * Write a function that, given a set, generates its power set.
 * <p>
 * For example, given the set {1, 2, 3},
 * it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 * <p>
 * You may also use a list or array to represent a set.
 */
public class PowerSet {

    public static <T> Set<Set<T>> generatePowerSet(Set<T> set) {
        final Set<Set<T>> result = new HashSet<>();

        // add empty set
        result.add(new HashSet<>());

        // recursively create sets
        recursivelyAddSets(set, result);

        return result;
    }

    private static <T> void recursivelyAddSets(Set<T> values, Set<Set<T>> result) {
        if (values.size() == 0) return;

        // add values currently in set
        result.add(values);

        // recursive call, after removing each element
        for (T value : values) {
            Set<T> copy = new HashSet<>(values);
            copy.remove(value);
            recursivelyAddSets(copy, result);
        }
    }
}
