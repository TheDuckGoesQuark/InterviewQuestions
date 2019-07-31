package test.linkedlistintersection;

import main.linkedlistintersection.LinkedListBuilder;
import main.linkedlistintersection.LinkedListIntersection;
import main.linkedlistintersection.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListIntersectionTest {

    @Test
    public void findIntersectingNodeWhenFirstNodeIntersectsTest() {
        Node listA = new LinkedListBuilder().add(1).add(2).add(3).build();
        Node listB = new LinkedListBuilder().add(1).add(2).add(3).build();
        assertEquals(1, LinkedListIntersection.findIntersectingNode(listA, listB).getValue());
    }

    @Test
    public void findIntersectingNodeWhenSecondNodeIntersectsTest() {
        Node listA = new LinkedListBuilder().add(2).add(3).add(4).build();
        Node listB = new LinkedListBuilder().add(1).add(2).add(3).build();

        assertEquals(2, LinkedListIntersection.findIntersectingNode(listA, listB).getValue());
    }

    @Test
    public void findIntersectingNodeWhenThirdNodeIntersectsTest() {
        Node listA = new LinkedListBuilder().add(3).add(4).add(5).build();
        Node listB = new LinkedListBuilder().add(1).add(2).add(3).add(4).add(5).build();

        assertEquals(2, LinkedListIntersection.findIntersectingNode(listA, listB).getValue());
    }

    @Test
    public void findIntersectingNodeWhenFirstNodeIntersectsWithPrecursorTest() {
        Node listA = new LinkedListBuilder().add(0).add(1).add(2).add(3).build();
        Node listB = new LinkedListBuilder().add(-1).add(1).add(2).add(3).build();
        assertEquals(1, LinkedListIntersection.findIntersectingNode(listA, listB).getValue());
    }

    @Test
    public void findIntersectingNodeWhenSecondNodeIntersectsWithPrecursorTest() {
        Node listA = new LinkedListBuilder().add(42).add(53).add(2).add(3).add(4).build();
        Node listB = new LinkedListBuilder().add(52).add(1).add(2).add(3).build();

        assertEquals(2, LinkedListIntersection.findIntersectingNode(listA, listB).getValue());
    }

    @Test
    public void findIntersectingNodeWhenThirdNodeIntersectsWithPrecursorTest() {
        Node listA = new LinkedListBuilder().add(51).add(3).add(4).add(5).build();
        Node listB = new LinkedListBuilder().add(1).add(2).add(3).add(4).add(5).build();

        assertEquals(2, LinkedListIntersection.findIntersectingNode(listA, listB).getValue());
    }
}