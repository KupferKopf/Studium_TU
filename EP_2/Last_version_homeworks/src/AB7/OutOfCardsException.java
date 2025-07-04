package AB7;

/**
 * Exception indicating that an attempt is made to draw a card from a deck that is out of cards.
 *
 * <p>This exception is typically used in the context of card game implementations where a deck
 * is depleted of all available cards, for instance, during gameplay in a Blackjack application.
 *
 * @see RuntimeException
 */
public class OutOfCardsException extends Exception {

    /**
     * Constructs a new OutOfCardsException with the specified detail message.
     * This exception is thrown to indicate that an attempt has been made to draw a card
     * from a deck that has no cards remaining.
     *
     * @param message the detail message, which provides further information about the exception
     */
    public OutOfCardsException(String message) {
        super("| " + message + " |");
    }
}
