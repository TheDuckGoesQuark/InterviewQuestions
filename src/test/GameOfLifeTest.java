package test;

import main.gameoflife.Coordinate;
import main.gameoflife.GameOfLife;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeTest {

    @Test
    public void gameOfLifeTest() throws Exception {
        final List<Coordinate> initial = new ArrayList<>();
        initial.add(new Coordinate(1, 1));
        initial.add(new Coordinate(2, 1));
        initial.add(new Coordinate(1, 2));
        initial.add(new Coordinate(2, 2));

        final GameOfLife gol = new GameOfLife(initial, 5);
        while (gol.getTicks() < gol.getMaxTicks()) {
            System.out.println(gol.toString());
            gol.incrementTicks();
        }

        gol.incrementTicks();
    }

}