package test.pathcount;

import main.pathcount.PathCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class PathCountTest {

    private int n;
    private int m;
    private int expected;

    public PathCountTest(int n, int m, int expected) {
        this.n = n;
        this.m = m;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {1, 1, 1},
                {2, 1, 1},
                {3, 1, 1},
                {1, 2, 1},
                {1, 3, 1},
                {2, 2, 2},
                {5, 5, 70},
        };

        return List.of(data);
    }

    @Test
    public void countPossiblePaths() {
        assertEquals(expected, PathCount.countPossiblePaths(n, m));
    }
}