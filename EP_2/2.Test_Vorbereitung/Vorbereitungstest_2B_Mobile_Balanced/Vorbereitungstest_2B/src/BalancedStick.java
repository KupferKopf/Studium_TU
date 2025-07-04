/**
 * A {@code BalancedStick} has a specified stick weight, that can not be changed after
 * initialisation. On the left and right end of the stick another mobile
 * is attached (recursive structure). {@code BalancedStick} implements {@code Mobile}.
 * You can assume that no part of a mobile has the same identity as another part.
 */
//
// TODO: Complete the methods in 'BalancedStick'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class BalancedStick implements Mobile // TODO: activate clause.
{

    private int stickWeight;
    private Mobile left;
    private Mobile right;


    /**
     * Initialises {@code this}; throws an {@link UnbalancedException} if the resulting mobile
     * would not be balanced, i.e. if {@code left.getWeight() != right.getWeight()}. The detail
     * message of the exception contains information about the difference between
     * left and right weight, for example "Stick unbalanced (left 6 - right 8)"
     * (see example in {@link ApplicationTest2}).
     *
     * @param stickWeight the weight of the stick, {@code stickWeight > 0}.
     * @param left        the left mobile, {@code left != null}.
     * @param right       the right mobile, {@code right != null}.
     *                    no part of a mobile has the same identity as another part.
     * @throws UnbalancedException if the mobile would not be balanced
     */
    public BalancedStick(int stickWeight, Mobile left, Mobile right) throws UnbalancedException {

        this.stickWeight = stickWeight;
        if (left.getWeight() != right.getWeight())
            throw new UnbalancedException("Stick unbalanced (left " + left.getWeight() + " - right " + right.getWeight() + ")");
        this.left = left;
        this.right = right;

    }

    /**
     * Replaces the mobile equal to {@code toReplace} with a new mobile {@code replaceWith} and
     * returns {@code true} if such a mobile is contained as part of this mobile, i.e., attached
     * to this stick or below (recursive search). Otherwise, the call of this method has no
     * effect and {@code false} is returned.
     * <p>
     * Throws an {@link UnbalancedException} if the replacement would violate the
     * conditions that all sticks need to be balanced. In this case this mobile remains unchanged.
     * The detail message of the exception contains information about the difference between left
     * and right weight, for example: "Stick unbalanced (left 6 - right 8)".
     *
     * @param toReplace   the mobile to be replaced, {@code toReplace != null}.
     * @param replaceWith the new mobile to replace with, {@code replaceWith != null}.
     * @return {@code true} if the replacement was successful, {@code false} otherwise.
     * @throws {@link UnbalancedException} if the replacement would unbalance the mobile.
     */
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws UnbalancedException {

        if (toReplace.getWeight() != replaceWith.getWeight())
            throw new UnbalancedException("Stick unbalanced (left " + left.getWeight() + " - right " + right.getWeight() + ")");


        if (left.equals(toReplace)) {
            left = replaceWith;
            return true;
        }

        if (right.equals(toReplace)) {
            right = replaceWith;
            return true;
        }


        boolean ret = false;

        if (left.getClass().equals(BalancedStick.class)) ret = ((BalancedStick) left).replace(toReplace, replaceWith);
        if (ret) return true;
        if (right.getClass().equals(BalancedStick.class)) ret = ((BalancedStick) left).replace(toReplace, replaceWith);
        return ret;

    }

    @Override
    public int getWeight() {
        return stickWeight + left.getWeight() + right.getWeight();
    }

    /**
     * Compares this stick to another for equality.
     * <p>
     * Two sticks are considered equal if:
     * <ol>
     *   <li>They have the same stick weight, and</li>
     *   <li>
     *     Either
     *     <ol type="a">
     *       <li>The left branch of this stick equals the left branch of the other,
     *       and the right branch of this equals the right branch of the other; or</li>
     *       <li>The left branch of this stick equals the right branch of the other,
     *       and the right branch of this equals the left branch of the other.</li>
     *     </ol>
     *   </li>
     * </ol>
     * Exchanging left and right branches does not affect the result of {@code equals}.
     * </p>
     * <p>
     * For example, all three of the following mobiles are equal (assuming corresponding
     * {@code Star} instances are equal):
     * </p>
     * <pre>
     *          |                      |                |
     *      +---2---+              +---2---+        +---2---+
     *      |       |              |       |        |       |
     *   +--2--+    *           +--2--+    *        *    +--2--+
     *   |     |    16          |     |    16       16   |     |
     *   *  +--1--+          +--1--+  *               +--1--+  *
     *   7  |     |          |     |  7               |     |  7
     *      *     *          *     *                  *     *
     *      3     3          3     3                  3     3
     * </pre>
     *
     * @param o the object to compare to
     * @return {@code true} if the two sticks are equal as defined above; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {

        if (o.getClass().equals(BalancedStick.class)) {
            if (((BalancedStick) o).stickWeight == this.stickWeight && (
                    (((BalancedStick) o).left.equals(this.left) && ((BalancedStick) o).right.equals(this.right)) ||
                            (((BalancedStick) o).left.equals(this.right) && ((BalancedStick) o).right.equals(this.left)))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public StarIterator iterator() {
        return new StickIterator_IMP(left, right);
    }

    @Override
    public StarCollection getStarCollection() {
        return new StarCollection_IMP(this);
    }

    @Override
    public String toString() {
        String ret = "";

        ret += "(" + left.toString() + ")-" + stickWeight + "-(" + right.toString() + ")";

        return ret;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getWeight());
    }


}

// TODO: define additional classes if needed (either here or in a separate file).