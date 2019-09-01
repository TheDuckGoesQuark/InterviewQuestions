package main.ctci.graphs;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Graphs {

    /**
     * @return true if a path exists between the two nodes in a directed graph
     */
    public static boolean routeExistsBetween(DirectedNode a, DirectedNode b) {

        // nodes seen when exploring from a and b
        final Set<DirectedNode> seenByA = new HashSet<>();
        final Set<DirectedNode> seenByB = new HashSet<>();

        // collection of nodes to explore next in each search
        final Queue<DirectedNode> toExploreA= new LinkedBlockingQueue<>();
        final Queue<DirectedNode> toExploreB = new LinkedBlockingQueue<>();

        toExploreA.add(a);
        toExploreB.add(b);

        // exhaust both networks
        while (!toExploreA.isEmpty() || !toExploreB.isEmpty()) {
            if (!seenByA.isEmpty()) {
                final DirectedNode next = toExploreA.remove();

                if (seenByB.contains(next)) return true;

                addNeighoursToSearch(next, seenByA, toExploreA);
            }

            if (!seenByB.isEmpty()) {
                final DirectedNode next = toExploreB.remove();

                if (seenByA.contains(next)) return true;

                addNeighoursToSearch(next, seenByB, toExploreB);
            }
        }

        return false;
    }

    private static void addNeighoursToSearch(DirectedNode node, Set<DirectedNode> seenNodes, Queue<DirectedNode> toExplore) {
        node.getAdjacentNodes()
                .stream()
                .filter(directedNode -> !seenNodes.contains(directedNode))
                .forEach(toExplore::add);
    }
}
