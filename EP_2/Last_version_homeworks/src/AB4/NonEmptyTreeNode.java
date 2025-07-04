package AB4;

import AB4.Interfaces.AbstractTreeNode;
import AB4.Interfaces.Dinosaur;

/**
 * Represents a non-empty node in a binary tree structure.
 *
 * <p>This class implements the {@code AbstractTreeNode} interface and encapsulates the functionality
 * of storing and retrieving a {@code Dinosaur} within a binary tree.</p>
 * <p>Each {@code NonEmptyTreeNode} instance represents a node for a specific DNA (key) and may contain a {@code Dinosaur}
 * as its value. The node also contains references to its left and right child nodes, where the left child's key is
 * smaller than the node's key and the right child's key is larger than the node's key. Child nodes are always non-null.</p>
 */
public class NonEmptyTreeNode implements AbstractTreeNode {
    private int key; //DNA
    private Dinosaur dino;
    private AbstractTreeNode left;
    private AbstractTreeNode right;
    private NonEmptyTreeNode parent;


    /**
     * Constructs a {@code NonEmptyTreeNode} that containing a given Dinosaur object.
     * <p>The node initializes its key and value attributes using the provided Dinosaur and initializes its left and right
     * children of type {@code AbstractTreeNode} to indicate that it initially has no child nodes.</p>
     * @param animal the Dinosaur object to be stored in the tree node.
     *               The DNA of this Dinosaur is used as the key, and the Dinosaur itself is the value of the node.
     */
    NonEmptyTreeNode(Dinosaur animal) {
        if(animal == null){
            //System.out.println("| NonEmptyTreeNode | constructor | ERROR | given Dino is null");
            return;
        }
        key = animal.getDNA();
        dino = animal;
        left = new EmptyTreeNode();
        right = new EmptyTreeNode();
    }

    /**
     * Stores a given Dinosaur within the tree.
     *
     * <p>The method uses the dinosaur's DNA as the key to determine the correct position
     * within the tree. If the DNA matches the current node's key, the existing value is updated.
     * If the DNA is less than the current node's key, the Dinosaur is stored in the left subtree.
     * Otherwise, the Dinosaur is stored in the right subtree.</p>
     *
     * @param animal the Dinosaur object to be stored in the tree. The dinosaur's DNA is used to determine the storage location.
     * @return the current tree node (the node where the parent node should point to) after the dinosaur has been stored.
     */
    @Override
    public AbstractTreeNode store(Dinosaur animal) {

        if(key == animal.getDNA()){
            this.dino = animal;
            return this;
        }
        if(animal.getDNA() < key){
            if(left.getClass() != EmptyTreeNode.class) {
                //System.out.println("| NonEmptyTreeNode | store | INFO | going left: " + animal.getDNA() + "< " + key);
                left.store(animal); // falls es links gibt weiter runter
            }else {
                //System.out.println("| NonEmptyTreeNode | store | INFO | added animal, ended left");
                NonEmptyTreeNode temp = (NonEmptyTreeNode) left.store(animal); // to set the parent after creating the child
                temp.parent = this;
                left = temp;
            }
        }else { // animal.getDNA() > key
            if (right.getClass() != EmptyTreeNode.class) {
                //System.out.println("| NonEmptyTreeNode | store | INFO | going right: " + animal.getDNA() + ">" + key);
                right.store(animal); //falls es rechts gibt weiter runter
            } else{
                //System.out.println("| NonEmptyTreeNode | store | INFO | added animal, ended right");
                NonEmptyTreeNode temp = (NonEmptyTreeNode) right.store(animal); // to set the parent after creating the child
                temp.parent = this;
                right = temp;
            }
        }
        return this;
    }

    /**
     * Removes the dinosaur identified by the given DNA from the tree.
     *
     * <p>The method clears the value (payload) of the node (set value to null) if the DNA matches the key of the current node.
     * If the current node does not have any child nodes after removal, it transitions into an empty node (NIL).</p>
     *
     * <p>If the DNA does not match the key, the operation is delegated to the left or right child node
     * based on whether the DNA is less than or greater than the key of the current node.</p>
     *
     * @param dna the unique integer encoded DNA of the dinosaur to be removed.
     * @return the current tree node after the removal operation or {@code EmptyTreeNode.NIL} after transitioning to an empty node.
     */
    @Override
    public AbstractTreeNode remove(int dna) {

        if(key == dna){ // wenn das der richtige knöten ist

            if(left.getClass() != EmptyTreeNode.class || right.getClass() != EmptyTreeNode.class){ // wenn eins ned null ist
                dino = null;
                return this;
            }else{ // wenn beide null sind
                return NILYourself(key);
            }

        }else{ // falls ned das richtige

            if(dna < key){ // also nach links

                AbstractTreeNode ret = left.remove(dna);
                NILYourself(key); // checken ob beide kinder jetzt NIL sind
                return this;

            }else if(dna > key){ // also nach rechts

                AbstractTreeNode ret = right.remove(dna);
                NILYourself(key); // checken ob beide kinder jetzt NIL sind
                return this;


            }else{ // however this can happen but in that case fuck you
                //System.out.println("| NonEmptyTreeNode | remove | INFO | dino with dis DNA: " + dna + " could not be found");
                return null;
            }
        }
    }


