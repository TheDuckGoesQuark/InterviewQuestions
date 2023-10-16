package interview.teambuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TeamBuilderTest {

    private final int[][] studentEnemies;
    private final int[][] expectedTeams;

    public TeamBuilderTest(int[][] studentEnemies, int[][] expectedTeams) {
        this.studentEnemies = studentEnemies;
        this.expectedTeams = expectedTeams;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[][]{
                                {3},
                                {2},
                                {1, 4},
                                {0, 4, 5},
                                {2, 3},
                                {3}
                        },
                        new int[][]{
                                {0, 1, 4, 5},
                                {2, 3}
                        }
                },
                {
                        new int[][]{
                                {3},
                                {2},
                                {1, 3, 4},
                                {0, 2, 4, 5},
                                {2, 3},
                                {3}
                        },
                        null
                }
        };
        return Arrays.asList(inputs);
    }

    private static String twoDimensionalArrayToString(int[][] arr) {
        return Arrays.toString(Arrays.stream(arr).map(a -> Arrays.toString(a) + ",\n").toArray());
    }

    @Test
    public void findTeams() {
        var testName = twoDimensionalArrayToString(studentEnemies);
        var teams = TeamBuilder.findTeams(studentEnemies);
        if (expectedTeams == null) assertNull(testName, teams);
        else assertTrue(testName + ":" + twoDimensionalArrayToString(teams), isSameTeams(expectedTeams, teams));
    }

    private boolean isSameTeams(int[][] expectedTeams, int[][] actualTeams) {
        if (expectedTeams.length > actualTeams.length) return false;

        for (int[] expectedTeam : expectedTeams) {
            if (!teamExistsOnce(expectedTeam, actualTeams)) return false;
        }

        return true;
    }

    private boolean teamExistsOnce(int[] expectedTeam, int[][] actualTeams) {
        var expectedTeamSet = IntStream.of(expectedTeam).boxed().collect(Collectors.toSet());
        var matchingTeamCount = 0;

        for (int[] actualTeam : actualTeams) {
            var actualTeamSet = IntStream.of(actualTeam).boxed().collect(Collectors.toSet());
            var match = actualTeamSet.equals(expectedTeamSet);
            if (match) matchingTeamCount++;
        }

        return matchingTeamCount == 1;
    }
}