/**
 * A mobile is a hanging room decoration consisting of sticks on whose left and right ends
 * further mobiles are attached (recursive structure). The actual decorations (e.g. stars) are
 * the leaf nodes. The numbers shown below correspond to the weights of
 * sticks respectively stars.
 *
 *          |
 *      +---2---+
 *      |       |
 *   +--2--+    *
 *   |     |    16
 *   *  +--1--+
 *   7  |     |
 *      *     *
 *      3     3
 *
 * Readable representation as string: ((*7)-2-((*3)-1-(*3)))-2-(*16)
 *
 * Each mobile must be balanced, this is, left and right part on a stick weigh the same.
 * Please, do not change this interface definition!
 */
public interface Mobile extends StarIterable {

    /**
     * Returns the total weight of this mobile, which is the sum of all the
     * weights of sticks and decorations (stars).
     *
     * @return the total weight of this mobile.
     */
    int getWeight();

    /**
     * Returns a readable representation of the mobile, showing its complete
     * structure with all weights using an expression with parentheses.
     * Example (compare with the graphical representation above):
     * ((*7)-2-((*3)-1-(*3)))-2-(*16)
     *
     * @return a readable representation of the mobile.
     */
    String toString();

    /**
     * Returns {@code true} if {@code this} and {@code obj} are equal.
     *
     * @param o the object to be compared with.
     * @return {@code true} if {@code this} and {@code obj}, {@code false} otherwise.
     */
    boolean equals(Object o);

    /**
     * Returns the hash code of {@code this}.
     *
     * @return the hash code of {@code this}.
     */
    int hashCode();

    /**
     * Returns an iterator over all {@link Star} objects in this mobile. The order of iteration
     * is not specified.
     *
     * @return an iterator over all {@link Star} objects in this mobile.
     */
    StarIterator iterator();

    /**
     * Returns a {@link StarCollection} view of {@code this}, containing all stars of this mobile.
     * Later changes in {@code this} will be reflected in the returned view.
     *
     * @return a {@link StarCollection} view of {@code this}.
     */
    StarCollection getStarCollection();
}

