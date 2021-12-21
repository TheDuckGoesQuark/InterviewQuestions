package interview.gameoflife;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coordinate {

    protected int x;
    protected int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean areAdjacentTo(Coordinate coord) {
        int diffX = Math.abs(x - coord.x);
        int diffY = Math.abs(y - coord.y);

        if (diffX == 0 && diffY == 1) return true;
        else if (diffY == 0 && diffX == 1) return true;
        else return diffX == 1 && diffY == 1;
    }

    Set<Coordinate> getSurroundingCoordinates() {
        final Set<Coordinate> neighbours = new HashSet<>();

        for (int x = this.x - 1; x <= (this.x + 1); x++) {
            for (int y = this.y - 1; y <= this.y + 1; y++) {
                neighbours.add(new Coordinate(x, y));
            }
        }

        neighbours.remove(this);

        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
