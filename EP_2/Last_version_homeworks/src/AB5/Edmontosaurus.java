package AB5;

import AB5.Interfaces.Dinosaur;

/**
 * This class represents the Edmontosaurus, a type of dinosaur that lived at the time of Tyrannosaurus rex.
 *
 * <p>The Edmontosaurus is a herbivorous dinosaur that is HAPPY by default and reacts to being fed by
 * changing its mood. Compared to the Tyrannosaurus rex, the Edmontosaurus has a more complex emotional system.
 * It varies from HAPPY, over SAD, to ANGRY.</p>
 *
 * <p>This class implements the {@link Dinosaur} interface.</p>
 */
public class Edmontosaurus implements Dinosaur { // cringe dino ngl wo stego
    /* DO NOT MODIFY ANY VARIABLES */
    private final DinosaurDNA dna;
    private String species;
    private String name;
    private Happiness happiness;

    // TODO: variable declarations (optional)

    /**
     * Computes the hash code for this Edmontosaurus instance based on its DNA.
     *
     * @return the hash code of the DNA of this dinosaur.
     */
    @Override
    public int hashCode() {
        return dna.hashCode();
    }

    /**
     * Compares this Edmontosaurus instance with another object for equality.
     * Two Edmontosaurus objects are considered equal if their DNA instances are equal.
     *
     * @param obj the object to be compared for equality with this Edmontosaurus instance
     * @return true if the specified object is equal to this Edmontosaurus instance, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == Edmontosaurus.class){
            return dna.equals(((Edmontosaurus) obj).getDNA());
        }
        return false;
    }

    // DO NOT MODIFY ANY METHODS BELOW THIS LINE!

    /**
     * Constructor for the Edmontosaurus class, initializing a new instance
     * of a Edmontosaurus with a specified genetic makeup (DNA) and name.
     *
     * <p>The species property ({@code String}) is set to "Edmontosaurus" by default, and the initial happiness state
     * is set to HAPPY.</p>
     *
     * @param dna  genetic code ({@code DinosaurDNA}) for this Edmontosaurus.
     * @param name name assigned to this animal at the moment of birth.
     */
    public Edmontosaurus(DinosaurDNA dna, String name) {
        this.dna = dna;
        this.name = name;
        this.species = "Edmontosaurus";
        this.happiness = Happiness.HAPPY;
    }

    /**
     * Retrieves the DNA sequence associated with this Edmontosaurus instance.
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
     * Retrieves the name of this Edmontosaurus.
     *
     * @return the name associated with this dinosaur.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Retrieves the current happiness state of this Edmontosaurus.
     *
     * @return the current happiness state, represented as a {@code Happiness} enum value,
     *         indicating whether the dinosaur is HAPPY, SAD or ANGRY.
     */
    @Override
    public Happiness getHappiness() {
        return happiness;
    }

    /**
     * Feeds the Edmontosaurus with the given food item and updates its happiness state accordingly.
     *
     *<p>Depending on the type of food provided, the happiness of the dinosaur is updated as follows:<br>
     * - If food type is PLANTS, the happiness state is set to HAPPY.<br>
     * - For any other food type, the happiness state decreases from HAPPY to SAD, or if already SAD, from
     *   SAD to ANGRY.</p>
     *
     * @param food the food item to be provided to the dinosaur, represented as an enum value {@code Food}.
     * @return the updated happiness state of the dinosaur, represented as a {@code Happiness} enum value.
     */
    @Override
    public Happiness feed(Food food) {
        switch(food){
            case PLANTS -> {
                happiness = Happiness.HAPPY;
            }
            case MEAT -> {
                if (happiness == Happiness.HAPPY) {
                    happiness = Happiness.SAD;
                } else if (happiness == Happiness.SAD) {
                    happiness = Happiness.ANGRY;
                }
            }
        }
        return happiness;
    }

    /**
     * Returns a string representation of the Edmontosaurus instance.
     *
     * <p>The resulting string starts with the species designation ("Edmontosaurus"), followed by a white space (" "),
     * followed by the dino's name, followed by a white space (" "), and finally a danger status indicator,
     * which is always "OK" (peaceful) for this species.</p>
     *
     * <p>Example: "Edmontosaurus Bob [OK]" for a peaceful Edmontosaurus named Bob.</P>
     *
     * @return a string, combining species, name and current danger status indicator.
     */
    public String toString(){
        return species + " " + name + " " + "[OK]";
    }

}
