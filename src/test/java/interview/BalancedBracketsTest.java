package interview;

import interview.balancedbrackets.BalancedBrackets;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBracketsTest {
    @Test
    public void bracketsAreBalanced() {
        assertTrue(BalancedBrackets.bracketsAreBalanced("([])[]({})"));
        assertFalse(BalancedBrackets.bracketsAreBalanced("([)]"));
        assertFalse(BalancedBrackets.bracketsAreBalanced("((()"));
    }
}