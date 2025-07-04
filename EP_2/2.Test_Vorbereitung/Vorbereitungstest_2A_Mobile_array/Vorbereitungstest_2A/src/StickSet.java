/**
 * A set of {@code Stick} elements.
 * Please, do not change this interface definition!
 */
public interface StickSet {

    /**
     * Returns the number of elements in 'this'.
     *
     * @return the number of elements in 'this'.
     */
    int size();

    /**
     * Returns {@code true} if this set contains an element equal to the specified object
     * {@code element}, or {@code false} otherwise.
     *
     * @param element the stick to check for containment, {@code element != null}.
     * @return {@code true} if this set contains an element equal to {@code element},
     *      {@code false} otherwise.
     */
    boolean contains(Stick element);
}
