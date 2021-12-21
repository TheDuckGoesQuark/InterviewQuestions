package interview.elevationmap;

/**
 * You are given an array of non-negative integers that
 * represents a two-dimensional elevation map where each element is unit-width wall
 * and the integer is the height.
 * <p>
 * Suppose it will rain and all spots between two walls get filled up.
 * <p>
 * Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 * <p>
 * For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
 * <p>
 * Given the input [3, 0, 1, 3, 0, 5],
 * we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index
 * (we cannot hold 5 since it would run off to the left),
 * so we can trap 8 units of water.
 */
public class ElevationMap {

    public static int getVolumeContainable(int[] elevationMap) {
        int units = 0;

        int i = 1;
        while (i < elevationMap.length) {

            int indexOfBasinStart = i - 1;

            int indexOfBasinEnd = i;
            while (i < elevationMap.length) {
                int current = elevationMap[i];

                if (current >= elevationMap[indexOfBasinStart]) {
                    indexOfBasinEnd = i;
                    break; // basin can't get bigger
                } else {
                    // increase basin min height if bigger wall found
                    if (current >= elevationMap[indexOfBasinEnd])
                        indexOfBasinEnd = i;

                    i++; // keep going until we reach the end or an equal wall
                }
            }

            int height = Integer.min(elevationMap[indexOfBasinStart], elevationMap[indexOfBasinEnd]);
            for (int j = indexOfBasinStart; j < i; j++) {
                if (elevationMap[j] <= height)
                    units += (height - elevationMap[j]);
            }

            // move i to end of last basin
            if (i != indexOfBasinEnd) i = indexOfBasinEnd + 1;
            i++;
        }

        return units;
    }

}
