package AB4;

import AB4.Interfaces.AbstractDinosaurFactory;
import AB4.Interfaces.Dinosaur;

/**
 * Factory class for creating instances of Edmontosaurus dinosaurs.
 *
 * <p>Implements the AbstractDinosaurFactory interface, providing a specific implementation
 * of the create method to produce Edmontosaurus objects, initialized with the provided DNA
 * and name parameters.</p>
 */
public class EdSFactory implements AbstractDinosaurFactory {
    /**
     * This factory method creates a new Edmontosaurus with the given DNA and name.
     * @param dna the unique integer encoded DNA for the dinosaur.
     * @param name the call name of the dinosaur.
     * @return the newly created Edmontosaurus instance or {@code null} if creation fails.
     */
    @Override
    public Dinosaur create(int dna, String name) {
        if(name == null) return null;
        return new Edmontosaurus(dna, name);
    }
}