    private AbstractTreeNode NILYourself(int dna){ // wenn beide left & right NIL sind und das hier auch value = null ist -> NIL yourself
        if(left.getClass() == EmptyTreeNode.class && right.getClass() == EmptyTreeNode.class && dino == null){
            if(parent == null) return new EmptyTreeNode(); // dann ist einfach alles tot
            EmptyTreeNode empty = new EmptyTreeNode();              //emptyNode zum reinspeichern

            if(parent.getKey() > dna) parent.setLeft(empty);       // bin ich left child
            else if(parent.getKey() < dna) parent.setRight(empty); // oder doch right child
            return empty;
        }
        return null; // noch alles gut
    }

    /**
     * Finds and returns a Dinosaur object in the tree based on its unique DNA identifier.
     *
     * <p>The method recursively traverses the tree, comparing the provided DNA with the node's key.
     * If the DNA matches the key, the corresponding Dinosaur is returned. If the DNA is less than
     * the key, the method continues its search in the left subtree. Otherwise, the search proceeds
     * in the right subtree.</p>
     *
     * @param dna the unique DNA, encoded as an {@code int}, of the dinosaur to be found.
     * @return the Dinosaur object with the specified DNA, or {@code null} if no such dinosaur is found in the tree.
     */
    @Override
    public Dinosaur find(int dna) {

        if(key == dna){
            //System.out.println("| NonEmptyTreeNode | find | INFO | Dino found with DNA: " + dna);
            return dino;
        }else{
            if(dna < key){
                return left.find(dna);
            }else{
                return right.find(dna);
            }
        }
    }


    /**
     * Finds a dinosaur within the tree by its name.
     *
     * <p>The method searches the current tree node and recursively checks
     * its left and right children to locate a dinosaur with the specified name.</p>
     *
     * @param name the name of the dinosaur to locate
     * @return the dinosaur object with the specified name, or {@code null} if no such dinosaur is found
     */
    @Override
    public Dinosaur findByName(String name) {

        if(dino.getName().equals(name)){

            //System.out.println("| NonEmptyTreeNode | findByName | INFO | Dino found with the name: " + name);
            return dino;

        }else{

            Dinosaur resultL = left.findByName(name);
            Dinosaur resultR = right.findByName(name);

            if(resultL != null) return resultL;
            if(resultR != null) return resultR;
            return null;

        }
    }

    /**
     * Flattens the tree into an array of Dinosaur objects using an in-order traversal.
     *
     * <p>This method iterates through the tree's structure by performing:<br>
     * 1. A recursive flattening of the left subtree.<br>
     * 2. Adding the current node's value if it exists, so it is not equal to {@code null}.<br>
     * 3. A recursive flattening of the right subtree.</p>
     *
     * @return an array of {@code Dinosaur} objects representing all dinosaurs in the tree,
     * sorted by their DNA in ascending order.
     */
    @Override
    public Dinosaur[] flatten() {

        Dinosaur[] leftAr = left.flatten();
        Dinosaur[] rightAr = right.flatten();
        Dinosaur[] retAr;
        Dinosaur middle = dino;

        retAr = new Dinosaur[leftAr.length + 1 + rightAr.length];

        if(leftAr.length != 0){
            System.arraycopy(leftAr, 0, retAr, 0, leftAr.length);
        }
        retAr[leftAr.length] = middle;
        if(rightAr.length != 0){
            System.arraycopy(rightAr, 0, retAr, leftAr.length+1, rightAr.length);
        }

        return retAr;
    }


    @Override
    public String toString() {
        return "NonEmptyTreeNode{" +
                "key=" + key +
                ", dino=" + dino +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    // GETTERS AND SETTERS

    /**
     * Retrieves the key of the current tree node.
     *
     * @return the key of the current tree node, represented as an {@code int}.
     */
    public int getKey() {
        return key;
    }

    /**
     * Retrieves the left child node of the current tree node.
     *
     * @return the left child node represented as an {@code AbstractTreeNode}.
     */
    public AbstractTreeNode getLeft() {
        return left;
    }

    /**
     * Retrieves the right child node of the current tree node.
     *
     * @return the right child node represented as an {@code AbstractTreeNode}.
     */
    public AbstractTreeNode getRight() {
        return right;
    }

    /**
     * Sets the left child node of the current tree node.
     *
     * <p>Precondition: (left != null) </p>
     * @param left the left child node to be assigned, represented as an {@code AbstractTreeNode}.
     */
    public void setLeft(AbstractTreeNode left) {
        this.left = left;
    }

    /**
     * Sets the right child node of the current tree node.
     *
     * <p>Precondition: (right != null) </p>
     * @param right the right child node to be assigned, represented as an {@code AbstractTreeNode}.
     */
    public void setRight(AbstractTreeNode right) {
        this.right = right;
    }


    public void setParent(NonEmptyTreeNode parent){
        this.parent = parent;
    }


    public AbstractTreeNode getParent(){
        return parent;
    }


}
