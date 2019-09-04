package test.expressiontree;

import main.expressiontree.ExpressionTree;
import main.expressiontree.ExpressionTreeParser;
import org.junit.Test;

import static main.expressiontree.ExpressionTreeParser.MULTIPLY;
import static main.expressiontree.ExpressionTreeParser.PLUS;
import static org.junit.Assert.*;

//@formatter:off
/**
 * Suppose an arithmetic expression is given as a binary tree.
 * Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.
 *
 * Given the root to such a tree, write a function to evaluate it.
 *
 * For example, given the following tree:
 *
 *     *
 *    / \
 *   +    +
 *  / \  / \
 * 3  2  4  5
 * You should return 45, as it is (3 + 2) * (4 + 5).
 */
//@formatter:on
public class ExpressionTreeParserTest {

    @Test
    public void parse() {
        ExpressionTree root = new ExpressionTree(MULTIPLY);
        ExpressionTree left = new ExpressionTree(PLUS);
        ExpressionTree right = new ExpressionTree(PLUS);
        ExpressionTree leftLeft = new ExpressionTree("3");
        ExpressionTree leftRight = new ExpressionTree("2");
        ExpressionTree rightLeft = new ExpressionTree("4");
        ExpressionTree rightRight = new ExpressionTree("5");

        root.setLeft(left);
        root.setRight(right);

        left.setLeft(leftLeft);
        left.setRight(leftRight);

        right.setLeft(rightLeft);
        right.setRight(rightRight);

        int expected = 45;
        assertEquals(expected, new ExpressionTreeParser().parse(root));
    }
}