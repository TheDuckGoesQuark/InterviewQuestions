package test;

import main.powerset.PowerSet;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PowerSetTest {

    @Test
    public void generatePowerSet() {
        Integer[] input = new Integer[]{1, 2, 3};
        Integer[][] expected = new Integer[][]{{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}};
        assertArrayEquals(expected, PowerSet.generatePowerSet(input));
    }

    @Test
    public void generatePowerSetEmpty() {
        Integer[] input = new Integer[]{};
        Integer[][] expected = new Integer[][]{{}};
        assertArrayEquals(expected, PowerSet.generatePowerSet(input));
    }

    @Test
    public void generatePowerSetOne() {
        Integer[] input = new Integer[]{1};
        Integer[][] expected = new Integer[][]{{}, {1}};
        assertArrayEquals(expected, PowerSet.generatePowerSet(input));
    }

    @Test
    public void generatePowerSetTwo() {
        Integer[] input = new Integer[]{1, 2};
        Integer[][] expected = new Integer[][]{{}, {1}, {2}, {1, 2}};
        assertArrayEquals(expected, PowerSet.generatePowerSet(input));
    }
}