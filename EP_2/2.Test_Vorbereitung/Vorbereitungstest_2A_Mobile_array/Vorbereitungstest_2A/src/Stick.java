/**
 * A {@code Stick} has a specified stick weight, that can not be changed after
 * initialisation. Mobiles can be attached to the stick (recursive structure).
 * {@code Stick} implements {@link Mobile}.
 * You can assume that no part of a mobile has the same identity as another part.
 */

public class Stick implements Mobile
{

    private final int stickWeight;
    private Mobile[] attached;


    /**
     * Initialises {@code this}; throws an {@link StickBreaksException} if the sum of the weight of
     * all mobiles in the array {@code attached} is greater than 10 times the {@code stickWeight}.
     * The detail message of the exception is "Stick breaks!".
     *
     * @param stickWeight the weight of this stick (without attached mobiles),
     *      {@code stickWeight > 0}.
     * @param attached an array with all the mobiles directly attached to this stick.
     *      Precondition: {@code attached != null && attached.length > 1} and for any two mobiles
     *                m1 and m2 being part of {@code attached} (including sub-mobiles) it holds that
     *                {@code m1.equals(m2) == false}, this is, there are no duplicates anywhere
     *                in a mobile.
     * @throws StickBreaksException if the sum of the weight of all mobiles in the array
     *        {@code attached} is greater than 10 times the {@code stickWeight}.
     */
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {
        this.stickWeight = stickWeight;
        int weight = 0;
        for(Mobile m : attached) weight += m.getWeight();
        if(weight > (stickWeight*10)) throw new StickBreaksException("Stick breaks!");
        else this.attached = attached.clone();
    }

    /**
     * Replaces the mobile equal to {@code toReplace} with a new mobile {@code replaceWith} if this
     * mobile is directly attached to this stick (no recursive search). In this case {@code true}
     * is returned.
     * Otherwise, the call of this method has no effect and {@code false} is returned.
     *
     * Throws a {@link StickBreaksException} if the replacement would violate the
     * condition that the sum of the weight of all attached mobiles has to be
     * less than or equal to 10 times its stick weight. In this case this mobile remains unchanged.
     *
     * @param toReplace the mobile to be replaced, toReplace != null.
     * @param replaceWith the new mobile to replace with, replaceWith != null.
     * @return {@code true} if the replacement was successful, {@code false} otherwise.
     * @throws StickBreaksException if the replacement would violate the
     *        condition that the sum of the weight of all attached mobiles has to be
     *        less than or equal to 10 times its stick weight.
     */
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {

        int weigth = 0;
        for(Mobile m : attached) weigth += m.getWeight();
        weigth = weigth - toReplace.getWeight() + replaceWith.getWeight();
        if(weigth > stickWeight*10) throw new StickBreaksException("Stick breaks!");

        for (int i = 0; i < attached.length; i++) {
            if(attached[i].equals(toReplace)){
                attached[i] = replaceWith;
                return true;
            }
        }
        return false;
    }

    @Override
    public int getWeight() {
        int weight = 0;
        for(Mobile m : attached) weight += m.getWeight();
        return weight + stickWeight;
    }

    /**
     * Returns {@code true} if {@code obj} is also of class {@code Stick}, has an equal stick
     * weight, and has equal mobiles attached, regardless of their order. This means that 'this'
     * and {@code obj} have the same number of mobiles attached and every mobile attached to this
     * stick is equal to a mobile attached to {@code obj} (and vice versa).
     * Otherwise, {@code false} is returned.
     *
     * @param obj the other object to compare with.
     * @return {@code true} if {@code this} and {@code obj} are equal and {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if(obj.getClass().equals(Stick.class)){
            if(((Stick) obj).attached.length == attached.length){

                for (int i = 0; i < attached.length; i++) {
                    boolean found = false;
                    for (int j = 0; j < attached.length; j++) {
                        if (attached[i].equals(((Stick) obj).attached[j])) {
                            found = true;
                        }
                    }
                    if(!found) return false;
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public StickSet getStickSetView() {
        return new StickColection(this, attached);
    }

    @Override
    public StarIterator iterator() {
        return new StickIter(this, attached);
    }



    /**
     * Returns a readable representation of the mobile, showing its complete
     * structure with all weights using an expression with parentheses.
     * Example (compare with the graphical representation above):
     * 5[2[*7, 1[*3, *3], *2], *12, *5]
     *
     * @return a readable representation of the mobile.
     */
    @Override
    public String toString(){
        String ret = "";

        ret += "" + stickWeight + "[";

        for(int i = 0; i < attached.length-1; i++){
            ret += attached[i].toString() + ", ";
        }

        return ret + attached[attached.length-1] + "]";
    }


    @Override
    public int hashCode(){
        return Integer.hashCode(stickWeight);
    }



}
