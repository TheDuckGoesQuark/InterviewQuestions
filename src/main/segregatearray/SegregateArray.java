package main.segregatearray;

/**
 * Given an array of strictly the characters 'R', 'G', and 'B',
 * segregate the values of the array so that all the Rs come first,
 * the Gs come second, and the Bs come last.
 * <p>
 * You can only swap elements of the array.
 * <p>
 * Do this in linear time and in-place.
 * <p>
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'],
 * it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
public class SegregateArray {

    public static void segregateArray(char[] arr) {
        int lastSwapIndex = 0;

        // first pass, swap all Rs
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 'R') {
                swap(i, lastSwapIndex, arr);
                lastSwapIndex++;
            }
        }

        // second pass pass, start from last R
        for (int i = lastSwapIndex; i < arr.length; i++) {
            if (arr[i] == 'G') {
                swap(i, lastSwapIndex, arr);
                lastSwapIndex++;
            }
        }
    }

    private static void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
