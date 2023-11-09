package interview.ctci.linkedlists.Palindrome;

import interview.ctci.linkedlists.LinkedListNode;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Implement a function to check if a linked list is a palindrome
 * (The same backwards and forwards)
 */
public class Palindrome {

    static class LLIterator implements  Iterator<LinkedListNode> {
        private LinkedListNode current;

        public LLIterator(LinkedListNode head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public LinkedListNode next() {
            var current = this.current;
            this.current = current.next;
            return current;
        }

        @Override
        public void remove() {
            throw new RuntimeException("Remove not implemented");
        }

        @Override
        public void forEachRemaining(Consumer<? super LinkedListNode> action) {
            throw new RuntimeException("forEachRemaining not implemented");
        }
    }

    public static boolean isPalindrome(LinkedListNode list) {
        // recurse to end of list, passing head of list and next element
        // return true while head == element
        if (list.next == null) return true;
        else return recursivelyIsPalindrome(new LLIterator(list), list.next);
    }

    private static boolean recursivelyIsPalindrome(LLIterator head, LinkedListNode element) {
        // reached end of list
        if (element.next == null) {
            return head.next().value == element.value;
        }

        var restOfListIsPalindrome = recursivelyIsPalindrome(head, element.next);
        // early exit
        if (!restOfListIsPalindrome) return false;

        var left = head.next();

        if (left == element) { // odd length list and we've reached middle element
            return true;
        }

        return left.value == element.value;
    }
}
