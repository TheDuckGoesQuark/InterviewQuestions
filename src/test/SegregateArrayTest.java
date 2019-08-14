package test;

import main.segregatearray.SegregateArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class SegregateArrayTest {

    @Test
    public void segregateArrayTest() {
        char[] input = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        SegregateArray.segregateArray(input);
        assertArrayEquals(new char[]{'R', 'R', 'R', 'G', 'G', 'B', 'B'}, input);
    }

    @Test
    public void segregateArrayTestEmpty() {
        char[] input = new char[]{};
        SegregateArray.segregateArray(input);
        assertArrayEquals(new char[]{}, input);
    }

    @Test
    public void segregateArrayTestOne() {
        char[] r = new char[]{'R'};
        SegregateArray.segregateArray(r);
        assertArrayEquals(new char[]{'R'}, r);

        char[] g = new char[]{'G'};
        SegregateArray.segregateArray(g);
        assertArrayEquals(new char[]{'G'}, g);

        char[] b = new char[]{'B'};
        SegregateArray.segregateArray(b);
        assertArrayEquals(new char[]{'B'}, b);
    }
}