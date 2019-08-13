package test;

import main.minpalindrome.MinPalindrome;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinPalindromeTest {

    @Test
    public void getMinPalindrome() {
        assertEquals("a", MinPalindrome.getMinPalindrome("a"));
        assertEquals("aba", MinPalindrome.getMinPalindrome("ab"));
        assertEquals("aba", MinPalindrome.getMinPalindrome("aba"));
        assertEquals("abba", MinPalindrome.getMinPalindrome("abba"));
        assertEquals("abcba", MinPalindrome.getMinPalindrome("acba"));
        assertEquals("ecarace", MinPalindrome.getMinPalindrome("race"));
        assertEquals("google", MinPalindrome.getMinPalindrome("elgoogle"));
        assertEquals("food", MinPalindrome.getMinPalindrome("doofood"));
        assertEquals("dood", MinPalindrome.getMinPalindrome("dood"));
        assertEquals("radnelacalendar", MinPalindrome.getMinPalindrome("calendar"));
        assertEquals("youwnoknowouy", MinPalindrome.getMinPalindrome("youknowouy"));
    }
}