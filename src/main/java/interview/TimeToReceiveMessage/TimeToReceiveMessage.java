package interview.TimeToReceiveMessage;

import interview.overlappingintervals.OverlappingIntervals;

import java.util.Arrays;
import java.util.HashSet;

/**
 * A network consists of nodes labeled 0 to N. You are given a list of edges (a, b, t), describing the time t it takes for a message to be sent from node a to node b. Whenever a node receives a message, it immediately passes the message on to a neighboring node, if possible.
 * <p>
 * Assuming all nodes are connected, determine how long it will take for every node to receive a message that begins at node 0.
 * <p>
 * For example, given N = 5, and the following edges:
 * <p>
 * edges = [
 * (0, 1, 5),
 * (0, 2, 3),
 * (0, 5, 4),
 * (1, 3, 8),
 * (2, 3, 1),
 * (3, 5, 10),
 * (3, 4, 5)
 * ]
 * You should return 9, because propagating the message from 0 -> 2 -> 3 -> 4 will take that much time.
 */
public class TimeToReceiveMessage {

    public static int findTimeForAllNodesToReceiveMessage(int[][] edges) {
        var nodes = new HashSet<Integer>();
        for (int[] edge : edges) {
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }

        if (nodes.isEmpty()) return 0;


        var numNodes = nodes.size();
        var distances = new int[numNodes];
        Arrays.fill(distances, Integer.MAX_VALUE);
        var visited = new boolean[numNodes];

        // initialise root to 0
        distances[0] = 0;

        for (int i = 0; i < numNodes; i++) {
            // pick nearest unvisited node
            var nearestUnvisitedNodeIndex = pickNearestUnvisitedNodeIndex(distances, visited);
            // mark it as visited
            visited[nearestUnvisitedNodeIndex] = true;

            // ignore nodes that can't be reached
            if (distances[nearestUnvisitedNodeIndex] == Integer.MAX_VALUE) {
                continue;
            }

            var distanceFromOriginToCurrentNode = distances[nearestUnvisitedNodeIndex];

            // find relevant edges
            for (var edge : edges) {
                // ignore edges that don't start from this vertex
                var start = edge[0];
                if (start != nearestUnvisitedNodeIndex) continue;

                // ignore edges with visited neighbours
                var end = edge[1];
                if (visited[end]) continue;

                var weight = edge[2];

                var distanceFromOriginToNeighbourViaCurrentNode = distanceFromOriginToCurrentNode + weight;
                var distanceFromOriginToNeighbour = distances[end];
                if (distanceFromOriginToNeighbourViaCurrentNode < distanceFromOriginToNeighbour) {
                    distances[end] = distanceFromOriginToNeighbourViaCurrentNode;
                }
            }
        }

        // return max time
        return Arrays.stream(distances).max().orElse(0);
    }

    private static int pickNearestUnvisitedNodeIndex(int[] distances, boolean[] visited) {
        var index = -1;
        var minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                index = i;
                minDistance = distances[i];
            }
        }
        return index;
    }
}
