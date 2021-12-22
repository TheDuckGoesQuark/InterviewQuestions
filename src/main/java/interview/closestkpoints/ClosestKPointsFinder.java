package interview.closestkpoints;

import java.util.LinkedList;

/**
 * Given a list of points, a central point, and an integer k,
 * find the nearest k points from the central point.
 *
 * For example, given the list of points [(0, 0), (5, 4), (3, 1)],
 * the central point (1, 2), and k = 2, return [(0, 0), (3, 1)].
 */
public class ClosestKPointsFinder {

    private final int[][] points;

    public ClosestKPointsFinder(int[][] points) {
        this.points = points;
    }

    public int[][] findClosestKPoints(int[] centralPoint, int k) {
        // min-max heap of distance-point pairs, add each point then take first k ( O(n) time O(n) space )
        // track k closest as distance-point pairs, iterating over each point and inserting into k ( O(n) * k, O(k) space )
        // Assuming n is generally large, and k << n, second solution is better

        // for each point, insert into linkedList of k points sorted by distance
        var sortedDistances = new LinkedList<DistancePointIndexTuple>();
        for (int i = 0; i < points.length; i++) {
            var point = points[i];
            var distance = distanceBetweenPoints(centralPoint, point);
            insertPointIntoSortedDistances(new DistancePointIndexTuple(distance, i),sortedDistances, k);
        }

        // build output
        var output = new int[Math.min(k, points.length)][2];
        var outputIter = sortedDistances.listIterator();
        while (outputIter.hasNext()) {
            var currentIndex = outputIter.nextIndex();
            var tuple = outputIter.next();
            var inputIndex = tuple.pointIndex;
            output[currentIndex] = points[inputIndex];
        }
        return output;
    }

    private static void insertPointIntoSortedDistances(DistancePointIndexTuple toInsert, LinkedList<DistancePointIndexTuple> sortedDistances, int k) {
        var outputIter = sortedDistances.listIterator();
        var inserted = false;
        while (outputIter.hasNext()) {
            var currentIndex = outputIter.nextIndex();
            var currentDistance = outputIter.next().distance;
            if (currentDistance < toInsert.distance)  {
                if (currentIndex > 0) {
                    // found where to insert
                    outputIter.add(toInsert);
                    inserted = true;
                } else {
                    // further than furthest point, don't proceed
                    return;
                }
            } // else keep looking
        }

        // reached end of list, must be closest point
        if (!inserted) {
            sortedDistances.add(toInsert);
        }

        // maintain k length
        if (sortedDistances.size() > k) {
            sortedDistances.removeFirst();
        }
    }

    private static double distanceBetweenPoints(int[] a, int[] b) {
        return Math.sqrt(Math.pow(Math.abs(a[0] - b[0]), 2) + Math.pow(Math.abs(a[1] - b[1]), 2));
    }

    private static class DistancePointIndexTuple {
        public double distance;
        public int pointIndex;

        public DistancePointIndexTuple(double distance, int pointIndex) {
            this.distance = distance;
            this.pointIndex = pointIndex;
        }
    }
}
