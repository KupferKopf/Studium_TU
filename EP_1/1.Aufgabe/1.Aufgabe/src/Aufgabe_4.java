import codedraw.*;


public class Aufgabe_4 {

    public static void main(String[] args) {


        int numLinesQuadrant= 25;
        drawCircle(numLinesQuadrant); // eigentliche aufgabe

        drawOverLab1Squares(numLinesQuadrant); // side idea 1 -> overlaps 2 quadrants with one corner

        drawOverLab2Squares(numLinesQuadrant); // side idea 2 -> overlaps 3 quadrants with one corner

    }



    public static void drawCircle(int linesPerSide){

        int height = 800;
        int width = 800;

        int x0 = width/10;
        int y0 = height/10;

        double spaceBtweenWidth = (width/2) / linesPerSide;
        double spaceBtweenHeight = (height/2) / linesPerSide;
        double startX = 0;
        double startY = 0;
        double endX = 0;
        double endY = 0;
        //CodeDraw cd = new CodeDraw( width + (y0*2), height + (x0*2));
        CodeDraw cd = new CodeDraw( width + 2*x0, height+2*y0);



        for (int i = 1; i <= linesPerSide; i++) {

            for (int j = 0; j < 4; j++) {

                switch(j){
                    case 0:
                        cd.setColor(Palette.CYAN);
                        startX = (width/2) - (spaceBtweenWidth*(i-1)) + x0;
                        startY = y0;
                        endX = x0;
                        endY = spaceBtweenHeight*i + y0;
                        break;
                    case 1:
                        cd.setColor(Palette.MAGENTA);
                        startX = x0;
                        startY = (height/2) + (spaceBtweenHeight*(i-1)) + y0;
                        endX = spaceBtweenWidth*i + x0;
                        endY = height + y0;
                        break;
                    case 2:
                        cd.setColor(Palette.ORANGE);
                        startX = (width/2) + (spaceBtweenWidth*(i-1)) + x0;
                        startY = height + y0;
                        endX = width + x0;
                        endY = height - (spaceBtweenHeight*i) + y0;
                        break;
                    case 3:
                        cd.setColor(Palette.GREEN);
                        startX = width + x0;
                        startY = (height/2) - (spaceBtweenHeight*(i-1)) + y0;
                        endX = width - (spaceBtweenWidth*(i)) + x0;
                        endY = y0;
                        break;
                }
                cd.drawLine(startX,startY,endX,endY);
            }
        }

        //nach den eigentlichen linien da diese sonst auf dem Kasterl enden würden
        //setup square
        cd.setColor(Palette.BLACK);
        cd.drawRectangle(x0, y0, width, height);

        //setup grid
        cd.drawLine(x0+(width/2), y0, x0+(width/2), y0+height );
        cd.drawLine(x0, y0+(height/2), x0+width, y0+(height/2) );

        cd.show();

    }

    public static void drawOverLab1Squares(int linesPerSide){

        int height = 800;
        int width = 800;

        int x0 = width/10;
        int y0 = height/10;

        double spaceBtweenWidth = (width) / linesPerSide;
        double spaceBtweenHeight = (height) / linesPerSide;
        double startX = 0;
        double startY = 0;
        double endX = 0;
        double endY = 0;
        //CodeDraw cd = new CodeDraw( width + (y0*2), height + (x0*2));
        CodeDraw cd = new CodeDraw( width + 2*x0, height+2*y0);



        for (int i = 1; i <= linesPerSide; i++) {

            for (int j = 0; j < 4; j++) {

                switch(j){
                    case 0:
                        cd.setColor(Palette.CYAN);
                        startX = (width/2) - ((spaceBtweenWidth/2)*(i-1)) + x0;
                        startY = y0;
                        endX = x0;
                        endY = (spaceBtweenHeight)*i + y0;
                        break;
                    case 1:
                        cd.setColor(Palette.MAGENTA);
                        startX = x0;
                        startY = (height/2) + ((spaceBtweenHeight/2)*(i-1)) + y0;
                        endX = spaceBtweenWidth*i + x0;
                        endY = height + y0;
                        break;
                    case 2:
                        cd.setColor(Palette.ORANGE);
                        startX = (width/2) + ((spaceBtweenWidth/2)*(i-1)) + x0;
                        startY = height + y0;
                        endX = width + x0;
                        endY = height - (spaceBtweenHeight*i) + y0;
                        break;
                    case 3:
                        cd.setColor(Palette.GREEN);
                        startX = width + x0;
                        startY = (height/2) - ((spaceBtweenHeight/2)*(i-1)) + y0;
                        endX = width - (spaceBtweenWidth*(i)) + x0;
                        endY = y0;
                        break;
                }
                cd.drawLine(startX,startY,endX,endY);
            }
        }

        //nach den eigentlichen linien da diese sonst auf dem Kasterl enden würden
        //setup square
        cd.setColor(Palette.BLACK);
        cd.drawRectangle(x0, y0, width, height);

        //setup grid
        cd.drawLine(x0+(width/2), y0, x0+(width/2), y0+height );
        cd.drawLine(x0, y0+(height/2), x0+width, y0+(height/2) );

        cd.show();



    }

    public static void drawOverLab2Squares(int linesPerSide){

        int height = 800;
        int width = 800;

        int x0 = width/10;
        int y0 = height/10;

        double spaceBtweenWidth = (width) / linesPerSide;
        double spaceBtweenHeight = (height) / linesPerSide;
        double startX = 0;
        double startY = 0;
        double endX = 0;
        double endY = 0;
        //CodeDraw cd = new CodeDraw( width + (y0*2), height + (x0*2));
        CodeDraw cd = new CodeDraw( width + 2*x0, height+2*y0);



        for (int i = 1; i <= linesPerSide; i++) {

            for (int j = 0; j < 4; j++) {

                switch(j){
                    case 0:
                        cd.setColor(Palette.CYAN);
                        startX = (width) - (spaceBtweenWidth*(i-1)) + x0;
                        startY = y0;
                        endX = x0;
                        endY = (spaceBtweenHeight)*i + y0;
                        break;
                    case 1:
                        cd.setColor(Palette.MAGENTA);
                        startX = x0;
                        startY =  (spaceBtweenHeight*(i-1)) + y0;
                        endX = spaceBtweenWidth*i + x0;
                        endY = height + y0;
                        break;
                    case 2:
                        cd.setColor(Palette.ORANGE);
                        startX = (spaceBtweenWidth*(i-1)) + x0;
                        startY = height + y0;
                        endX = width + x0;
                        endY = height - (spaceBtweenHeight*i) + y0;
                        break;
                    case 3:
                        cd.setColor(Palette.GREEN);
                        startX = width + x0;
                        startY = (height) - (spaceBtweenHeight*(i-1)) + y0;
                        endX = width - (spaceBtweenWidth*(i)) + x0;
                        endY = y0;
                        break;
                }
                cd.drawLine(startX,startY,endX,endY);
            }
        }

        //nach den eigentlichen linien da diese sonst auf dem Kasterl enden würden
        //setup square
        cd.setColor(Palette.BLACK);
        cd.drawRectangle(x0, y0, width, height);

        //setup grid
        cd.drawLine(x0+(width/2), y0, x0+(width/2), y0+height );
        cd.drawLine(x0, y0+(height/2), x0+width, y0+(height/2) );

        cd.show();



    }

}
