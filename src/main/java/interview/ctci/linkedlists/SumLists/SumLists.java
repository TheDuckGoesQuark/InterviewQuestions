package interview.ctci.linkedlists.SumLists;

import interview.ctci.linkedlists.LinkedListNode;

/**
 * You have two numbers represented by a linked list where each node contains a single digit.
 * The digits are stored in reverse order such that the 1s digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list
 * <p>
 * input 7->1->6 + 5->9->2 (617 + 295)
 * output 2 -> 1 -> 9 (912)
 * <p>
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * 6->1->7 + 2->9->5 = 9->1->2
 */
public class SumLists {

    public static LinkedListNode sumListsReversed(LinkedListNode listA, LinkedListNode listB) {
        var output = new LinkedListNode(0);
        var carry = 0;
        var a = listA;
        var b = listB;
        var c = output;

        while (a != null || b != null || carry > 0) {
            var aValue = a == null ? 0 : a.value;
            var bValue = b == null ? 0 : b.value;
            var sum = aValue + bValue + carry;
            carry = sum / 10;
            c.value = sum % 10;

            // prepare next iteration
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
            if (a != null || b != null || carry > 0) {
                c.next = new LinkedListNode(0);
                c = c.next;
            }
        }

        return output;
    }

    public static LinkedListNode sumLists(LinkedListNode listA, LinkedListNode listB) {
        return listA;
    }
}
