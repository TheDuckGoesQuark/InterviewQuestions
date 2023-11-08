package interview.ctci.linkedlists.DeleteMiddleNode;

import interview.ctci.linkedlists.LinkedListNode;

/**
 *
 */
public class DeleteMiddleNode {
    public static void deleteNode(LinkedListNode nodeToDelete) {
        // set current value to next value
        // repeat for rest of list until end
        // set end null
        // O(n)
        nodeToDelete.value = nodeToDelete.next.value;

        // if next element is last in list
        if (nodeToDelete.next.next == null) {
            nodeToDelete.next = null;
        } else deleteNode(nodeToDelete.next);
    }
}
