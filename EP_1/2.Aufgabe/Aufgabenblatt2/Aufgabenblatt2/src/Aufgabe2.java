/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    //TODO: Implementieren Sie hier die in der Angabe beschriebenen Methoden

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.

        assert (isCharNTimesInString("nennenswerte Worte", 'n', 4));
        assert (!isCharNTimesInString("nennenswerte Worte", 'n', 3));
        assert (!isCharNTimesInString("nennenswerte Worte", 'e', 6));
        assert (isCharNTimesInString("Test", 'x', 0));

        assert (changeLettersInString("Hello World!").equals("Gdkkn Vnqkc!"));
        assert (changeLettersInString("Anfang und Ende.").equals("Ameamf tmc Dmcd."));
        assert (changeLettersInString("+ABC_123_DEF#").equals("+AAB_123_CDE#"));
        assert (changeLettersInString("ABCDYZ_abcdyz").equals("AABCXY_aabcxy"));

        //**********************************************************************

        //TODO: Testen Sie hier zusätzlich alle Methoden mit verschiedenen Inputs!
    }


    public static void printNumCharsInString(String text, int startIndex, int numChar){

        String endString = "";

        if(text != null && !text.isEmpty() && startIndex >= 0 && text.length() > startIndex && numChar >= 0){

            for (int i = startIndex; i < numChar+startIndex; i++) {

                if(i < text.length()){

                    endString += text.charAt(i);

                }else{

                    endString += text.charAt(i-text.length());

                }
            }

        }else{

            System.out.println("Eingabe Parameter nix gut");

        }

        System.out.println(endString);

    }


    public static void printNumbersInInterval(int start, int end){

        if(start < end) {

            for (int i = end; i >= start; i--) {

                if (i % 3 == 0) {
                    System.out.print(i + " ");
                }

            }
        }else{
            System.out.println("Eingabe Parameter nix gut, start ist größer als end");
        }
    }

    public static boolean isCharNTimesInString(String text, char character, int nTimes){
        System.out.println();
        int amount = 0;

        for (int i = 0; i < text.length(); i++) {

            if(text.charAt(i) == character){
                amount++;
            }

        }

        if(amount == nTimes){
            return true;
        }else {
            return false;
        }
    }


    public static String changeLettersInString(String text){

        String newText = "";


        if(text != null) {
            //A = 65
            //a = 97
            for (int i = 0; i < text.length(); i++) {

                if ((int) text.charAt(i) >= 66 && (int) text.charAt(i) <= 91 || (int) text.charAt(i) >= 98 && (int) text.charAt(i) <= 123) {
                    char letter = text.charAt(i);
                    letter -= 1;
                    newText += letter;
                } else {
                    newText += text.charAt(i);
                }

            }

            return newText;
        }else {
            return null;
        }
    }

}
