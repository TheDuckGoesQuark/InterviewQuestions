package test.reconstructtree;

import main.reconstructtree.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.parameterized.ParametersRunnerFactory;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class TreeReconstructorTest {

    private String[] preOrder;
    private String[] inOrder;
    private TreeNode expected;

    public TreeReconstructorTest(String[] preOrder, String[] inOrder, TreeNode expected) {
        this.preOrder = preOrder;
        this.inOrder = inOrder;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][]{
                {new int[]{13, 19, 13, 13}, 19},
                {new int[]{2, 3, 3, 3}, 2},
                {new int[]{3, 2, 3, 3}, 2},
                {new int[]{3, 3, 2, 3}, 2},
                {new int[]{3, 3, 3, 2}, 2},
                {new int[]{1, 2, 3, 1, 2, 1, 2}, 3},
                {new int[]{1, 2, 2, 2, 3, 3, 3}, 1},
                {new int[]{6, 1, 3, 3, 3, 6, 6}, 1}
        };

        return Arrays.asList(data);
    }

    @Test
    public void reconstructTree() {

    }
}