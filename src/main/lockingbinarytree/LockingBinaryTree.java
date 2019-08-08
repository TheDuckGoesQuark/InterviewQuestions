package main.lockingbinarytree;

import main.treesolver.Node;

/**
 * Implement locking in a binary tree.
 * <p>
 * A binary tree node can be locked or unlocked only
 * if all of its descendants or ancestors are not locked.
 * <p>
 * Design a binary tree node class with the following methods:
 * <p>
 * isLocked, which returns whether the node is locked
 * <p>
 * lock, which attempts to lock the node.
 * If it cannot be locked, then it should return false.
 * Otherwise, it should lock it and return true.
 * <p>
 * unlock, which unlocks the node.
 * If it cannot be unlocked, then it should return false.
 * Otherwise, it should unlock it and return true.
 * <p>
 * You may augment the node to add parent pointers or any other property you would like.
 * You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes.
 * Each method should run in O(h), where h is the height of the tree.
 */
public class LockingBinaryTree {

    private boolean locked;

    private LockingBinaryTree parent;
    private LockingBinaryTree left;
    private LockingBinaryTree right;

    public LockingBinaryTree() {
    }

    public LockingBinaryTree getLeft() {
        return left;
    }

    public void setLeft(LockingBinaryTree left) {
        this.left = left;
        left.setParent(this);
    }

    public LockingBinaryTree getRight() {
        return right;
    }

    public void setRight(LockingBinaryTree right) {
        this.right = right;
        right.setParent(this);
    }

    public LockingBinaryTree getParent() {
        return parent;
    }

    public void setParent(LockingBinaryTree parent) {
        this.parent = parent;
    }

    /**
     * @return true if the node is locked
     */
    public boolean isLocked() {
        return false;
    }

    /**
     * Attempts to lock the node.
     *
     * @return false if node cannot be locked, true otherwise
     */
    public boolean lock() {
        return false;
    }

    /**
     * Attempts to unlock the node
     *
     * @return false if unable to unlock. True otherwise.
     */
    public boolean unlock() {
        return false;
    }
}
