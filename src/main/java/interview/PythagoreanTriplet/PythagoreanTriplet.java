package interview.PythagoreanTriplet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array of integers, determine whether it contains a Pythagorean triplet.
 * Recall that a Pythagorean triplet (a, b, c) is defined by the equation a2+ b2= c2.
 */
public class PythagoreanTriplet {
    public static boolean containsPythagoreanTriplet(int[] arr) {
        if (arr.length < 3) return false;

        // O(n)
        var set = new HashSet<Integer>();
        for (int i : arr) {
            set.add(i * i);
        }

        // sort so we can guarantee all numbers to the right are greater
        // O(n * logn)
        Arrays.sort(arr);

        // O((n-1 + n-2 + n-3 + n-4... 1)) = O((n/2) * (n-1))
        for (int i = 0; i < arr.length; i++) {
            var a = arr[i];
            // only need to sum with larger numbers, as we've already summed with lower numbers
            for (int j = i + 1; j < arr.length; j++) {
                var b = arr[j];
                var a2 = a * a;
                var b2 = b * b;
                if (set.contains(a2 + b2)) return true;
            }
        }

        return false;
    }
}
