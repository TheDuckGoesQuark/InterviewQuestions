package interview;

import interview.powerset.PowerSet;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PowerSetTest {

    private static Set<Set<Integer>> jaggedArrayToSet(int[][] arr) {
        final Set<Set<Integer>> set = new HashSet<>(arr.length);
        for (int[] innerArr : arr) {
            set.add(arrToSet(innerArr));
        }
        return set;
    }

    private static Set<Integer> arrToSet(int[] arr) {
        final Set<Integer> set = new HashSet<>(arr.length);
        for (int val : arr) {
            set.add(val);
        }
        return set;
    }

    @Test
    public void generatePowerSet() {
        int[] input = new int[]{1, 2, 3};
        int[][] expected = new int[][]{{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}};
        assertEquals(jaggedArrayToSet(expected), PowerSet.generatePowerSet(arrToSet(input)));
    }

    @Test
    public void generatePowerSetEmpty() {
        int[] input = new int[]{};
        int[][] expected = new int[][]{{}};
        assertEquals(jaggedArrayToSet(expected), PowerSet.generatePowerSet(arrToSet(input)));
    }

    @Test
    public void generatePowerSetOne() {
        int[] input = new int[]{1};
        int[][] expected = new int[][]{{}, {1}};
        assertEquals(jaggedArrayToSet(expected), PowerSet.generatePowerSet(arrToSet(input)));
    }

    @Test
    public void generatePowerSetTwo() {
        int[] input = new int[]{1, 2};
        int[][] expected = new int[][]{{}, {1}, {2}, {1, 2}};
        assertEquals(jaggedArrayToSet(expected), PowerSet.generatePowerSet(arrToSet(input)));
    }
}