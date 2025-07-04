package AB7;

import AB7.Interfaces.Card;
import AB7.Interfaces.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Class represents a full deck of 52 playing cards for the game of Blackjack.
 *
 * <p>A deck consists of 52 cards, which belong to one of 4 suits (hearts, diamonds, clubs and spades), each containing
 * 13 cards of distinct value. The card values include the numbers 2 to 10, as much as jack, queen, king and an ace.
 * A card's score is determined by its value. It is equivalent to its number if it is a number card, it is 10 (if the
 * card is a jack, a queen, or a king), and 1 or 11 if the card is an ace.</p>
 *
 * <p>A deck in addition keeps track of which cards have been drawn/used already. This information is reset if the deck
 * is shuffled.</p>
 */
public class BJDeck implements Deck {
    private ArrayList<Card> cards = null;


    /**
     * Creates the deck of 52 cards for a game of Blackjack.
     */
    public BJDeck() {
        cards = new ArrayList<>();
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Value v : Card.Value.values()) {
                cards.add(new BJCard(s,v));
            }
        }
        Collections.shuffle(cards);
    }

    /**
     * Draws the next card from the deck, that has not been drawn so far.
     * Hence, this method digs through the deck from the first card down to the last.
     *
     * @return the next undrawn card in the deck if available
     * @throws OutOfCardsException if all cards have been drawn from the deck
     */
    @Override
    public Card drawCard() throws OutOfCardsException {
        try {
            return cards.removeLast();
        }catch (NoSuchElementException nse){
            throw new OutOfCardsException("Da sand keine Karten mehr du Blindfisch");
        }
    }

    /**
     * Shuffles the current deck of cards (randomizing the order of the cards).
     *
     * <p>In addition, the deck is reset, so all cards are considered as not drawn so far and {@code drawCard()}
     * will start at the first/top card.</p>
     */
    @Override
    public void shuffle() {
        cards = new BJDeck().cards;
    }

}
