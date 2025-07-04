import java.util.NoSuchElementException;

public class StickIter implements StarIterator{

    private Stick stick;
    private StarIterator[] iters;

    public StickIter(Stick stick, Mobile[] attached){
        this.stick = stick;
        iters = new StarIterator[attached.length];
        for(int i = 0; i < attached.length; i++){
            iters[i] = attached[i].iterator();
        }
    }

    public boolean hasNextStick(){
        if(stick != null) return true;
        for(StarIterator iter : iters){
            if(iter.getClass().equals(StickIter.class)){
                if(((StickIter) iter).hasNextStick()) return true;
            }
        }
        return false;
    }


    public Stick nextStick(){
        if(!hasNextStick()) return null;
        for(StarIterator iter : iters){
            if(iter.getClass().equals(StickIter.class)){
                if(((StickIter) iter).hasNextStick()){
                    Stick temp =  ((StickIter) iter).nextStick();
                    //System.out.println(temp);
                    return temp;
                }
            }
        }
        Stick temp = stick;
        stick = null;
        return temp;
    }


    @Override
    public boolean hasNext() {
        for( StarIterator iter : iters){
            if(iter.hasNext()) return true;
        }
        return false;
    }

    @Override
    public Star next() {
        if(!hasNext()) throw new NoSuchElementException("no star element!");
        for(StarIterator iter : iters){
            if(iter.hasNext()) return iter.next();
        }
        return null;
    }
}
