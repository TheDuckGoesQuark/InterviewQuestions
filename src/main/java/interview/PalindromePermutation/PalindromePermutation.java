package interview.PalindromePermutation;

/**
 *
 */
public class PalindromePermutation {
    public static boolean isPermutationOfPalindrome(String str) {
        // palindrome requires each letter to appear an even number of times in even length string
        // and each letter EXCEPT ONE to appear an even number of times in odd length string.

        // for even length, we can use bit vector to check each character appears an even number of times
        // for odd length, we can do the same, but check at least there is only one bit flag with value 1
        // i.e. is value of bit vector a power of 2

        var emptySpaceCount = 0;

        var checker = 0;
        for (var c : str.toCharArray()) {
            if (c == ' ') {
                emptySpaceCount++;
                continue;
            }
            // get index of character in alphabet in range 0 - 26
            var normalizedCharValue = c - 'a';
            // convert to bit mask by shifting 1 left by the index in alphabet
            var bitMask = 1 << normalizedCharValue;
            // XOR with checker. If a character appears an even number of times, then it cancels out again to 0.
            checker ^= bitMask;
        }

        if ((str.length() - emptySpaceCount) % 2 == 0) {
            return checker == 0;
        } else {
            return (checker & (checker - 1)) == 0;
        }
    }
}
