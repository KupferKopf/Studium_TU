/* DO NOT EDIT */
package AB7.Interfaces;

import AB7.IllegalOperationException;

/**
 * Represents a generic hand of cards in a card game.
 *
 * <p>This interface provides functionality to manage the cards in a hand, calculate the hand's
 * total score, and modify the hand by adding cards.</p>
 */
public interface Hand extends Cloneable {
    /**
     * Adds a card to the current hand in a card game and returns the hand's new total score.
     *
     * <p>If the hand is in a game specific "locked" state, an attempt to add a card
     * will throw an IllegalOperationException as the hand cannot be modified.</p>
     *
     * @param card the card to be added to the hand. Must not be {@code null}.
     * @return the updated total score of the hand after adding the card.
     * @throws IllegalOperationException if the hand is in a locked state, and a card is added.
     */
    int addCard(Card card) throws IllegalOperationException;

    /**
     * Calculates and retrieves the total score of the current hand in a card game.
     *
     * <p>The method determines the total score based on the game's rules.</p>
     *
     * @return the total score of the current hand.
     */
    int getScore();

    /**
     * Removes all cards from the current hand, effectively resetting it to an empty state.
     *
     * <p>This method is used to clear the hand of all cards, which may be necessary
     * when resetting the game, starting a new round, or when the hand needs to be emptied for other reasons.</p>
     */
    void clear();

    /**
     * Creates and returns a deep copy of this hand.
     * Each card in the hand is also cloned to ensure a completely independent copy.
     *
     * @return a deep copy of this hand or null if the clone operation fails.
     */
    Hand clone();
}
