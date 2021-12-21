package interview;

import interview.regeximpl.Regex;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegexTest {

    @Test
    public void testMatcherJustDot() {
        Regex regex = new Regex(".");

        assertTrue(regex.matches("r"));

        assertFalse(regex.matches(""));
        assertFalse(regex.matches("ra"));
        assertFalse(regex.matches("abc"));
    }

    @Test
    public void testMatcherMultipleDots() {
        Regex regex = new Regex("...");

        assertTrue(regex.matches("rat"));

        assertFalse(regex.matches(""));
        assertFalse(regex.matches("r"));
        assertFalse(regex.matches("ra"));
        assertFalse(regex.matches("ratty"));
    }

    @Test
    public void testMatcherDotAtEnd() {
        Regex regex = new Regex("ra.");

        assertTrue(regex.matches("ray"));
        assertFalse(regex.matches("ra"));
        assertFalse(regex.matches("r"));
        assertFalse(regex.matches("abc"));
        assertFalse(regex.matches("bac"));
        assertFalse(regex.matches("raymond"));
    }

    @Test
    public void testMatcherDotAtStart() {
        Regex regex = new Regex(".ing");

        assertTrue(regex.matches("ding"));
        assertFalse(regex.matches("ing"));
        assertFalse(regex.matches("ng"));
        assertFalse(regex.matches("abcd"));
        assertFalse(regex.matches(""));
    }

    @Test
    public void testMatcherDotAtMiddle() {
        Regex regex = new Regex("b.t");

        assertTrue(regex.matches("bat"));
        assertFalse(regex.matches("cat"));
        assertFalse(regex.matches("ban"));
        assertFalse(regex.matches("bt"));
        assertFalse(regex.matches(""));
        assertFalse(regex.matches("boot"));
    }

    @Test
    public void testMatcherDotMultiple() {
        Regex regex = new Regex(".a.b.c.");

        assertTrue(regex.matches("catbyci"));
        assertTrue(regex.matches("aabbccc"));
        assertFalse(regex.matches("cbtcaya"));
        assertFalse(regex.matches("abc"));
        assertFalse(regex.matches("aabbcc"));
    }

    @Test
    public void testMatcherAsteriskSingleChar() {
        Regex regex = new Regex("c*t");

        assertTrue(regex.matches("ccccccct"));
        assertTrue(regex.matches("cct"));
        assertTrue(regex.matches("ct"));
        assertTrue(regex.matches("t"));

        assertFalse(regex.matches("r"));
        assertFalse(regex.matches("bt"));
        assertFalse(regex.matches(""));
    }

    @Test
    public void testMatcherAsteriskEnd() {
        Regex regex = new Regex("ct*");

        assertTrue(regex.matches(""));
        assertTrue(regex.matches("ct"));
        assertTrue(regex.matches("ctct"));
        assertTrue(regex.matches("ctctctct"));

        assertFalse(regex.matches("cte"));
        assertFalse(regex.matches("ctctcte"));
        assertFalse(regex.matches("cttcctct"));
        assertFalse(regex.matches("c"));
        assertFalse(regex.matches("t"));
        assertFalse(regex.matches("r"));
    }

    @Test
    public void testMatcherAsteriskMultiple() {
        Regex regex = new Regex("ct*ab*");

        assertTrue(regex.matches(""));
        assertTrue(regex.matches("ab"));
        assertTrue(regex.matches("ctab"));
        assertTrue(regex.matches("ctctab"));
        assertTrue(regex.matches("ctctctctab"));
        assertTrue(regex.matches("ctctctctabctab"));
        assertTrue(regex.matches("ctctctctabctctabab"));
        assertTrue(regex.matches("ctctctctababctctabab"));

        assertFalse(regex.matches("cte"));
        assertFalse(regex.matches("ctctctct"));
        assertFalse(regex.matches("ctct"));
        assertFalse(regex.matches("ct"));
        assertFalse(regex.matches("ctctcta"));
        assertFalse(regex.matches("a"));
        assertFalse(regex.matches("b"));
        assertFalse(regex.matches("t"));
        assertFalse(regex.matches("c"));
    }

    @Test
    public void testMatcherDotAndAsterisk() {
        Regex regex = new Regex(".*at");

        assertTrue(regex.matches("chat"));
        assertTrue(regex.matches("chabcadsfkadsfat"));
        assertTrue(regex.matches("cat"));
        assertTrue(regex.matches("at"));
        assertFalse(regex.matches("chats"));
    }
}