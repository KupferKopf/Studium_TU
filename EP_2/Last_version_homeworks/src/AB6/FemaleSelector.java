package AB6;

import AB6.Interfaces.Dinosaur;
import AB6.Interfaces.Predicate;

/**
 * The FemaleSelector class is a predicate implementation that classifies dinosaurs
 * based on their biological sex, specifically selecting female dinosaurs.
 *
 * <p>This class implements the Predicate interface and overrides the {@code test}
 * method to return {@code true} if the biological sex of the given dinosaur
 * is {@code FEMALE}, and {@code false} otherwise.</p>
 */
public class FemaleSelector implements Predicate {

    // TODO: variable declarations (optional)

    /**
     * Tests if the given dinosaur is biologically female.
     *
     * @param dinosaur the dinosaur to be evaluated. Must not be null.
     * @return true if the biological sex of the provided dinosaur is female, false otherwise.
     */
    @Override
    public boolean test(Dinosaur dinosaur) {
        return dinosaur.getBiologicalSex().equals(Dinosaur.Sex.FEMALE);
    }
}
