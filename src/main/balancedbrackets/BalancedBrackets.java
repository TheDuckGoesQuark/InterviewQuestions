package main.balancedbrackets;

import java.util.Stack;

/**
 * Given a string of round, curly, and square open and closing brackets,
 * return whether the brackets are balanced (well-formed).
 * <p>
 * For example, given the string "([])[]({})", you should return true.
 * <p>
 * Given the string "([)]" or "((()", you should return false.
 */
public class BalancedBrackets {

    public static boolean bracketsAreBalanced(String str) {
        final Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            switch (current) {
                case '(':
                case '{':
                case '[':
                    bracketStack.push(current);
                    break;
                case ')':
                    if (bracketStack.peek() == '(') bracketStack.pop();
                    else return false;
                    break;
                case '}':
                    if (bracketStack.peek() == '{') bracketStack.pop();
                    else return false;
                    break;
                case ']':
                    if (bracketStack.peek() == '[') bracketStack.pop();
                    else return false;
                    break;
                default:
                    return false;
            }
        }

        return bracketStack.isEmpty();
    }

}
