package interview.runnerspath;

import java.util.Arrays;

/**
 * A competitive runner would like to create a route that starts and ends at his house,
 * with the condition that the route goes entirely uphill at first, and then entirely downhill.
 * <p>
 * Given a dictionary of places of the form {location: elevation},
 * and a dictionary mapping paths between some of these locations to their corresponding distances,
 * find the length of the shortest route satisfying the condition above.
 * Assume the runner's home is location 0.
 * <p>
 * For example, suppose you are given the following input:
 * <p>
 * elevations = {0: 5, 1: 25, 2: 15, 3: 20, 4: 10}
 * paths = {
 * (0, 1): 10,
 * (0, 2): 8,
 * (0, 3): 15,
 * (1, 3): 12,
 * (2, 4): 10,
 * (3, 4): 5,
 * (3, 0): 17,
 * (4, 0): 10
 * }
 * In this case, the shortest valid path would be 0 -> 2 -> 4 -> 0, with a distance of 28.
 */
public class RoutePlanner {
    /**
     * @param elevations elevations[i] = the elevation of location i
     * @param paths      paths[i] = [startLocation, endLocation, distanceBetween]
     * @return shortest path length where path goes entirely uphill then entirely downhill
     */
    public static int findShortestPathLength(int[] elevations, int[][] paths) {
        // find uphill only path distance from origin to all other locations
        var uphillDistances = getDistancesFromOrigin(elevations, paths, true);
        // find downhill only path distance from origin to all other locations
        var downhillDistances = getDistancesFromOrigin(elevations, paths, false);

        // iterate over all other locations to find the min uphill path distance + downhill path distance
        var minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < elevations.length; i++) {
            if (uphillDistances[i] == Integer.MAX_VALUE || downhillDistances[i] == Integer.MAX_VALUE) continue;

            var totalDistance = uphillDistances[i] + downhillDistances[i];
            if (totalDistance < minDistance) {
                minDistance = totalDistance;
            }
        }
        return minDistance;
    }

    private static int[] getDistancesFromOrigin(int[] elevations, int[][] paths, boolean ascending) {
        // initialise distances to each location to max
        var numNodes = elevations.length;
        var distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        // track visited nodes
        var visitedNodes = new boolean[numNodes];

        for (int i = 0; i < numNodes; i++) {
            var currentIndex = pickNearestUnvisitedNode(visitedNodes, distances);
            visitedNodes[currentIndex] = true;

            if (distances[currentIndex] == Integer.MAX_VALUE) {
                continue;
            }

            for (var path : paths) {
                // for ascending, we do normal dijkstra
                // for descending, we flip the start and finish of edges to be upwards from the origin
                // so that we can re-use the same logic
                var start = ascending ? path[0] : path[1];
                var end = ascending ? path[1] : path[0];

                // skip edges not originating from current node
                if (start != currentIndex) continue;
                // ignore visited neighbours
                if (visitedNodes[end]) continue;

                // skip edges not in direction we're going
                var isUphill = elevations[start] < elevations[end];
                if (!isUphill) continue;

                var vertexDistance = path[2];
                var distanceFromOriginToCurrentNode = distances[currentIndex];
                var distanceFromOriginToNeighbourThroughCurrentNode = distanceFromOriginToCurrentNode + vertexDistance;
                var distanceFromOriginToNeighbour = distances[end];
                if (distanceFromOriginToNeighbourThroughCurrentNode < distanceFromOriginToNeighbour) {
                    distances[end] = distanceFromOriginToNeighbourThroughCurrentNode;
                }
            }
        }

        return distances;
    }

    private static int pickNearestUnvisitedNode(boolean[] visitedIndices, int[] tentativeDistances) {
        var minDistanceIndex = -1;
        for (int i = 0; i < tentativeDistances.length; i++) {
            if (visitedIndices[i]) continue;
            if (minDistanceIndex == -1 || (tentativeDistances[i] < tentativeDistances[minDistanceIndex])) {
                minDistanceIndex = i;
            }
        }
        return minDistanceIndex;
    }
}
