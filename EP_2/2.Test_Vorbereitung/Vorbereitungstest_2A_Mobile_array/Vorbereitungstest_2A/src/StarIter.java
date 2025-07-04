public class StarIter implements StarIterator{

    private Star star;


    public StarIter(Star star){
        this.star = star;
    }


    public boolean hasNext(){
        return star != null;
    }


    public Star next(){
        if(!hasNext()) return null;
        Star temp = star;
        star = null;
        return temp;
    }


}
