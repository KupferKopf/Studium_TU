public class Main {
    public static void main(String[] args) {


        short result = (short)getIntegerRoot(25);
        String test = "Blaukraut";

        System.out.println(result);
        System.out.println(getIntegerRoot(144));
        System.out.println(getIntegerRoot(13));
        System.out.println(getIntegerRoot(1));
        System.out.println(getThird("toss","a", "coin"));
        System.out.println(getThird("Blaukraut","bleibt",test));
        System.out.println(getThird("badger","badger","badger"));
        System.out.println(replaceA("TU Wien"));
        System.out.println(replaceA("Hubba bubba!"));
        System.out.println(replaceA("aaaa"));
        printBars(2);
        printBars(19);
        printBars(20);
        printBars(21);

        System.out.println();
        System.out.println("Break");
        System.out.println();

        printBars_2(2);
        printBars_2(19);
        printBars_2(20);
        printBars_2(21);


        printPattern(6,'?');

    }








    public static int findDoubles(String text){
        int count = 0;

        for (int i = 0; i < text.length()-1; i++) {
            if(text.charAt(i) == text.charAt(i+1) && text.charAt(i) == 'a' ) {
                count++;
            }
        }

        return count;
    }














    // wurzel ziehn möglich oder ned
    public static int getIntegerRoot(int k){

        for (int i = 0; i < k+1; i++) {
            if(i*i == k){
                return i;
            }
        }
        return -1;
    }

    public static String getThird(String a, String b, String c){

        if(a.equals(b) && b.equals(c)){
            return "alle gleich";
        }else if (a.equals(b)){
            return c;
        }else if (b.equals(c)){
            return a;
        }else if (c.equals(a)){
            return b;
        }else{
            return "alle unterschiedlich";
        }
    }

    public static String replaceA(String s){
        String copy = "";
        int aCounter = 1;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a'){
                copy += "" + aCounter;
                aCounter++;
            }else{
                copy += "" + s.charAt(i);
            }
        }
        return copy;
    }


    public static void printBars(int i){

        for (int k = 0; k < 2; k++) {
            int symbol = 0;
            for (int j = 1; j < i+1; j++) {
                if(j % 3 != 0 && k == 0){
                    System.out.print(j);
                    if(symbol == 0){
                        System.out.print("-");
                        symbol++;
                    }else{
                        System.out.print("+");
                        symbol--;
                    }
                }
                if(j % 3 == 0 && k == 1){
                    System.out.print(j);
                    if(symbol == 0){
                        System.out.print("+");
                        symbol++;
                    }else{
                        System.out.print("-");
                        symbol--;
                    }
                }
            }
            if(k==0){System.out.println();}
        }
        System.out.println();
    }


    public static void printBars_2(int i){
        String first = "";
        int zeichen_1 = 0;
        String second = "";
        int zeichen_2 = 0;

        for (int j = 1; j < i+1; j++) {
            if(j % 3 == 0){
                second += j;
                if(zeichen_2 == 0){
                    second += "+";
                    zeichen_2++;
                }else{
                    second += "-";
                    zeichen_2--;
                }
            }else{
                first += j;
                if(zeichen_1 == 0){
                    first += "-";
                    zeichen_1++;
                }else{
                    first += "+";
                    zeichen_1--;
                }
            }
        }


        System.out.println(first);
        if(!second.isEmpty()) System.out.println(second);
    }





    public static void printPattern(int n, char character){
        for (int i = 0; i < n; i++) {
            String muster = "";

            if(i % 2 != 0) {
                for (int j = 0; j < n*2; j++) { // nur zeichen
                    muster += character;
                }
            }else {
                for (int j = 0; j < n; j++) { // zeichen und .
                    muster += character + "" + '.';
                }
            }
            muster += i+1;
            System.out.println(muster);
        }

    }
















/* K2 test NR 1

    public static int countDivisors(int x, int y)
    {
        int count = 0;
        for (int i = x; i <= y; i++) {
            if(i % 4 == 0 && i % 6 != 0){
                count ++;
            }
        }
        return count;
    }



    public static String reverseInsert(String text, char character){

        String word = "";

        for (int i = text.length()-1; i > 0; i--) {
            word += text.charAt(i) + "" + character;
        }

        return word + text.charAt(0);
    }


*/

}