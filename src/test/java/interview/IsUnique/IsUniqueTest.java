package interview.IsUnique;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IsUniqueTest {

    private final String input;
    private final boolean expectedIsUnique;

    public IsUniqueTest(String input, boolean expectedIsUnique) {
        this.input = input;
        this.expectedIsUnique = expectedIsUnique;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {"a", true},
                {"aa", false},
                {"b", true},
                {"bb", false},
                {"ab", true},
                {"ba", true},
                {"aba", false},
                {"bab", false},
                {"abcdefghijklmnopqrstuvwxyz", true},
                {"abcdefghijklmnopqrstuvwxyzb", false},
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(input, expectedIsUnique, IsUnique.isUnique(input));
    }
}
