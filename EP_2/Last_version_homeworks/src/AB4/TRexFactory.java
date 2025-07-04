package AB4;

import AB4.Interfaces.AbstractDinosaurFactory;
import AB4.Interfaces.Dinosaur;

/**
 * Factory class for creating instances of Tyrannosaurus rex dinosaurs.
 *
 * <p>Implements the AbstractDinosaurFactory interface, providing a specific implementation
 * of the create method to produce Tyrannosaurus rex objects, initialized with the provided DNA
 * and name parameters.</p>
 */
public class TRexFactory implements AbstractDinosaurFactory {
    /**
     * This factory method creates a new Tyrannosaurus rex with the given DNA and name.
     * @param dna the unique integer encoded DNA for the dinosaur.
     * @param name the call name of the dinosaur.
     * @return the newly created Tyrannosaurus rex instance or {@code null} if creation fails.
     */
    @Override
    public Dinosaur create(int dna, String name) {
        if(name == null) return null;
        Dinosaur rexi = new TyrannosaurusRex(dna, name);
        return rexi;
    }
}
