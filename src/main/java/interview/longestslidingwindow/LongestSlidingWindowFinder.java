package interview.longestslidingwindow;

/**
 * A girl is walking along an apple orchard with a bag in each hand.
 * She likes to pick apples from each tree as she goes along, but is meticulous about not putting different kinds of apples in the same bag.
 * <p>
 * Given an input describing the types of apples she will pass on her path, in order,
 * determine the length of the longest portion of her path that consists of just two types of apple trees.
 * <p>
 * For example, given the input [2, 1, 2, 3, 3, 1, 3, 5], the longest portion will involve types 1 and 3, with a length of four.
 */
public class LongestSlidingWindowFinder {

    private static void initialiseWindow(int[] arr, int[] numbersInWindow, int[] numbersInWindowStreakStart) {
        // first number starts streak
        numbersInWindow[0] = arr[0];
        numbersInWindowStreakStart[0] = 0;

        // find next different number
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != numbersInWindow[0]) {
                numbersInWindow[1] = arr[i];
                numbersInWindowStreakStart[1] = i;
                break;
            }
        }
    }

    private static int getIndexInWindow(int number, int[] numbersInWindow) {
        // find index of this numbers streak counter
        for (int i = 0; i < numbersInWindow.length; i++) {
            if (number == numbersInWindow[i]) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isInWindow(int number, int[] numbersInWindow) {
        return getIndexInWindow(number, numbersInWindow) != -1;
    }

    private static boolean isMostRecentNumberInWindow(int currentNumber, int[] numbersInWindow, int[] numbersInWindowStreakStart) {
        var numberInWindowIndex = getIndexInWindow(currentNumber, numbersInWindow);

        var currentNumberStreakStart = numbersInWindowStreakStart[numberInWindowIndex];
        for (int i : numbersInWindowStreakStart) {
            // if the index of the current numbers streak is earlier in the list
            // then it can't be the most recent streak
            if (currentNumberStreakStart < i) {
                return false;
            }
        }
        return true;
    }

    private static int getOldestEntryInWindowIndex(int[] numbersInWindow, int[] numbersInWindowStreakStart) {
        var oldestEntryIndex = 0;
        for (int i = 0; i < numbersInWindow.length; i++) {
            var streakStart = numbersInWindowStreakStart[i];
            if (streakStart < numbersInWindowStreakStart[oldestEntryIndex]) {
                oldestEntryIndex = i;
            }
        }
        return oldestEntryIndex;
    }

    private static void replaceOldestEntryInWindow(int currentNumber, int currentNumberIndex, int[] numbersInWindow, int[] numbersInWindowStreakStart) {
        var oldestEntryIndex = getOldestEntryInWindowIndex(numbersInWindow, numbersInWindowStreakStart);
        numbersInWindow[oldestEntryIndex] = currentNumber;
        numbersInWindowStreakStart[oldestEntryIndex] = currentNumberIndex;
    }

    public static int findLongestWindowOfTwoNumbers(int[] arr) {
        // easy cases
        if (arr.length <= 2) {
            return arr.length;
        }

        // the two numbers in current sliding window
        var numbersInWindow = new int[2];
        // the index of each numbers most recent streak in the sliding window
        var numbersInWindowStreakStart = new int[2];

        // initialise window so we can guarantee two different numbers are being tracked
        initialiseWindow(arr, numbersInWindow, numbersInWindowStreakStart);
        // if no second number was found, we can return early as the whole list is one number
        if (numbersInWindowStreakStart[1] == 0) {
            return arr.length;
        }

        // the max streak
        var maxStreak = 2;
        // the current sliding window length
        var currentStreak = 2;
        for (var i = 2; i < arr.length; i++) {
            var currentNumber = arr[i];

            if (!isInWindow(currentNumber, numbersInWindow)) {
                // remove oldest entry
                replaceOldestEntryInWindow(currentNumber, i, numbersInWindow, numbersInWindowStreakStart);
                // reset streak
                var newStreakStartIndex = numbersInWindowStreakStart[getOldestEntryInWindowIndex(numbersInWindow, numbersInWindowStreakStart)];
                currentStreak = i - newStreakStartIndex;
            } else if (!isMostRecentNumberInWindow(currentNumber, numbersInWindow, numbersInWindowStreakStart)) {
                // reset streak to start from current index
                var indexInWindow = getIndexInWindow(currentNumber, numbersInWindow);
                numbersInWindowStreakStart[indexInWindow] = i;
            }

            currentStreak++;
            if (currentStreak > maxStreak) maxStreak = currentStreak;
        }

        return maxStreak;
    }
}
