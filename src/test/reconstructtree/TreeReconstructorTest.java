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

        final TreeNode<String> h = new TreeNode<>("h");
        final TreeNode<String> i = new TreeNode<>("i");
        final TreeNode<String> j = new TreeNode<>("j");
        final TreeNode<String> k = new TreeNode<>("k");

        h.setLeft(i);
        h.setRight(j);

        i.setLeft(k);
        i.setRight(b);

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
                        new String[]{"a", "b", "d", "e", "c", "f", "g"}, // preorder
                        new String[]{"d", "b", "e", "a", "f", "c", "g"}, // inorder
                        a
                },
                /*
                 *     h
                 *    / \
                 *   i   j
                 *  / \
                 * k   b
                 *    / \
                 *   d   e
                 */
                {
                        new String[]{"h", "i", "k", "b", "d", "e", "j"}, // preorder
                        new String[]{"k", "i", "d", "b", "e", "h", "j"}, // inorder
                        h
                },
        };

        return Arrays.asList(data);
    }

    @Test
    public void reconstructTree() {
        assertEquals(expected, TreeReconstructor.reconstructTree(preOrder, inOrder));
    }
}