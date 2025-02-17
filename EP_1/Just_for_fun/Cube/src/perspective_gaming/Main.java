package perspective_gaming;

import codedraw.CodeDraw;
import java.util.Scanner;

public class Main {

    //main size vals
    private static int width = 1000;
    private static int height = 500;

    //extra val to increas the field for a better view | but not fuck with the clean values
    private static int extra = 200;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CodeDraw mainPlain = new CodeDraw(width + extra, height + extra);

        plain(mainPlain);


        mainPlain.show();
    }


    public static void plain(CodeDraw mainPlain){

        //end of the horizons
        mainPlain.drawCircle(100, 350, 1);
        mainPlain.drawCircle(1100, 350, 1);


        //middle line
        mainPlain.drawLine(600,100,600,600);

        //connection lines
        mainPlain.drawLine(600,100,100,350);
        mainPlain.drawLine(600,100,1100,350);
        mainPlain.drawLine(600,600,100,350);
        mainPlain.drawLine(600,600,1100,350);

        //equation for needed y value
        float y_hight = (float) (350 - 100)/(600-100);
        System.out.println(y_hight + " | " + 500*0.5);

        float inner = (float) (550-100)*y_hight;
        float middle = (float) (500-100)*y_hight;
        float outer = (float) (450-100)*y_hight;

        System.out.println(inner + " | " + middle + " | " + outer);

        //Cube side lines ??? innen | mittl | ausen
        mainPlain.drawLine(550,350-inner,550,350+inner);
        mainPlain.drawLine(650,350-inner,650,350+inner);

        mainPlain.drawLine(500,350-middle,500,350+middle);
        mainPlain.drawLine(700,350-middle,700,350+middle);

        mainPlain.drawLine(450,350-outer,450,350+outer);
        mainPlain.drawLine(750,350-outer,750,350+outer);


    }



}
