package main.expressiontree;

public class ExpressionTree {

    private final String value;
    private ExpressionTree left;
    private ExpressionTree right;

    public ExpressionTree(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public ExpressionTree getLeft() {
        return left;
    }

    public void setLeft(ExpressionTree left) {
        this.left = left;
    }

    public ExpressionTree getRight() {
        return right;
    }

    public void setRight(ExpressionTree right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public int getAsInteger() {
        return Integer.parseInt(value);
    }
}
