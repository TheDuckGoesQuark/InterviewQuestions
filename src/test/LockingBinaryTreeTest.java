package test;

import main.lockingbinarytree.LockingBinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockingBinaryTreeTest {

    @Test
    public void isLockedTestOnlyRoot() {
        LockingBinaryTree node = new LockingBinaryTree();

        assertFalse(node.isLocked());

        node.lock();

        assertTrue(node.isLocked());
    }

    @Test
    public void isLockedTestRootAndLeft() {
        LockingBinaryTree node = new LockingBinaryTree();

        LockingBinaryTree left = new LockingBinaryTree();
        node.setLeft(left);

        node.lock();
        assertTrue(left.isLocked());

        node.unlock();
        assertFalse(left.isLocked());
    }

    @Test
    public void isLockedTestRootAndRight() {
        LockingBinaryTree node = new LockingBinaryTree();

        LockingBinaryTree right = new LockingBinaryTree();
        node.setRight(right);

        node.lock();
        assertTrue(right.isLocked());

        node.unlock();
        assertFalse(right.isLocked());
    }

    @Test
    public void isLockedTestRootLeftAndRight() {
        LockingBinaryTree node = new LockingBinaryTree();

        LockingBinaryTree right = new LockingBinaryTree();
        node.setRight(right);
        LockingBinaryTree left = new LockingBinaryTree();
        node.setLeft(left);

        node.lock();
        assertTrue(left.isLocked());
        assertTrue(right.isLocked());

        node.unlock();
        assertFalse(left.isLocked());
        assertFalse(right.isLocked());
    }

    @Test
    public void isLockedTestRootTwoDeep() {
        //    *
        //   / \
        //  *   *
        // / \ / \
        //*  * *  *
        LockingBinaryTree node = new LockingBinaryTree();

        LockingBinaryTree right = new LockingBinaryTree();
        node.setRight(right);
        LockingBinaryTree left = new LockingBinaryTree();
        node.setLeft(left);

        LockingBinaryTree leftLeft = new LockingBinaryTree();
        left.setLeft(leftLeft);
        LockingBinaryTree leftRight = new LockingBinaryTree();
        left.setRight(leftRight);

        LockingBinaryTree rightLeft= new LockingBinaryTree();
        right.setLeft(rightLeft);
        LockingBinaryTree rightRight = new LockingBinaryTree();
        right.setRight(rightRight);

        // Lock deepest nodes
        leftLeft.lock();
        assertFalse(left.isLocked());
        leftLeft.unlock();

        leftRight.lock();
        assertFalse(left.isLocked());
        leftRight.unlock();

        // Lock nodes h - 1 deep
        left.lock();
        assertTrue(leftLeft.isLocked());
        assertTrue(leftRight.isLocked());
        left.unlock();
        assertFalse(leftLeft.isLocked());
        assertFalse(leftRight.isLocked());

        // Lock root
        node.lock();
        assertTrue(left.isLocked());
        assertTrue(leftLeft.isLocked());
        assertTrue(leftRight.isLocked());

        assertTrue(right.isLocked());
        assertTrue(rightLeft.isLocked());
        assertTrue(rightRight.isLocked());

        node.unlock();
        assertFalse(left.isLocked());
        assertFalse(leftLeft.isLocked());
        assertFalse(leftRight.isLocked());

        assertFalse(right.isLocked());
        assertFalse(rightLeft.isLocked());
        assertFalse(rightRight.isLocked());
    }
}