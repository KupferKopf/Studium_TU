/* DO NOT EDIT */
package AB6.Interfaces;

import AB6.Provided.DinosaurDNA;

/**
 * An interface representing a collection that stores and manages {@code Dinosaur} objects, allowing
 * for operations such as storage, removal, lookup, and traversal.
 *
 * <p>Classes implementing this interface provide the functionality to manipulate a bucket of
 * {@code Dinosaur} objects, where each object is uniquely identified by its {@code DinosaurDNA}.</p>
 */
public interface DinosaurList {

    /**
     * Stores the given dinosaur in the collection. If a dinosaur with the same DNA already exists,
     * it updates the stored dinosaur with the provided one and returns the old one.
     * If no dinosaur with the same DNA exists, it adds the new dinosaur into the collection.
     *
     * @param dinosaur the {@code Dinosaur} object to be stored. The dinosaur is identified
     *               by its unique DNA.
     * @return the previously stored dinosaur with the same DNA if one exists, or {@code null} if the provided
     *         dinosaur is newly added to the collection.
     */
    Dinosaur store(Dinosaur dinosaur);

    /**
     * Removes the {@code Dinosaur} object identified by the specified {@code DinosaurDNA} from the collection.
     * If a dinosaur with the given DNA is found, it is removed and returned.
     * If no dinosaur with the matching DNA exists, {@code null} is returned.
     *
     * @param dna the {@code DinosaurDNA} identifying the dinosaur to be removed from the collection
     * @return the removed {@code Dinosaur} object if found, or {@code null} if no dinosaur with the specified DNA exists
     */
    Dinosaur remove(DinosaurDNA dna);

    /**
     * Finds and retrieves the {@code Dinosaur} object in the collection that matches the specified {@code DinosaurDNA}.
     * If no dinosaur with the given DNA is found, {@code null} is returned.
     *
     * @param dna the {@code DinosaurDNA} used to identify the dinosaur to be retrieved
     * @return the {@code Dinosaur} object that matches the specified DNA, or {@code null} if no match is found
     */
    Dinosaur find(DinosaurDNA dna);

    /**
     * Checks if the bucket is empty.
     *
     * @return {@code true} if the bucket contains no elements,
     *         {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Retrieves the number of elements currently stored in the bucket.
     *
     * @return the total count of elements in the bucket as an integer. If the bucket is empty, returns 0.
     */
    int size();

    /**
     * Removes all elements from the collection, leaving it empty.
     * After the invocation of this method, the collection will contain no elements.
     */
    void clear();
}
