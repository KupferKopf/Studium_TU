/*
    Aufgabe 6) Kreise => Rekursiv
*/

import codedraw.*;

import java.awt.*;
import java.nio.file.attribute.UserPrincipalLookupService;

public class Aufgabe6 {

    private static void drawCirclesRec(CodeDraw myDrawObj, int y, int radius, int num) {
        myDrawObj.setColor(new Color(255 - num * 30, 255 - num * 30, 0));
        double width = myDrawObj.getWidth();

        myDrawObj.fillCircle(width/2, y, radius);

        if(num - 1 > 0){
            if(false) {// ich war so deppat am rumprobieren und mach einmal die if false (statt "y-radius > 0") und aufeinmal gehts hhahahahaha
                //drawCirclesRec(myDrawObj, y-y/2, radius, num);  ich lass das einfach nur als spaß mal da stehn hat keinen einfluss auf die aufgabe und könnte weg aber lol egal
                drawCirclesRec(myDrawObj, y+y/2, radius, num);
            }else {
                drawCirclesRec(myDrawObj, y-radius/2, radius / 2, num - 1);
                drawCirclesRec(myDrawObj, y+radius/2, radius / 2, num - 1);
            }
        }
    }

    public static void main(String[] args) {
        int pixelWidth = 512;
        int pixelHeight = 512;
        CodeDraw myDrawObj = new CodeDraw(pixelWidth, pixelHeight);
        drawCirclesRec(myDrawObj, pixelHeight / 2, pixelWidth / 2, 5);
        myDrawObj.show();
    }
}



