package interview.linkedlistintersection;

/**
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * <p>
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 * <p>
 * In this example, assume nodes with the same value are the exact same node objects.
 * <p>
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */
public class LinkedListIntersection {

    public static Node findIntersectingNode(Node headOfListA, Node headOfListB) {
        int lengthA = getLengthOfList(headOfListA);
        int lengthB = getLengthOfList(headOfListB);
        int difference = lengthA - lengthB;

        return traverseInParallel(headOfListA, headOfListB, difference);
    }

    /**
     * Traverses lists in parallel, returning the intersection of both lists.
     *
     * @param headOfListA head of linked list A
     * @param headOfListB head of linked list B
     * @param difference  difference between length of list A and list B.
     *                    If positive, difference steps will be taken in list A first before parallel traversal
     *                    Otherwise, difference steps will be taken in list B first before parallel traversal
     * @return intersection of both lists
     */
    private static Node traverseInParallel(Node headOfListA, Node headOfListB, int difference) {
        if (difference >= 0) {
            for (int i = 0; i < difference; i++) {
                headOfListA = headOfListA.getNext();
            }
        } else {
            difference = Math.abs(difference);
            for (int i = 0; i < difference; i++) {
                headOfListB = headOfListB.getNext();
            }
        }

        Node aNode = headOfListA, bNode = headOfListB;
        while (aNode != null && bNode != null) {
            if (aNode.equals(bNode))
                return aNode;

            aNode = aNode.getNext();
            bNode = bNode.getNext();
        }

        return null;
    }

    private static int getLengthOfList(Node head) {
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.getNext();
        }

        return length;
    }

}
