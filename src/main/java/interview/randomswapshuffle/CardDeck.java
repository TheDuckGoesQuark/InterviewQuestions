package interview.randomswapshuffle;

import java.util.Arrays;

public class CardDeck {
    private static final int DECK_SIZE = 52;
    private static final int SUIT_SIZE = 13;
    private static final String[] SUITS = new String[]{"H", "C", "D", "S"};

    public String[] cards;

    public CardDeck() {
        cards = new String[DECK_SIZE];

        for (int i = 0; i < SUIT_SIZE; i++) {
            var value = getCardValueChar(i);

            for (int j = 0; j < SUITS.length; j++) {
                var suit = SUITS[j];
                var index = i + (j * SUIT_SIZE);
                cards[index] = String.format("%s%s", suit, value);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.cards);
    }

    private static String getCardValueChar(int index) {
        return switch (index + 1) {
            case 1 -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> Integer.toString(index + 1);
        };
    }
}
