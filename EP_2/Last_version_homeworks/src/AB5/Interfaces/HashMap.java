/* DO NOT EDIT */
package AB5.Interfaces;

import AB5.DinosaurDNA;

/**
 * Interface representing a HashMap for storing, retrieving, and managing dinosaur objects.
 * This HashMap associates each dinosaur with a unique key derived from
 * its DNA for quick access, modification, and removal of entries.
 */
public interface HashMap {

    /**
     * Inserts the specified dinosaur into the HashMap. If a dinosaur with the same DNA
     * is already present in the collection, it will be replaced by the new dinosaur.
     *
     * @param dinosaur the dinosaur object to add to the HashMap.
     *                 It must contain valid DNA for identification.
     * @return the previous dinosaur associated with the same DNA, or null if there was no mapping for the DNA.
     */
    Dinosaur put(Dinosaur dinosaur);

    /**
     * Retrieves a dinosaur from the HashMap based on its DNA.
     *
     * @param dna the DNA of the dinosaur to retrieve. It must uniquely identify a dinosaur in the HashMap.
     * @return the dinosaur associated with the specified DNA, or null if no such dinosaur exists in the collection.
     */
    Dinosaur get(DinosaurDNA dna);

    /**
     * Removes the dinosaur associated with the specified DNA from the HashMap.
     *
     * @param dna the DNA of the dinosaur to be removed. This uniquely identifies the dinosaur in the HashMap.
     * @return the dinosaur previously associated with the specified DNA, or null if no such dinosaur existed.
     */
    Dinosaur remove(DinosaurDNA dna);

    /**
     * Removes all entries from the HashMap, leaving it empty.
     * After invoking this method, the number of entries in the collection will be zero.
     */
    void clear();

    /**
     * Returns the number of entries currently present in the HashMap.
     *
     * @return the total number of dinosaurs stored in the HashMap.
     *         If the HashMap is empty, this method returns 0.
     */
    int size(); // number of entries in the hashmap
}
