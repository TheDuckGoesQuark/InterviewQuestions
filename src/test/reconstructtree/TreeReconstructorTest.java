package test.reconstructtree;

import com.sun.source.tree.Tree;
import main.reconstructtree.TreeNode;
import main.reconstructtree.TreeReconstructor;
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

    @Parameters
    public static Collection<Object[]> data() {
        final TreeNode a = new TreeNode("a");
        final TreeNode b = new TreeNode("b");
        final TreeNode c = new TreeNode("c");
        final TreeNode d = new TreeNode("d");
        final TreeNode e = new TreeNode("e");
        final TreeNode f = new TreeNode("f");
        final TreeNode g = new TreeNode("g");

        a.setLeft(b);
        a.setRight(c);

        b.setLeft(d);
        b.setRight(e);

        c.setLeft(f);
        c.setRight(g);

        final Object[][] data = new Object[][]{
                {
                        new String[]{"d"}, // preorder
                        new String[]{"d"}, // inorder
                        d
                },
                /*
                *   b
                *  / \
                * d   e
                */
                {
                        new String[]{"b", "d", "e"}, // preorder
                        new String[]{"d", "b", "e"}, // inorder
                        a
                },
                /*
                 *     a
                 *    / \
                 *   b   c
                 *  / \ / \
                 * d  e f  g
                 */
                {
                        new String[]{"a", "b", "d", "e", "c", "f", "g"}, // preorder
                        new String[]{"d", "b", "e", "a", "f", "c", "g"}, // inorder
                        a
                },
        };

        return Arrays.asList(data);
    }

    @Test
    public void reconstructTree() {
        assertEquals(expected, TreeReconstructor.reconstructTree(preOrder, inOrder));
    }
}