/**
 * Leaf node of a mobile. The actual decoration of a mobile.
 * A {@code Star} has a specified weight, that can not be changed after
 * initialisation. {@code Star} implements {@link Decoration}.
 */

public class Star implements Decoration
{

    private final int weight;

    /**
     * Initializes {@code this} with its weight.
     *
     * @param weight the weight of this star, {@code weight > 0}.
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
     * symbol '*' followed by the weight of this star.
     *
     * @return a readable representation of {@code this}.
     */
    @Override
    public String toString() {

        return "*" + weight;
    }

    @Override
    public StickSet getStickSetView() {
        return null;
    }

    @Override
    public StarIterator iterator() {
        return new StarIter(this);
    }


    @Override
    public boolean equals(Object o){
        return this == o;
    }


    @Override
    public int hashCode(){
        return Integer.hashCode(weight);
    }

}

