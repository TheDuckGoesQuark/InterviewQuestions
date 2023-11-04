package interview.OneAway;

/**
 *
 */
public class OneAway {

    public static boolean isOneEditAway(String inputA, String inputB) {
        // three types of edits: insert, remove, or replace a character

        // first, rule out options
        if (inputA.length() == inputB.length()) { // replace is only option if lengths are equal
            return isOneReplaceDifferent(inputA, inputB);
        } else if (inputA.length() == (inputB.length() - 1)) { // insert is only option if a is one bigger than b
            // but removing from one is the same as inserting in the other, so we can reuse this function
            // but flip the parameters
            return isOneRemovalDifferent(inputB, inputA);
        } else if (inputA.length() == (inputB.length() + 1)) { // remove is only option if a is one smaller than b
            return isOneRemovalDifferent(inputA, inputB);
        }

        // otherwise, more edits are necessary
        return false;
    }

    private static boolean isOneRemovalDifferent(String inputA, String inputB) {
        // inputA is 1 character longer than inputB
        // so if we hit different character, *remove it*, check rest of string matches
        // if not, then more edits are necessary
        var removalPerformed = false;
        for (int i = 0; i < inputA.length(); i++) {
            var a = inputA.charAt(i);

            var j = removalPerformed ? i - 1 : i;
            if (j == inputB.length()) {
                // we need one more removal to get rid of extra character in inputA
                // so if removal was already performed, then that's two edits, e.g. false
                return !removalPerformed;
            }

            var b = inputB.charAt(j);
            if (a != b) {
                // early exit if one removal wasn't enough
                if (removalPerformed) return false;
                removalPerformed = true;
            }
        }

        return removalPerformed;
    }

    private static boolean isOneReplaceDifferent(String inputA, String inputB) {
        var differenceCount = 0;
        for (int i = 0; i < inputA.length(); i++) {
            var a = inputA.charAt(i);
            var b = inputB.charAt(i);
            if (a != b) {
                // early exit if there are multiple characters needing replaced
                if (differenceCount == 1) return false;
                differenceCount++;
            }
        }

        // looking for exactly one replace
        return differenceCount == 1;
    }
}
