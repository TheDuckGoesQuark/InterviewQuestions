package test.pathcount;

import com.sun.tools.javac.util.List;
import main.pathcount.PathCount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

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
                {2, 2, 5} ,
                {5, 5, 70} ,
        };

        return List.from(data);
    }

    @Test
    public void countPossiblePaths() {
        assertEquals(expected, PathCount.countPossiblePaths(n, m));
    }
}