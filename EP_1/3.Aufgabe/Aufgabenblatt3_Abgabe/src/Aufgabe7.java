/*
    Aufgabe 7) Kreise => Iterativ
*/

import codedraw.*;

import java.awt.*;

public class Aufgabe7 {

    // Iterative Version => ChatGPT 3.5 generiert
    public static void drawCirclesIter35(CodeDraw myDrawObj, int y, int radius, int num) {
        int xCenter = myDrawObj.getWidth() / 2;

        while (num > 0) {
            // Setze die Farbe für den aktuellen Kreis
            myDrawObj.setColor(new Color(255 - num * 30, 255 - num * 30, 0));

            // Zeichne den Kreis in der Mitte
            myDrawObj.fillCircle(xCenter, y, radius);

            // Berechne den nächsten Radius und die nächste y-Position
            radius /= 2;
            y -= radius; // Verschiebung des y-Werts nach oben für die nächste Iteration

            num--;
        }
    }

    // Iterative Version => ChatGPT 4.0 generiert
    public static void drawCirclesIter40(CodeDraw myDrawObj, int y, int radius, int num) {
        // Stapel für die Iteration
        int currentY = y;
        int currentRadius = radius;
        int currentNum = num;

        while (currentNum > 0) {
            // Setzt die Farbe basierend auf der Rekursionstiefe
            myDrawObj.setColor(new Color(255 - currentNum * 30, 255 - currentNum * 30, 0));

            // Zeichne den Kreis
            int x = 256; // die konstante x-Koordinate, die Mitte des Fensters
            myDrawObj.fillCircle(x, currentY, currentRadius);

            // Berechne die Parameter für die nächste Stufe
            currentNum--;
            currentRadius /= 2;
            currentY -= currentRadius;

            // Zeichne den unteren Kreis, durch Änderung von y in entgegengesetzte Richtung
            if (currentNum > 0) {
                myDrawObj.fillCircle(x, y + currentRadius, currentRadius);
            }
        }
    }
    
    // Iterative Version -> handgeschrieben und basierend auf ChatGPT Version -> ChatGPT 3.5
    private static void drawCirclesIterHand(CodeDraw myDrawObj, int y, int radius, int num){
        int xCenter = myDrawObj.getWidth() / 2;

        while (num > 0) {
            int tempY = y;
            // Setze die Farbe für den aktuellen Kreis
            myDrawObj.setColor(new Color(255 - num * 30, 255 - num * 30, 0));

            // Zeichne den Kreis in der Mitte
            myDrawObj.fillCircle(xCenter, y, radius);

            while(tempY+radius*2<= xCenter*2) {
                myDrawObj.fillCircle(xCenter, tempY+radius*2, radius);
                tempY += radius*2 ;
            }
            // Berechne den nächsten Radius und die nächste y-Position
            radius /= 2;
            y -= radius; // Verschiebung des y-Werts nach oben für die nächste Iteration

            num--;
        }
    }

    public static void main(String[] args) {

        int pixelWidth = 512;
        int pixelHeight = 512;

        CodeDraw myDrawObjI35 = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjI35.setTitle("Output Iterative Method -> ChatGPT 3.5");
        myDrawObjI35.setCanvasPositionX(50);
        myDrawObjI35.setCanvasPositionY(50);

        CodeDraw myDrawObjI40 = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjI40.setTitle("Output Iterative Method -> ChatGPT 4.0");
        myDrawObjI40.setCanvasPositionX(600);
        myDrawObjI40.setCanvasPositionY(50);

        CodeDraw myDrawObjIHand = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjIHand.setTitle("Output Iterative Method Hand");
        myDrawObjIHand.setCanvasPositionX(1150);
        myDrawObjIHand.setCanvasPositionY(50);

        drawCirclesIter35(myDrawObjI35, pixelHeight/2, pixelWidth/2, 5);
        myDrawObjI35.show();
        drawCirclesIter40(myDrawObjI40, pixelHeight/2, pixelWidth/2, 5);
        myDrawObjI40.show();

        drawCirclesIterHand(myDrawObjIHand, pixelHeight/2, pixelWidth/2, 5);
        myDrawObjIHand.show();
    }
}



