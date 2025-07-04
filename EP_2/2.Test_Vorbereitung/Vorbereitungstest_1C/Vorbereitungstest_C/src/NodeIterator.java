public class NodeIterator {


    private Node current;
    private NodeIterator left;
    private NodeIterator right;


    public NodeIterator(Node root){
        current = root;
        if(root.getLeft() != null) left = root.getLeft().getIterator();
        if(root.getRight() != null) right = root.getRight().getIterator();
    }


    public boolean hasNext(){

        return current != null || (left != null &&left.hasNext()) || (right != null && right.hasNext());
    }

    public Node next(){
        if(!hasNext()) return null;


        if (left != null && left.hasNext()) return left.next();

        if(current != null){
            Node temp = current;
            current = null;
            return temp;
        }

        if(right != null && right.hasNext()) return right.next();

        return null;
    }


}
