package AB7;

import AB7.Interfaces.Card;

/**
 * Represents a playing card for the Blackjack game.
 * A card consists of a suit and a value. The suit can be hearts, diamonds, clubs, or spades, and the value
 * can range from the numbers two through ten, to face cards (jack, queen, king) and ace.
 * It also includes functionality to calculate the score based on the card's value.
 */
public class BJCard implements Card {
    Suit suit;
    Value value;
    int score;

    /**
     * Constructs a new BJCard object representing a playing card in the game of Blackjack.
     *
     * @param suit  the suit of the card, such as HEARTS, DIAMONDS, CLUBS, or SPADES
     * @param value the value of the card, such as TWO, THREE, TEN, JACK, QUEEN, KING, or ACE
     */
    public BJCard(Suit suit, Value value) {

        if (suit == null) throw new IllegalOperationException("Suit darf ned null sein");
        if (value == null) throw new IllegalOperationException("Value darf ned null sein");

        this.suit = suit;
        this.value = value;
        this.score = getScore();

    }

    /**
     * Retrieves the suit of the card.
     *
     * @return the suit of the card, which is one of the four suits in a standard deck of
     * playing cards: HEARTS, DIAMONDS, CLUBS, or SPADES.
     */
    @Override
    public Suit getSuit() {
        return suit;
    }

    /**
     * Retrieves the value of the card.
     *
     * @return the value of the card, which represents its rank in a standard deck of playing cards.
     * This includes number values (TWO through TEN), face cards (JACK, QUEEN, KING), and ACE.
     */
    @Override
    public Value getValue() {
        return value;
    }

    /**
     * Calculates the score associated with the card based on its value.
     * For number cards (2-10), the score matches the card value.
     * For face cards (jack, queen, king), the score is 10.
     * For an ace, the score is 11.
     *
     * @return the score value of the card based on its value.
     */
    @Override
    public int getScore() {
        if (score != 0) return score;
        return switch (value) {
            case ACE -> 11;
            case KING, JACK, QUEEN, TEN -> 10;
            case NINE -> 9;
            case EIGHT -> 8;
            case SEVEN -> 7;
            case SIX -> 6;
            case FIVE -> 5;
            case FOUR -> 4;
            case THREE -> 3;
            case TWO -> 2;
        };
    }

    /**
     * Returns a string representation of the card, combining its value and suit.
     *
     * <p>The string's format and content can be freely chosen, but should at least contain information on suit and value.</p>
     *
     * @return a string containing the card's value and suit.
     */
    @Override
    public String toString() {
        return value + " of " + suit;
    }

    /**
     * Compares this card to the specified object for equality. Two cards are considered equal
     * if they have the same suit and value.
     *
     * @param obj the object to be compared with this card for equality
     * @return true if the specified object is equal to this card; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == BJCard.class) {
            if (value.equals(((BJCard) obj).value) && suit.equals(((BJCard) obj).suit)) return true;
        }
        return false;
    }

}
