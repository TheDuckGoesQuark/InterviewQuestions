package interview;

import interview.justifytext.JustifyText;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JustifyTextTest {
    @Test
    public void justifyText() {
        final List<String> words = Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
        int k = 16;

        final List<String> expected = Arrays.asList("the  quick brown", "fox  jumps  over", "the   lazy   dog");
        assertEquals(expected, JustifyText.justifyText(words, k));
    }
}