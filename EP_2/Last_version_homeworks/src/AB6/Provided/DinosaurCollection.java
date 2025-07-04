/* DO NOT EDIT */
package AB6.Provided;

import AB6.DinosaurFilteringIterator;
import AB6.Interfaces.*;

/**
 * A concrete implementation of the {@code DinosaurList} interface that uses a linked list
 * to store and manage {@code Dinosaur} objects. Each dinosaur is uniquely identified by its DNA.
 *
 * <p></p>This class allows adding, updating, removing, and querying dinosaurs within a dynamically
 * maintained list structure, using the {@code DinosaurDNA} as the identifier. Operations are
 * supported for checking the list's state (e.g., size, emptiness) and clearing all elements.</p>
 */
public class DinosaurCollection implements DinosaurList, IterableDinosaurList, IterableFilteredDinosaurList {
    private AbstractListNode head;

    /**
     * Constructor for the DinosaurCollection class.
     * Initializes an empty collection.
     */
    public DinosaurCollection() {
        head = null;
    }

    /**
     * Stores a dinosaur in the list. If the list is empty, a new node is created with the given dinosaur.
     * If a dinosaur with the same DNA is already in the list, its value is updated, and the old value is returned.
     * If no match is found, the dinosaur is added to the end of the list.
     *
     * @param dinosaur the {@code Dinosaur} object to be stored or updated in the list. This must not be {@code null}.
     * @return the previous {@code Dinosaur} object with the same DNA if one existed, or {@code null} if the
     * operation resulted in a new insertion.
     */
    @Override
    public Dinosaur store(Dinosaur dinosaur) {
        // if this list is empty, start a new one
        if (isEmpty()) {
            head = new DinosaurListNode(dinosaur);
            return null;
        }

        // check if the list already contains the animal, which should then be updated
        AbstractListNode currentNode = head;
        AbstractListNode lastNode = null;
        while (currentNode != null) {
            if (currentNode.value().equals(dinosaur)) {
                // current node contains the animal, so link parent node to current node's next
                var oldValue = currentNode.value();
                currentNode.setValue(dinosaur);
                return oldValue;
            }
            lastNode = currentNode;
            currentNode = currentNode.next();
        }

        // the animal was not found within the list, so add it
        if (lastNode != null)
            lastNode.setNext(new DinosaurListNode(dinosaur)); // lastNode!=null as head!=null (checked above)
        return null;
    }

    /**
     * Removes a dinosaur from the collection.
     * The dinosaur is identified by its DNA.
     *
     * @param dna the {@code DinosaurDNA} of the dinosaur to be removed. This must not be {@code null}.
     * @return the {@code Dinosaur} associated with the specified DNA if found and removed,
     * or {@code null} if no dinosaur with the specified DNA exists in the collection.
     */
    @Override
    public Dinosaur remove(DinosaurDNA dna) {
        // if the list is empty, return null
        if (head == null) return null;

        // if the list's head contains the animal, replace the head with head.next()
        if (head.value().getDNA().equals(dna)) {
            Dinosaur oldValue = head.value();
            head = head.next();
            return oldValue;
        }

        // otherwise traverse the list
        AbstractListNode parent = head;
        AbstractListNode currentNode = head.next();
        while (currentNode != null) {
            if (currentNode.value().getDNA().equals(dna)) {
                // current node contains the animal, so link parent node to current node's next
                parent.setNext(currentNode.next());
                return currentNode.value();
            }
            parent = currentNode;
            currentNode = currentNode.next();
        }

        // nothing was found, so return null
        return null;
    }

    /**
     * Finds and retrieves a {@code Dinosaur} associated with the given DNA from the collection.
     * If no dinosaur with the specified DNA exists in the collection, {@code null} is returned.
     *
     * @param dna the {@code DinosaurDNA} of the dinosaur to be retrieved. This must not be {@code null}.
     * @return the {@code Dinosaur} object associated with the specified DNA if found,
     * or {@code null} if no match is found.
     */
    @Override
    public Dinosaur find(DinosaurDNA dna) {
        DinosaurIterator iterator = new DinosaurIterator(head);
        while (iterator.hasNext()) {
            Dinosaur dino = iterator.next();
            if (dino.getDNA().equals(dna)) return dino;
        }
        return null;
    }

    /**
     * Checks if the collection is empty.
     *
     * @return {@code true} if the collection contains no elements, otherwise {@code false}.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Retrieves the number of elements currently stored in the collection.
     *
     * @return the total count of elements in the collection as an integer. If the collection is empty, returns 0.
     */
    @Override
    public int size() {
        int count = 0;
        for (DinosaurIterator iterator = new DinosaurIterator(head); iterator.hasNext(); iterator.next()) count++;
        return count;
    }

    /**
     * Removes all elements stored within the collection, effectively clearing its contents.
     * After this method is called, the collection will be empty.
     */
    @Override
    public void clear() {
        head = null;
    }

    /**
     * Returns a {@code ListIterator} for traversing the elements of the collection.
     * The iterator provides sequential access to the elements in the collection
     * starting from the head of the list.
     *
     * @return a {@code DinosaurIterator} instance starting from the head of the collection's list.
     */
    @Override
    public DinosaurIterator iterator() {
        return new DinosaurIterator(head);
    }

    /**
     * Returns a {@code DinosaurFilteringIterator} that allows filtered traversal of the collection.
     * The iterator applies the given filter criterion to each element of the collection to determine
     * which elements should be included during the iteration.
     *
     * @param filterCriterion the predicate used to filter elements during iteration. Only the dinosaurs
     *                        that satisfy the given predicate will be included in the iteration.
     * @return a {@code DinosaurFilteringIterator} instance configured to iterate over the collection
     * while applying the specified filter criterion.
     */
    @Override
    public DinosaurFilteringIterator filteringIterator(Predicate filterCriterion) {
        return new DinosaurFilteringIterator(head, filterCriterion);
    }
}
