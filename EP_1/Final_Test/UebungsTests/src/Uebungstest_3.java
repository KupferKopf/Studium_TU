import java.util.Arrays;

public class Uebungstest_3 {

    public static void main(String[] args){

        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        System.out.println(Arrays.deepToString(labelPath(3, new int[][] {})));
        System.out.println(Arrays.deepToString(labelPath(4, data0)));
        System.out.println();

        findMatches(data0, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[2], target2);
        System.out.println(Arrays.toString(target2));
        System.out.println();

        System.out.println(insertMiddle("XY", "abc"));
        System.out.println(insertMiddle("01234", "abc"));
        System.out.println(insertMiddle("01234567890123", "./-"));

    }

    public static int[][] labelPath(int n, int[][] points){

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                result[i][j] = n;

            }
        }

        for (int i = 0; i < points.length; i++) {

            result[points[i][0]][points[i][1]] = -1;

        }

        return result;
    }


    public static void findMatches(int[][] data, int[] pattern, int[] target){

        for (int i = 0; i < data.length; i++) {
            int count = 0;


            for (int j = 0; j < data[i].length; j++) {

                if(data[i][j] == pattern[0]) {
                    boolean broke = true;
                    for (int k = 1; k < pattern.length; k++) {

                        if(j+k < data[i].length && data[i][j+k] == pattern[k]){
                            broke = true;
                        }else{
                            broke = false;
                        }

                    }
                    if(broke){
                        count++;
                    }
                }

            }
            //System.out.println(count);
            target[i] = count;

        }

        //System.out.println(Arrays.toString(target));
    }


    public static String insertMiddle(String input, String seps){

        String result = "";

        int laenge = input.length()/2;
        String links = "";
        String rechts = "";

        if(laenge > 0 && !seps.isEmpty()) {
            links = insertMiddle(input.substring(0, laenge), seps.substring(1));
            rechts = insertMiddle(input.substring(laenge, input.length()), seps.substring(1));

            result = links + seps.charAt(0) + rechts;

        }else{
            result = input;
        }

        //System.out.println(result);

        return result;
    }

}
