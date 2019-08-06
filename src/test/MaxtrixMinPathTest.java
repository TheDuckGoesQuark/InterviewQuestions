package test;

import main.matrixminpath.MaxtrixMinPath;
import main.matrixminpath.Point;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class MaxtrixMinPathTest {

    private static final boolean t = true;
    private static final boolean f = false;

    @Test
    public void getMinPath() {
        final boolean[][] board = new boolean[][]{
                {f, f, f, f},
                {t, t, f, t},
                {f, f, f, f},
                {f, f, f, f}
        };
        final Point start = new Point(3, 0);
        final Point end = new Point(0, 0);

        final Optional<Integer> result = MaxtrixMinPath.getMinPath(board, start, end);
        assertTrue(result.isPresent());

        int expected = 7;
        assertEquals(expected, result.get().intValue());
    }

    @Test
    public void getMinPathNoPath() {
        final boolean[][] board = new boolean[][]{
                {f, t, f, f},
                {t, t, f, t},
                {f, f, f, f},
                {f, f, f, f}
        };

        final Point start = new Point(3, 0);
        final Point end = new Point(0, 0);

        final Optional<Integer> result = MaxtrixMinPath.getMinPath(board, start, end);
        assertFalse(result.isPresent());
    }

    @Test
    public void getMinPathNoWall() {
        final boolean[][] board = new boolean[][]{
                {f, f, f, f},
                {f, f, f, t},
                {f, f, f, f},
                {f, f, f, f}
        };

        final Point start = new Point(0, 0);
        final Point end = new Point(3, 3);

        final Optional<Integer> result = MaxtrixMinPath.getMinPath(board, start, end);
        assertTrue(result.isPresent());

        final int expected = 6;
        assertEquals(expected, result.get().intValue());
    }

    @Test
    public void getMinPathNoMoves() {
        final boolean[][] board = new boolean[][]{
                {f, t, f, f},
                {t, t, f, t},
                {f, f, f, f},
                {f, f, f, f}
        };

        final Point start = new Point(0, 0);
        final Point end = new Point(3, 3);

        final Optional<Integer> result = MaxtrixMinPath.getMinPath(board, start, end);
        assertFalse(result.isPresent());
    }
}