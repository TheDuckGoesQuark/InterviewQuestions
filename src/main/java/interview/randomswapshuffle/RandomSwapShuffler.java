package interview.randomswapshuffle;

public class RandomSwapShuffler {

    private int random(int k) {
        return (int) Math.floor(Math.random() * k);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.
     * It should run in O(N) time.
     * Hint: Make sure each one of the 52! permutations of the deck is equally likely.
     *
     * Fisher-Yates Shuffling
     *
     * @param arr array to sort
     */
    public <T> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            var j = random(i + 1);
            swap(arr, i, j);
        }
    }
}
