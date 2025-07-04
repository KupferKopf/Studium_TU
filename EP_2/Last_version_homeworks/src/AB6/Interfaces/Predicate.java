/* DO NOT EDIT */
package AB6.Interfaces;

/**
 * A functional interface representing a condition or predicate to test on a Dinosaur object.
 *
 * <p>This interface is designed to evaluate whether a given Dinosaur satisfies a specific condition
 * by implementing the {@code test} method. It is useful in filtering, selection, and other operations
 * that involve applying criteria to Dinosaur instances.</p>
 */
public interface Predicate {

    /**
     * Tests whether the specified dinosaur meets a condition.
     *
     * @param dinosaur the dinosaur object to be evaluated. It must not be null.
     * @return true if the dinosaur satisfies the condition implemented in the method; otherwise, false.
     */
    public boolean test(Dinosaur dinosaur);
}
