package AB7;

/**
 * Exception indicating that an illegal or inappropriate operation has been attempted.
 *
 * <p>This exception is typically used in scenarios where the attempted operation is not
 * valid or violates the rules or state constraints of the current context or system.</p>
 *
 *  @see RuntimeException
 */
public class IllegalOperationException extends RuntimeException {

    /**
     * Constructs a new IllegalOperationException with the specified detail message.
     *
     * @param message the detail message that explains the reason for the exception
     */
    public IllegalOperationException(String message) {
        super("| " + message + " |");
    }
}
