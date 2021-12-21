package interview.ctci.graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphsTest {

    @Test
    public void routeExistsBetween() {
        final DirectedNode
                a = new DirectedNode(), b = new DirectedNode(),
                c = new DirectedNode(), d = new DirectedNode(),
                e = new DirectedNode(), f = new DirectedNode();

        assertFalse(Graphs.routeExistsBetween(a, b));
        assertTrue(Graphs.routeExistsBetween(a, a));

        a.addAdjacentNode(b);
        assertTrue(Graphs.routeExistsBetween(a, b));

        b.addAdjacentNode(c);
        assertTrue(Graphs.routeExistsBetween(a, c));

        c.addAdjacentNode(d);
        assertTrue(Graphs.routeExistsBetween(a,d));
        assertTrue(Graphs.routeExistsBetween(b,d));

        a.addAdjacentNode(e);
        e.addAdjacentNode(f);
        f.addAdjacentNode(d);

        assertTrue(Graphs.routeExistsBetween(e, d));
        assertTrue(Graphs.routeExistsBetween(e, a));
        assertTrue(Graphs.routeExistsBetween(e, a));
    }
}