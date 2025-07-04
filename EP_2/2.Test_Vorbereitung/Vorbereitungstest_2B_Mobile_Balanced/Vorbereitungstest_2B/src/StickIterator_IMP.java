import java.util.NoSuchElementException;

public class StickIterator_IMP implements StarIterator {

    private StarIterator left;
    private StarIterator right;

    public StickIterator_IMP(Mobile left, Mobile right) {

        this.left = left.iterator();
        this.right = right.iterator();

    }

    @Override
    public boolean hasNext() {
        return left.hasNext() || right.hasNext();
    }

    @Override
    public Star next() {

        if(hasNext()){
            if(left.hasNext()){
                return left.next();
            }else{
                return right.next();
            }
        }
        else throw new NoSuchElementException("no star element!");
    }
}
