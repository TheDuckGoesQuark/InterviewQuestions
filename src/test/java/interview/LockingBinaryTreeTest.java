package interview;

import interview.lockingbinarytree.LockingBinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockingBinaryTreeTest {

    @Test
    public void isLockedTestOnlyRoot() {
        LockingBinaryTree node = new LockingBinaryTree();

        assertFalse("initial state is unlocked", node.isLocked());
        assertTrue("able to lock single node", node.lock());
        assertTrue("locking a single node works", node.isLocked());
        assertTrue("able to unlock single node", node.unlock());
        assertFalse("unlocking a single node works", node.isLocked());
    }

    @Test
    public void isLockedTestRootAndLeft() {
        LockingBinaryTree node = new LockingBinaryTree();

        LockingBinaryTree left = new LockingBinaryTree();
        node.setLeft(left);

        assertTrue("able to lock parent if descendants are unlocked", node.lock());
        assertTrue("result of call to lock is persisted", node.isLocked());
        assertFalse("unable to lock node if already locked", node.lock());
        assertFalse("unable to lock child if parent is locked", left.lock());
        assertFalse("failed call to lock does not change state", left.isLocked());
        assertTrue("able to unlock node", node.unlock());
        assertFalse("result of call to unlock is persisted", node.isLocked());

        assertTrue("able to lock child if parent is unlocked", left.lock());
        assertTrue("result of call to lock is persisted", left.isLocked());
        assertFalse("unable to lock parent if child is locked", node.lock());
        assertTrue("able to unlock child", left.unlock());
        assertFalse("result of call to unlock is persisted", left.isLocked());
    }

    @Test
    public void isLockedTestRootAndRight() {
        LockingBinaryTree node = new LockingBinaryTree();

        LockingBinaryTree right = new LockingBinaryTree();
        node.setRight(right);

        assertTrue("able to lock parent if descendants are unlocked", node.lock());
        assertTrue("result of call to lock is persisted", node.isLocked());
        assertFalse("unable to lock node if already locked", node.lock());
        assertFalse("unable to lock child if parent is locked", right.lock());
        assertFalse("failed call to lock does not change state", right.isLocked());
        assertTrue("able to unlock node", node.unlock());
        assertFalse("result of call to unlock is persisted", node.isLocked());

        assertTrue("able to lock child if parent is unlocked", right.lock());
        assertTrue("result of call to lock is persisted", right.isLocked());
        assertFalse("unable to lock parent if child is locked", node.lock());
        assertTrue("able to unlock child", right.unlock());
        assertFalse("result of call to unlock is persisted", right.isLocked());
    }

    @Test
    public void isLockedTestRootLeftAndRight() {
        LockingBinaryTree node = new LockingBinaryTree();

        LockingBinaryTree right = new LockingBinaryTree();
        node.setRight(right);
        LockingBinaryTree left = new LockingBinaryTree();
        node.setLeft(left);

        // Locking parent node
        assertTrue("able to lock parent if descendants are unlocked", node.lock());
        assertTrue("result of call to lock is persisted", node.isLocked());
        assertFalse("unable to lock node if already locked", node.lock());
        assertFalse("unable to lock child if parent is locked", left.lock());
        assertFalse("unable to lock child if parent is locked", right.lock());
        assertFalse("failed call to lock does not change state", left.isLocked());
        assertFalse("failed call to lock does not change state", right.isLocked());
        assertTrue("able to unlock node", node.unlock());
        assertFalse("result of call to unlock is persisted", node.isLocked());

        // Locking children
        assertTrue("able to lock child if parent is unlocked", left.lock());
        assertTrue("result of call to lock is persisted", left.isLocked());
        assertFalse("unable to lock parent if child is locked", node.lock());
        assertTrue("able to lock node if sibling is locked", right.lock());
        assertTrue("result of call to lock is persisted", right.isLocked());
        assertTrue("able to unlock node if sibling is locked", right.unlock());
        assertTrue("able to unlock node", left.unlock());

        // Checking parent can be locked again
        assertTrue("able to lock parent after unlocking all children", node.lock());
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

        LockingBinaryTree rightLeft = new LockingBinaryTree();
        right.setLeft(rightLeft);
        LockingBinaryTree rightRight = new LockingBinaryTree();
        right.setRight(rightRight);

        // Locking parent node
        assertTrue("able to lock parent if descendants are unlocked", node.lock());
        assertTrue("result of call to lock is persisted", node.isLocked());
        assertFalse("unable to lock node if already locked", node.lock());
        assertFalse("unable to lock child if parent is locked", left.lock());
        assertFalse("unable to lock deeper child if parent is locked", leftLeft.lock());
        assertFalse("unable to lock deeper child if parent is locked", leftRight.lock());
        assertFalse("unable to lock deeper child if parent is locked", rightLeft.lock());
        assertFalse("unable to lock deeper child if parent is locked", rightRight.lock());
        assertFalse("unable to lock child if parent is locked", right.lock());

        // Unlocking parent node
        assertTrue("able to unlock node", node.unlock());

        // Locking children
        assertTrue("able to lock child if parent is unlocked", left.lock());
        assertFalse("unable to lock parent if child is locked", node.lock());
        assertFalse("unable to lock child of child if child is locked", leftLeft.lock());
        assertFalse("unable to lock child of child if child is locked", leftRight.lock());

        // Locking siblings
        assertTrue("able to lock node if sibling is locked", right.lock());
        assertFalse("unable to lock child of child if child is locked", rightLeft.lock());
        assertFalse("unable to lock child of child if child is locked", rightRight.lock());
        assertTrue("able to unlock node if sibling is locked", right.unlock());
        assertTrue("able to unlock node", left.unlock());

        // Locking deepest children
        assertTrue("able to lock child of child if parents unlocked", leftLeft.lock());
        assertFalse("unable to lock parent if child is locked", node.lock());
        assertFalse("unable to lock parent if child is locked", left.lock());
        assertTrue("able to lock cousin", right.lock());
        assertTrue("able to unlock cousin", right.unlock());
        assertTrue("able to lock sibling", leftRight.lock());
        assertTrue("able to unlock sibling", leftRight.unlock());
    }
}