/*
    Aufgabe 4) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe4 {

    private static int[][] generateFilled2DArray(int n) {

        int[][] field = new int[n][n];

        if(n == 1){
            field[0][0] = 1;
            return field;
        }else if (n == 3){
            field[n/2][n/2] = 1;
        } else {



            for (int i = 0; i < n; i++) {
                int start = 1+i;
                int buffer = start-2;
                for (int j = 0; j < n; j++) {

                    while(start > 1) {
                        field[i][j] = start;
                        start--;
                        j++;
                    }
                    field[i][j] = j-buffer;

                }

            }

        }

        field[n/2][n/2] = 1;
        int ver = -1;
        for (int i = 0; i < 3; i++) {
            int hor = -1;
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1){

                }else{
                    field[n/2+ver][n/2+hor] = -1;
                }
                hor++;
            }
            ver++;
        }


        return field;
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN! Doch ich habs schöner gemacht :)
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int[] arr : inputArray) {
                for (int val : arr) {
                    if(val == -1){
                        System.out.print(" " + val + "  ");
                    }else{
                        System.out.print("  " + val + "  ");
                    }
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int val : inputArray) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] array = generateFilled2DArray(1);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1}}));
        System.out.println("-----");

        array = generateFilled2DArray(3);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{-1, -1, -1}, {-1, 1, -1}, {-1, -1, -1}}));
        System.out.println("-----");

        array = generateFilled2DArray(5);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4, 5}, {2, -1, -1, -1, 4}, {3, -1, 1, -1, 3},
                {4, -1, -1, -1, 2}, {5, 4, 3, 2, 1}}));
        System.out.println("-----");

        array = generateFilled2DArray(7);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4, 5, 6, 7}, {2, 1, 2, 3, 4, 5, 6}, {3, 2, -1, -1, -1, 4, 5},
                {4, 3, -1, 1, -1, 3, 4}, {5, 4, -1, -1, -1, 2, 3}, {6, 5, 4, 3, 2, 1, 2}, {7, 6, 5, 4, 3, 2, 1}}));
        System.out.println("-----");
        System.out.println();
    }
}
