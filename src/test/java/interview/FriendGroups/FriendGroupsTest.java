package interview.FriendGroups;

import interview.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FriendGroupsTest {

    private final int[][] inputFriendships;
    private final int expectedFriendGroupCount;

    public FriendGroupsTest(int[][] inputFriendships, int expectedFriendGroupCount) {
        this.inputFriendships = inputFriendships;
        this.expectedFriendGroupCount = expectedFriendGroupCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new int[][]{
                                {1},
                                {0}
                        },
                        1
                },
                {
                        new int[][]{
                                {},
                                {},
                                {}
                        },
                        3
                },
                {
                        new int[][]{
                                {1, 2},
                                {0, 5},
                                {0},
                                {6},
                                {},
                                {1},
                                {3},
                        },
                        3
                }
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
        assertEquals(Util.twoDimensionalArrayToString(inputFriendships), expectedFriendGroupCount, FriendGroups.numberOfFriendGroups(inputFriendships));
    }
}
