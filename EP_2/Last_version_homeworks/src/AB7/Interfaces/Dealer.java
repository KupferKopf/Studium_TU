/* DO NOT EDIT */
package AB7.Interfaces;

import AB7.BadDeckException;

/**
 * Represents a dealer in a card game. The dealer is responsible for managing the deck,
 * dealing cards to players, and performing related operations such as shuffling. A dealer may
 * also implement a play action, if required by the underlying card game.
 */
public interface Dealer {
    /**
     * Deals a card from the deck. If the deck is out of cards, it reshuffles and tries again.
     * If no card can be dealt even after reshuffling, a BadDeckException is thrown.
     *
     * @return the next card from the deck
     * @throws BadDeckException if the deck cannot provide any card even after reshuffling
     */
    Card dealCard() throws BadDeckException;

    /**
     * Shuffles the deck of cards managed by the dealer.
     */
    void shuffleDeck();

    /**
     * Performs a play action for the dealer and evaluates the outcome (score).
     *
     * @param dealerHand the hand of cards the dealer was assigned for play or {@code null} if the dealer does not require a hand.
     * @return an integer value representing the resulting score of the dealers play action.
     */
    int playAction(Hand dealerHand);
}
