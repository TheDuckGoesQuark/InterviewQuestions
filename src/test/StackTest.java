package test;

import main.stack.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void stackTest() {
        final Stack<Integer> stack = new Stack<>();

        boolean failedPop = false;
        try {
            stack.pop();
        } catch (Exception e) {
            failedPop = true;
        }

        assertTrue(failedPop);

        boolean failedMax = false;
        try {
            stack.pop();
        } catch (Exception e) {
            failedMax = true;
        }

        assertTrue(failedMax);
        stack.push(1);
        assertEquals(1, stack.max().intValue());

        stack.push(2);
        assertEquals(2, stack.max().intValue());

        stack.push(2);
        assertEquals(2, stack.max().intValue());

        stack.push(1);
        assertEquals(2, stack.max().intValue());

        stack.push(5);
        assertEquals(5, stack.max().intValue());

        assertEquals(5, stack.pop().intValue());
        assertEquals(2, stack.max().intValue());

        assertEquals(2, stack.pop().intValue());
        assertEquals(2, stack.max().intValue());

        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.max().intValue());

        assertEquals(1, stack.pop().intValue());

        failedPop = false;
        try {
            stack.pop();
        } catch (Exception e) {
            failedPop = true;
        }

        assertTrue(failedPop);

        failedMax = false;
        try {
            stack.pop();
        } catch (Exception e) {
            failedMax = true;
        }

        assertTrue(failedMax);
    }
}