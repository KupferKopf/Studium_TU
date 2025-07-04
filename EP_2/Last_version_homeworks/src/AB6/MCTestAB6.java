package AB6;

// Bitte beantworten Sie die Multiple-Choice-Fragen.

public class MCTestAB6 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(
		      
                new Question(
                        "Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?",

                        new Choice(false, "Mergesort wird auf Arrays häufiger eingesetzt als Quicksort.                       (1A)"),
                        new Choice(false, "Hash-Tabellen werden wegen ihrer Zufallsabhängigkeit kaum verwendet.               (1B)"),
                        new Choice(true, "Hash-Tabellen sind für geordnete Daten ungeeignet.                                 (1C)"),
                        new Choice(false, "Arrays verwenden wir meist nur wo andere Datenstrukturen nicht passen.             (1D)"),
                        new Choice(false, "Arrays sind für die meisten Anwendungen zu ineffizient.                            (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?",

                        new Choice(false, "Iteratoren über Bäumen traversieren Bäume meist rekursiv.                          (2A)"),
                        new Choice(false, "Das Interface Iterator spezifiziert die Methode iterator().                        (2B)"),
                        new Choice(true, "Eine Collection kann auch mehrere Iterator-Implementierung enthalten.              (2C)"),
                        new Choice(false, "Ein Iterator hält Kopien aller Daten der iterierten Datenstruktur.                 (2D)"),
                        new Choice(true, "Mehrere Iteratoren auf dem gleichen Objekt stören sich nicht gegenseitig.          (2E)")
                )

        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Mergesort wird auf Arrays häufiger eingesetzt als Quicksort.                       (1A)\n" +
            "    XXXXXXXXX Hash-Tabellen werden wegen ihrer Zufallsabhängigkeit kaum verwendet.               (1B)\n" +
            "    XXXXXXXXX Hash-Tabellen sind für geordnete Daten ungeeignet.                                 (1C)\n" +
            "    XXXXXXXXX Arrays verwenden wir meist nur wo andere Datenstrukturen nicht passen.             (1D)\n" +
            "    XXXXXXXXX Arrays sind für die meisten Anwendungen zu ineffizient.                            (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Iteratoren über Bäumen traversieren Bäume meist rekursiv.                          (2A)\n" +
            "    XXXXXXXXX Das Interface Iterator spezifiziert die Methode iterator().                        (2B)\n" +
            "    XXXXXXXXX Eine Collection kann auch mehrere Iterator-Implementierung enthalten.              (2C)\n" +
            "    XXXXXXXXX Ein Iterator hält Kopien aller Daten der iterierten Datenstruktur.                 (2D)\n" +
            "    XXXXXXXXX Mehrere Iteratoren auf dem gleichen Objekt stören sich nicht gegenseitig.          (2E)\n" +
            "\n";

    public static final long UID = 1775044353336426L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
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
