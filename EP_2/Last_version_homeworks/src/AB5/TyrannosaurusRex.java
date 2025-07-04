package AB5;

import AB5.Interfaces.Dinosaur;

import javax.smartcardio.TerminalFactory;

/**
 * This class represents a Tyrannosaurus rex, a carnivorous type of dinosaur that is very aggressive and
 * hence ANGRY by default. It reacts to being fed with MEAT by changing its state to HAPPY.
 *
 * <p>The Tyrannosaurus rex species is rather simple-minded and can only be HAPPY or ANGRY. It is ANGRY by default.</p>
 *
 * <p>This class implements the {@link Dinosaur} interface.</p>
 */
public class TyrannosaurusRex implements Dinosaur {
    /* DO NOT MODIFY ANY VARIABLES */
    private final DinosaurDNA dna;
    private final String species;
    private final String name;
    private Happiness happiness;

    // TODO: variable declarations (optional)

    /**
     * Computes the hash code for this TyrannosaurusRex instance based on its DNA.
     *
     * @return the hash code of the DNA of this dinosaur.
     */
    @Override
    public int hashCode() {
       return dna.hashCode();
    }

    /**
     * Compares this TyrannosaurusRex instance with another object for equality.
     * Two TyrannosaurusRex objects are considered equal if their DNA instances are equal.
     *
     * @param obj the object to be compared for equality with this TyrannosaurusRex instance
     * @return true if the specified object is equal to this TyrannosaurusRex instance, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == TerminalFactory.class){
            return dna.equals(((TyrannosaurusRex)obj).getDNA());
        }
        return false;
    }

    // DO NOT MODIFY ANY METHODS BELOW THIS LINE!

    /**
     * Constructor for the TyrannosaurusRex class, initializing a new instance
     * of a Tyrannosaurus rex with a specified genetic makeup (DNA) and name.
     *
     * <p>The species property ({@code String}) is set to "TRex" by default, and the initial happiness state
     * is set to ANGRY.</p>
     *
     * @param dna  genetic code ({@code DinosaurDNA}) for this Tyrannosaurus rex.
     * @param name name assigned to this animal at the moment of birth.
     */
    public TyrannosaurusRex(DinosaurDNA dna, String name) {
        this.dna = dna;
        this.name = name;
        this.species = "TRex";
        this.happiness = Happiness.ANGRY;
    }

    /**
     * Retrieves the DNA sequence associated with this Tyrannosaurus rex instance.
     *
     * <p>The DNA sequence is of type {@code DinosaurDNA} that encodes the genetic makeup
     * of the dinosaur, which uniquely identifies its biological traits.</p>
     *
     * @return the DNA of this dinosaur.
     */
    @Override
    public DinosaurDNA getDNA() {
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
        return happiness;
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
        happiness = ( food == Food.MEAT ? Happiness.HAPPY : Happiness.ANGRY );
        return happiness;
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
        return species + " " + name + " " + (happiness != Happiness.HAPPY ? "[DANGER]" : "[OK]");
    }



}
