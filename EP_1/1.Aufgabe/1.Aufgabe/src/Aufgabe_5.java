import codedraw.*;

public class Aufgabe_5 {

    public static void main(String[] args){

        drawWeirdSeven(49);

    }


    public static void drawWeirdSeven(int n){

        if(n < 5 || n > 19){
            System.out.println("Aint no way buddy, make it smaller then 20 and bigger then 4 and DONT make that sh*t divadable by 2, we dont like them evens");
        }else {

            int width = 500;
            int height = 500;

            double squareSide = width / n;

            CodeDraw cd = new CodeDraw(width, height);


            for (int i = 0; i < n - 1; i++) {

                cd.setColor(Palette.RED);
                cd.setLineWidth(4);
                cd.drawSquare(squareSide * i, 0, squareSide);

            }

            for (int i = 0; i < n; i++) {

                if (i <= n / 2 || i == n - 1) {
                    cd.setColor(Palette.BLUE);
                    cd.setLineWidth(2);
                    cd.drawSquare(squareSide * (n - 1 - i), squareSide * i, squareSide);
                }
            }

            for (int i = 0; i < n - 1; i++) {

                cd.setColor(Palette.RED);
                cd.setLineWidth(4);

                if (i < n / 2) {
                    cd.drawSquare(squareSide * (n - (n / 2) - 1), squareSide * (n - (n / 2) + i), squareSide);
                } else {
                    cd.drawSquare(squareSide * (1 + (i - n / 2)), squareSide * (n - 1), squareSide);
                }

            }
            cd.show();
        }
    }
}
