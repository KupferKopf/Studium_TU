import java.util.Random;
public class Zeitschleife {

    public static void main(String[] args){

        int size = 1000;
        int[] zeitSch = zeitMessung(size);
        printArray(zeitSch);
        boolean zeitTest = checkZeitschleife(zeitSch);
    }

    public static boolean checkZeitschleife(int[] array){
        boolean result = false;
        int pos = 1;
        for (int i = 0; i < array.length; i++){

            if(array[i] == array[0] && array[i+1] == array[1] && array[i+2] == array[2] && pos!=1){
                System.out.println("Zeitschleifer erkannt and Postion: " + pos);
                System.out.println(array[i] + " | " + array[i+1] + " | " + array[i+2]);
                result = true;
            }

            pos++;
        }
        return result;
    }

    public static int[] zeitMessung(int size){

        int[] timeMes = new int[size];
        Random randy = new Random(0); // vlt mit seed 0 wenn man fix ne schleife braucht
        for (int i = 0; i < size; i++) {
            timeMes[i] = (randy.nextInt(0,10));
        }
        return timeMes;
    }

    public static void printArray(int[] array){
        for (int j : array) {
            System.out.print(j);
        }
        System.out.println();
    }





}
