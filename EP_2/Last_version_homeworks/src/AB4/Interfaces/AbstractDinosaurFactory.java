/* DO NOT EDIT */
package AB4.Interfaces;

/**
 * Represents a factory for creating instances of dinosaurs.
 *
 * <p>Implementations of this interface are responsible for producing specific types of dinosaurs.</p>
 */
public interface AbstractDinosaurFactory {
    /**
     * This factory method creates a new dinosaur with the given DNA and name.
     *
     * @param dna the unique integer encoded DNA for the dinosaur.
     * @param name the call name of the dinosaur.
     * @return the newly created Dinosaur instance or {@code null} if creation fails.
     */
    Dinosaur create(int dna, String name);
}
