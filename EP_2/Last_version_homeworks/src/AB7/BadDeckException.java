package AB7;

/**
 * Exception indicating that the deck used in a card game is considered incorrect or unusable.
 *
 * <p>This exception is typically thrown in scenarios where the deck cannot provide a card to draw as expected.</p>
 *
 * @see RuntimeException
 */
public class BadDeckException extends RuntimeException {


    /**
     * Constructs a new BadDeckException with the specified detail message and cause.
     *
     * @param message the detail message, which provides additional information about the exception
     * @param cause   the cause of the exception, which can be used to retrieve the underlying issue
     */
    public BadDeckException(String message, Throwable cause) {
        super("| " + cause.toString() + " | " + message + " |");
    }
}
