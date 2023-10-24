package interview.GraphCycle;

/**
 * Given an undirected graph, determine if it contains a cycle.
 */
public class GraphCycle {
    public static boolean containsCycle(int[][] adjacencyMatrix) {
        // DFS for each node, if find explored node then graph contains cycle
        // O(V+E)
        var visited = new boolean[adjacencyMatrix.length];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            var alreadyVisited = visited[i];

            if (!alreadyVisited) {
                if (containsCycle(adjacencyMatrix, i, visited)) return true;
            }
        }

        return false;
    }

    private static boolean containsCycle(int[][] adjacencyMatrix, int i, boolean[] visited) {
        if (visited[i]) return true;
        visited[i] = true;

        for (int j = 0; j < adjacencyMatrix[i].length; j++) {
            var edgeExists = adjacencyMatrix[i][j] == 1;
            if (edgeExists) {
                // remove this edge in both directions so we don't use it again
                // not really a cycle
                adjacencyMatrix[i][j] = 0;
                adjacencyMatrix[j][i] = 0;
                if (containsCycle(adjacencyMatrix, j, visited)) return true;
            }
        }

        return false;
    }
}
