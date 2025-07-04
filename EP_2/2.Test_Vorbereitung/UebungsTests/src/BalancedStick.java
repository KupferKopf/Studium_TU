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

    //TODO: define missing parts of the class.
    private final int stickWeight;
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

        if(left.getWeight() != right.getWeight())
            throw new UnbalancedException("Stick unbalanced (left " + left.getWeight() + " - right " + right.getWeight() + ")");

        this.stickWeight = stickWeight;
        this.left = left;
        this.right = right;
    }

    /**
     * Replaces the mobile equal to {@code toReplace} with a new mobile {@code replaceWith} and
     * returns {@code true} if such a mobile is contained as part of this mobile, i.e., attached
     * to this stick or below (recursive search). Otherwise, the call of this method has no
     * effect and {@code false} is returned.
     *
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


        if(toReplace.getWeight() != replaceWith.getWeight())
            throw new UnbalancedException("Replace Stick would be unbalanced (Searched Mobile: " + toReplace.getWeight() + " - Replacement Mobile: " + replaceWith.getWeight());

        boolean found = false;

        if(left.getClass() != Star.class){
            BalancedStick balaLeft = (BalancedStick) left;
            if(balaLeft.replace(toReplace, replaceWith)){
                found = true;
            }
        }

        if(right.getClass() != Star.class){
            BalancedStick balaRight = (BalancedStick) right;
            if(balaRight.replace(toReplace, replaceWith)){
                found = true;
            }
        }


        if(left == toReplace){
            left = toReplace;
            found = true;
        }

        if(right == toReplace){
            right = toReplace;
            found = true;
        }

        return found;
    }

    @Override
    public int getWeight() {
        return left.getWeight() + right.getWeight() + stickWeight;
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

        if(o.getClass() != (BalancedStick.class)) return false;
        BalancedStick temp = (BalancedStick) o;
        return (this.stickWeight == temp.stickWeight &&
                (left.equals(temp.left) && right.equals(temp.right)) ||
                (left.equals(temp.right) && right.equals(temp.left)));

    }

    @Override
    public StarIterator iterator() {
        return new StickIterator(left, right);
    }

    @Override
    public StarCollection getStarCollection() {
        return new StarCollection_Imp(left, right);
    }


    /**
     * Returns a readable representation of the mobile, showing its complete
     * structure with all weights using an expression with parentheses.
     * Example (compare with the graphical representation above):
     * ((*7)-2-((*3)-1-(*3)))-2-(*16)
     *
     * @return a readable representation of the mobile.
     */
    @Override
    public String toString(){

        String lefty = left.toString();
        String righty = right.toString();


        return "(" + lefty + ")-" + stickWeight + "-(" + righty + ")";
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(getWeight());
    }


}

// TODO: define additional classes if needed (either here or in a separate file).