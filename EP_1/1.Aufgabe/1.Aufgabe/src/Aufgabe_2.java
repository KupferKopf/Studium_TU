public class Aufgabe_2 {

    public static void main(String[] args) {

        String text = "Eine nennenswerte und geeignete Sprache.";
        String test = "Anzahl der Zeichen ist nicht genug!";


        System.out.println("Start Aufgabe 2");
        System.out.println();
        System.out.println("Aufgabe a");
        seperateNouns(text);
        seperateNouns(test);

        System.out.println();
        System.out.println("Aufgabe b");
        afterJ(text);
        afterJ(test);

        System.out.println();
        System.out.println("Aufgabe c");
        fiveNotSeven(35, 175);


    }

    //a
    public static void seperateNouns(String sentence){
        int i = 0;
        String result = "";
        String toLower = sentence.toLowerCase();
        while(i < toLower.length()) {
            char stell = toLower.charAt(i);
            switch (stell) {
                case 'a':
                    result += "-"+sentence.charAt(i);
                    break;
                case 'e':
                    result += "-"+sentence.charAt(i);
                    break;
                case 'i':
                    result += "-"+sentence.charAt(i);
                    break;
                case 'o':
                    result += "-"+sentence.charAt(i);
                    break;
                case 'u':
                    result += "-"+sentence.charAt(i);
                    break;
                default:
                    result += sentence.charAt(i);
            }
            i++;
        }
        System.out.println(result);
    }


    //b
    public static void afterJ(String text){
        int i = 0;
        char stelle = ' ';
        int value = 0;
        String newString = "";
        String toLower = text.toLowerCase();

        /*
        System.out.print((int)'a' + " = a | " + (int)'j' + " = j | " + (int)'k' + " = k | " + (int)'!' + " = ! | " + (int)'.' + " = . | " + (int)' ' + " =   | ");
        System.out.println();
        */

        while(i<text.length()){
            stelle = toLower.charAt(i);
            value = (int)stelle;
            if(value > 106 || value < 97 && value != 32){
                newString += text.charAt(i);
            }
            i++;
        }

        System.out.println(newString);
    }


    //c
    public static void fiveNotSeven(int intBegin, int intEnd){
        int i = intBegin;
        String numbs = "";

        while(i<intEnd){

            if(i%5==0 && i%7==0){
                numbs += i + " ";
            }
            i++;
        }

        System.out.println(numbs);
    }


}
