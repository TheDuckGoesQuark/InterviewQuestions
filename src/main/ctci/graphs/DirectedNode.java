package main.ctci.graphs;

import java.util.HashSet;
import java.util.Set;

public class DirectedNode {

    final Set<DirectedNode> adjacentNodes = new HashSet<>();

    public DirectedNode() {
    }

    public void addAdjacentNode(DirectedNode neighbour) {
        this.adjacentNodes.add(neighbour);
    }

    public Set<DirectedNode> getAdjacentNodes() {
        return adjacentNodes;
    }
}
