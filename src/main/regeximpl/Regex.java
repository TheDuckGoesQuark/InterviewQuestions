package main.regeximpl;

/**
 * Implement regular expression matching with the following special characters:
 * <p>
 * . (period) which matches any single character
 * * (asterisk) which matches zero or more of the preceding element
 * <p>
 * That is, implement a function that takes in a string and a
 * valid regular expression and
 * returns whether or not the string matches the regular expression.
 * <p>
 * For example, given the regular expression "ra."
 * and the string "ray", your function should return true.
 * The same regular expression on the string "raymond" should return false.
 * <p>
 * Given the regular expression ".*at"
 * and the string "chat", your function should return true.
 * The same regular expression on the string "chats" should return false.
 */
public class Regex {
    private static final char DOT = '.';
    private static final char ASTERISK = '*';

    public Regex(String pattern) {

    }

    public boolean matches(String str) {
        return false;
    }
}
