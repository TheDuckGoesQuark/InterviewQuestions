package test;

import main.sort5.Horse;
import main.sort5.HorseRacer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HorseRacerTest {

    private final int[] horseTimes;
    private final int[] expectedTopThree;
    private final int expectedNumberOfRaces;

    public HorseRacerTest(int[] horseTimes, int[] expectedTopThree, int expectedNumberOfRaces) {
        this.horseTimes = horseTimes;
        this.expectedTopThree = expectedTopThree;
        this.expectedNumberOfRaces = expectedNumberOfRaces;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {new int[]{1,2,3,4,5}, new int[]{1,2,3}, 1},
                {new int[]{5,4,3,2,1}, new int[]{1,2,3}, 1},
                {new int[]{1,2,3,4,5,6,7,8,9}, new int[]{1,2,3}, 3},
                {new int[]{9,8,7,6,5,4,3,2,1}, new int[]{1,2,3}, 3},
                {new int[]{1,2,3,4,5,6,7,8,9,10}, new int[]{1,2,3}, 4},
                {new int[]{10,9,8,7,6,5,4,3,2,1}, new int[]{1,2,3}, 4},
                {new int[]{1,2,3,4,5,6,7,8,9,10,11}, new int[]{1,2,3}, 4},
                {new int[]{11,10,9,8,7,6,5,4,3,2,1}, new int[]{1,2,3}, 4},
        };
        return Arrays.asList(inputs);
    }

    private static Horse[] createHorseArray(int[] times) {
        var horses = new Horse[times.length];
        for (int i = 0; i < times.length; i++) {
            horses[i] = new Horse(times[i]);
        }
        return horses;
    }

    private static int[] getTimeArray(Horse[] horses) {
        var times = new int[horses.length];
        for (int i = 0; i < times.length; i++) {
            times[i] = horses[i].getFinishTime();
        }
        return times;
    }

    @Test
    public void name() {
        var horseRacer = new HorseRacer();
        var winners = getTimeArray(horseRacer.getTopThreeHorses(createHorseArray(this.horseTimes)));

        assertArrayEquals("Winning horses correct", this.expectedTopThree, winners);
        assertEquals("Number of races equals", this.expectedNumberOfRaces, horseRacer.getRaceCounter());
    }
}