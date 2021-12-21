package test.reconstructtree;

import interview.reconstructtree.TreeNode;
import interview.reconstructtree.TreeReconstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class TreeReconstructorTest {

    private String[] inOrder;
    private TreeNode expected;

    public TreeReconstructorTest(String[] inOrder, TreeNode expected) {
        this.inOrder = inOrder;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final TreeNode<String> a = new TreeNode<>("a");
        final TreeNode<String> b = new TreeNode<>("b");
        final TreeNode<String> c = new TreeNode<>("c");
        final TreeNode<String> d = new TreeNode<>("d");
        final TreeNode<String> e = new TreeNode<>("e");
        final TreeNode<String> f = new TreeNode<>("f");
        final TreeNode<String> g = new TreeNode<>("g");

        a.setLeft(b);
        a.setRight(c);

        b.setLeft(d);
        b.setRight(e);

        c.setLeft(f);
        c.setRight(g);

        final Object[][] data = new Object[][]{
                {
                        new String[]{"d"}, // inorder
                        d
                },
                /*
                *   b
                *  / \
                * d   e
                */
                {
                        new String[]{"d", "b", "e"}, // inorder
                        b
                },
                /*
                 *     a
                 *    / \
                 *   b   c
                 *  / \ / \
                 * d  e f  g
                 */
                {
                        new String[]{"d", "b", "e", "a", "f", "c", "g"}, // inorder
                        a
                },
        };

        return Arrays.asList(data);
    }

    @Test
    public void reconstructTree() {
        assertEquals(expected, TreeReconstructor.reconstructTree(inOrder));
    }
}