package main.matrixminpath;

import java.util.*;

/**
 * You are given an M by N matrix consisting of booleans that represents a board.
 * Each True boolean represents a wall.
 * Each False boolean represents a tile you can walk on.
 * <p>
 * Given this matrix, a start coordinate, and an end coordinate,
 * return the minimum number of steps required to reach the end coordinate from the start.
 * If there is no possible path, then return null.
 * <p>
 * You can move up, left, down, and right.
 * You cannot move through walls.
 * You cannot wrap around the edges of the board.
 * <p>
 * For example, given the following board:
 * [[f, f, f, f],
 * [t, t, f, t],
 * [f, f, f, f],
 * [f, f, f, f]]
 * and start = (3, 0) (bottom left) and end = (0, 0) (top left),
 * the minimum number of steps required to reach the end is 7,
 * since we would need to go through (1, 2)
 * because there is a wall everywhere else on the second row.
 */
public class MaxtrixMinPath {

    private static final boolean WALL = true;

    /**
     * Greedy depth first search
     *
     * @param board       board describing possible path where true represents walls and false represents path
     * @param startCoords position currently in
     * @param endCoords   position to end in
     * @return number of steps between start and end, or empty if no path exists
     */
    public static Optional<Integer> getMinPath(boolean[][] board, Point startCoords, Point endCoords) {
        final Map<Point, Integer> known = new HashMap<>();
        return getMinPathRecursively(board, startCoords, endCoords, known);
    }

    private static Optional<Integer> getMinPathRecursively(boolean[][] board, Point startCoords, Point endCoords, Map<Point, Integer> known) {
        if (startCoords.equals(endCoords)) return Optional.of(0);

        // Mark this as wall since its being explored again if this doesn't work
        board[startCoords.x][startCoords.y] = WALL;

        // sort possible next steps by distance to end coords
        PriorityQueue<Point> nextSteps = getGreedyNextStep(board, startCoords, endCoords);

        Integer min = null;
        for (Point nextStep : nextSteps) {

            Integer steps = null;
            if (known.containsKey(nextStep)) {
                steps = known.get(nextStep);
            } else {
                Optional<Integer> optSteps = getMinPathRecursively(board, nextStep, endCoords, known);

                if (optSteps.isPresent()) {
                    steps = optSteps.get();
                    known.put(nextStep, steps);
                }
            }

            if (steps != null && (min == null || min > steps))
                min = steps;
        }

        board[startCoords.x][startCoords.y] = !WALL;

        if (min != null) return Optional.of(min + 1);
        else return Optional.empty();
    }

    private static PriorityQueue<Point> getGreedyNextStep(boolean[][] board, Point startCoords, Point endCoords) {
        // Heap sorted by distance to end goal
        final PriorityQueue<Point> sortedNextSteps = new PriorityQueue<>((o1, o2) -> {
            int o1DistanceToGoal = distance(o1.x, o1.y, endCoords.x, endCoords.y);
            int o2DistanceToGoal = distance(o2.x, o2.y, endCoords.x, endCoords.y);
            return Integer.compare(o1DistanceToGoal, o2DistanceToGoal);
        });

        Point[] nextSteps = new Point[4];
        nextSteps[0] = new Point(startCoords.x + 1, startCoords.y); // right
        nextSteps[1] = new Point(startCoords.x - 1, startCoords.y); // left
        nextSteps[2] = new Point(startCoords.x, startCoords.y + 1); // up
        nextSteps[3] = new Point(startCoords.x, startCoords.y - 1); // down

        for (Point current : nextSteps) {
            if (withinBounds(current, board) && notWall(current, board))
                sortedNextSteps.add(current);
        }

        return sortedNextSteps;
    }

    private static boolean notWall(Point current, boolean[][] board) {
        return board[current.x][current.y] != WALL;
    }

    private static boolean withinBounds(Point point, boolean[][] board) {
        int maxX = board[0].length;
        int maxY = board.length;

        return point.x >= 0 && point.x < maxX
                && point.y >= 0 && point.y < maxY;
    }

    /**
     * Taxicab distance between two points
     */
    private static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
