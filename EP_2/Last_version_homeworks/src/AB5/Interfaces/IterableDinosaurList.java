/* DO NOT EDIT */
package AB5.Interfaces;

import AB5.DinosaurListIterator;

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
    DinosaurListIterator iterator();
}
