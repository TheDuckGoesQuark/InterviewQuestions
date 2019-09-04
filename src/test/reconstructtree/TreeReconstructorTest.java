package test.reconstructtree;

import com.sun.source.tree.Tree;
import main.reconstructtree.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.parameterized.ParametersRunnerFactory;

import java.util.Arrays;
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

    /*
     * [a, b, d, e, c, f, g]
     *
     * And the following inorder traversal:
     *
     * [d, b, e, a, f, c, g]
     */
    @Parameters
    public static Collection<Object[]> data() {
        TreeNode root =
        final Object[][] data = new Object[][]{
                {
                        new String[]{"a", "b", "d", "e", "c", "f", "g"},
                        new String[]{"d", "b", "e", "a", "f", "c", "g"},
                }
        };

        return Arrays.asList(data);
    }

    @Test
    public void reconstructTree() {

    }
}