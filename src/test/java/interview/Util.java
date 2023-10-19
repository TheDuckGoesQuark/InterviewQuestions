package interview;

import java.util.Arrays;

public class Util {
    public static <T> String twoDimensionalArrayToString(T[][] arr) {
        var sb = new StringBuilder();
        for (T[] row : arr) {
            sb.append(Arrays.toString(row));
            sb.append(",\n");
        }
        return sb.toString();
    }

    public static String twoDimensionalArrayToString(int[][] arr) {
        var sb = new StringBuilder();
        for (var row : arr) {
            sb.append(Arrays.toString(row));
            sb.append(",\n");
        }
        return sb.toString();
    }
}
