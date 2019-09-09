package test.crossword;

import main.crossword.Crossword;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class CrosswordTest {

    private char[][] crossword;
    private String input;
    private boolean expected;

    public CrosswordTest(char[][] crossword, String input, boolean expected) {
        this.crossword = crossword;
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final char[][] crossword = new char[][]{
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };

        final Object[][] data = new Object[][]{
                {crossword, "FOAM", true},
                {crossword, "MASS", true},
                {crossword, "NO", true},
                {crossword, "QOS", true},
                {crossword, "ANO", true},

                {crossword, "POPE", false},
                {crossword, "IPA", false},
                {crossword, "FACID", false},
        };

        return List.of(data);
    }

    @Test
    public void wordExists() {
        assertEquals(expected, new Crossword(crossword).wordExists(input));
    }
}