package interview.stackqueue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement a queue using two stacks.
 * <p>
 * Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods:
 * <p>
 * enqueue, which inserts an element into the queue,
 * and dequeue, which removes it.
 */
public class StackQueue<T> {

    private final Stack<T> main;
    private final Stack<T> temp;

    public StackQueue() {
        main = new Stack<>();
        temp = new Stack<>();
    }

    public void enqueue(T value) {
        while (!main.isEmpty())
            temp.push(main.pop());

        main.push(value);

        while (!temp.isEmpty())
            main.push(temp.pop());
    }

    public T dequeue() {
        if (main.isEmpty())
            throw new NoSuchElementException();

        return main.pop();
    }

}
