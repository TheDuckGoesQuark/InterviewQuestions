package test;

import main.treesolver.Node;
import main.treesolver.TreeSolver;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TreeSolverTests {

    @Test
    public void testCountNodesWhenOne() {
        Node node = new Node(0, null, null);

        assertEquals(1, TreeSolver.countNumberOfNodes(node));
    }

    @Test
    public void testCountNodesWhenOneOnLeft() {
        Node left = new Node(0, null, null);
        Node root = new Node(0, left, null);

        assertEquals(2, TreeSolver.countNumberOfNodes(root));
    }

    @Test
    public void testCountNodesWhenOneOnRight() {
        Node right = new Node(0, null, null);
        Node root = new Node(0, null, right);

        assertEquals(2, TreeSolver.countNumberOfNodes(root));
    }

    @Test
    public void testCountNodesWhenBothSides() {
        Node right = new Node(0, null, null);
        Node left = new Node(0, null, null);
        Node root = new Node(0, left, right);

        assertEquals(3, TreeSolver.countNumberOfNodes(root));
    }

    @Test
    public void testCountNodesWhenBothSidesTwoDeep() {
        /*

        *
       / \
      *   *
     /\  / \
    *  **   *

         */
        Node right = new Node(0, new Node(0, null, null), new Node(0, null, null));
        Node left = new Node(0, new Node(0, null, null), new Node(0, null, null));
        Node root = new Node(0, left, right);

        assertEquals(7, TreeSolver.countNumberOfNodes(root));
    }

    @Test
    public void testDeepestNodeWhenNone() {
        assertEquals(0, TreeSolver.returnMaxDepth(null));
    }

    @Test
    public void testDeepestNodeWhenOne() {
        Node node = new Node(0, null, null);

        assertEquals(1, TreeSolver.returnMaxDepth(node));
    }

    @Test
    public void testDeepestNodeWhenOneOnLeft() {
        Node left = new Node(0, null, null);
        Node root = new Node(0, left, null);

        assertEquals(2, TreeSolver.returnMaxDepth(root));
    }

    @Test
    public void testDeepestNodeWhenOneOnRight() {
        Node right = new Node(0, null, null);
        Node root = new Node(0, null, right);

        assertEquals(2, TreeSolver.returnMaxDepth(root));
    }

    @Test
    public void testDeepestNodeWhenBothSides() {
        Node right = new Node(0, null, null);
        Node left = new Node(0, null, null);
        Node root = new Node(0, left, right);

        assertEquals(2, TreeSolver.returnMaxDepth(root));
    }

    @Test
    public void testDeepestNodesWhenLeftDeeper() {
        /*

        *
       /  \
      *    *
     /\   / \
    *  * *   *
        \
         *

         */
        Node right = new Node(0, new Node(0, null, null), new Node(0, null, null));
        Node left = new Node(0, new Node(0, null, null), new Node(0, null, new Node(0, null, null)));
        Node root = new Node(0, left, right);

        assertEquals(4, TreeSolver.returnMaxDepth(root));
    }

    @Test
    public void testDeepestNodesWhenRightDeeper() {
        /*

        *
       /  \
      *    *
     /\   / \
    *  * *   *
          \
           *

         */
        Node right = new Node(0, new Node(0, null, null), new Node(0, new Node(0, null, null), null));
        Node left = new Node(0, new Node(0, null, null), new Node(0, null, null));
        Node root = new Node(0, left, right);

        assertEquals(4, TreeSolver.returnMaxDepth(root));
    }


}
