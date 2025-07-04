package AB6;

import AB6.Interfaces.AbstractListNode;
import AB6.Interfaces.Dinosaur;
import AB6.Interfaces.Predicate;

public class DinosaurFilteringIterator {
    private AbstractListNode current;
    private Predicate filterCriterion;

    // TODO: variable declarations (optional)

    /**
     * Constructs a {@code DinosaurFilteringIterator} initialized with the given starting node. This iterator
     * provides a filtered view of the underlying linked list structure.
     *
     * <p>This iterator allows traversal through a linked list structure composed of {@code AbstractListNode} elements.
     * During traversal a filter predicate is applied to each node in the list to determine if the node should be included.</p>
     *
     * @param current         the starting node of the linked list from which the iterator begins its traversal.
     *                        Can be {@code null}, which indicates that the iterator is positioned at the end of the list or list is empty.
     * @param filterCriterion the predicate used to determine if a node should be included in the iteration.
     */
    public DinosaurFilteringIterator(AbstractListNode current, Predicate filterCriterion) {
        this.current = current;
        this.filterCriterion = filterCriterion;
    }

    /**
     * Determines if there are more elements to iterate over in the underlying linked list structure considering the
     * applied filter.
     *
     * @return {@code true} if the iterator has more elements to traverse;
     * {@code false} if the end of the list has been reached or the list is empty.
     */
    public boolean hasNext() {
        if(current == null) return false;
        AbstractListNode tempCursor = current;

        while (tempCursor != null){
            if(filterCriterion.test(tempCursor.value())) return true;
            tempCursor = tempCursor.next();
        }
        return false;
    }

    /**
     * Retrieves the current node in the iteration and advances the iterator to the next node in the linked list.
     * If the current node is not null, this method returns the current node and updates the internal state to point
     * to the next node in the sequence. If the current node is null (indicating the end of the list or empty list),
     * this method returns null.
     *
     * @return the current {@code Dinosaur} in the iteration, or {@code null} if there are no more nodes.
     */
    public Dinosaur next() {
        if(current == null) return null;


        Dinosaur ret;
        while (current != null){
            if(filterCriterion.test(current.value())){
                ret = current.value();
                current = current.next();
                return ret;
            }
            current = current.next();
        }


        return null;
    }
}
