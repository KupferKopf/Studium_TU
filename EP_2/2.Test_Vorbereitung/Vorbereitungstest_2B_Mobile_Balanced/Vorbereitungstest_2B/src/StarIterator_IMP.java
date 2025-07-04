import java.util.NoSuchElementException;

public class StarIterator_IMP implements StarIterator {

    private Star s;

    public StarIterator_IMP(Star newStar){
        this.s = newStar;
    }

    @Override
    public boolean hasNext() {
        return s != null;
    }

    @Override
    public Star next() {
       if(hasNext()){
           Star temp = s;
           s = null;
           return temp;
       }
       else throw new NoSuchElementException("no star element!");
    }
}
