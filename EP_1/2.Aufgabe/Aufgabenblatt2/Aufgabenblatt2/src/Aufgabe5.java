import codedraw.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Aufgabe5 {

    public static void main(String[] args){ // Das ist zwar schon relativ weit aber noch ned vollständig, just vor fun würd ich dann aber noch die fertige version beim Abgabegesrpäch herzeigen
        Scanner input = new Scanner(System.in);
        System.out.println("How big should the Canvas be (bigger then a 100 cause you wont see much) and after that the intensiti (bigger then 10 cause it should be a bit fun right?)");
        //int width = input.nextInt();
        //int intensiti = input.nextInt();
        //if(width > 100 && intensiti > 10 )
            drawASquareV2(500, 10);
            DrawV3(500, 100);
        //else System.out.println("What did i just tell you??? try again later");
    }

    public static void drawASquareV2(int width, int intesiti) {
        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350
        //int cubeOffset = width/25; // 500 -> 20 fuern würfel
        int cubeDistanc = width/5; // 500 -> 100 fuern würfel
        double temp = width/6.6; // 500 -> 75 fuern würfel
        int cubeVerschiebung = (int)temp;


        cd.setLineWidth(2);
        cd.drawLine(150,150,350,150); // top mid
        cd.drawLine(350,150,350,350); // top right
        cd.drawLine(350,350,150,350); // top bottom
        cd.drawLine(150,350,150,150); // top left

        cd.drawLine(150,150,250,50); // top back
        cd.drawLine(250,50,450,50); // top left
        cd.drawLine(450,50, 350,150); // top right

        cd.drawLine(450,50,450,250); // right back
        cd.drawLine(350,350, 450, 250); // right bottom

        cd.show(100);
        cd.clear();

    }

    public static void DrawV3(int width, int intesiti){
        CodeDraw cd = new CodeDraw(width+width/5, width);

        int oneCord = width/2 - ((width/10)*2); // the first cord for the square / 500 -> 150
        int secCord = width/2 + ((width/10)*2); // the second cord for the square in a square canvas / 500 -> 350
        //int cubeOffset = width/25; // 500 -> 20 fuern würfel
        int cubeDistanc = width/5; // 500 -> 100 fuern würfel
        double temp = width/6.6; // 500 -> 75 fuern würfel
        int cubeVerschiebung = (int)temp;


        cd.setLineWidth(2);
        cd.drawLine(oneCord, oneCord, secCord, oneCord + 20);
        cd.drawLine(secCord, oneCord + 20, secCord, secCord + 20);
        cd.drawLine(secCord, secCord + 20, oneCord, secCord);
        cd.drawLine(oneCord, secCord, oneCord, oneCord);

        cd.drawLine(oneCord + 100, oneCord - 75, secCord + 100, oneCord + 20 - 75); // top back
        cd.drawLine(oneCord, oneCord, oneCord + 100, oneCord - 75); // top left
        cd.drawLine(secCord, oneCord + 20, secCord + 100, oneCord + 20 - 75); // top right

        cd.drawLine(secCord + 100, oneCord + 20 - 75, secCord + 100, secCord + 20 - 75); // right back
        cd.drawLine(secCord, secCord + 20, secCord + 100, secCord + 20 - 75); // right bottom

        cd.show(100);
        cd.clear();
    }


}


// Just some notes
/* Spinning cube
My first idea was creating a square using random numbers, bogo-sort and 4 lines (16 values) but after thinking about it, i realiced that would be !16 different options for only the sort
which would mean it would take about a couple of thousands of years if it were to make 150 or even 1500 sorts per second.
So? the idea was changed first the values are still random but the funny haha bogo-sort ain't no more cause don't have the time and cant have you, profs & tutors, sit here waiting for it to finish
also cant have it run on the "vertrau mir bruder"-basis so just gona tweak it to make it more normal or in this lifetime solvable

new idea the square and the lines and the random numbers stay, but they get more accurate over time/each loop so it doesn't take forever
so now we got our square what now, it's a nice animation but what after that, that can't be all right? yes, yeah that would be too bland too boring, not fun enough
now what can make it better, what's better than 1 square alone, right 5 other ones, seen or not seen, forming a cube.
so Second part is also generating the rest of the squares and getting the cube to be complete

and third and final we got the spinning part, not sure if im gona make it automatical or random or let the user decide the direction but one way or the other that cube will be spinning

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