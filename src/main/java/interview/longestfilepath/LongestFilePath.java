package interview.longestfilepath;

import java.util.Stack;

/**
 * Suppose we represent our file system by a string in the following manner:
 * <p>
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * <p>
 * dir
 * subdir1
 * subdir2
 * file.ext
 * <p>
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 * <p>
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * <p>
 * dir
 * subdir1
 * subsubdir1
 * file1.ext
 * subdir2
 * subsubdir2
 * file2.ext
 * <p>
 * The directory dir contains two sub-directories subdir1 and subdir2.
 * subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
 * subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 * <p>
 * We are interested in finding the longest (number of characters) absolute path to
 * a file within our file system.
 * For example, in the second example above, the longest absolute path is
 * "dir/subdir2/subsubdir2/file2.ext",
 * and its length is 32 (not including the double quotes).
 * <p>
 * Given a string representing the file system in the above format,
 * return the length of the longest absolute path to a file in the abstracted file system.
 * If there is no file in the system, return 0.
 * <p>
 * Note:
 * <p>
 * The name of a file contains at least a period and an extension.
 * The name of a directory or sub-directory will not contain a period.
 */
public class LongestFilePath {

    private static final char NEWLINE = '\n';
    private static final char TAB = '\t';
    private static final char DOT = '.';

    private class TraversalState {
        private Stack<Integer> fileLengthsInCurrentPath = new Stack<>();
        private int currentIndex;
        private int currentLongest;

        public TraversalState() {
            this.currentIndex = 0;
            this.currentLongest = 0;
        }

        public void incrementCurrentIndex() {
            currentIndex++;
        }

        public void pushDirectoryNameLength(int dirNameLength) {
            fileLengthsInCurrentPath.push(dirNameLength);

            // Update current longest if exceeded
            int currentLength = fileLengthsInCurrentPath.size() + fileLengthsInCurrentPath.stream().mapToInt(i -> i).sum();
            if (currentLength > this.currentLongest) this.currentLongest = currentLength;
        }

        public void recordFilenameLength(int filenameLength) {
            // Update current longest if exceeded
            int currentLength = fileLengthsInCurrentPath.size() + 1 + fileLengthsInCurrentPath.stream().mapToInt(i -> i).sum() + filenameLength;
            if (currentLength > this.currentLongest) this.currentLongest = currentLength;
        }

        public void popNDirectories(int nPops) {
            for (int i = 0; i < nPops; i++) {
                fileLengthsInCurrentPath.pop();
            }
        }

        public int getDirectoryDepth() {
            return fileLengthsInCurrentPath.size();
        }
    }

    private String fileSystemString;

    public LongestFilePath(String fileSystemString) {
        this.fileSystemString = fileSystemString;
    }

    public int findLongestFilePathLength() {
        if (fileSystemString == null || fileSystemString.isEmpty() || fileSystemString.isBlank()) {
            return 0;
        }

        final TraversalState traversalState = new TraversalState();

        traverseTree(traversalState);

        return traversalState.currentLongest;
    }

    private void traverseTree(TraversalState traversalState) {
        int startIndex = traversalState.currentIndex;

        char currentChar;
        boolean stillCountingDirectory;
        boolean newline = false;
        do {
            if (newline) {
                traverseTabs(traversalState);
                newline = false;
                startIndex = traversalState.currentIndex;
            }

            currentChar = fileSystemString.charAt(traversalState.currentIndex);

            if (currentChar == DOT) {
                traverseFilename(startIndex, traversalState);
                traversalState.incrementCurrentIndex();
                newline = true;
                stillCountingDirectory = false;
            } else if (currentChar == NEWLINE) {
                traversalState.pushDirectoryNameLength((traversalState.currentIndex - (startIndex)));
                traversalState.incrementCurrentIndex();
                stillCountingDirectory = false;
                newline = true;
            } else {
                traversalState.incrementCurrentIndex();
                stillCountingDirectory = true;
            }

        } while (traversalState.currentIndex < fileSystemString.length());

        if (stillCountingDirectory)
            traversalState.pushDirectoryNameLength((traversalState.currentIndex - (startIndex)));

    }

    /**
     * Iterates over tab characters until the first alphabetical character appears.
     * Once it does, directories will be popped from the stack according to the difference
     * between previous tab depth and new
     *
     * @param traversalState  current state of the tree traversal
     */
    private void traverseTabs(TraversalState traversalState) {
        int stackedDirs = traversalState.getDirectoryDepth();
        int countedTabs = 0;

        char currentChar;
        do {
            currentChar = fileSystemString.charAt(traversalState.currentIndex);

            if (currentChar == TAB) {
                countedTabs++;
            } else {
                break;
            }

            traversalState.incrementCurrentIndex();
        } while (traversalState.currentIndex < fileSystemString.length());

        traversalState.popNDirectories(stackedDirs - countedTabs);
    }

    /**
     * Iterates over filename until newline or EOF,
     * Then checks if new maximum has been reached once either of these conditions are reached
     *
     * @param startIndex     index filename starts from
     * @param traversalState current state
     */
    private void traverseFilename(int startIndex, TraversalState traversalState) {
        char currentChar;
        do {
            currentChar = fileSystemString.charAt(traversalState.currentIndex);
            if (currentChar == NEWLINE) {
                // end of filename, record path length
                traversalState.recordFilenameLength(traversalState.currentIndex - startIndex);
                break;
            }

            traversalState.incrementCurrentIndex();
        } while (traversalState.currentIndex < fileSystemString.length());

        // Record length of last file before leaving
        if (traversalState.currentIndex == fileSystemString.length())
            traversalState.recordFilenameLength(traversalState.currentIndex - startIndex);
    }
}
