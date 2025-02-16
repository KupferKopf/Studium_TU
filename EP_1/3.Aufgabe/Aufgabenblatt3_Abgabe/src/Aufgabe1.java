/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in 1-2 Sätzen was der Spaghetticode macht
    // Der Code Zeichnet ein 10x11 großes Feld in welchem eine Raute dargestellt wird

    //TODO zu Punkt b): Beschreiben Sie in 1-2 Sätzen was Sie ändern würden und warum
    // Die Klammern sollten entweder bei einzeiligen if-statements entfernt werden oder es sollte in mehrere zeilen aufgeteilt werden
    // Korrektes einrücken des Codes damit dieser leichter lesbar ist/man eher sieht wo wann welche schleife aufhört



    //TODO zu Punkt c und d): Implementieren Sie hier die Methoden Ihrer Lösung
    public static void drawRaute(int seite){
        //seite da die raute eine gewisse seitenlänge hat

        int hoehe = seite * 2 + 1 + 2 ; // nur so dumm angeschrieben damit man es leichter verstehen kann + 1 für die mitte und + 2 für den rand oben und unten
        int breite = seite * 2 ;

        for (int i = 0; i < hoehe; i++) {

            if(i == 0 || i == hoehe - 1){ // first and last row
                printPLine(breite);
            }else if(i == (hoehe-1)/2){ // middel row
                System.out.print("#|");
                for (int j = 0; j < breite - 2; j++) {
                    System.out.print(" ");
                }
                System.out.println("|#");
            }else{ // abov middel
                if(i < (hoehe-1)/2){
                    drawDreieck(seite, true);
                    i += seite-1;
                }else{ // below middel
                    drawDreieck(seite, false);
                    i += seite-1;
                }
            }
        }
    }


    public static void printPLine(int breite){
        System.out.print("#");
        for (int i = 0; i < breite; i++) {
            System.out.print("+");
        }
        System.out.println("#");
    }

    public static void drawDreieck(int height, boolean up){

        int width = height * 2; // damit ma wissen wie breit der ganze spaß wird
        int peak = height; // damit man weiß wo die spitze des dreiecks ist
        int peakM = height; // damit man eine hilfsvariable hat die man bearbeiten kann aber den gleichen wert hat wie peak
        int points = height-1; // damit man weiß wie viele punkte pro ebene gerpintet werden müssen

        if(up){
            for (int i = 1; i <= height; i++) {
                System.out.print("#"); // start #
                for (int j = 0; j < width; j++) {
                    if(j < points || j > peak){ // punkt bis vor/nach dem peak
                        System.out.print(".");
                    }else if(j == peakM - i){ // erster teil vom dreieck
                        System.out.print("/");
                    }else if(j == peak){ // zweiter teil vom dreieck
                        System.out.print("\\");
                    }else{ // die füllung dazwischen mit den abständen
                        System.out.print(" ");
                    }
                }
                System.out.println("#"); // end #
                points--; // damit
                peak++; //
            }
           
        }else{
            peak = width-1; // startet bei bsp 7 und wird bis zur mitte kleiner / immer um 1 kleiner somit wird auch immer ein punkt mehr
            peakM = 0; // startet von 0 und wird passend größer
            points = 0; //erhöht sich jede runde um 1 und somit kommt auch immer ein punkt dazu

            for (int i = 1; i <= height; i++) {
                System.out.print("#"); // start #
                for (int j = 0; j < width; j++) {
                    if(j < points || j > peak){ // punkt bis vor/nach dem peak
                        System.out.print(".");
                    }else if(j == peak){ // erster teil vom dreieck
                        System.out.print("/");
                    }else if(j == peakM){ // zweiter teil vom dreieck
                        System.out.print("\\");
                    }else{ // die füllung dazwischen mit den abständen
                        System.out.print(" ");
                    }
                }
                System.out.println("#"); // end #
                points++; // damit mehr punkte links sind
                peakM++; // damit sich der \ verschiebt
                peak--; // damit sich das / verschiebt und rechts punkte kommen
            }
        }


    }




    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt c,d und e): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");

        drawRaute(5);

        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:"); // allgemein bissl mehr zeilenumbrüche

        System.out.print("#");
        for (int i = 1; i <= 8; i++) {System.out.print("+");} // Klammern weg oder einrücekn / for fixen // eigene Methode
        System.out.println("#");

        for (int i = 1; i < 5; i++) { // ab hier startend richtig einrücken
        System.out.print("#");
        for (int j = 2; j <= (8 / 2 - i + 1); j++) {System.out.print("."); // Klammern weg oder einrücekn
        }
        System.out.print("/");
        for (int j = 1; j <= 2 * (i - 1); j++) {
            System.out.print(" ");
        }
            System.out.print("\\");
            for (int j = 2; j <= (8 / 2 - i + 1); j++) {
            System.out.print(".");
            }System.out.print("#");System.out.println();// nach der } zeilenumbruch und beider prints in unterschiedliche zeilen
        }// fertig richtig einrücken

        System.out.println("#|      |#");
        for (int i = 1; i < 5; i++) {// ab hier richtig einrücken
        System.out.print("#");
        for (int j = 2; j <= i; j++) {
            System.out.print(".");
        }
            System.out.print("\\");
for (int j = 1; j <= (8 - 2 * i); j++) {
    System.out.print(" ");
}
            System.out.print("/");
            for (int j = 2; j <= i; j++) {
                System.out.print(".");
}
            System.out.print("#");
            System.out.println();
}// ende richtig einrücken

        System.out.print("#");
        for (int i = 1; i <= 8; i++) { // eigene Methode
        System.out.print("+");} // zeilen umbruch vor der }
        System.out.println("#");
    }


}


