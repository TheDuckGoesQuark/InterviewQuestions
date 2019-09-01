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
        final Queue<DirectedNode> toExploreA = new LinkedBlockingQueue<>();
        final Queue<DirectedNode> toExploreB = new LinkedBlockingQueue<>();

        toExploreA.add(a);
        toExploreB.add(b);

        // exhaust both networks
        while (!toExploreA.isEmpty() || !toExploreB.isEmpty()) {
            if ((!toExploreA.isEmpty() && performParallelSearch(toExploreA, seenByB, seenByA))
                    || (!toExploreB.isEmpty() && performParallelSearch(toExploreB, seenByA, seenByB))) return true;
        }

        return false;
    }

    private static boolean performParallelSearch(Queue<DirectedNode> toExplore, Set<DirectedNode> seenDuringOtherSearch, Set<DirectedNode> seenDuringCurrentSearch) {
        final DirectedNode next = toExplore.remove();

        if (seenDuringOtherSearch.contains(next)) return true;

        addNeighoursToSearch(next, seenDuringCurrentSearch, toExplore);

        seenDuringCurrentSearch.add(next);

        return false;
    }

    private static void addNeighoursToSearch(DirectedNode node, Set<DirectedNode> seenNodes, Queue<DirectedNode> toExplore) {
        node.getAdjacentNodes()
                .stream()
                .filter(directedNode -> !seenNodes.contains(directedNode))
                .forEach(toExplore::add);
    }
}
