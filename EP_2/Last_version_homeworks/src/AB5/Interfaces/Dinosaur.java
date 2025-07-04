/* DO NOT EDIT */
package AB5.Interfaces;

import AB5.DinosaurDNA;

/**
 * Represents a dinosaur with certain properties and actions.
 * A dinosaur is identified by a unique DNA, holds an individual name, and has a happiness state.
 * Dinosaurs can be fed with food, which affects their happiness.
 */
public interface Dinosaur {

    /**
     * Enum representing the types of food consumed by dinosaurs.
     *
     * <p>This enumeration defines two types of food:<br>
     * - MEAT: Represents food suitable for carnivorous dinosaurs.<br>
     * - PLANTS: Represents food suitable for herbivorous dinosaurs.</p>
     */
    enum Food {
        MEAT,
        PLANTS
    }

    /**
     * Enum representing the emotional states of a dinosaur.
     *
     * <p>This enumeration is used to define the happiness (mood) of a dinosaur, which can influence its behavior and interactions.
     * Not all dinosaur species are capable of the same range of moods. Which species can be in which mood, is subject to the species'
     * implementation.</p>
     *
     * <p>The emotional states include:<br>
     * - HAPPY: Indicates a positive or content state.<br>
     * - SAD: Indicates a negative or unhappy state.<br>
     * - ANGRY: Indicates an irritable or aggressive state.</p>
     */
    enum Happiness {
        HAPPY,
        SAD,
        ANGRY
    }

    /**
     * Returns the unique DNA of the dinosaur.
     * @return the unique DNA of type {@code DinosaurDNA} of the dinosaur.
     */
    DinosaurDNA getDNA();

    /**
     * Returns the name of the dinosaur.
     *
     * @return the name, a specific dinosaur is called by, as a String.
     */
    String getName();

    /**
     * Retrieves the current emotional state of the dinosaur.
     *
     * @return the {@code Happiness} enum representing the dinosaur's current emotional state.
     */
    Happiness getHappiness();

    /**
     * Feeds the dinosaur with the specified type of food, potentially altering its happiness state.
     *
     * @param food the type of food to feed the dinosaur. This must be one of the {@code Food} enum values (e.g., MEAT or PLANTS).
     * @return the new {@code Happiness} state of the dinosaur after being fed.
     */
    Happiness feed(Food food);
}
