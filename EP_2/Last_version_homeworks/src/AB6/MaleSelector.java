package AB6;

import AB6.Interfaces.Dinosaur;
import AB6.Interfaces.Predicate;

/**
 * The MaleSelector class is a predicate implementation that classifies dinosaurs
 * based on their biological sex, specifically selecting male dinosaurs.
 *
 * <p>This class implements the Predicate interface and overrides the {@code test}
 * method to return {@code true} if the biological sex of the given dinosaur
 * is {@code MALE}, and {@code false} otherwise.</p>
 */
public class MaleSelector implements Predicate {

    // TODO: variable declarations (optional)

    /**
     * Tests if the given dinosaur is biologically male.
     *
     * @param dinosaur the dinosaur to be evaluated. Must not be null.
     * @return true if the biological sex of the provided dinosaur is male, false otherwise.
     */
    @Override
    public boolean test(Dinosaur dinosaur) {
        return dinosaur.getBiologicalSex().equals(Dinosaur.Sex.MALE);
    }
}
