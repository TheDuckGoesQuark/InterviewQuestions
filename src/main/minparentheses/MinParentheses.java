package main.minparentheses;

import java.util.Stack;

/**
 * Given a string of parentheses, write a function to compute the minimum
 * number of parentheses to be removed to make the string valid
 * (i.e. each open parenthesis is eventually closed).
 * <p>
 * For example, given the string "()())()",
 * you should return 1.
 * <p>
 * Given the string ")(",
 * you should return 2,
 * since we must remove all of them.
 */
public class MinParentheses {

    public static final char OPEN = '(';

    public static int getMinNeedingRemoved(String str) {
        final char[] arr = str.toCharArray();

        int count = 0;
        final Stack<Character> bracketStack = new Stack<>();

        for (char c : arr) {
            if (c == OPEN) {
                bracketStack.push(OPEN);
            } else {
                if (bracketStack.isEmpty()) {
                    count++;
                } else {
                    bracketStack.pop();
                }
            }
        }

        return count + bracketStack.size();
    }

}