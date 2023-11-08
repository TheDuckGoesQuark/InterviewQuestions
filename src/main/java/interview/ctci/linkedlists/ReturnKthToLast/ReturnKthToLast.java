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

    public static int returnKthToLastRecursively(LinkedListNode linkedList, int k) {
        // recursively iterate through list to end
        // return 1 + call(nextElement) until 1 = k
        // return k'th element
        return recursivelyFindKthElement(linkedList, k)[1];
    }

    // returns [k from end, value of k from end]
    private static int[] recursivelyFindKthElement(LinkedListNode linkedList, int k) {
        // hit end
        if (linkedList.next == null) {
            if (k == 0) {
                return new int[]{0, linkedList.value};
            } else {
                return new int[]{0, -1};
            }
        }

        var kFromEnd = recursivelyFindKthElement(linkedList.next, k);

        // kth from end already found
        if (kFromEnd[0] >= k) {
            return kFromEnd;
        }

        kFromEnd[0]++;
        if (kFromEnd[0] == k) {
            kFromEnd[1] = linkedList.value;
        }

        return kFromEnd;
    }

}
