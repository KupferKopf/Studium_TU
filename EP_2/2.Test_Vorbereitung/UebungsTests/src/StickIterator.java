import java.util.NoSuchElementException;

public class StickIterator implements StarIterator{

    private StarIterator leftIt;
    private StarIterator rightIt;


    public StickIterator(Mobile left, Mobile right){
        this.leftIt = left.iterator();
        this.rightIt = right.iterator();
    }

    @Override
    public boolean hasNext() {
        return leftIt.hasNext() || rightIt.hasNext();
    }

    @Override
    public Star next() throws NoSuchElementException {
        if(!hasNext()) throw new NoSuchElementException("no star element!");
        if(leftIt.hasNext()) return leftIt.next();
        return rightIt.next();
    }
}
