package interview;

import interview.linkedlistkthelement.KthElement;
import interview.linkedlistkthelement.Node;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class KthElementTest {

    private static Node generatedListOfLengthN(int n) {
        Node head = new Node(0);
        Node current = head;

        for (int i = 1; i < n; i++) {
            Node next = new Node(i);
            current.setNext(next);
            current = next;
        }

        return head;
    }

    private static void assertKthElementRemoved(Node head, int[] expected) {
        Node current = head;

        for (int i : expected) {
            assertNotNull(current);
            assertEquals(i, current.getValue());
            current = current.getNext();
        }

        assertNull(current);
    }

    @Test
    public void removeKthElementLastLengthTwo() {
        final int originalLength = 2;
        final int k = 0;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{0});
    }

    @Test
    public void removeKthElementLastLengthThree() {
        final int originalLength = 3;
        final int k = 0;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{0, 1});
    }

    @Test
    public void removeKthElementLastLengthTen() {
        final int originalLength = 10;
        final int k = 0;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void removeKthElementFirstLengthTwo() {
        final int originalLength = 2;
        final int k = 1;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{1});
    }

    @Test
    public void removeKthElementFirstLengthThree() {
        final int originalLength = 3;
        final int k = 2;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{1, 2});
    }

    @Test
    public void removeKthElementFirstLengthTen() {
        final int originalLength = 10;
        final int k = 9;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void removeKthElementMiddleLengthThree() {
        final int originalLength = 3;
        final int k = 1;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{0, 2});
    }

    @Test
    public void removeKthElementMiddleLengthTen() {
        final int originalLength = 10;
        final int k = 5;

        Node head = generatedListOfLengthN(originalLength);

        head = KthElement.removeKthLastElement(head, k);
        assertKthElementRemoved(head, new int[]{0, 1, 2, 3, 5, 6, 7, 8, 9});
    }
}