package test;

import main.maxstack.MaxStack;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxStackTest {

    @Test
    public void stackTest() {
        final MaxStack<Integer> maxStack = new MaxStack<>();

        boolean failedPop = false;
        try {
            maxStack.pop();
        } catch (Exception e) {
            failedPop = true;
        }

        assertTrue(failedPop);

        boolean failedMax = false;
        try {
            maxStack.pop();
        } catch (Exception e) {
            failedMax = true;
        }

        assertTrue(failedMax);
        maxStack.push(1);
        assertEquals(1, maxStack.max().intValue());

        maxStack.push(2);
        assertEquals(2, maxStack.max().intValue());

        maxStack.push(2);
        assertEquals(2, maxStack.max().intValue());

        maxStack.push(1);
        assertEquals(2, maxStack.max().intValue());

        maxStack.push(5);
        assertEquals(5, maxStack.max().intValue());

        assertEquals(5, maxStack.pop().intValue());
        assertEquals(2, maxStack.max().intValue());

        assertEquals(1, maxStack.pop().intValue());
        assertEquals(2, maxStack.max().intValue());

        assertEquals(2, maxStack.pop().intValue());
        assertEquals(2, maxStack.max().intValue());

        assertEquals(2, maxStack.pop().intValue());
        assertEquals(1, maxStack.max().intValue());

        assertEquals(1, maxStack.pop().intValue());

        failedPop = false;
        try {
            maxStack.pop();
        } catch (Exception e) {
            failedPop = true;
        }

        assertTrue(failedPop);

        failedMax = false;
        try {
            maxStack.pop();
        } catch (Exception e) {
            failedMax = true;
        }

        assertTrue(failedMax);
    }
}