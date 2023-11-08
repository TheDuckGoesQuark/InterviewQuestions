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
        // 1 -> 2 -> 3 -> 1 -> -> 4
        // first pass: sort  O(n *  logn)
        // second pass: remove duplicates immediately ahead O(n)
        // but merge sort is a pita to write for linked lists and we'd need different tests to handle the sorted output
        // so we're gonna do it the two pointer way O(n^2)

        var currentPointer = inputHead;

        while (currentPointer != null) {
            var value = currentPointer.value;

            var searchPointer = currentPointer;

            while (searchPointer.next != null) {
                var next = searchPointer.next;
                if (next.value == value) {
                    searchPointer.next = next.next;
                } else {
                    searchPointer = next;
                }
            }

            currentPointer = currentPointer.next;
        }

        return inputHead;
    }

}
