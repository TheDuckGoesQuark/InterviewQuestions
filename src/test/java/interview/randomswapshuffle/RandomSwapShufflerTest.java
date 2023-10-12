package interview.randomswapshuffle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RandomSwapShufflerTest {

    @Test
    void cardDeckInit() {
        var cardDeck = new CardDeck();
        var expected = new String[]{"HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK", "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK", "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK", "SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK"};
        assertArrayEquals(expected, cardDeck.cards, "Card deck is correctly initialised");
    }

    @Test
    void shuffle() {
        var cardDeck = new CardDeck();
        var shuffler = new RandomSwapShuffler();
        shuffler.shuffle(cardDeck.cards);
        System.out.println(Arrays.toString(cardDeck.cards));
    }
}