public class StarCollection_IMP implements StarCollection {


    private Mobile mob;

    public StarCollection_IMP(Mobile obj) {
        mob = obj;
    }

    @Override
    public boolean contains(Star s) {
        StarIterator iter = mob.iterator();

        while(iter.hasNext()){
            Star temp = iter.next();
            if(temp == s) return true;
        }
        return false;
    }

    @Override
    public StarIterator iterator() {
        return mob.iterator();
    }
}
