package main.expressiontree;

/**
 * Suppose an arithmetic expression is given as a binary tree.
 * Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 * <p>
 * Given the root to such a tree, write a function to evaluate it.
 * <p>
 * For example, given the following tree:
 * <p>
 * *
 * / \
 * +    +
 * / \  / \
 * 3  2  4  5
 * You should return 45, as it is (3 + 2) * (4 + 5).
 */
public class ExpressionTreeParser {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public int parse(ExpressionTree node) {
        if (node.isLeaf())
            return node.getAsInteger();

        int left = this.parse(node.getLeft());
        int right = this.parse(node.getRight());

        return applyOperation(node, left, right);
    }

    private int applyOperation(ExpressionTree node, int left, int right) {
        switch (node.getValue()) {
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVIDE:
                return left / right;
        }

        throw new IllegalArgumentException("Operation is not valid: " + node.getValue());
    }

}
