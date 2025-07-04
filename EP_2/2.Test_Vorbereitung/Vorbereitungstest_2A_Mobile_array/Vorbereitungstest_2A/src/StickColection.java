import java.util.LinkedList;

public class StickColection implements StickSet{

    private LinkedList<Stick> sticks = new LinkedList<>();
    private StickIter iter;

    public StickColection(Stick stick, Mobile[] anhang) {
        iter = new StickIter(stick, anhang);
        int pos = 0;
        while (iter.hasNextStick()) {
            Stick temp = iter.nextStick();
            //System.out.println(temp);
            if(!sticks.contains(temp))                sticks.add(temp);
            //System.out.println(pos);
            pos++;
        }
    }

    @Override
    public int size() {
        return sticks.size();
    }

    @Override
    public boolean contains(Stick element) {
        for(Stick stick : sticks){

            if(stick.equals(element)) return true;

        }
        return false;
    }
}
