package interview.booleanarray;

import java.util.Arrays;

public class BooleanExpressionArrayEvaluator {
    /**
     * You are presented with an array representing a Boolean expression. The elements are of two kinds:
     * <p>
     * T and F, representing the values True and False.
     * &, |, and ^, representing the bitwise operators for AND, OR, and XOR.
     * Determine the number of ways to group the array elements using parentheses so that the entire expression evaluates to True.
     * <p>
     * For example, suppose the input is ['F', '|', 'T', '&', 'T']. In this case, there are two acceptable groupings: (F | T) & T and F | (T & T).
     */
    private static final char TRUE = 'T';
    private static final char FALSE = 'F';
    private static final char XOR = '^';
    private static final char OR = '|';
    private static final char AND = '&';

    private static boolean isTrue(char a) {
        return a == TRUE;
    }

    private static boolean or(char a, char b) {
        return (isTrue(a)) || (isTrue(b));
    }

    private static boolean xor(char a, char b) {
        return (isTrue(a) || isTrue(b)) && (a != b);
    }

    private static boolean and(char a, char b) {
        return (isTrue(a)) && (isTrue(b));
    }

    private static boolean evaluate(char a, char operation, char b) {
        return switch (operation) {
            case XOR -> xor(a, b);
            case OR -> or(a, b);
            case AND -> and(a, b);
            default -> throw new RuntimeException("Invalid operation character: " + operation);
        };
    }

    public static int countParenthesesGroupingThatEvaluateToTrue(char[] arr) {
        // base case, evaluate. If it's true, then 1 parenthesis combo. Else, 0 parenthesis combos
        if (arr.length == 3) {
            return evaluate(arr[0], arr[1], arr[2]) ? 1 : 0;
        }

        // split the arr on each operator, one at a time
        // evaluate either side of the operator
        var count = 0;
        for (int i = 1; i < arr.length; i += 2) {
            var operator = arr[i];
            var left = Arrays.copyOfRange(arr, 0, i);
            var leftCount = countParenthesesGroupingThatEvaluateToTrue(left);
            var leftValue = left.length == 1
                    ? left[0]
                    : leftCount > 0 ? TRUE : FALSE;

            var right = Arrays.copyOfRange(arr, i + 1, arr.length);
            var rightCount = countParenthesesGroupingThatEvaluateToTrue(right);
            var rightValue = right.length == 1
                    ? right[0]
                    : rightCount > 0 ? TRUE : FALSE;

            var evaluatesToTrue = evaluate(leftValue, operator, rightValue);
            System.out.printf("o: %s,\n left: %s,\n right: %s,\n ett: %s%n", operator, Arrays.toString(left), Arrays.toString(right), evaluatesToTrue);
            if (evaluatesToTrue) {
                // multiply as it's the product (i.e. every combination) of left and right
                // min 1 so we don't multiply by zero
                count += (Math.max(rightCount, 1) * Math.max(leftCount, 1));
            }
        }

        return count;
    }
}
