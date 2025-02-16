import java.lang.reflect.Array;
import java.util.Arrays;

public class Uebungstest_2 {

    public static void main(String[] args){

        int[][] test1 = { {1, 2, 0,-1,-2, 3}, {-1, 2, 3}, {0, 0}, {}, {4, 5,-1} };
        int[][] test2 = { {1, 2, 3}, {4, 5, 2}, {-2,-3, 2,-1}, {3, 2, 1, 5}, {4, 5, 1, 4} };
        int[][] test3 = { {1,-1, 2,-2, 3}, {1, 2, 3}, {-3,-1,-2} };
        char[] age1 = {'d', 'u', '-', 'd', 'u', '-', 'd', 'a', '-', 'd', 'a'};
        char[] age2 = {'m', 'a', 'm', 'a', '!', 'n', 'e', 'i', 'n'};


        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));
        System.out.println();

        fill(test1, test2[3], test2[4]);
        System.out.println(Arrays.deepToString(test1));
        fill(result1, test2[2], test2[4]);
        System.out.println(Arrays.deepToString(result1));
        fill(test3, test2[2], test2[3]);
        System.out.println(Arrays.deepToString(test3));

        System.out.println();

        System.out.println(extractString(age1, 0, age1.length, '-'));
        System.out.println(extractString(age1, 1, 7, 'u'));
        System.out.println(extractString(age2, 0, 5, 'a'));
        System.out.println(extractString(age2, 5, age2.length, 'n'));
    }

    public static int[][] generate(int[][] input){

        int[][] result = new int[input.length][];

        for (int i = 0; i < input.length; i++) {

            int[] temp = new int[input[i].length];
            int coloum = 0;

            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] < 0){
                    temp[coloum] = input[i][j];
                    coloum++;
                }
            }

            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] >= 0){
                    temp[coloum] = input[i][j];
                    coloum++;
                }
            }
            //System.out.println(Arrays.toString(temp));
            result[i] = temp;
            //System.out.println(Arrays.deepToString(result));
        }

        return result;
    }

    public static void fill(int[][] target, int[] values, int[] times){

        int row = 0;
        int coloum = 0;

        for (int i = 0; i < times.length; i++) {

            for (int j = 0; j < times[i]; j++) {


                if(coloum < target[row].length){
                    target[row][coloum] = values[i];
                    coloum++;
                }else if(row+1 < target.length){
                    coloum = 0;
                    row++;
                    if(target[row].length == 0){
                        row++;
                    }
                    target[row][coloum] = values[i];
                    coloum++;
                }else{
                    break;
                }
                //System.out.println(Arrays.deepToString(target));
            }

        }


    }

    public static String extractString(char[] sequence, int start, int end, char omit){

        String result = "";

        if(start<end){
            if(sequence[start] != omit){
                result += sequence[start];
            }
            result += extractString(sequence, start+1, end, omit);

            return result;
        }else {
            return "";
        }

    }


}
