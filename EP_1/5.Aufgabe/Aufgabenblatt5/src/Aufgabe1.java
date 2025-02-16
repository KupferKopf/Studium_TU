/*
    Aufgabe 1) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        int memLine = 0; // um die Zeile zu speichern die am kürzesten ist
        int memVal = 0; // to save the amount of elements in the shortest line
        int round = 0; // to know what round we have
        int count = 0; // if all the values are equally long
        for (int[] i : workArray){

            if(round == 0){ // reste runde
                memVal = i.length;
            }

            if(i.length < memVal){ // wenns ein kleineres gibt
                memLine = round;
                memVal = i.length;
            }else if( i.length == memVal){ // wenn es ein gleiches gibt
                count ++;
            }
            round++;
        }

        if(count == workArray.length){ // all elements in the array are the same length
            int[][] temp = new int[workArray.length][];

            temp[workArray.length-1] = workArray[0]; // erste ausm alten ans ende vom neuen

            for (int i = 0; i < workArray.length-1; i++) {// rest auffüllen
                temp[i] = workArray[i+1];
            }

            for (int i = 0; i < temp.length; i++) {
                workArray[i] = temp[i];
            }

            //workArray = temp.clone();// überspeichert den alten array mit der neuen anordnung

        }else{
            int[] temp = workArray[memLine];
            workArray[memLine] = workArray[0];
            workArray[0] = temp;
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

        System.out.println("Test shiftLines:");
        System.out.println("-----");
        int[][] array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 6}, {4, 3}, {6, 3, 0, 6, 9}, {6, 4, 3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4, 3}, {1, 9, 6}, {1, 5, 6, 7}, {6, 3, 0, 6, 9}, {6, 4, 3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{3, 2, 4, 1}, {7, 3, 6}, {4}, {5, 6, 2, 4}, {9, 1}, {3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4}, {7, 3, 6}, {3, 2, 4, 1}, {5, 6, 2, 4}, {9, 1}, {3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{3, 4, 1}, {6, 2, 5}, {9, 7, 8}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{6, 2, 5}, {9, 7, 8}, {3, 4, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");
    }
}

