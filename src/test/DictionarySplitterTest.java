package test;

import main.dictionarysplitter.DictionarySplitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class DictionarySplitterTest {

    private static Set<String> arrToSet(String[] strings) {
        return Arrays.stream(strings).collect(Collectors.toSet());
    }

    @Test
    public void reconstructSentenceSingleSolution() {
        Set<String> words = arrToSet(new String[]{"quick", "brown", "the", "fox"});
        String input = "thequickbrownfox";
        String[] output = new String[]{"the", "quick", "brown", "fox"};

        assertArrayEquals(output, DictionarySplitter.reconstructSentence(input, words));
    }

    @Test
    public void reconstructSentenceMultipleSolutions() {
        Set<String> words = arrToSet(new String[]{"bed", "bath", "bedbath", "and", "beyond"});
        String input = "bedbathandbeyond";

        // Multiple allowed
        try {
            String[] output = new String[]{"bed", "bath", "and", "beyond"};
            assertArrayEquals(output, DictionarySplitter.reconstructSentence(input, words));
        } catch (AssertionError e) {
            String[] output = new String[]{"bedbath", "and", "beyond"};
            assertArrayEquals(output, DictionarySplitter.reconstructSentence(input, words));
        }
    }
}