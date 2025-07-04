import java.util.NoSuchElementException;

public class StarIterator_Imp implements StarIterator {

    private Star star;

    public StarIterator_Imp(Star s) { //TODO noch fixen wie man itteriert
        star = s;
    }


    @Override
    public boolean hasNext() {
        return star != null;
    }

    @Override
    public Star next() {
        if (star != null) {
            Star retS = star;
            star = null;
            return retS;
        }
        throw new NoSuchElementException("no star element!");
    }
}
