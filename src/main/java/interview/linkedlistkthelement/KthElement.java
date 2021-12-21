package interview.linkedlistkthelement;

/**
 * Given a singly linked list and an integer k,
 * remove the kth last element from the list.
 * k is guaranteed to be smaller than the length of the list.
 * <p>
 * The list is very long, so making more than one pass is prohibitively expensive.
 * <p>
 * Do this in constant space and in one pass.
 */
public class KthElement {

    public static Node removeKthLastElement(Node head, int k) {
        int passed = 0;

        Node kth = head;
        Node current = head;

        // Skip ahead since kth last must be within list, so we can start from the kth element
        for (int i = 0; i < k; i++) {
            current = current.getNext();
        }

        // Iterate until we reach the end of the list
        Node preKth = null;
        while (current.getNext() != null) {
            current = current.getNext();
            preKth = kth;
            kth = kth.getNext();
        }

        // kth is the value we want to remove
        if (preKth == null) {
            head = kth.getNext();
        } else {
            preKth.setNext(kth.getNext());
        }

        return head;
    }

}
