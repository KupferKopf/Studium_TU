/* DO NOT EDIT */
package AB7.Interfaces;

import AB7.OutOfCardsException;

/**
 * Represents a deck of cards used in card games, consisting of a collection of cards
 * with functionality to shuffle the deck and draw cards from it.
 */
public interface Deck {
    /**
     * Draws the next card from the deck, which has not been drawn so far.
     * Hence, this method digs through the deck from the first card down to the last.
     *
     * @return the next undrawn card in the deck if available
     * @throws OutOfCardsException if all cards have been drawn from the deck
     */
    Card drawCard() throws OutOfCardsException;

    /**
     * Shuffles the current deck of cards (randomizing the order of all 52 cards).
     * <p>In addition, the deck is reset, so all cards are considered as not drawn so far and {@code drawCard()}
     * will restart at the first/top card.</p>
     */
    void shuffle();
}
