package interview.ctci.arraysandstrings.RotateMatrix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class RotateMatrixTest {

    public RotateMatrixTest() {
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
    }
}
