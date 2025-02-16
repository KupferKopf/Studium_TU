/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static boolean isStartAndEndSeq(String text, String sequence) {

        boolean contains = false; // the first boolean for the first sequence
        boolean contains_2 = false; // the second boolean for the second sequence

        int pos = text.length() - sequence.length();

        if(text.isEmpty()){ // cant have that if the text is to short or empty
            return false;
        }

        if(sequence.isEmpty()){
            return false;
        }

        if(text.length() < sequence.length()*2){
            return false;
        }

        if(text.charAt(0) == sequence.charAt(0) && text.charAt(pos) == sequence.charAt(0)){
            contains = true;
            if(sequence.length() > 1) {
               contains_2 = isStartAndEndSeq(text.substring(1, pos) + text.substring(pos), sequence.substring(1));
            }else{
                contains_2 = true;
            }
        }else{
            return false;
        }

        if(contains && contains_2){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isStartAndEndSeq("", "1"));
        System.out.println(isStartAndEndSeq("AA", "A"));
        System.out.println(isStartAndEndSeq("ABBAB", "AB"));
        System.out.println(isStartAndEndSeq("ABBBA", "AB"));
        System.out.println(isStartAndEndSeq("ottootto", "otto"));
        System.out.println(isStartAndEndSeq("otto", "otto"));
        System.out.println(isStartAndEndSeq("ottotto", "otto"));
        System.out.println(isStartAndEndSeq("ottoottt", "otto"));
        System.out.println(isStartAndEndSeq("test1234test", "test"));
        System.out.println(isStartAndEndSeq("NEN", "NEEN"));

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (isStartAndEndSeq("", "1") == false);
        assert (isStartAndEndSeq("AA", "A") == true);
        assert (isStartAndEndSeq("ABBAB", "AB") == true);
        assert (isStartAndEndSeq("ABBBA", "AB") == false);
        assert (isStartAndEndSeq("ottootto", "otto") == true);
        assert (isStartAndEndSeq("otto", "otto") == false);
        assert (isStartAndEndSeq("ottotto", "otto") == false);
        assert (isStartAndEndSeq("ottoottt", "otto") == false);
        assert (isStartAndEndSeq("test1234test", "test") == true);
        assert (isStartAndEndSeq("NEN", "NEEN") == false);
        //**********************************************************************
    }
}

/*



boolean contains = false; // the first boolean for the first sequence
        boolean contains_2 = false; // the second boolean for the second sequence

        if(text.length() < sequence.length() || text.isEmpty()){ // cant have that if the text is to short or empty
            return false;
        }else{
            if(text.substring(0,sequence.length()).equals(sequence)){
                contains = true;
            }else{
                return false;
            }
            if(text.length() - sequence.length() > 0) {
                int BegEndSeq = text.length() - sequence.length(); // begin punkt der endsequenz
                System.out.print(BegEndSeq + " ");
                contains_2 = isStartAndEndSeq(text.substring(BegEndSeq), sequence);
            }
        }
        System.out.println( contains + " " + contains_2);
        if(contains && contains_2){
            return true;
        }else {
            return false;
        }



*/
