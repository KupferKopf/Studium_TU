/* DO NOT EDIT */
package AB6.Interfaces;

import AB6.DinosaurFilteringIterator;

/**
 * Interface representing a collection of filterable dinosaurs that can be iterated over.
 * Classes implementing this interface provide a way to obtain an iterator
 * that allows filtered traversal through their elements.
 */
public interface IterableFilteredDinosaurList {

    /**
     * Returns a filtering list iterator for traversing the elements in this collection. The list iterator provides
     * methods to navigate through the elements and retrieve them in sequence.
     *
     * @return a {@code ListIterator} for iterating over the elements of this collection.
     */
    DinosaurFilteringIterator filteringIterator(Predicate filterCriterion);
}
