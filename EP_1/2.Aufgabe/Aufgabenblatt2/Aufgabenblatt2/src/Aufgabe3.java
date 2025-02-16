/*
    Aufgabe 3) Schleifen und Methoden - Harshad-Zahlen
*/
public class Aufgabe3 {

    private static boolean isHarshadNumber(int number) {
        int sum = 0;
        int numHolder = number;

        if(number > 0) {

            while (numHolder > 0) {
                sum += numHolder % 10;
                numHolder = numHolder / 10;
            }

            if (number % sum == 0) {
                return true;
            } else {
                return false;
            }
        }else {
            System.out.println("number muss positiv sein duuuh");
            return false;
        }
    }

    private static void printHarshadNumbersInInterval(int start, int end) {
        if(start > 0 && end > 0 && start <= end) {

            for (int i = start; i <= end; i++) {

                if (isHarshadNumber(i)) {
                    System.out.print(i + " ");
                }
            }
        }else{
            System.out.println("Start und ende müssen positiv sein und end muss nach start sein");
        }
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHarshadNumber(...).
        System.out.println("1 --> " + isHarshadNumber(1));
        assert (isHarshadNumber(1));
        System.out.println("4 --> " + isHarshadNumber(4));
        assert (isHarshadNumber(4));
        System.out.println("13 --> " + isHarshadNumber(13));
        assert (!isHarshadNumber(13));
        System.out.println("97 --> " + isHarshadNumber(97));
        assert (!isHarshadNumber(97));
        System.out.println("777 --> " + isHarshadNumber(777));
        assert (isHarshadNumber(777));
        System.out.println("8316 --> " + isHarshadNumber(8316));
        assert (isHarshadNumber(8316));
        System.out.println("9214 --> " + isHarshadNumber(9214));
        assert (!isHarshadNumber(9214));
        System.out.println("172986 --> " + isHarshadNumber(172986));
        assert (isHarshadNumber(172986));
        //**********************************************************************

        //TODO: Testen Sie hier alle Methoden mit verschiedenen Inputs!
    }
}
