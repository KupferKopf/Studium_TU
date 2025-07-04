public class Node {

    private Node left;
    private Node right;

    private IntConst key;
    private IntConst value;


    public Node(IntConst key, IntConst value){
        this.key = key;
        this.value = value;
    }


    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public IntConst getKey() {
        return key;
    }

    public IntConst getValue() {
        return value;
    }

    public void setValue(IntConst value) {
        this.value = value;
    }

    public void setKey(IntConst key) {
        this.key = key;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }


    public NodeIterator getIterator(){
        return new NodeIterator(this);
    }


}
