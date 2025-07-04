package AB5;

import AB5.Interfaces.AbstractListNode;
import AB5.Interfaces.Dinosaur;

/**
 * The {@code DinosaurListIterator} class provides an iterator for traversing over all
 * {@code Dinosaur} objects within a list.
 *
 * <p>The iterator provides sequential access to the elements in the list, starting from
 * a specified node and moving to the subsequent nodes until the end of the list is reached.</p>
 */
public class DinosaurListIterator {
    private AbstractListNode current;

    // TODO: variable declarations (optional)

    /**
     * Constructs a {@code DinosaurListIterator} initialized with the given starting node.
     * This iterator allows traversal through a linked list structure composed of {@code AbstractListNode} elements.
     *
     * @param current the starting node of the linked list from which the iterator begins its traversal.
     *                Can be {@code null}, which indicates that the iterator is positioned at the end of the list or list is empty.
     */
    public DinosaurListIterator(AbstractListNode current) {
        this.current = current;
    }

    /**
     * Determines if there are more elements to iterate over in the underlying linked list structure.
     *
     * @return {@code true} if the iterator has more elements to traverse;
     * {@code false} if the end of the list has been reached or the list is empty.
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * Retrieves the current node in the iteration and advances the iterator to the next node in the linked list.
     * If the current node is not null, this method returns the current node and updates the internal state to point
     * to the next node in the sequence. If the current node is null (indicating the end of the list or empty list),
     * this method returns null.
     *
     * @return the current {@code AbstractListNode} in the iteration, or {@code null} if there are no more nodes.
     */
    public Dinosaur next() {
        if(!hasNext()) return null;

        Dinosaur cur = current.value();
        current = current.next();
        return cur;
    }
}
