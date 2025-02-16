/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addChar(String text, char character) {

        if(text.isEmpty()){
            System.out.print("");
        }else if(text.length() == 1){
            System.out.print(text);
        }else{
            for (int i = 0; i < text.length(); i++) {
                if(i == 0){
                    System.out.print(text.charAt(i));
                }else if(i%2==0){
                    System.out.print(character + "" + text.charAt(i));
                }else{
                    System.out.print(character + "" + character + "" + text.charAt(i));
                }
            }
        }
        System.out.println();
    }

    private static void addChar(int number, char character) {
        String text = Integer.toString(number);
        addChar(text,character);
    }

    private static void addChar(String text, String characters) {
        for (int i = 0; i < characters.length(); i++) {
            addChar(text,characters.charAt(i));
        }
    }

    private static void addChar(String text) {
        addChar(text,'=');
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "A";
        String text2 = "CW";
        String text3 = "EP1";
        String text4 = "Index";

        addChar(text0, '&');
        addChar(text1, '+');
        addChar(text2, '*');
        addChar(text3, '-');
        addChar(text4, '#');
        System.out.println();

        addChar(1, '.');
        addChar(42, ':');
        addChar(148, '$');
        addChar(2048, ')');
        addChar(131719, '%');
        System.out.println();

        addChar(text2, "!O(");
        addChar(text4, "T1#+");
        System.out.println();

        addChar(text1);
        addChar(text2);
        addChar(text3);
    }
}
