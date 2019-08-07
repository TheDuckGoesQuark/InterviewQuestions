package main.lockingbinarytree;

/**
 * Implement locking in a binary tree.
 * <p>
 * A binary tree node can be locked or unlocked only
 * if all of its descendants or ancestors are not locked.
 * <p>
 * Design a binary tree node class with the following methods:
 * <p>
 * is_locked, which returns whether the node is locked
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
    /**
     * @return true if the node is locked
     */
    boolean is_locked() {
        return false;
    }

    /**
     * Attempts to lock the node.
     *
     * @return false if node cannot be locked, true otherwise
     */
    boolean lock() {
        return false;
    }

    /**
     * Attempts to unlock the node
     *
     * @return false if unable to unlock. True otherwise.
     */
    boolean unlock() {
        return false;
    }
}
