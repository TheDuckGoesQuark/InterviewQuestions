package main.gameoflife;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Conway's Game of Life takes place on an infinite two-dimensional board of square liveCells.
 * Each cell is either dead or alive, and at each tick, the following rules apply:
 * <p>
 * Any live cell with less than two live neighbours dies.
 * Any live cell with two or three live neighbours remains living.
 * Any live cell with more than three live neighbours dies.
 * Any dead cell with exactly three live neighbours becomes a live cell.
 * <p>
 * A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.
 * <p>
 * Implement Conway's Game of Life.
 * It should be able to be initialized with a starting list of live cell coordinates
 * and the number of steps it should run for.
 * <p>
 * Once initialized, it should print out the board state at each step.
 * Since it's an infinite board, print out only the relevant coordinates,
 * i.e. from the top-leftmost live cell to bottom-rightmost live cell.
 * <p>
 * You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).
 */
public class GameOfLife {

    private final Set<Cell> liveCells;
    private final int maxTicks;
    private int ticks;

    public GameOfLife(List<Coordinate> point, int maxTicks) {
        this.maxTicks = maxTicks;
        this.liveCells = point.stream()
                .map(Cell::new)
                .collect(Collectors.toSet());
    }

    public int getTicks() {
        return ticks;
    }

    public void incrementTicks() {
        // track liveCells to be removed on next iteration
        final Set<Cell> forDeletion = new HashSet<>();

        // track liveCells to be created on next iteration
        final Set<Cell> forCreation = new HashSet<>();

        // kill off starved or overpopulated cells
        for (Cell cell : liveCells) {
            int numNeighbours = cell.getNumNeighbours();
            if (numNeighbours < 2 || numNeighbours > 3)
                forDeletion.add(cell);
        }

        // create liveCells

        // delete liveCells

        ticks++;
    }

    @Override
    public String toString() {
        // print board
        return null;
    }
}
