package AB4;

import AB4.Interfaces.Dinosaur;

/**
 * This class represents a Tyrannosaurus rex, a carnivorous type of dinosaur that is very aggressive and
 * hence ANGRY by default. It reacts to being fed with MEAT by changing its state to HAPPY.
 *
 * <p>The Tyrannosaurus rex species is rather simple-minded and can only be HAPPY or ANGRY. It is ANGRY by default.</p>
 *
 * <p>This class implements the {@link Dinosaur} interface.</p>
 */
public class TyrannosaurusRex implements Dinosaur {
    private int dna;
    private String name;
    private static final Food food = Food.MEAT;
    private Happiness mood;

    /**
     * Constructor for the TyrannosaurusRex class, initializing a new instance
     * of a Tyrannosaurus rex with a specified genetic makeup (DNA) and name.
     *
     * <p>The species property ({@code String}) is set to "TRex" by default, and the initial happiness state
     * is set to ANGRY.</p>
     *
     * @param dna  integer encoded genetic code for this Tyrannosaurus rex.
     * @param name name assigned to this animal at the moment of birth.
     */
    public TyrannosaurusRex(int dna, String name) {

        this.dna = dna;
        this.name = name;
        mood = Happiness.ANGRY;
    }

    /**
     * Retrieves the DNA sequence associated with this Tyrannosaurus rex instance.
     *
     * <p>The DNA sequence is an integer value that encodes the genetic makeup
     * of the dinosaur, which uniquely identifies its biological traits.</p>
     *
     * @return the integer representation of the dinosaur's genetic code (DNA).
     */
    @Override
    public int getDNA() {
        return dna;
    }

    /**
     * Retrieves the name of this Tyrannosaurus rex.
     *
     * @return the name associated with this dinosaur.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retrieves the current happiness state of this Tyrannosaurus rex.
     *
     * @return the current happiness state, represented as a {@code Happiness} enum value,
     *         indicating whether the dinosaur is HAPPY or ANGRY.
     */
    @Override
    public Happiness getHappiness() {
        return mood;
    }

    /**
     * Feeds the Tyrannosaurus rex with the given food item and updates its happiness state accordingly.
     *
     *<p>Depending on the type of food provided, the happiness of the dinosaur is updated as follows:<br>
     * - If the food is MEAT, the happiness state is set to HAPPY.<br>
     * - For any other food type, the happiness state is set to ANGRY.</p>
     *
     * @param food the food item to be provided to the dinosaur, represented as an enum value {@code Food}.
     * @return the updated happiness state of the dinosaur, represented as a {@code Happiness} enum value.
     */
    @Override
    public Happiness feed(Food food) {
        if(food == Food.MEAT) mood = Happiness.HAPPY;
        else mood = Happiness.ANGRY;
        return mood;
    }

    /**
     * Returns a string representation of the Tyrannosaurus rex instance.
     *
     * <p>The resulting string starts with the species designation ("TRex"), followed by a white space (" "),
     * followed by the dino's name, followed by a white space (" "), and finally a danger status indicator,
     * based on the current happiness state:<br>
     * - If the happiness is ANGRY, the status is "[DANGER]".<br>
     * - Otherwise, the status is "[OK]".</p>
     *
     * <p>Example: "TRex Jack [DANGER]" for an angry Tyrannosaurus rex named Jack.</P>
     *
     * @return a string combining the species, name, and current danger status indicator.
     */
    @Override
    public String toString(){
        String ret = "TRex " + name + " ";
        if(mood == Happiness.ANGRY) ret += "[DANGER]";
        else ret += "[OK]";
        return ret;
    }
}
