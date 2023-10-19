package interview.SunsetStreet;

import java.util.Stack;

/**
 * You are given an array representing the heights of neighboring buildings
 * on a city street, from east to west.
 * <p>
 * The city assessor would like you to write an algorithm that
 * returns how many of these buildings have a view of the setting sun,
 * in order to properly value the street.
 * <p>
 * For example, given the array [3, 7, 8, 3, 6, 1],
 * you should return 3,
 * since the top floors of the buildings with heights 8, 6, and 1
 * all have an unobstructed view to the west.
 * <p>
 * Can you do this using just one forward pass through the array?
 */
public class SunsetStreet {
    public static int countBuildingsWithViewOfSunset(int[] heights) {
        // the forward pass requirement makes this harder
        // as going backwards is easy, just track the current max height
        var heightStack = new Stack<Integer>();
        for (int height : heights) {
            if (heightStack.isEmpty()) {
                heightStack.add(height);
                continue;
            }

            if (height < heightStack.peek()) {
                heightStack.add(height);
            } else if (height > heightStack.peek()) {
                while (!heightStack.empty() && height > heightStack.peek()) heightStack.pop();
                heightStack.push(height);
            }
        }
        return heightStack.size();
    }
}
