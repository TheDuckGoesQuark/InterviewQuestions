package interview;

import interview.dictionarysplitter.DictionarySplitter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
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

        Optional<String[]> result = DictionarySplitter.reconstructSentence(input, words);
        assertTrue(result.isPresent());
        assertArrayEquals(output, result.get());
    }

    @Test
    public void reconstructSentenceComplex() {
        Set<String> words = arrToSet(new String[]{"i", "am", "reading", "about", "read", "ding", "brotherhood", "bro", "broth", "there"});
        String input = "iamreadingaboutbrotherhood";
        String[] output = new String[]{"i", "am", "reading", "about", "brotherhood"};

        Optional<String[]> result = DictionarySplitter.reconstructSentence(input, words);
        assertTrue(result.isPresent());
        assertArrayEquals(output, result.get());
    }

    @Test
    public void reconstructSentenceMultipleSolutions() {
        Set<String> words = arrToSet(new String[]{"bed", "bath", "bedbath", "and", "beyond"});
        String input = "bedbathandbeyond";

        Optional<String[]> result = DictionarySplitter.reconstructSentence(input, words);
        assertTrue(result.isPresent());

        // Multiple allowed
        try {
            String[] output = new String[]{"bed", "bath", "and", "beyond"};
            assertArrayEquals(output, result.get());
        } catch (AssertionError e) {
            String[] output = new String[]{"bedbath", "and", "beyond"};
            assertArrayEquals(output, result.get());
        }
    }

}