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
    public static <E extends Comparable<E>> BinarySearchNode<E> findSecondLargestNode(BinarySearchNode<E> root) {
        final BinarySearchNode<E>[] maxes = new <>BinarySearchNode[2];
        recursivelyFindSecondLargestNode(root, maxes);

        return maxes[0];
    }

    private static <E extends Comparable<E>> void recursivelyFindSecondLargestNode(BinarySearchNode<E> root, BinarySearchNode<E>[] maxes) {
        insertIntoMaxes(root, maxes);

        BinarySearchNode<E> left = root.getLeft();
        if (left != null) recursivelyFindSecondLargestNode(left, maxes);
        BinarySearchNode<E> right = root.getRight();
        if (right != null) recursivelyFindSecondLargestNode(right, maxes);

    }

    private static <E extends Comparable<E>> void insertIntoMaxes(BinarySearchNode<E> node, BinarySearchNode<E>[] maxes) {
        if (maxes[1] == null) maxes[1] = node;
        else {
            if (node.getValue().compareTo(maxes[1].getValue()) > 0) {
                maxes[0] = maxes[1];
                maxes[1] = node;
            } else {
                if (maxes[0] == null || node.getValue().compareTo(maxes[0].getValue()) > 0) {
                    maxes[0] = node;
                }
            }
        }
    }
}
