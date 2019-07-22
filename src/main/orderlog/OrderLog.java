package main.orderlog;

import java.util.Arrays;

/**
 * You run an e-commerce website and want to record the last N order ids in a log.
 * <p>
 * Implement a data structure to accomplish this, with the following API:
 * <p>
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log.
 * <p>
 * i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 */
public class OrderLog {

    /**
     * If number of logs has exceeded the maximum allowed amount
     */
    private boolean overflowing;
    /**
     * Index in log array where most recent log is stored
     */
    private int endIndex;
    /**
     * Log array
     */
    private int[] log;

    public OrderLog(int maxBacklog) {
        this.overflowing = false;
        this.endIndex = 0;
        this.log = new int[maxBacklog];
    }

    public void record(int orderId) {
        if (!overflowing) {
            endIndex++;
            if (endIndex == log.length) {
                endIndex = 0;
                overflowing = true;
            }
            log[endIndex] = orderId;
        } else {
            endIndex = (endIndex + 1) % log.length;
            log[endIndex] = orderId;
        }
    }

    public int getLast(int n) {
        n = n - 1;

        if (n > log.length)
            throw new IllegalArgumentException(String.format("Log only maintains up to %d messages.", log.length));

        if (n > endIndex) {
            return log[endIndex - n + log.length];
        } else {
            return log[endIndex - n];
        }
    }

    @Override
    public String toString() {
        return "OrderLog{" +
                "overflowing=" + overflowing +
                ", endIndex=" + endIndex +
                ", log=" + Arrays.toString(log) +
                '}';
    }
}

