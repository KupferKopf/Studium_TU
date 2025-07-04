/**
 * Leaf node of a mobile. The actual decoration of a mobile.
 * A {@code Star} has a specified weight, that can not be changed after
 * initialisation. {@code Star} implements {@link Decoration}.
 */
//
// TODO: Complete the methods in 'Star'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Star implements Decoration
{
    private final int weight;

    /**
     * Initializes {@code this} with its weight.
     *
     * @param weight the weight of this star.
     */
    public Star(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    /**
     * Returns a readable representation of {@code this} with the
     * symbol {@code *} followed by the weight of this star.
     */
    @Override
    public String toString() {
        return "*" + weight;
    }


    @Override
    public boolean equals(Object obj){

        if(obj.getClass().equals(Star.class)){
            if(((Star) obj).getWeight() == weight) return true;
            return false;
        }
        return false;
    }


    @Override
    public StarIterator iterator() { // TODO Iterator basteln
        return new StarIterator_Imp(this);
    }

    @Override
    public StarCollection getStarCollection() { // TODO Collection basteln
        return null;
    }
}
