package main.expressiontree;

public class ExpressionTree {

    final String value;
    ExpressionTree left;
    ExpressionTree right;

    public ExpressionTree(String value) {
        this.value = value;
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
