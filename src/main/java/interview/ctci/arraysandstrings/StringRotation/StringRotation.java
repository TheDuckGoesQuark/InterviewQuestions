package interview.ctci.arraysandstrings.StringRotation;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 */
public class StringRotation {

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        else if (s1.length() == 0) return true;

        var s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }
}
