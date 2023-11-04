package interview.StringCompression;

/**
 *
 */
public class StringCompression {

    public static String compress(String input) {
        // there's no way to compress two characters better
        if (input.length() <= 2) return input;

        var sb = new StringBuilder();
        var repeatedChar = input.charAt(0);
        var repeatedCharCount = 1;
        var index = 1;
        while (index < input.length()) {
            var c = input.charAt(index);
            if (c == repeatedChar) repeatedCharCount++;
            else {
                sb.append(repeatedChar);
                sb.append(repeatedCharCount);
                repeatedChar = c;
                repeatedCharCount = 1;
            }
            index++;
        }

        sb.append(repeatedChar);
        sb.append(repeatedCharCount);

        if (sb.length() >= input.length()) return input;
        else return sb.toString();
    }
}
