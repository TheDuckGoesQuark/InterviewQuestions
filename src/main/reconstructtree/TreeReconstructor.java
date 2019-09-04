package main.reconstructtree;

// @formatter:off
import com.sun.source.tree.Tree;import java.util.Arrays; /**
 * Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.
 *
 * For example, given the following preorder traversal:
 *
 * [a, b, d, e, c, f, g]
 *
 * And the following inorder traversal:
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
     * Preorder (Root, Left, Right) : a, b, d, e, c, f, g
     * Inorder (Left, Root, Right) : d, b, e, a, f, c, g
     */
    public static TreeNode reconstructTree(String[] preOrder, String[] inOrder) {
        return reconstructTreeRecursively(preOrder, inOrder, 0, preOrder.length - 1);
    }

    private static TreeNode reconstructTreeRecursively(String[] preOrder, String[] inOrder, int startIndex, int endIndex) {
        int length = (endIndex - startIndex) + 1;

        if (length == 0)
            return null;
        else if (length == 1)
            return new TreeNode<>(inOrder[startIndex]);

        // 0
        // 0, 1
        // 0, 1, 2
        // 0, 1, 2, 3
        // 0, 1, 2, 3, 4

        int middleIndex = startIndex + (length / 2);
        final TreeNode<String> root = new TreeNode<>(inOrder[startIndex + length / 2]);

        root.setLeft(reconstructTreeRecursively(preOrder, inOrder, startIndex, middleIndex - 1));

        if (length > 2)
            root.setRight(reconstructTreeRecursively(preOrder, inOrder, middleIndex + 1, endIndex));

        return root;
    }


}
