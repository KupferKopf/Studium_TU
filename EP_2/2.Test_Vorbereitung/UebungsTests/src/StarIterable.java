/**
 * An object with a method that returns a {@link StarIterator}.
 * Please, do not change this interface definition!
 */
public interface StarIterable extends Iterable<Star> {

    /**
     * Returns an iterator over {@link Star} elements.
     *
     * @return an iterator over {@link Star} elements.
     */
    StarIterator iterator();
}
