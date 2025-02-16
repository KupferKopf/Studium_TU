/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void printArray(int[] workArray) {
        for (int i = workArray.length; i > 0; i--) {
            System.out.print(workArray[i-1] + " ");
        }
        System.out.println();
    }

    private static void fillArray(int[] filledArray) {
        int number = 3;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 3;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 9 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[15];
        int number = 4;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 4;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    public static void main(String[] args) {
        int[] filledArray = new int[15];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 123;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Antwort zu Punkt a: da die schleife i >= 15 im argument stehen hatte kam es zu einem outOfBounds Fehler da wir versucht haben auf eine stelle im array zuzugreifen welche nicht exestiert (max 15 stellen)
    //
    //Antwort zu Punkt b: Der array soll befüllt werden, nicht ausgegeben, die Methode macht was sie verspricht und befüllt den array mit werten (vielfach von 3)
    //
    //Antwort zu Punkt c: es wird nicht der ganze array kopiert sondern nur die referenzen des arrays mit denen er auf die Daten zugreift, somit haben wir 2 arrays die auf dei gleichen daten zugreifen
    //
    //Antwort zu Punkt d: in Zeile 38 wird die Temporäre/Übergegebene Variable überspeichert aber nicht das original, dafür müsste man den neuen array returnen und die allgemeine/globale array-liste überspeichern
    //
    //
    //  Zusatzfragen:
    //
    //  1. Welchen Datentyp muss der Indexausdruck haben, mit dem die Position in einem Array
    // bestimmt wird?
    //  A: Int - ganzzahlig von 0 bis unendlich/wie lang der array halt ist -1
    //
    // 2. Wie kann die Länge eines Arrays verändert werden?
    //  A: man initaliesiert einen neuen Array mit der gewünschten größe da ein Array nach dem erstellen nicht verändert werden kann
    //
    // 3. Wie gehen Sie vor, wenn Sie ein int-Array kopieren müssen?
    //  A: Um sicherzugehen kann ich entweder durch den array durch iterieren/loopen und jedes einzelne element kopieren oder das ganze mit methoden lösen ( clone(), arraycopy(), Array.copyOf(), Array.copyOfRange()
    //
    //
    // int b[] = a.clone();
    // public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
    // public static int[] copyOf?(int[] original, int newLength)
    // public static int[] copyOfRange?(int[] original, int from, int to)
    //
    //
    // 4. Ist es sinnvoll, zwei Arrays mit "==" zu vergleichen? Was passiert im Detail bei einem Vergleich mit "=="?
    // Nein ist nicht sinnvoll da wir beim vergleichen mit == nur die Adressen vergleichen die in den Arrays gespeichert sind und nicht die eigentlichen werte


}
