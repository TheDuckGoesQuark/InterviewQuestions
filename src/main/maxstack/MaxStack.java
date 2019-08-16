package main.maxstack;

import java.util.Stack;

/**
 * Implement a stack that has the following methods:
 * <p>
 * push(val), which pushes an element onto the stack
 * <p>
 * pop(), which pops off and returns the topmost element of the stack.
 * If there are no elements in the stack,
 * then it should throw an error or return null.
 * <p>
 * max(), which returns the maximum value in the stack currently.
 * If there are no elements in the stack,
 * then it should throw an error or return null.
 * <p>
 * Each method should run in constant time.
 */
public class MaxStack<T extends Comparable<T>> {

    // two normal stacks, one with last added, one with maxes
    private final Stack<T> normalStack = new Stack<>();
    private final Stack<T> maxStack = new Stack<>();

    public void push(T val) {
        normalStack.push(val);

        if (maxStack.isEmpty() || maxStack.peek().compareTo(val) <= 0)
            maxStack.push(val);
    }

    public T pop() {
        final T popped = normalStack.pop();

        if (maxStack.peek() == popped) maxStack.pop();

        return popped;
    }

    public T max() {
        return maxStack.peek();
    }
}
