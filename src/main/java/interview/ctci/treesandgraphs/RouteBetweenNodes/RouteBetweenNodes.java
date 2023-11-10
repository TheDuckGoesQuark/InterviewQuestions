package interview.ctci.treesandgraphs.RouteBetweenNodes;

import java.util.LinkedList;

/**
 * Given a directed graph
 * Design an algorithm to find out whether there is a route between two nodes
 */
public class RouteBetweenNodes {
    public static boolean routeBetweenTwoNodes(int[][] adjacencyList, int nodeAIndex, int nodeBIndex) {
        // depth first search from both nodes
        var explored = new boolean[adjacencyList.length];
        var toExplore = new LinkedList<Integer>();

        toExplore.push(nodeAIndex);

        while (!toExplore.isEmpty()) {
            var next = toExplore.pop();

            // already seen this node
            if (explored[next]) continue;

            // for each neighbour,
            // check if we've reached B
            // add to explore if not seen before
            for (int i = 0; i < adjacencyList[next].length; i++) {
                var edge = adjacencyList[next][i];
                var edgeExists = edge == 1;
                if (!edgeExists || explored[i]) continue;
                else if (i == nodeBIndex) return true;
                else {
                    toExplore.push(i);
                }
                explored[next] = true;
            }
        }
        return false;
    }
}
