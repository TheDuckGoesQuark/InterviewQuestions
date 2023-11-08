package interview.ctci.linkedlists.ReturnKthToLast;

import interview.ctci.linkedlists.LinkedListNode;

/**
 * implement an algorithm to find the kth to last element of a singly linked list
 */
public class ReturnKthToLast {

    public static int returnKthToLast(LinkedListNode linkedList, int k) {
        // first pass, get length
        // second pass, find kth from last element
        // O(n + (n-k))

        var current = linkedList;
        var length = 0;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        if (k > length) return -1;

        var index = length - k;

        var kth = linkedList;
        for (int i = 0; i < index; i++) {
            kth = kth.next;
        }

        return kth.value;
    }
}
