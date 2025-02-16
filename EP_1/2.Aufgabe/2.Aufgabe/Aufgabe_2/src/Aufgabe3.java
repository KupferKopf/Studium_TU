public class Aufgabe3 {

    public static void main(String[] args){

        System.out.println(isHarshadNumber(777));
        printHarshadNumbersInInterval(51,79);

    }

    public static boolean isHarshadNumber(int number){

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

    public static void printHarshadNumbersInInterval(int start, int end){

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



}
