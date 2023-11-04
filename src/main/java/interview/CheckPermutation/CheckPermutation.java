package interview.CheckPermutation;

import java.util.Arrays;

/**
 *
 */
public class CheckPermutation {
    public static boolean isPermutation(String a, String b) {
        // sort both strings
        // for length of a, compare a[i] and b[i] for equality
        if (a.length() != b.length()) return false;

        var aSorted = a.toCharArray();
        Arrays.sort(aSorted);
        var bSorted = b.toCharArray();
        Arrays.sort(bSorted);

        for (int i = 0; i < aSorted.length; i++) {
            if (aSorted[i] != bSorted[i]) return false;
        }

        return true;
    }
}
