package main.secondlargestnode;

/**
 * Given the root to a binary search tree, find the second largest node in the tree.
 */
public class BinaryTreeSearcher {

    /**
     * Given the root to a binary search tree, find the second largest node in the tree.
     *
     * @param root root of binary tree
     * @return node with second largest value in tree
     */
    public static BinarySearchNode findSecondLargestNode(BinarySearchNode root) {
        final BinarySearchNode[] maxes = new BinarySearchNode[2];
        recursivelyFindSecondLargestNode(root, maxes);

        return maxes[0];
    }

    private static void recursivelyFindSecondLargestNode(BinarySearchNode root, BinarySearchNode[] maxes) {
        insertIntoMaxes(root, maxes);

        BinarySearchNode left = root.getLeft();
        if (left != null) recursivelyFindSecondLargestNode(left, maxes);
        BinarySearchNode right = root.getRight();
        if (right != null) recursivelyFindSecondLargestNode(right, maxes);

    }

    private static void insertIntoMaxes(BinarySearchNode node, BinarySearchNode[] maxes) {
        if (maxes[1] == null) maxes[1] = node;
        else {
            if (node.compareTo(maxes[1].getValue()) > 0) {
                maxes[0] = maxes[1];
                maxes[1] = node;
            } else {
                if (maxes[0] == null || node.compareTo(maxes[0].getValue()) > 0) {
                    maxes[0] = node;
                }
            }
        }
    }
}
