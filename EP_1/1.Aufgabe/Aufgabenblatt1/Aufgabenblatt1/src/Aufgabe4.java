/*
    Aufgabe 4) CodeDraw Bibliothek und Schleifen
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {

        int pixelWidth = 500;
        int pixelHeight = 500;
        CodeDraw myDrawObj = new CodeDraw(pixelWidth, pixelHeight);

        int numLinesQuadrant = 50;

        for (int i = 1; i <= numLinesQuadrant; i++) {
            //CYAN quadrant (top left)
            myDrawObj.setColor(Palette.CYAN);
            myDrawObj.drawLine(i * (pixelWidth / 2.0 / numLinesQuadrant), 0, 0, pixelHeight / 2.0 - ((i - 1) * (pixelHeight / 2.0 / numLinesQuadrant)));

            //TODO: Implement MAGENTA quadrant (bottom left) here

            //TODO: Implement the GREEN quadrant (top right) here

            //TODO: Implement the ORANGE quadrant (bottom right) here
        }

        myDrawObj.setLineWidth(2);
        myDrawObj.setColor(Palette.BLACK);
        myDrawObj.drawLine(pixelWidth / 2.0, 0, pixelWidth / 2.0, pixelHeight);//vertical line
        myDrawObj.drawLine(0, pixelHeight / 2.0, pixelWidth, pixelHeight / 2.0);//horizontal line

        myDrawObj.show();
    }
}
