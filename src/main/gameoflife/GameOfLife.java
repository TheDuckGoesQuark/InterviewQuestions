package main.gameoflife;

import java.util.*;
import java.util.function.Function;
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

    private final Map<Coordinate, Cell> liveCells;
    private final int maxTicks;

    private Coordinate minCoord;
    private Coordinate maxCoord;

    private int ticks;

    public GameOfLife(List<Coordinate> point, int maxTicks) {
        this.maxTicks = maxTicks;
        this.liveCells = point.stream()
                .map(Cell::new)
                .collect(Collectors.toMap(Cell::getCoords, Function.identity()));

        this.liveCells.keySet().forEach(this::updateLimits);
    }

    private void updateLimits(Coordinate coordinate) {
        if (minCoord == null) minCoord = coordinate;
        if (maxCoord == null) maxCoord = coordinate;

        if (coordinate.x < minCoord.x) minCoord.x = coordinate.x;
        if (coordinate.x > maxCoord.x) maxCoord.x = coordinate.x;
        if (coordinate.y < minCoord.y) minCoord.y = coordinate.y;
        if (coordinate.y > maxCoord.y) maxCoord.y = coordinate.y;
    }


    public int getTicks() {
        return ticks;
    }

    public void incrementTicks() {
        // track liveCells to be removed on next iteration
        final Set<Cell> forDeletion = new HashSet<>();

        // track coordinates and the number of live cells
        final Map<Coordinate, Set<Cell>> forCreation = new HashMap<>();

        // removeFromNeighbours off starved or overpopulated cells
        for (Cell cell : liveCells.values()) {
            int numNeighbours = cell.getNumNeighbours();

            if (numNeighbours < 2 || numNeighbours > 3)
                forDeletion.add(cell);

            cell.getCoords().getSurroundingCoordinates().stream()
                    .filter(coord -> !liveCells.containsKey(coord))
                    .forEach(coord -> {
                        if (!liveCells.containsKey(coord)) {
                            Set<Cell> neighboursToCell = forCreation.getOrDefault(coord, new HashSet<>());
                            neighboursToCell.add(cell);
                            forCreation.put(coord, neighboursToCell);
                        }
                    });
        }

        // create liveCells
        for (Map.Entry<Coordinate, Set<Cell>> entry : forCreation.entrySet()) {
            if (entry.getValue().size() == 3) {
                Cell cell = new Cell(entry.getKey());
                entry.getValue().forEach(neighbour -> {
                    cell.addNeighbour(neighbour);
                    neighbour.addNeighbour(cell);
                });
                liveCells.put(entry.getKey(), cell);
                updateLimits(cell.getCoords());
            }
        }

        // delete any cells due for deletion
        forDeletion.forEach(cell -> {
            cell.removeFromNeighbours();
            liveCells.remove(cell.getCoords());
        });

        ticks++;
    }

    @Override
    public String toString() {
        int length = Math.abs(maxCoord.x - minCoord.x);
        int height = Math.abs(maxCoord.y - minCoord.y);

        final StringBuilder sb = new StringBuilder((length * height) + height); // num cells + num newline characters

        for (int x = minCoord.x; x <= maxCoord.x; x++) {
            for (int y = minCoord.y; y <= maxCoord.y; y++) {
                if (liveCells.containsKey(new Coordinate(x, y)))
                    sb.append("*");
                else
                    sb.append(".");
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
