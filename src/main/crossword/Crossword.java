package main.crossword;

/**
 * Given a 2D matrix of characters and a target word,
 * write a function that returns whether the word can be found
 * in the matrix by going left-to-right, or up-to-down.
 * <p>
 * For example, given the following matrix:
 * <p>
 * [['F', 'A', 'C', 'I'],
 * ['O', 'B', 'Q', 'P'],
 * ['A', 'N', 'O', 'B'],
 * ['M', 'A', 'S', 'S']]
 * <p>
 * and the target word 'FOAM', you should return true,
 * since it's the leftmost column.
 * <p>
 * Similarly, given the target word 'MASS',
 * you should return true, since it's the last row.
 */
public class Crossword {

    private final char[][] crossword;

    public Crossword(char[][] crossword) {
        this.crossword = crossword;
    }

    public boolean wordExists(String word) {
        return true;
    }

}
