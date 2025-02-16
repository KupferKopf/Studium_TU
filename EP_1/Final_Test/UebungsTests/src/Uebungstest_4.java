import java.util.Arrays;

public class Uebungstest_4 {
    public static void main(String[] args){

        int[][] test1 = {{5, 2, 4}, {8, 5, 4}, {9, 6, 8, 7}};
        int[][] test2 = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};
        int[][] test3 = {{6}, {2, 4}, {2, 4}, {2, 4}, {4, 2}};
        int[] seq1 = {4, 3, 2, 1, 10, 5, 5, 5};



        int[][] result1 = rearrange(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = rearrange(test3);
        System.out.println(Arrays.deepToString(result2));
        int[][] result3 = rearrange(new int[][]{{}});
        System.out.println(Arrays.deepToString(result3));

        System.out.println();

        label(test1);
        label(test2);
        label(test3);

        System.out.println();

        System.out.println(findMaxOppositeSum(seq1, 0, 7));
        System.out.println(findMaxOppositeSum(seq1, 0, 5));
        System.out.println(findMaxOppositeSum(seq1, 4, 7));

    }


    public static int[][] rearrange(int[][] inputArray){

        int anz = 0;
        int[][] result;

        for (int i = 0; i < inputArray.length; i++) {
            anz += inputArray[i].length;
        }
        //System.out.println(anz);

        if(anz%4 == 0){
            result = new int[anz/4][4];
        }else{
            result = new int[anz/4+1][4];
        }
        //System.out.println(result.length);

        int row = 0;
        int coloum = 0;

        for(int[] reihen : inputArray){
            for(int spalten : reihen){

                result[row][coloum] = spalten;
                coloum++;

                if(coloum%4==0){
                    coloum = 0;
                    row++;
                }

            }
        }

        return result;
    }


    public static void label(int[][] inputArray){

        int[][] temp = new int[inputArray.length][];

        for (int i = 0; i < inputArray.length; i++) {
            int[] temprow = new int[inputArray[i].length];
            for (int j = 0; j < inputArray[i].length; j++) {
                temprow[j] = inputArray[i][j];
            }
            temp[i] = temprow;
        }
        System.out.println(Arrays.deepToString(temp));

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {

                inputArray[i][j] = -9;

            }
        }


    }


    public static int findMaxOppositeSum(int[] sequence, int start, int end){

        return 0;
    }


}
