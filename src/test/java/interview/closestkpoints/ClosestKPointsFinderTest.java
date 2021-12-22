package interview.closestkpoints;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given a list of points, a central point, and an integer k,
 * find the nearest k points from the central point.
 * <p>
 * For example, given the list of points [(0, 0), (5, 4), (3, 1)],
 * the central point (1, 2), and k = 2, return [(0, 0), (3, 1)].
 */
@RunWith(Parameterized.class)
public class ClosestKPointsFinderTest {

    private final int[][] listOfPoints;
    private final int[] centralPoint;
    private final int k;
    private final int[][] expectedOutput;

    public ClosestKPointsFinderTest(int[][] listOfPoints, int[] centralPoint, int k, int[][] expectedOutput) {
        this.listOfPoints = listOfPoints;
        this.centralPoint = centralPoint;
        this.k = k;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {new int[][]{{0, 0}, {5, 4}, {3, 1}}, new int[]{1, 2}, 2, new int[][]{{0, 0}, {3, 1}}},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void findClosestKPoints() {
        var closestKPointsFinder = new ClosestKPointsFinder(listOfPoints);
        var closestKPoints = closestKPointsFinder.findClosestKPoints(centralPoint, k);
        assertArrayEquals("Points correct", expectedOutput, closestKPoints);
    }
}