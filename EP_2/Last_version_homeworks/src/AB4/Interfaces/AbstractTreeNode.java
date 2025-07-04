/* DO NOT EDIT */

package AB4.Interfaces;

/**
 * Interface for a tree node.
 */
public interface AbstractTreeNode {
    /**
     * Stores a new dinosaur within the tree.
     *
     * <p>Each dinosaur is identified (so can be found) by its DNA (see interface {@code Dinosaur}).</p>
     * @param animal the new dinosaur to be stored within the tree.
     * @return the tree node in which the dinosaur was stored.
     */
    AbstractTreeNode store(Dinosaur animal);

    /**
     * Removes a dinosaur so it can no longer be found in the tree.
     *
     * @param dna the individual DNA of the dinosaur to be removed.
     * @return the tree node to which the parent node should refer to after removal. This can be the same node
     * in which the dinosaur (payload) was removed (if the node is kept within the tree),
     * or NIL {@code EmptyTreeNode} if the current node including its siblings was removed from tree.
     */
    AbstractTreeNode remove(int dna);

    /**
     * Finds and returns a Dinosaur object in the tree based on its unique DNA.
     *
     * @param dna the unique DNA encoded as {@code int} of the dinosaur to be found.
     * @return the dinosaur object with the specified DNA, or {@code null} if no such dinosaur exists in the tree.
     */
    Dinosaur find(int dna);

    /**
     * Finds a dinosaur within the tree by its name.
     *
     * @param name the name of the dinosaur to locate
     * @return the dinosaur object with the specified name, or {@code null} if no such dinosaur is found
     */
    Dinosaur findByName(String name);

    /**
     * Flattens the tree structure into an array of all dinosaurs contained within the tree.
     *
     * @return an array of non-null {@code Dinosaur} objects representing all the dinosaurs in the tree.
     */
    Dinosaur[] flatten();
}
