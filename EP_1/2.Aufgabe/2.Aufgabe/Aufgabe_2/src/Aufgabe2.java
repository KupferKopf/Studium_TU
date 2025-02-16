public class Aufgabe2 {


    public static void main(String[] args){

        printNumCharsInString("test",2,3);
        printNumbersInInterval(10,25);
        System.out.println(isCharNTimesInString("test", 't', 2));
        System.out.println(changeLettersInString("ABCDYZ_abcdyz"));
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
