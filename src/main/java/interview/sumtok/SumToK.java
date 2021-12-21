package interview.sumtok;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Given a list of integers S and a target number k,
 * write a function that returns a subset of S that adds up to k.
 * <p>
 * If such a subset cannot be made, then return null.
 * <p>
 * Integers can appear more than once in the list.
 * You may assume all numbers in the list are positive.
 * <p>
 * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24,
 * return [12, 9, 2, 1] since it sums up to 24.
 */
public class SumToK {

    public static Optional<List<Integer>> getSubsetThatAddsToK(List<Integer> numbers, int target) {
        if (numbers.size() == 0) {
            if (target == 0)
                return Optional.of(Collections.emptyList());
            else
                return Optional.empty();
        }

        // check if current subset can produce target
        int currentTotal = numbers.stream().reduce(Integer::sum).get();
        if (currentTotal == target) return Optional.of(numbers);
        else if (currentTotal < target) return Optional.empty();

        // remove number from list and try generate with that subset
        for (int i = 0; i < numbers.size(); i++) {
            int removed = numbers.remove(i);
            Optional<List<Integer>> result = getSubsetThatAddsToK(numbers, target);

            if (result.isPresent()) return result;
            else numbers.add(i, removed);
        }

        return Optional.empty();

    }
}
