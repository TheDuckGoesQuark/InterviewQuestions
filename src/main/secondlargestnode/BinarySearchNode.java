package main.secondlargestnode;

public class BinarySearchNode<T extends Comparable<T>> implements Comparable {

    private T value;
    private BinarySearchNode<T> left;
    private BinarySearchNode<T> right;

    public BinarySearchNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinarySearchNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchNode<T> left) {
        this.left = left;
    }

    public BinarySearchNode<T> getRight() {
        return right;
    }

    public void setRight(BinarySearchNode<T> right) {
        this.right = right;
    }

    public void add(T value) {
        if (value.compareTo(this.value) < 0) {
            if (left == null) left = new BinarySearchNode<>(value);
            else left.add(value);
        } else {
            if (right == null) right = new BinarySearchNode<T>(value);
            else right.add(value);
        }
    }

    public void addAll(Iterable<T> values) {
        for (T value : values) {
            this.add(value);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left.toString());
        }
        sb.append(value);
        sb.append(", ");
        if (right != null) {
            sb.append(right.toString());
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        final BinarySearchNode<T> node = (BinarySearchNode<T>) o;
        return this.value.compareTo(node.getValue());
    }
}
