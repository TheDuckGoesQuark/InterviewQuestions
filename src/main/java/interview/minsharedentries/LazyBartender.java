package interview.minsharedentries;

import java.util.*;
import java.util.stream.IntStream;

/**
 * At a popular bar, each customer has a set of favorite drinks, and will happily accept any drink among this set.
 * For example, in the following situation, customer 0 will be satisfied with drinks 0, 1, 3, or 6.
 * <p>
 * preferences = {
 * 0: [0, 1, 3, 6],
 * 1: [1, 4, 7],
 * 2: [2, 4, 7, 5],
 * 3: [3, 2, 5],
 * 4: [5, 8]
 * }
 * A lazy bartender working at this bar is trying to reduce his effort by limiting the drink recipes he must memorize.
 * Given a dictionary input such as the one above, return the fewest number of drinks he must learn in order to satisfy all customers.
 * <p>
 * For the input above, the answer would be 2, as drinks 1 and 5 will satisfy everyone.
 */
public class LazyBartender {

    private static Map<Integer, Integer> countCustomersSatisfiedByDrinks(int[][] preferences, int[] remainingCustomerIndices) {
        // find which drinks satisfies the most users
        var drinkToCustomerCount = new HashMap<Integer, Integer>();

        for (int customerIndex : remainingCustomerIndices) {
            var customer = preferences[customerIndex];
            for (int drink : customer) {
                drinkToCustomerCount.computeIfPresent(drink, (key, val) -> val + 1);
                drinkToCustomerCount.putIfAbsent(drink, 1);
            }
        }
        return drinkToCustomerCount;
    }

    private static List<Integer> getMostPopularDrinks(Map<Integer, Integer> drinkToCustomerCount) {
        var drinkToCustomerCountIterator = drinkToCustomerCount.entrySet().iterator();
        var maxSatisfyingDrinks = new ArrayList<Integer>();
        var firstEntry = drinkToCustomerCountIterator.next();
        var maxSatisfiedCount = firstEntry.getValue();
        maxSatisfyingDrinks.add(firstEntry.getKey());
        while (drinkToCustomerCountIterator.hasNext()) {
            var next = drinkToCustomerCountIterator.next();
            var satisfiedCount = next.getValue();
            var drink = next.getKey();
            if (satisfiedCount > maxSatisfiedCount) {
                maxSatisfyingDrinks.clear();
                maxSatisfyingDrinks.add(drink);
                maxSatisfiedCount = satisfiedCount;
            } else if (satisfiedCount.equals(maxSatisfiedCount)) {
                maxSatisfyingDrinks.add(drink);
            }
        }

        return maxSatisfyingDrinks;
    }

    private static boolean contains(int[] list, int number) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == number) return true;
        }
        return false;
    }

    private static int[] removeSatisfiedCustomerIndices(int[][] preferences, int[] remainingCustomerIndices, int drink) {
        return Arrays.stream(remainingCustomerIndices)
                .filter(i -> !contains(preferences[i], drink))
                .toArray();
    }

    private static int recursivelyFindMinRecipesNeeded(int[][] preferences, int[] remainingCustomerIndices) {
        if (remainingCustomerIndices.length == 0) return 0;

        var drinkToCustomerCount = countCustomersSatisfiedByDrinks(preferences, remainingCustomerIndices);
        var maxSatisfyingDrinks = getMostPopularDrinks(drinkToCustomerCount);

        var minRecipes = drinkToCustomerCount.size();
        for (var drink : maxSatisfyingDrinks) {
            var unsatisfiedCustomerIndices = removeSatisfiedCustomerIndices(preferences, remainingCustomerIndices, drink);
            var minRecipesThisDrinkRemoved = recursivelyFindMinRecipesNeeded(preferences, unsatisfiedCustomerIndices);
            if (minRecipesThisDrinkRemoved < minRecipes) {
                minRecipes = minRecipesThisDrinkRemoved;
            }
        }

        // plus one to account for the recipe used
        return 1 + minRecipes;
    }


    public static int findMinRecipesNeeded(int[][] preferences) {
        return recursivelyFindMinRecipesNeeded(preferences, IntStream.range(0, preferences.length).toArray());
    }
}
