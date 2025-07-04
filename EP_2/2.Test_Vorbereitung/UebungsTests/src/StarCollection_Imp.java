public class StarCollection_Imp implements StarCollection{

    private Mobile left;
    private Mobile right;

    public StarCollection_Imp(Mobile left, Mobile right){
            this.left = left;
            this.right = right;
    }


    @Override
    public boolean contains(Star s) {
        StarIterator iter = new StickIterator(left, right);

        while(iter.hasNext()){
            if(iter.next() == s) return true;
        }

        return false;
    }

    @Override
    public StarIterator iterator() {
        return new StickIterator(left, right);
    }
}
