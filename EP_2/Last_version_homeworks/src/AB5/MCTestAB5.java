package AB5;

// Bitte beantworten Sie die Multiple-Choice-Fragen.

public class MCTestAB5 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTestAB5 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?",

                        new Choice(true, "Rekursive Traversierungen durch Iteratoren sind kaum sinnvoll.                     (1A)"),
                        new Choice(true, "Iterator-Implementierungen sind eigene Klassen.                                    (1B)"),
                        new Choice(false, "Mehrere Iteratoren auf dem gleichen Objekt stören sich gegenseitig.                (1C)"),
                        new Choice(true, "Lineare Listen sind meist einfacher iterierbar als Binärbäume.                     (1D)"),
                        new Choice(false, "Die Reihenfolge der Iterationen zeigt die Art der Datenstruktur.                   (1E)")
                ),
		
                new Question(
                        "i, j und k seien Objektreferenzen ungleich null.\n" +
                        "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
                        "boolean equals(Object obj)  und  int hashCode()  in Java gelten?",

                        new Choice(false, "null.equals(k)  gibt  false  zurück.                                               (2A)"),
                        new Choice(true, "Aus  i.equals(j)  folgt  i.hashCode() == j.hashCode().                             (2B)"),
                        new Choice(true, "Aus  i.equals(j)  und  j.equals(k)  folgt  k.equals(i).                            (2C)"),
                        new Choice(false, "Aus  i.hashCode() == j.hashCode()  folgt  i.equals(j).                             (2D)"),
                        new Choice(false, "Aus  i.equals(j)  folgt  !j.equals(i).                                             (2E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Rekursive Traversierungen durch Iteratoren sind kaum sinnvoll.                     (1A)\n" +
            "    XXXXXXXXX Iterator-Implementierungen sind eigene Klassen.                                    (1B)\n" +
            "    XXXXXXXXX Mehrere Iteratoren auf dem gleichen Objekt stören sich gegenseitig.                (1C)\n" +
            "    XXXXXXXXX Lineare Listen sind meist einfacher iterierbar als Binärbäume.                     (1D)\n" +
            "    XXXXXXXXX Die Reihenfolge der Iterationen zeigt die Art der Datenstruktur.                   (1E)\n" +
            "\n" +
            " 2. i, j und k seien Objektreferenzen ungleich null.\n" +
            "    Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "    boolean equals(Object obj)  und  int hashCode()  in Java gelten?\n" +
            "    \n" +
            "    XXXXXXXXX null.equals(k)  gibt  false  zurück.                                               (2A)\n" +
            "    XXXXXXXXX Aus  i.equals(j)  folgt  i.hashCode() == j.hashCode().                             (2B)\n" +
            "    XXXXXXXXX Aus  i.equals(j)  und  j.equals(k)  folgt  k.equals(i).                            (2C)\n" +
            "    XXXXXXXXX Aus  i.hashCode() == j.hashCode()  folgt  i.equals(j).                             (2D)\n" +
            "    XXXXXXXXX Aus  i.equals(j)  folgt  !j.equals(i).                                             (2E)\n" +
            "\n";

    public static final long UID = 1775044353336426L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}
