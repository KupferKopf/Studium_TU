/*
    Aufgabe 5) Rekursion
*/
public class Aufgabe5 {

    private static String orderCharGroups(String text) {

        String sortedChars = "";

        if(text.length() <= 2){
            return text;
        }else{

            sortedChars = orderCharGroups(text.substring(1));
            sortedChars = text.charAt(0) + sortedChars;
            if(sortedChars.charAt(0) != sortedChars.charAt(1) && sortedChars.charAt(0) != sortedChars.charAt(2) || sortedChars.charAt(0) != sortedChars.charAt(1) && sortedChars.charAt(0) == sortedChars.charAt(2)){
                sortedChars = sortedChars.substring(1) + sortedChars.charAt(0);
            }
        }
        return sortedChars;
    }

    /*
    *
    * 1212
    *  212
    *   12
    *
    *  2+12 X -> 122
    *  1+122 Y -> 1122
    *
    */



    public static void main(String[] args) {

        System.out.println(orderCharGroups(""));
        System.out.println(orderCharGroups("1"));
        System.out.println(orderCharGroups("12"));
        System.out.println(orderCharGroups("1212"));
        System.out.println(orderCharGroups("abbaaababbaa"));
        System.out.println(orderCharGroups("ABBA"));
        System.out.println(orderCharGroups("11221122"));
        System.out.println(orderCharGroups("AAAAAA"));
        System.out.println();

    }
}
