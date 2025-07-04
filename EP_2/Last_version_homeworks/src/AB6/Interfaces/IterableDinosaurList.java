/* DO NOT EDIT */
package AB6.Interfaces;

import AB6.Provided.DinosaurIterator;

/**
 * Interface representing a collection of dinosaurs that can be iterated over.
 * Classes implementing this interface provide a way to obtain an iterator
 * that allows traversal through their elements.
 */
public interface IterableDinosaurList {

    /**
     * Returns a list iterator for traversing the elements in this collection. The list iterator provides
     * methods to navigate through the elements and retrieve them in sequence.
     *
     * @return a {@code ListIterator} for iterating over the elements of this collection.
     */
    DinosaurIterator iterator();
}
