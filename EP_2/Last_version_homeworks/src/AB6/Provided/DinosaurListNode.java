/* DO NOT EDIT */
package AB6.Provided;

import AB6.Interfaces.AbstractListNode;
import AB6.Interfaces.Dinosaur;

/**
 * Represents a node in a linked list that stores a {@code Dinosaur} object.
 * Each node consists of a {@code Dinosaur} value and a reference to the next node in the list.
 *
 * <p>This class is an implementation of the {@code AbstractListNode} interface,
 * providing concrete behavior for managing and navigating through a linked list
 * of {@code Dinosaur} objects.</p>
 */
public class DinosaurListNode implements AbstractListNode {
    private Dinosaur value;
    private AbstractListNode next;

    /**
     * Constructs a new {@code DinosaurListNode} with the specified {@code Dinosaur} value.
     *
     * @param value the {@code Dinosaur} object to be stored in this node. Must not be null.
     */
    public DinosaurListNode(Dinosaur value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Retrieves the next node in the linked list.
     * This method returns the next {@code AbstractListNode} referenced by the current node.
     *
     * @return the next {@code AbstractListNode} in the sequence, or {@code null} if no next node exists.
     */
    @Override
    public AbstractListNode next() {
        return next;
    }

    /**
     * Updates the reference to the next node in the linked list sequence.
     * This method sets the current node's next reference to the specified node,
     * which can be used to link nodes in the list.
     *
     * @param next the {@code AbstractListNode} to be set as the next node
     *             in the linked list. Can be {@code null} if there is no next node.
     */
    @Override
    public void setNext(AbstractListNode next) {
        this.next = next;
    }

    /**
     * Retrieves the value stored in this node.
     * The value represents a {@code Dinosaur} object
     * encapsulated by this node.
     *
     * @return the {@code Dinosaur} object stored in this node.
     */
    @Override
    public Dinosaur value() {
        return value;
    }

    /**
     * Updates the value stored in this node with the specified {@code Dinosaur} object.
     * This method allows the value within the node to be replaced by another {@code Dinosaur} instance.
     *
     * @param value the {@code Dinosaur} object to be stored in this node.
     *              Must not be {@code null}.
     */
    @Override
    public void setValue(Dinosaur value) {
        this.value = value;
    }
}
