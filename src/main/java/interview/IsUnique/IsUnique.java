package interview.IsUnique;

/**
 *
 */
public class IsUnique {
    public static boolean isUnique(String str) {
        // ASSUMING character only contains english alphabet strings
        var checker = 0;
        for (var ch : str.toCharArray()) {
            var index = ch - 'a';
            var bitFlag = (1 << index);
            // if bit is already flagged, non unique value
            if ((checker & bitFlag) > 0) return false;
            // set flag in checker
            checker |= bitFlag;
        }
        return true;
    }
}
