package main.treesolver;

public class TreeSolver {
    public static int countNumberOfNodes(Node root) {
        if (root != null) {
            return countNumberOfNodes(root.getLeft()) + countNumberOfNodes(root.getRight()) + 1;
        } else {
            return 0;
        }
    }


    public static int returnMaxDepth(Node root) {
        if (root == null) return 0;
        else {
            int leftDepth = returnMaxDepth(root.getLeft()) + 1;
            int rightDepth = returnMaxDepth(root.getRight()) + 1;

            return leftDepth > rightDepth ? leftDepth : rightDepth;
        }
    }
}
