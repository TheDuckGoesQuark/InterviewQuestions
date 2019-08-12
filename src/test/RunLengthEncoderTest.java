package test;

import main.runlengthencoder.RunLengthEncoder;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunLengthEncoderTest {

    @Test
    public void encodeTest() {
        assertEquals("", RunLengthEncoder.encode(""));
        assertEquals("1A", RunLengthEncoder.encode("A"));
        assertEquals("1A1B", RunLengthEncoder.encode("AB"));
        assertEquals("4A", RunLengthEncoder.encode("AAAA"));
        assertEquals("4A3B2C1D2A", RunLengthEncoder.encode("AAAABBBCCDAA"));
    }

    @Test
    public void decodeTest() {
        assertEquals("", RunLengthEncoder.decode(""));
        assertEquals("A", RunLengthEncoder.decode("1A"));
        assertEquals("AB", RunLengthEncoder.decode("1A1B"));
        assertEquals("AAAA", RunLengthEncoder.decode("4A"));
        assertEquals("AAAABBBCCDAA", RunLengthEncoder.decode("4A3B2C1D2A"));
    }

}