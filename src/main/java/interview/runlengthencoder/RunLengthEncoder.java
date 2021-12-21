package interview.runlengthencoder;

/**
 * Run-length encoding is a fast and simple method of encoding strings.
 * The basic idea is to represent repeated successive characters as a single count and character.
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * <p>
 * Implement run-length encoding and decoding.
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
 * You can assume the string to be decoded is valid.
 */
public class RunLengthEncoder {

    public static String decode(String str) {
        final StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            int startingIndex = i;
            while (Character.isDigit(str.charAt(i))) i++;

            int numRepeats = Integer.parseInt(str.substring(startingIndex, i));
            char repeatingChar = str.charAt(i);

            for (int j = 0; j < numRepeats; j++) {
                sb.append(repeatingChar);
            }

            i++;
        }

        return sb.toString();
    }

    public static String encode(String str) {
        final StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            int startingIndex = i;
            char current = str.charAt(startingIndex);

            while (i < str.length() && str.charAt(i) == current) i++;

            int numRepeats = i - startingIndex;

            sb.append(numRepeats);
            sb.append(current);
        }

        return sb.toString();
    }

}
