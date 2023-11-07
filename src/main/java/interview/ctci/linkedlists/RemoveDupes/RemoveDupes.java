package interview.ctci.linkedlists.RemoveDupes;

import interview.ctci.linkedlists.LinkedListNode;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDupes {
    public static LinkedListNode removeDupes(LinkedListNode inputHead) {
        var duplicateSet = new HashSet<Integer>();

        var current = inputHead;
        duplicateSet.add(current.value);

        while (current.next != null) {
            var next = current.next;
            if (duplicateSet.contains(next.value)) {
                current.next = next.next;
            } else {
                duplicateSet.add(next.value);
                current = next;
            }
        }

        return inputHead;
    }

    public static LinkedListNode removeDupesWithoutBuffer(LinkedListNode inputHead) {
        return inputHead;
    }
    // with buffer: hashset of values, remove values that appear twice
    // without buffer:
}
