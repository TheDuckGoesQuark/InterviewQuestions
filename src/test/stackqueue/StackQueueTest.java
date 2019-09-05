package test.stackqueue;

import main.stackqueue.StackQueue;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StackQueueTest {

    @Test(expected = NoSuchElementException.class)
    public void emptyDequeueException() {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.dequeue();
    }

    @Test
    public void enqueueDequeue() {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.enqueue(1);
        int returned = queue.dequeue();
        assertEquals(1, returned);
    }

    @Test(expected = NoSuchElementException.class)
    public void enqueueDequeueThenEmpty() {
        StackQueue<Integer> queue = new StackQueue<>();

        queue.enqueue(1);

        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void multipleEnqueueDequeue() {
        StackQueue<Integer> queue = new StackQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue().intValue());
        assertEquals(2, queue.dequeue().intValue());

        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(3, queue.dequeue().intValue());

        queue.enqueue(5);

        assertEquals(4, queue.dequeue().intValue());
        assertEquals(5, queue.dequeue().intValue());
    }
}