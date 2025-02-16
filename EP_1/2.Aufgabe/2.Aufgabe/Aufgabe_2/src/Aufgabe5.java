import codedraw.*;
import java.util.Scanner;
import java.util.Random;
public class Aufgabe5 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //System.out.println("How big should the Canvas be");
        //drawASquare_V2(input.nextInt());
        drawASquare_V2(500);
    }


    public static void drawASquare(int width, int height) {
        CodeDraw cd = new CodeDraw(width, height);
        Random randy = new Random();

        int[][] cords = new int[2][8];

        for (int i = 0; i < cords.length; i++) {
            for (int j = 0; j < cords[i].length; j++) {
                cords[i][j] = randy.nextInt(width);
            }
            System.out.println();
        }


        while (true) {

            cd.drawLine(cords[0][0], cords[1][0], cords[0][1], cords[1][1]);
            cd.drawLine(cords[0][2], cords[1][2], cords[0][3], cords[1][3]);
            cd.drawLine(cords[0][4], cords[1][4], cords[0][5], cords[1][5]);
            cd.drawLine(cords[0][6], cords[1][6], cords[0][7], cords[1][7]);

            for (int i = 0; i < cords.length; i++) {
                for (int j = 0; j < cords[i].length; j++) {
                    cords[i][j] = randy.nextInt(width);
                }
                System.out.println();
            }


            cd.show(100);
            cd.clear();
        }

    }


    public static void drawASquare_V2(int width) {
        CodeDraw cd = new CodeDraw(width, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas

        //help lines
        cd.drawLine(0,width/10,width,width/10);
        cd.drawLine(0,width - width/10,width,width - width/10);

        // front square with vars
        //cd.setColor(Palette.RED);
        cd.setLineWidth(2);
        cd.drawLine(oneCord, oneCord, secCord, oneCord);
        cd.drawLine(secCord, oneCord, secCord, secCord);
        cd.drawLine(secCord, secCord, oneCord, secCord);
        cd.drawLine(oneCord, secCord, oneCord, oneCord);


        cd.show(1000);
        cd.clear();

    }






}




/* Spinning cube
My first idea was creating a square using random numbers, bogo-sort and 4 lines (16 values) but after thinking about it, i realiced that would be !16 different options for only the sort
which would mean it would take about a couple of thousands of years if it were to make 150 or even 1500 sorts per second.
So? the idea was changed first the values are still random but the funny haha bogo-sort ain't no more cause don't have the time and cant have you, profs & tutors, sit here waiting for it to finish
also cant have it run on the "vertrau mir bruder"-basis so just gona tweak it to make it more normal or in this lifetime solvable

// front square -> one side is 200px
        cd.drawLine(150,150,350,150);
        cd.drawLine(350,150,350,350);
        cd.drawLine(350,350,150,350);
        cd.drawLine(150,350,150,150);

int oneCord = width/2 - ((width/10)*2); // the first cord for the square
int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas


new idea the square and the lines and the random numbers stay, but they get more accurate over time/each loop so it doesn't take forever
so now we got our square what now, it's a nice animation but what after that, that can't be all right? yes, yeah that would be too bland too boring, not fun enough
now what can make it better, what's better than 1 square alone, right 5 other ones, seen or not seen, forming a cube.
so Second part is also generating the rest of the squares and getting the cube to be complete

and third and final we got the spinning part, not sure if im gona make it automatical or random or let the user decide the direction but one way or the other that cube will be spinning

*/

/*




CodeDraw cd = new CodeDraw(width, height);
        Random randy = new Random();

        int[][] cords = new int[2][8];

        for (int i = 0; i < cords.length; i++) {
            for (int j = 0; j < cords[i].length; j++) {
                cords[i][j] = randy.nextInt(width);
            }
            System.out.println();
        }


        while (true) {

            cd.drawLine(cords[0][0], cords[1][0], cords[0][1], cords[1][1]);
            cd.drawLine(cords[0][2], cords[1][2], cords[0][3], cords[1][3]);
            cd.drawLine(cords[0][4], cords[1][4], cords[0][5], cords[1][5]);
            cd.drawLine(cords[0][6], cords[1][6], cords[0][7], cords[1][7]);

            for (int i = 0; i < cords.length; i++) {
                for (int j = 0; j < cords[i].length; j++) {
                    cords[i][j] = randy.nextInt(width);
                }
                System.out.println();
            }


            cd.show(1500);
            cd.clear();
}


static void shuffleArray(int[] ar){
            Random rnd = new Random();
            for (int i = ar.length - 1; i > 0; i--)
            {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
        }



*/



/* Testing some stuff / its some funny code i want to keep so just ignore it, good? good
CodeDraw cd = new CodeDraw(width, height);

        int x = 10;
        int y = 10;
        int laenge = 50;

        int a = 10;

        while(true){

            cd.drawSquare(x,y,laenge);

            Random randy = new Random();
            int randomX = randy.nextInt(width);
            for(int i = 0; randomX > width - 50 ; i ++){
                randomX = randy.nextInt(width);
            }
            int randomY = randy.nextInt(height);
            for(int i = 0; randomY > height - 50 ; i ++){
                randomY = randy.nextInt(height);
            }

            x = randomX;
            y = randomY;
            a--;
            cd.show(50);
            cd.clear();
        }
        */