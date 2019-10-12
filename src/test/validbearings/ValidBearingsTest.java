package test.validbearings;

import main.validbearings.ValidBearings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValidBearingsTest {

    private String[] listOfRules;
    private boolean expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = {
                {new String[]{}, true}
        };
        return Arrays.asList(data);
    }

    @Test
    void isValidListOfRules() {
        assertEquals(expected, ValidBearings.isValidListOfRules(listOfRules));
    }
}