package main.sudoku;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Helper class for iterating over sudoku puzzle
 */
public class SudokuIterator implements ListIterator<Integer> {

    private final int[][] puzzle;
    private int index;

    public SudokuIterator(int[][] puzzle) {
        this.puzzle = puzzle;
        this.index = 0;
    }

    public int getColIndex() {
        return index % 9;
    }

    public int getRowIndex() {
        return index / 9;
    }

    public int getBoxIndex() {
        int boxRow = getRowIndex() / 3;
        int boxCol = getColIndex() / 3;
        return (boxRow * 3) + boxCol;
    }

    @Override
    public boolean hasNext() {
        return index < (puzzle.length * puzzle.length);
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException("No more elements exist in puzzle");

        index++;

        return current();
    }

    @Override
    public boolean hasPrevious() {
        return index != 0;
    }

    @Override
    public Integer previous() {
        if (!hasPrevious())
            throw new NoSuchElementException("Cannot go before start of puzzle");

        index--;

        return current();
    }

    public Integer current() {
        return puzzle[getRowIndex()][getColIndex()];
    }

    @Override
    public int nextIndex() {
        return index + 1;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove element from puzzle");
    }

    @Override
    public void set(Integer integer) {
        puzzle[getRowIndex()][getColIndex()] = integer;
    }

    @Override
    public void add(Integer integer) {
        throw new UnsupportedOperationException("Cannot add element to puzzle");
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        while (hasNext()) action.accept(next());
    }
}
