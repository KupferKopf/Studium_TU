/*
    Aufgabe 3) Zweidimensionale Arrays
*/

import java.util.Arrays;
import java.util.Random;

public class Aufgabe3 {

    private static boolean[][] genAnimalCompound(int compoundSize, float probability) {

        Random myRand = new Random(5); // Diese Zeile nicht verändern!
        boolean[][] propGehege = new boolean[compoundSize][];

        for (int i = 0; i < compoundSize; i++) { // Zeilen durchgehen
            boolean[] propLine = new boolean[compoundSize];
            Arrays.fill(propLine, false);

            for (int j = 0; j < compoundSize; j++) { // einzelne Werte durchgehen

                if(probability >= myRand.nextFloat()){ // wenn die prop passt dann wird geswitchted
                     propLine[j] = true;
                }
            }
            propGehege[i] = propLine.clone();
        }

        return propGehege;
    }

    private static int[][] calcAnimalDensity(boolean[][] animalCompound) {

        int[][] densitiy = new int[animalCompound.length][];

        for (int i = 0; i < densitiy.length; i++) {
            int[] densitiyRow = new int[densitiy.length];
            for (int j = 0; j < densitiy.length; j++) {

                if(i - 1 >= 0 && j - 1 >= 0){ // top left check
                    if(animalCompound[i-1][j-1]){
                        densitiyRow[j] ++;
                    }
                }
                if(i-1 >= 0){ // top middle
                    if(animalCompound[i-1][j]){
                        densitiyRow[j] ++;
                    }
                }
                if(i-1 >= 0 && j+1 < animalCompound.length){ // top right
                    if(animalCompound[i-1][j+1]){
                        densitiyRow[j] ++;
                    }
                }
                if(j-1 >= 0) {// middle left
                    if (animalCompound[i][j - 1]) {
                        densitiyRow[j]++;
                    }
                }
                if(j+1 < densitiyRow.length) { // right middle
                    if (animalCompound[i][j+1]) {
                        densitiyRow[j]++;
                    }
                }
                if(j-1 >= 0 && i+1 < densitiy.length){ // bottom left
                    if (animalCompound[i+1][j - 1]) {
                        densitiyRow[j]++;
                    }
                }
                if(i+1 < densitiy.length){ // bottom middle
                    if (animalCompound[i+1][j]) {
                        densitiyRow[j]++;
                    }
                }
                if(j+1 < animalCompound.length && i+1 < animalCompound.length){ // bottom right
                    if (animalCompound[i+1][j+1]) {
                        densitiyRow[j]++;
                    }
                }
                if (animalCompound[i][j]) {
                    densitiyRow[j]++;
                }

            }
            densitiy[i] = densitiyRow;
        }

        return densitiy; //Zeile kann geändert oder entfernt werden.
    }

    // helping method for printing the animal compound
    private static void printCompound(boolean[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                if (animalCompound[y][x]) {
                    System.out.print("* ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    // helping method for printing the number of animals
    private static void printDensity(int[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                System.out.print(animalCompound[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // variables
        int compoundSize = 8;
        float probability = 0.8f;
        boolean[][] animalCompound = genAnimalCompound(compoundSize, probability);
        printCompound(animalCompound);
        System.out.println();
        int[][] animalDensity = calcAnimalDensity(animalCompound);
        printDensity(animalDensity);
    }
}
