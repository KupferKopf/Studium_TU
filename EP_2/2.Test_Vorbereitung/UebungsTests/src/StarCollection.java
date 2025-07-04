/**
 * A collection of {@code Star} objects. The elements have no specified order.
 * Please, do not change this interface definition!
 */
public interface StarCollection extends StarIterable {

    /**
     * Returns {@code true} if this collection contains an element equal to the specified object
     * {@code s} and {@code false} otherwise.
     *
     * @param s the star to check for containment, {@code s != null}.
     * @return true if {@code this} has an element equal to {@code s}, false otherwise.
     */
    boolean contains(Star s);
}
