package main.linkedlistintersection;

public class LinkedListBuilder {

    private Node root;
    private Node head;

    public LinkedListBuilder() {
    }

    public LinkedListBuilder add(int value) {
        if (root == null) {
            root = new Node(value);
            head = root;
        } else {
            Node newHead = new Node(value);
            head.setNext(newHead);
            head = newHead;
        }

        return this;
    }

    public Node build() {
        return this.root;
    }
}
