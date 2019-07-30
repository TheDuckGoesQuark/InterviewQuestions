package test.longestfilepath;

import main.longestfilepath.LongestFilePath;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestFilePathTest {

    @Test
    public void nullTest() {
        LongestFilePath lfp = new LongestFilePath(null);
        assertEquals(0, lfp.findLongestFilePathLength());
    }

    @Test
    public void emptyTest() {
        LongestFilePath lfp = new LongestFilePath("");
        assertEquals(0, lfp.findLongestFilePathLength());
    }

    @Test
    public void blankTest() {
        LongestFilePath lfp = new LongestFilePath("  ");
        assertEquals(0, lfp.findLongestFilePathLength());
    }

    @Test
    public void singleDirTest() {
        LongestFilePath lfp = new LongestFilePath("dir");
        assertEquals(4, lfp.findLongestFilePathLength());
    }

    @Test
    public void singleFileTest() {
        LongestFilePath lfp = new LongestFilePath("file.txt");
        assertEquals(9, lfp.findLongestFilePathLength());
    }

    @Test
    public void dirsOnlyAtRootSecondLongestTest() {
        LongestFilePath lfp = new LongestFilePath("dir1\notherdir");
        assertEquals(9, lfp.findLongestFilePathLength());
    }

    @Test
    public void dirsOnlyAtRootFirstLongestTest() {
        LongestFilePath lfp = new LongestFilePath("longerdir\ndir");
        assertEquals(10, lfp.findLongestFilePathLength());
    }

    @Test
    public void filesOnlyAtRootSecondLongestTest() {
        LongestFilePath lfp = new LongestFilePath("file.txt\nlongerfile.txt");
        assertEquals(15, lfp.findLongestFilePathLength());
    }

    @Test
    public void filesOnlyAtRootFirstLongestTest() {
        LongestFilePath lfp = new LongestFilePath("longerfile.txt\nfile.txt");
        assertEquals(15, lfp.findLongestFilePathLength());
    }

    @Test
    public void dirWithFileTest() {
        LongestFilePath lfp = new LongestFilePath("dir\n\tfile.txt");
        assertEquals(13, lfp.findLongestFilePathLength());
    }

    @Test
    public void dirWithTwoFilesFirstLongerTest() {
        LongestFilePath lfp = new LongestFilePath("dir\n\tfilelong.txt\n\tfile.txt");
        assertEquals(17, lfp.findLongestFilePathLength());
    }

    @Test
    public void dirWithTwoFilesSecondLongerTest() {
        LongestFilePath lfp = new LongestFilePath("dir\n\tfile.txt\n\tfilelong.txt");
        assertEquals(17, lfp.findLongestFilePathLength());
    }

    @Test
    public void dirWithSubDirTest() {
        LongestFilePath lfp = new LongestFilePath("dir\n\tfile.txt\n\tlongsubdir1");
        assertEquals(16, lfp.findLongestFilePathLength());
    }

    @Test
    public void dirWithSubDirWithFileTest() {
        LongestFilePath lfp = new LongestFilePath("dir\n\tfile.txt\n\tsubdir1\n\t\totherfile.txt");
        assertEquals(26, lfp.findLongestFilePathLength());
    }
}