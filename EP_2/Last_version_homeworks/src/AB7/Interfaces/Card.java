/* DO NOT EDIT */
package AB7.Interfaces;

/**
 * Represents a playing card in a standard deck.
 * A card consists of a suit and a value. The suit can be hearts, diamonds, clubs, or spades, and the value
 * can range from the numbers two through ten, to face cards (jack, queen, king) and ace.
 * It also includes functionality to calculate the score based on the card's value.
 */
public interface Card {
    /**
     * Enum representing the four suits in a standard deck of playing cards.
     */
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES;
    }

    /**
     * Enum representing the possible values of playing cards in a standard deck.
     * <p>
     * Each value corresponds to a card rank, ranging from number cards (2-10) to
     * face cards (Jack, Queen, King) and the Ace. These values are used to determine
     * the card's rank and associated score in card games.
     * </p>
     */
    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    }

    /**
     * Retrieves the suit of the card.
     *
     * @return the suit of the card, which is one of the four suits in a standard deck of
     * playing cards: HEARTS, DIAMONDS, CLUBS, or SPADES.
     */
    Suit getSuit();

    /**
     * Retrieves the value of the card.
     *
     * @return the value of the card, which represents its rank in a standard deck of playing cards.
     * This includes number values (TWO through TEN), face cards (JACK, QUEEN, KING), and ACE.
     */
    Value getValue();

    /**
     * Calculates the score associated with the card based on its value.
     *
     * @return the score of the card based on its value.
     */
    int getScore();

}
