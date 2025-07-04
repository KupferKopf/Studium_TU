/**
 * A mobile is a hanging room decoration consisting of sticks with a specified stick weight on which
 * further mobiles are attached (recursive structure). The actual decorations (e.g. stars with
 * a specified weight) are the leaf nodes.
 *
 * Example:
 *                     |
 *              +------5---+----+
 *              |          |    |
 *        +-----2--+--+    *    *
 *        |        |  |    12   5
 *        |        |  *
 *        *        |  2
 *        7        |
 *              +--1--+
 *              |     |
 *              *     *
 *              3     3
 *
 * Readable representation as string: 5[2[*7, 1[*3, *3], *2], *12, *5]
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
     * 5[2[*7, 1[*3, *3], *2], *12, *5]
     *
     * @return a readable representation of the mobile.
     */
    String toString();

    /**
     * Returns {@code true} if {@code this} and {@code obj} are equal.
     *
     * @param obj the object to be compared with.
     * @return {@code true} if {@code this} and {@code obj} are equal, {@code false} otherwise.
     */
    boolean equals(Object obj);

    /**
     * Returns the hash code of {@code this}.
     *
     * @return the hash code of {@code this}.
     */
    int hashCode();

    /**
     * Returns a {@link StickSet} view of {@code this}. The returned object contains all
     * the sticks in this mobile. Later changes in {@code this} will be reflected
     * in the returned view.
     *
     * @return a {@link StickSet} view of {@code this}.
     */
    StickSet getStickSetView();

    /**
     * Returns an iterator over all {@link Star} objects in this mobile. The order of iteration
     * is not specified.
     *
     * @return an iterator over all {@link Star} objects in this mobile.
     */
    StarIterator iterator();
}
