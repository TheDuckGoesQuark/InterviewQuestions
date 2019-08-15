package main.gameoflife;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cell {
    private Coordinate coords;
    private Set<Cell> liveNeighbours = new HashSet<>();

    Cell(Coordinate coords) {
        this.coords = coords;
    }

    public Coordinate getCoords() {
        return coords;
    }

    public boolean isNeighbour(Cell cell) {
        return coords.areAdjacentTo(cell.coords);
    }

    public int getNumNeighbours() {
        return liveNeighbours.size();
    }

    public void addNeighbour(Cell cell) {
        liveNeighbours.add(cell);
    }

    public void removeNeighbour(Cell cell) {
        liveNeighbours.remove(cell);
    }

    public Set<Cell> getNeighbouringCells() {
        return coords.getSurroundingCoordinates()
                .stream()
                .map(Cell::new)
                .collect(Collectors.toSet());
    }
}
