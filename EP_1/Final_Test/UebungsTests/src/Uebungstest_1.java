import java.util.Arrays;

public class Uebungstest_1 {

    public static void main(String[] args){

        int[][] test1 = { {5, 2, 4}, {2, 7, 3}, {9, 5, 8} };
        int[][] test2 = { {1} };
        int[][] test3 = { {6, 7, 8}, {7, 5, 3, 1}, {2} };
        String seq1 = "ABBAACBA";


        int[][] result1 = generate(test1);
        System.out.println("" + Arrays.deepToString(result1));
        int[][] result2 = generate(test2);
        System.out.println("" + Arrays.deepToString(result2));

        System.out.println();

        reorder(result1);
        System.out.println("" + Arrays.deepToString(result1));
        reorder(result2);
        System.out.println("" + Arrays.deepToString(result2));
        reorder(test3);
        System.out.println("" + Arrays.deepToString(test3));

        System.out.println();

        System.out.println(isPresentNTimes(seq1, 'A', 4));
        System.out.println(isPresentNTimes(seq1, 'A', 3));
        System.out.println(isPresentNTimes(seq1, 'A', 5));
        System.out.println(isPresentNTimes(seq1, 'Z', 0));


    }


    public static int[][] generate(int[][] input){

        int[][] result = new int[input.length*2-1][];
        //System.out.println(result.length);
        for (int i = 0; i < input.length; i++){
            int[] temp = new int[input[i].length-i];
            //System.out.println(temp.length);
            for (int j = 0; j < temp.length; j++){

                temp[j] = input[i][j];
                //System.out.print(temp[j]);
            }
            //System.out.println();
            result[i] = temp;
            //System.out.println(Arrays.deepToString(result));
        }

        int pos = input.length;
        int count = 0;
        for(int i = input.length-2; i >= 0 ; i-- ){
            int[] temp = new int[input[i].length-i];
            //System.out.println(temp.length);
            for (int j = 0; j < temp.length; j++){

                temp[j] = input[i][j];
                //System.out.print(temp[j]);
            }
            //System.out.println();
            result[pos+count] = temp;
            //System.out.println(Arrays.deepToString(result));
            count++;
            //System.out.println(pos + "  " + count);
        }

        return result;
    }

    public static void reorder(int[][] input){

        //System.out.println("" + Arrays.deepToString(input));
        int[][] result = new int[input.length][];

        for (int i = 0; i < input.length; i++) {
            int[] temp = new int[input[i].length];
            for (int j = 0; j < input[i].length; j++) {

                temp[j] = input[i][j];

            }
            result[i] = temp;
        }

        //System.out.println(result.length);
        //System.out.println(Arrays.deepToString(result));

        for (int i = 0; i < input.length; i++) {
            //System.out.println(temp.length);

            for (int j = 0; j < input[i].length; j++ ){
                //System.out.println(input[i].length-j);
                input[i][j] = result[i][input[i].length-j-1];
                //System.out.println("" + Arrays.deepToString(input));
            }

        }

    }

    public static boolean isPresentNTimes(String sequence, char marker, int count){

        int zaehler = 0;
        boolean result = false;

        char temp = sequence.charAt(0);
        //System.out.println(temp);
        if(temp == marker){
            zaehler++;
        }
        //System.out.println("Zaehler: " + zaehler);
        //System.out.println("Count: " + (count-zaehler));
        count = count-zaehler;
        if(sequence.length()>1){
            sequence = sequence.substring(1);
            result = isPresentNTimes(sequence, marker, count);
            sequence = "";
        }


        if (count == 0 && sequence.length()==1){
            return true;
        }else if(result){
            return true;
        }else{
            return false;
        }
    }



}
