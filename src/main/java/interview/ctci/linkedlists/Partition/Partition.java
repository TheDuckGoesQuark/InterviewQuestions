package interview.ctci.linkedlists.Partition;

import interview.ctci.linkedlists.LinkedListNode;

/**
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x.
 * The partition element x can appear anywhere in the "right partition", it does not need to appear
 * between the left and right partitions
 * <p>
 * Example
 * input
 * 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * output
 * 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Partition {

    public static LinkedListNode partition(LinkedListNode inputList, int partitionValue) {
        // keep pointer to end of list lower than x
        // if first element >= x, pointer will be null
        // iterate over list
        // if find element lower than x, insert after current pointer, make this element the new pointer
        LinkedListNode leftListHead = null;
        LinkedListNode prevElement = null;
        LinkedListNode currentElement = inputList;

        while (currentElement != null) {
            if (currentElement.value >= partitionValue) {
                prevElement = currentElement;
                currentElement = currentElement.next;
                continue;
            }

            // initialise left list if not exist yet
            if (leftListHead == null) {
                // place this element at the start of the list
                leftListHead = currentElement;
                // make previous element point to next element
                if (prevElement != null) {
                    prevElement.next = currentElement.next;
                }

                // make new left list point to rest of list, as long we're not already the first element in the list
                if (currentElement != inputList) {
                    leftListHead.next = inputList;

                }

                prevElement = currentElement;
                currentElement = currentElement.next;
                continue;
            }

            // already in good order
            if (leftListHead.next == currentElement) {
                prevElement = currentElement;
                currentElement = currentElement.next;
                continue;
            }

            // insert in left list
            var next = currentElement.next;
            currentElement.next = leftListHead.next;
            leftListHead.next = currentElement;

            if (prevElement != null) {
                prevElement.next = next;
            }

            currentElement = next;
        }

        return leftListHead == null ? inputList : leftListHead;
    }
}
