package interview;

import interview.gameoflife.Cell;
import interview.gameoflife.Coordinate;
import interview.gameoflife.GameOfLife;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class GameOfLifeTest {

    @Test
    public void gameOfLifeTestBlock() throws Exception {
        final Set<Coordinate> initial = new HashSet<>();
        initial.add(new Coordinate(1, 1));
        initial.add(new Coordinate(2, 1));
        initial.add(new Coordinate(1, 2));
        initial.add(new Coordinate(2, 2));

        final GameOfLife gol = new GameOfLife(initial, 5);
        while (gol.getTicks() < gol.getMaxTicks()) {
            System.out.println(gol.toString());
            gol.incrementTicks();
        }

        final Set<Coordinate> expected = new HashSet<>(initial);
        assertEquals(expected, gol.getLiveCells().stream().map(Cell::getCoords).collect(Collectors.toSet()));
    }

    @Test
    public void gameOfLifeTestBlinker() throws Exception {
        final Set<Coordinate> initial = new HashSet<>();
        initial.add(new Coordinate(1, 2));
        initial.add(new Coordinate(2, 2));
        initial.add(new Coordinate(3, 2));

        final GameOfLife gol = new GameOfLife(initial, 3);
        System.out.println(gol.toString());

        gol.incrementTicks();
        System.out.println(gol.toString());

        Set<Coordinate> expected = new HashSet<>();
        expected.add(new Coordinate(2, 1));
        expected.add(new Coordinate(2, 2));
        expected.add(new Coordinate(2, 3));
        assertEquals(expected, gol.getLiveCells().stream().map(Cell::getCoords).collect(Collectors.toSet()));

        gol.incrementTicks();
        System.out.println(gol.toString());

        expected = new HashSet<>();
        expected.add(new Coordinate(1, 2));
        expected.add(new Coordinate(2, 2));
        expected.add(new Coordinate(3, 2));
        assertEquals(expected, gol.getLiveCells().stream().map(Cell::getCoords).collect(Collectors.toSet()));
    }

}