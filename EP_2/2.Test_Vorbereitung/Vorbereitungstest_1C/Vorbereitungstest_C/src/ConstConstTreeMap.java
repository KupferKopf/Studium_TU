/**
 * This data structure maps keys ('IntConst' objects) to values ('IntConst' objects).
 * It is implemented as a binary search tree where keys are ordered according to the order
 * relation of the 'IntConst' class defined by its 'lessThan' and 'isEqual' method.
 * For the keys k1 and k2 of any two mappings in this map the following condition holds:
 * k1.isEqual(k2) == false.
 * There is no limit on the number of key-value mappings stored in the map.
 */
//
// TODO: Complete the methods in 'ConstConstTreeMap'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'ConstConstTreeMap' or any other class.
//
public class ConstConstTreeMap {

    private Node root;


    /**
     * Initializes 'this' as an empty map.
     */
    public ConstConstTreeMap() {
    }

    /**
     * Initializes this map as a copy of the specified 'map'. This map has the same key-value
     * mappings as 'map'. If 'map' is changed later, it will not affect 'this' and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     */
    public ConstConstTreeMap(ConstConstTreeMap map) {


        IntConstQueue queue = new IntConstQueue();
        map.addAllKeysTo(queue);

        while(queue.size() > 0){
            IntConst temp = queue.poll();
            this.put(temp, map.get(temp));
        }
    }

    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, 'null' is returned.
     *
     * @param key   a variable != null.
     * @param value the constant to be associated with the key (can also be 'null').
     * @return the old value if the key already existed in this map, or 'null' otherwise.
     */
    public IntConst put(IntConst key, IntConst value) {

        if (root == null) {
            root = new Node(key, value);
            return null;
        }

        Node currentNode = root;

        while (true) {
            if (currentNode.getKey().isEqual(key)) {
                IntConst temp = currentNode.getValue();
                currentNode.setValue(value);
                return temp;
            }
            if (currentNode.getKey().lessThan(key)) { // current ist kleiner als key -> nach rechts weiter

                if (currentNode.getRight() == null) { // noch ned drinnen
                    currentNode.setRight(new Node(key, value));
                    return null;
                } else {
                    currentNode = currentNode.getRight();
                }

            } else { // current ist groesser als key -> nach links weiter

                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new Node(key, value));
                    return null;
                } else {
                    currentNode = currentNode.getLeft();
                }
            }
        }
    }

    /**
     * Returns the value associated with the specified key. Returns 'null' if the key is not
     * contained in this map.
     *
     * @param key a constant != null.
     * @return the value associated with the specified key (or 'null' if the key is not contained in
     * this map).
     */
    public IntConst get(IntConst key) {

        if (root == null) return null;

        Node current = root;

        while (true) {
            if (current.getKey().isEqual(key)) {
                return current.getValue();
            }
            if (key.lessThan(current.getKey())) {
                if (current.getLeft() == null) return null;
                current = current.getLeft();
            } else {
                if (current.getRight() == null) return null;
                current = current.getRight();
            }
        }

    }

    /**
     * Adds all keys of this map to the specified queue in the key order of this tree
     * (the smallest key is added first to the queue).
     *
     * @param queue the queue, which is not null.
     */
    public void addAllKeysTo(IntConstQueue queue) {

        NodeIterator iter = getIterator();

        while (iter.hasNext()){
            queue.add(iter.next().getKey());
        }

        //queue = inOrder(root);

    }


    private IntConstQueue inOrder(Node start){

        Node current = start;
        IntConstQueue left;
        IntConstQueue right;
        IntConstQueue ret = new IntConstQueue();

        if(current.getLeft() != null) {
            left = inOrder(current.getLeft());
            while(left.size() > 0){
                ret.add(left.poll());
            }
        }

        ret.add(current.getKey());

        if(current.getRight() != null) {
            right = inOrder(current.getRight());
            while(right.size() > 0){
                ret.add(right.poll());
            }

        }
        return ret;
    }


    public NodeIterator getIterator(){
        return new NodeIterator(root);
    }



}

// TODO: define further classes, if needed (either here or in a separate file).
