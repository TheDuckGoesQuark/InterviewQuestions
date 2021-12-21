package interview.gameoflife;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cell {
    private final Coordinate coords;
    private final Set<Cell> liveNeighbours = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(coords, cell.coords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coords);
    }

    /**
     * Remove self as neighbour from neigbouring cells
     */
    public void removeFromNeighbours() {
        for (Cell neighbour : liveNeighbours) {
            neighbour.removeNeighbour(this);
        }
    }
}
