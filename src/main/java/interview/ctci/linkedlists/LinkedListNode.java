package interview.ctci.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public int[] toArray() {
        var list = new ArrayList<Integer>();

        var head = this;
        list.add(head.value);

        while (head.next != null) {
            head = head.next;
            list.add(head.value);
        }

        var arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static LinkedListNode fromArray(int[] arr) {
        if (arr.length == 0) return null;

        var head = new LinkedListNode(arr[0]);
        var current = head;

        for (int i = 1; i < arr.length; i++) {
            var next = new LinkedListNode(arr[i]);
            current.next = next;
            current = next;
        }

        return head;
    }

    public void append(LinkedListNode tail) {
        var current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = tail;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
