/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {

        short[] arrS = {3,6,24,31,35,44,67,73,89,92};
        //linesAndSemi(arrS);

        char[] arrC = {'a', '8', '8', 'G', '2', ':', ':', ':', 'F', '7', 'b', 'b', '-', 'T'};
        //plusSplit(arrC);

        four20(); // haha 420 und so


    }


    public static void linesAndSemi(short[] arrS){
        System.out.print("|");
        for (int i = 0; i < arrS.length; i++) {
            if(i != arrS.length-1){
                System.out.print(arrS[i] + ";");
            }else{
                System.out.print(arrS[i] + "|");
            }
        }
        System.out.println();
    }


    public static void plusSplit(char[] arrC){
        char[] temp = new char[arrC.length*2-1]; // weil der neue Array kann maximal so groß sein wie der andere mit einem + zwischen jedem zeichen
        int puffer = 0; // für die mahle wo schon ein + eingefügt wurde damit der stellen abstand zwischen den beiden arrays noch passt
        for (int i = 0; i < arrC.length; i++) {

            temp[i+puffer] = arrC[i];
            if(i+1 < arrC.length && arrC[i] == arrC[i+1]){
                temp[i+1+puffer] = '+';
                puffer++;
            }

        }
        char[] finalArrC = new char[arrC.length+puffer];
        System.arraycopy(temp, 0, finalArrC, 0 ,arrC.length+puffer);

        for (char c : finalArrC) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void four20(){

        int[] revTw = new int[20];

        for (int i = 19; i >= 0; i--) {
            revTw[19-i] = i;
        }

        String forSt = "";
        for (int i : revTw) {
            forSt = "!" + i + forSt;
        }
        forSt = "for-Schleife: " + forSt.substring(1);
        System.out.println(forSt);

        String whileSt = "";
        int i = 0;
        while(i < revTw.length){
            whileSt = "!" + revTw[i] + whileSt;
            i++;
        }
        whileSt = "while-Schleife: " + whileSt.substring(1);
        System.out.println(whileSt);

    }

}

