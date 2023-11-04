package interview.URLify;

/**
 *
 */
public class URLify {

    /**
     * URL encodes the given input string, up to the input true string size.
     * It's assumed that the size of the input char array is enough to url encode the input true string size
     *
     * @param input               input char array, to be edited in place
     * @param inputTrueStringSize the length of the string in the input char array to be urlified
     * @return the string representation of the urlified char array
     */
    public static String urlify(char[] input, int inputTrueStringSize) {
        var offset = 1;
        for (int i = 0; i < inputTrueStringSize; i++) {
            // point to end of buffer
            var endOfBufferIndex = input.length - i - offset;
            // point to current character in string
            var endOfStringIndex = inputTrueStringSize - i - 1;

            var currentCharacter = input[endOfStringIndex];
            // regular characters can just be copied over
            if (currentCharacter != ' ') {
                input[endOfBufferIndex] = currentCharacter;
                continue;
            }

            input[endOfBufferIndex] = '0';
            input[endOfBufferIndex - 1] = '2';
            input[endOfBufferIndex - 2] = '%';
            offset += 2;
        }
        return new String(input);
    }
}
