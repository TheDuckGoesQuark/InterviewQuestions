package interview.ctci.linkedlists.Intersection;

import interview.ctci.linkedlists.LinkedListNode;

/**
 * Given two singly linked lists determine if the two lists intersect.
 * Return the intersecting node.
 * Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node as the jth node of the second linked lists, then they are intersecting
 */
public class Intersection {

    static class TailAndSize {
        public LinkedListNode tail;
        public int length;

        public TailAndSize(LinkedListNode tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }

    private static TailAndSize findTailAndSizeOfList(LinkedListNode head) {
        var length = 1;
        while (head.next != null) {
            head = head.next;
            length++;
        }

        return new TailAndSize(head, length);
    }

    public static LinkedListNode getIntersectingNode(LinkedListNode a, LinkedListNode b) {
        // find tail and length of both lists
        var aTailAndSize = findTailAndSizeOfList(a);
        var bTailAndSize = findTailAndSizeOfList(b);

        if (aTailAndSize.tail != bTailAndSize.tail) return null;

        if (aTailAndSize.length > bTailAndSize.length) {
            var numToRemove = aTailAndSize.length - bTailAndSize.length;
            while (numToRemove > 0) {
                a = a.next;
                numToRemove--;
            }
        } else if (bTailAndSize.length > aTailAndSize.length) {
            var numToRemove = bTailAndSize.length - aTailAndSize.length;
            while (numToRemove > 0) {
                b = b.next;
                numToRemove--;
            }
        }

        // iterate through lists until equal node is found
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;
    }
}
