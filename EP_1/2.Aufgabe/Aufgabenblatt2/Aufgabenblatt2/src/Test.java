import codedraw.CodeDraw;
import codedraw.Palette;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        //TODO: Implementieren Sie hier Ihre Lösung für die KREATIVAUFGABE
        int start = 0;
        int ende = 2;
        Random myRand = new Random();
        Scanner scanner = new Scanner(System.in);
        int w = 300;
        int reps = 2;
        CodeDraw drawing = new CodeDraw(w,w);
        drawing.setCanvasPositionX(100);
        drawing.setCanvasPositionY(100);
        int wincount = 0;
        for (int i = 0; i < reps; i++) {
            int myNum = myRand.nextInt(start,ende);
            System.out.println("An welche Zahl zwischen " + start + " und " + ende + " denke ich gerade? Rate mal:");
            int n = scanner.nextInt();
            drawing.setColor(Palette.YELLOW);
            drawing.fillRectangle(0,0,300,300);
            if(n == myNum){
                drawing.setColor(Palette.BLACK);
                drawing.fillCircle(150,150,100);
                drawing.setColor(Palette.YELLOW);
                drawing.fillRectangle(50,50,200,100);
                drawing.fillCircle(150,150,50);
                drawing.setColor(Palette.BLACK);
                drawing.fillCircle(80,80,40);
                drawing.fillCircle(w-80,80, 40);
                drawing.show();
                wincount++;
                System.out.println("Richtig!");
            }else if(n <= ende && n >= start) {
                drawing.setColor(Palette.BLACK);
                drawing.fillCircle(150,250,100);
                drawing.setColor(Palette.YELLOW);
                drawing.fillRectangle(50,250,200,100);
                drawing.fillCircle(150,250,50);
                drawing.setColor(Palette.BLACK);
                drawing.fillCircle(80,80,40);
                drawing.fillCircle(w-80,80, 40);
                drawing.show();
                System.out.println("Leider Falsch, viel Glück beim nächsten Mal!");
            } else{
                drawing.setColor(Palette.BLACK);
                drawing.setLineWidth(30);
                drawing.drawLine(50,50,w-50,w-50);
                drawing.drawLine(w-50,50,50,w-50);
                drawing.show();
                System.out.println("Ich habe gesagt zwischen " + start + " und " + ende + ", versuch es nochmal!");
            }
        }
        if(wincount != 0){
            System.out.println("Für jedes richtige Mal gebe ich dir eine Katze! :D");
            for (int j = 0; j < wincount; j++) {
                System.out.print(" ᓚᘏᗢ ");
            }
        }else{
            System.out.println("Nicht gewonnen, keine Katzen für dich!");
        }
    }


}
