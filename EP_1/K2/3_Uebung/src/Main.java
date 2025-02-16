public class Main {
    public static void main(String[] args) {

        short result = (short)0;
        String test = "all: hallo hall";

        System.out.println(sumUp(2,5,11));

        System.out.println("Hello world!");
        System.out.println("");


        System.out.println(addMark(test, "allo", 6));
        System.out.println(addMark(test, "all", 3));
        System.out.println(addMark(test, "hall", 3));
        System.out.println(addMark(test, "@all", 3));


        System.out.println("");
        System.out.println("Hello world!");

        printPattern(6,2);

        System.out.println("");
    }

    public static int sumUp(int d, int s, int t){

        int counter = 0;

        int divid = 0;

        for (int i = 0; s < t; i++) {

            if(s%d != 0){
                s += s%d;
            }else{
                s += 1;
                counter++;
            }

        }

        return counter;
    }


    public static String addMark(String a, String pattern, int pos){

        String text ="";

        if(a.charAt(pos) == pattern.charAt(0))
        {
            // richtig
            boolean totalPattern = true;
            for (int i = 0; i < pattern.length(); i++) {

                if(a.charAt(pos+i) != pattern.charAt(i)){
                    totalPattern = false;
                }

            }

            if(totalPattern == true){
                for (int i = 0; i <= a.length()-pos-1; i++) {
                    text += a.charAt(pos+i);
                }
            }

        }else{

            for (int i = 0; i < a.length(); i++) {
                boolean totalPattern = true;
                if(a.charAt(i) == pattern.charAt(0)) {
                    // second

                    for (int j = 0; j < pattern.length(); j++) {

                        if (a.charAt(i + j) != pattern.charAt(j)) {
                            totalPattern = false;
                        }

                    }
                    if(totalPattern = true){
                        if(i < pos){
                            text = "--" + a;
                            break;
                        }else{
                            text = a + "--";
                            break;
                        }
                    }

                }
                if(text.equals("")){
                    text = "--";
                }
            }

        }
        return text;
    }


    public static String digitsToDistance(String text){

        String numbs = "";

        for (int i = 0; i < text.length(); i++) {

            char temp = text.charAt(i);

            if(true == Character.isDigit(temp)) {
                numbs += text.charAt(i);
            }
        }


        return numbs;
    }


    public static void printPattern(int lineLength, int patternLength){

        int verschiebung = 0;


        for (;verschiebung <= lineLength-patternLength;) {

            String line = "";

            for (int i = 0; i < verschiebung; i++) {
                line += "x";
            }

            for (int i = 0; i < patternLength; i++) {
                line += "?";
            }

            for (int i = verschiebung; i < lineLength-patternLength; i++) {
                line += "y";
            }

            System.out.println(line);
            verschiebung += patternLength;
        }


    }


    /*
    * String text = "";

        for (int i = 0; i < a.length(); i++) {

            if(a.charAt(0) == a.charAt(i)){

                if(i+pattern.length() < a.length()) {

                    if (a.charAt(pattern.length() - 1) == a.charAt(i + pattern.length() - 1)) {

                        for (int j = 0; j < a.length() - pattern.length() - 2; j++) {

                            text += a.charAt(pos + j);

                        }

                    }else{
                        text += "--"+a;
                    }
                }

            }
    * */



}