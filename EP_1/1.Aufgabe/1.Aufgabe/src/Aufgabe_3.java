import java.sql.SQLOutput;

public class Aufgabe_3 {

    public static void main(String[] args) {

        int iterations = 500;
        int maxCap = 1500;
        int numFoxes = 2;
        int numRabbits = 2500;

        hasenAndFoxes(iterations, maxCap, numFoxes, numRabbits);


    }

    public static void hasenAndFoxes(int rounds, int _maxCap, int numOfFoxes, int numOfRabbits){

        final int dt = 1;

        double maxCap = _maxCap; // maximale capazität der Weide
        double numRabbits = numOfRabbits; // anzahl der Hasen auf der Weide
        double numFoxes = numOfFoxes; // anzahl der Füchse auf der Weide

        double rabbitSym = 0; // anzahl der Hasensymbole *
        double foxSym = 0; // anzahl der Fuchssymbole #



        for(int i = 1; i <= rounds; i += dt){


            double freeCap = maxCap- numRabbits; // maxCap - numRabbits;

            // +8% -> % menge an wachstum der anzahl an Hasen PRO Woche (wenn es genug platzt gibt)
            double incRabbits = (1.0 / maxCap) * freeCap * 0.08 * numRabbits;

            // -20% -> % menge an biomassen verlust PRO Woche
            double decFoxes = 0.2 * numFoxes;

            double numContacts = numRabbits * numFoxes;

            //new amount of Rabbits and foxes after assesing the change of
            numRabbits = numRabbits + dt * (incRabbits- 0.002 * numContacts);
            numFoxes = numFoxes + dt * (0.0004 * numContacts- decFoxes);


            //print out section
            System.out.format("Iteration: %d" + " | freeCap: %.2f" + " | numRabbits: %.2f" + " | numFoxes: %.2f" ,i,freeCap,numRabbits,numFoxes);
            System.out.println();

            rabbitSym = Math.round(numRabbits/5);
            for (int j = 0; j < rabbitSym; j++) {
                System.out.print("*");
            }
            System.out.println();

            foxSym = Math.round(numFoxes/2.5);
            for (int j = 0; j < foxSym; j++) {
                System.out.print("#");
            }
            System.out.println();


        }

    }

}
