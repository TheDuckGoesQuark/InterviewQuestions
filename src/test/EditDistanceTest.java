package test;

import main.editdistance.EditDistance;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    @Test
    public void getEditDistance() {
        assertEquals(3, EditDistance.getEditDistance("kitten", "sitting"));
        assertEquals(1, EditDistance.getEditDistance("abcde", "abde"));
        assertEquals(1, EditDistance.getEditDistance("car", "far"));
        assertEquals(1, EditDistance.getEditDistance("islander", "slander"));
        assertEquals(5, EditDistance.getEditDistance("mart", "karma"));
        assertEquals(8, EditDistance.getEditDistance("intention", "execution"));
    }
}