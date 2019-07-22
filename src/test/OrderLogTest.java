package test;

import main.orderlog.OrderLog;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class OrderLogTest {

    @Test
    public void record() {
        // Set backlog to 1
        OrderLog orderLog = new OrderLog(1);
        orderLog.record(1);

        assertEquals(1, orderLog.getLast(1));

        orderLog.record(2);
        assertEquals(2, orderLog.getLast(1));

        // Set backlog to 2
        orderLog = new OrderLog(2);
        orderLog.record(1);
        assertEquals(1, orderLog.getLast(1));
        orderLog.record(2);
        assertEquals(1, orderLog.getLast(2));
        assertEquals(2, orderLog.getLast(1));
        orderLog.record(3);
        assertEquals(2, orderLog.getLast(2));
        assertEquals(3, orderLog.getLast(1));
        orderLog.record(4);
        assertEquals(3, orderLog.getLast(2));
        assertEquals(4, orderLog.getLast(1));

        // Set backlog to 5
        orderLog = new OrderLog(5);
        orderLog.record(1);
        orderLog.record(2);
        orderLog.record(3);
        orderLog.record(4);
        orderLog.record(5);
        orderLog.record(6);
        orderLog.record(7);
        assertEquals(7, orderLog.getLast(1));
        assertEquals(6, orderLog.getLast(2));
        assertEquals(5, orderLog.getLast(3));
        assertEquals(4, orderLog.getLast(4));
        assertEquals(3, orderLog.getLast(5));

        orderLog.record(8);
        orderLog.record(9);
        orderLog.record(10);
        orderLog.record(11);
        orderLog.record(12);
        assertEquals(12, orderLog.getLast(1));
        assertEquals(11, orderLog.getLast(2));
        assertEquals(10, orderLog.getLast(3));
        assertEquals(9, orderLog.getLast(4));
        assertEquals(8, orderLog.getLast(5));

        System.out.println(orderLog.toString());
    }

    @Test
    public void getLast() {
    }

}