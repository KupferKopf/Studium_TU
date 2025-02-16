/*
    Aufgabe 2) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe2 {

    private static void reformatArray(int[][] workArray) {


        int round = 0;
        for (int[] row : workArray){
            int[] tempRow = new int[row.length+1]; // Array für die derzeitige reihe
            int pos = 0; // the position of the current
            int sum = 0; // end value for each row

            for (int val : row){
                if(val%2 == 0){
                    tempRow[pos] = val;
                    pos++;
                    sum += val;
                }
            }

            for (int val : row){
                if(val%2 != 0){
                    tempRow[pos] = val;
                    pos++;
                    sum += val;
                }
            }

            tempRow[tempRow.length-1] = sum;
            workArray[round] = tempRow;
            round++;
        }

    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j
                     = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Test: reformatArray");
        System.out.println("-----");
        int[][] array2 = new int[][]{{3, 4, 6, 9}, {1, 0, 2}, {3}, {2}, {4, 6, 8, 10}, {1, 3, 5, 7, 9}, {2, 7, 9, 2, 2}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{4, 6, 3, 9, 22}, {0, 2, 1, 3}, {3, 3}, {2, 2}, {4, 6, 8, 10, 28}, {1, 3, 5, 7, 9, 25}, {2, 2, 2, 7, 9, 22}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{0}, {1}, {2}, {3, 4}, {5, 7, 6}, {6, 8, 9}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{0, 0}, {1, 1}, {2, 2}, {4, 3, 7}, {6, 5, 7, 18}, {6, 8, 9, 23}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {2, 2, 2, 2, 2, 4, 4, 4, 4, 4}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{0, 2, 4, 6, 8, 1, 3, 5, 7, 9, 45}, {2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 30}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");
    }
}

