/* DO NOT EDIT */
package AB5.Interfaces;

/**
 * Represents an abstract node in a linked list data structure.
 * This interface defines the foundational contract for managing and navigating
 * through linked list nodes that store values and references to subsequent nodes.
 *
 * <p>Implementations of this interface should manage the current node's value and
 * a reference to the next node in the list. The type encapsulated in these nodes
 * is {@code Dinosaur}.</p>
 */
public interface AbstractListNode {

    /**
     * Retrieves the next node in the linked list.
     * This method returns the next {@code AbstractListNode} that the current node points to,
     * or {@code null} if there is no such node.
     *
     * @return the next {@code AbstractListNode} in the sequence, or {@code null} if no next node exists.
     */
    AbstractListNode next();

    /**
     * Sets the next node in the linked list.
     * This method updates the reference of the current node to point to the specified next node.
     *
     * @param next the {@code AbstractListNode} that should be assigned as the next node
     *             of this current node. It can be {@code null} if there is no next node.
     */
    void setNext(AbstractListNode next);

    /**
     * Retrieves the value stored in this node.
     * The value represents a reference to a {@code Dinosaur} object
     * encapsulated by the current node.
     *
     * @return the {@code Dinosaur} object stored in this node
     */
    Dinosaur value();

    /**
     * Sets the value stored in this node.
     * This method updates the current node with the specified {@code Dinosaur} value.
     *
     * @param value the {@code Dinosaur} object that should be stored in this node.
     */
    void setValue(Dinosaur value);
}
