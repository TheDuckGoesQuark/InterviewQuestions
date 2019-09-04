package main.reconstructtree;

// @formatter:off
import com.sun.source.tree.Tree;import java.util.Arrays; /**
 * Given in-order traversals of a binary tree, write a function to reconstruct the tree.
 *
 * For example, given the following inorder traversal:
 *
 * [d, b, e, a, f, c, g]
 *
 * You should return the following tree:
 *
 *     a
 *    / \
 *   b   c
 *  / \ / \
 * d  e f  g
 */
// @formatter:on
public class TreeReconstructor {

    /**
     * Inorder (Left, Root, Right) : d, b, e, a, f, c, g
     */
    public static TreeNode reconstructTree(String[] inOrder) {
        return reconstructTreeRecursively(inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode reconstructTreeRecursively(String[] inOrder, int startIndex, int endIndex) {
        int length = (endIndex - startIndex) + 1;

        if (length == 0)
            return null;
        else if (length == 1)
            return new TreeNode<>(inOrder[startIndex]);

        int middleIndex = startIndex + (length / 2);
        final TreeNode<String> root = new TreeNode<>(inOrder[startIndex + length / 2]);

        root.setLeft(reconstructTreeRecursively(inOrder, startIndex, middleIndex - 1));

        if (length > 2)
            root.setRight(reconstructTreeRecursively(inOrder, middleIndex + 1, endIndex));

        return root;
    }


}
