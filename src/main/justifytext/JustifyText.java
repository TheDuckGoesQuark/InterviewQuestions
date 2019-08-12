package main.justifytext;

import java.util.LinkedList;
import java.util.List;

/**
 * Write an algorithm to justify text.
 * Given a sequence of words and an integer line length k,
 * return a list of strings which represents each line, fully justified.
 * <p>
 * More specifically, you should have as many words as possible in each line.
 * There should be at least one space between each word.
 * Pad extra spaces when necessary so that each line has exactly length k.
 * Spaces should be distributed as equally as possible,
 * with the extra spaces, if any, distributed starting from the left.
 * <p>
 * If you can only fit one word on a line,
 * then you should pad the right-hand side with spaces.
 * <p>
 * Each word is guaranteed not to be longer than k.
 * <p>
 * For example, given the list of words
 * ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
 * and k = 16, you should return the following:
 * <p>
 * ["the  quick brown", # 1 extra space on the left
 * "fox  jumps  over", # 2 extra spaces distributed evenly
 * "the   lazy   dog"] # 4 extra spaces distributed evenly
 */
public class JustifyText {

    public static List<String> justifyText(List<String> words, int lineLength) {
        List<String> lines = new LinkedList<>();

        int indexOfStartOfLine = 0;
        int currentLengthCharacters = 0;
        int numWords = 0;

        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);

            if ((currentLengthCharacters + numWords + currentWord.length()) > lineLength) {
                // split previous line
                addNewJustifiedLine(lines, words, indexOfStartOfLine, numWords, currentLengthCharacters, lineLength);

                // start new line
                currentLengthCharacters = 0;
                numWords = 0;
                indexOfStartOfLine = i;
            }

            // append this to line
            currentLengthCharacters += currentWord.length();
            numWords++;
        }

        if (numWords > 0)
            addNewJustifiedLine(lines, words, indexOfStartOfLine, numWords, currentLengthCharacters, lineLength);

        return lines;
    }

    private static void addNewJustifiedLine(List<String> lines, List<String> words, int startOfLine, int numWords, int currentLength, int lineLength) {
        int insideSpaces = numWords - 1;
        int charactersRemaining = lineLength - currentLength;
        int numSpaces = charactersRemaining / insideSpaces;
        int leftOver = charactersRemaining % insideSpaces;
        int lastWord = startOfLine + numWords - 1;

        final StringBuilder sb = new StringBuilder();

        for (int i = startOfLine; i < lastWord; i++) {
            sb.append(words.get(i));
            sb.append(" ".repeat(numSpaces));

            // Distribute remaining spaces, from left to right
            if (leftOver > 0) {
                sb.append(" ");
                leftOver--;
            }
        }

        sb.append(words.get(lastWord));

        lines.add(sb.toString());
    }

}
