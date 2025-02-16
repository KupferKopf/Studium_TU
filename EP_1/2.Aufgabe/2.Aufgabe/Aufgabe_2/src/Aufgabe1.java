import codedraw.*;


public class Aufgabe1 {

    public static void main(String[] args){

        illusionDraw(400);

    }


    public static void illusionDraw(int length){

        int width = length;
        int height = length;

        CodeDraw cd = new CodeDraw(width, height);
        cd.drawSquare(0,0,width);


        double radius = (1/60f)*width;


        for (int i = 0; i < 15; i++) {

            for (int j = 0; j < 15; j++) {

                cd.setColor(Palette.BLACK);
                cd.fillCircle((2 * radius) + ((4 * radius) * j), 2 * radius + ((4 * radius) * i), radius);
                cd.setLineWidth(3);
                cd.setColor(Palette.GRAY);
                cd.drawCircle((2 * radius) + ((4 * radius) * j), 2 * radius + ((4 * radius) * i), radius);

            }

        }
            cd.setLineWidth(1);
            cd.setColor(Palette.WHITE);

            double startX = 0.25*width+radius;
            double startY = 0.25*height+radius;

            cd.fillSquare(0.25*width+radius,0.25*height+radius,0.5*width-2*radius);
            cd.setColor(Palette.BLACK);
            cd.drawSquare(0.25*width+radius,0.25*height+radius,0.5*width-2*radius);

        for (int i = 0; i < 7; i++) {

            for (int j = 0; j < 7; j++) {
                cd.drawSquare(startX+ (radius) +(4*radius)*j, startY + (radius) + (4*radius)*i, radius*2);
            }
        }

        cd.show();

    }



}
