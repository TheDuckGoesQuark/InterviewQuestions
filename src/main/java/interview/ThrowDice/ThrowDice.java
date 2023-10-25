package interview.ThrowDice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

/**
 * Write a function, throw_dice(N, faces, total),
 * that determines how many ways it is possible to throw N dice with some number of faces each to get a specific total.
 * <p>
 * For example, throw_dice(3, 6, 7) should equal 15.
 */
public class ThrowDice {

    public static int numWaysToAchieveTotal(int nDice, int nFaces, int total) {
        return recursivelyFindNumWaysToAchieveTotal(nDice, nFaces, total, new HashMap<>());
    }

    private static int recursivelyFindNumWaysToAchieveTotal(int nDice, int nFaces, int total, Map<String, Integer> knownCombinations) {
        // assumption: we're looking for permutations not combinations, i.e. rolling 1 and 2 are not the same as rolling 2 and 1
        if (nDice == 1) {
            // if the total required is within the number of faces we have
            // then it's achievable for one dice
            return total <= nFaces ? 1 : 0;
        }

        var count = 0;
        for (int i = 0; i < nFaces; i++) {
            var rolled = i + 1;

            var remainingTotal = total - rolled;

            // overrolled
            if (remainingTotal == 0) break;

            var remainingDice = nDice - 1;
            var combinationEncoded = remainingDice + "," + nFaces + "," + remainingTotal;

            // memoise
            if (knownCombinations.containsKey(combinationEncoded)) {
                count += knownCombinations.get(combinationEncoded);
            } else {
                var waysToAchieveRemainingTotal = recursivelyFindNumWaysToAchieveTotal(remainingDice, nFaces, remainingTotal, knownCombinations);
                count += waysToAchieveRemainingTotal;
                knownCombinations.put(combinationEncoded, waysToAchieveRemainingTotal);
            }
        }

        return count;
    }
}
