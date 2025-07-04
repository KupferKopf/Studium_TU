package AB7;

// Bitte beantworten Sie die Multiple-Choice-Fragen.

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class MCTestAB7 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTestAB7 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",

                        new Choice(false, "'Propagieren einer Ausnahme' bedeutet: 'Ausnahme wird abgefangen'.                 (1A)"),
                        new Choice(true, "Ausnahmen vom Typ Error sind nicht überprüft (unchecked).                          (1B)"),
                        new Choice(false, "Ausnahmen vom Typ NullPointerException sind überprüft (checked).                   (1C)"),
                        new Choice(false, "Das Java-Laufzeitsystem wirft nur überprüfte (checked) Ausnahmen.                  (1D)"),
                        new Choice(false, "Gibt es mehrere catch-Blöcke, wird der letzte passende ausgeführt.                 (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                                "Java-Collections-Framework zu?",

                        new Choice(false, "TreeSet<E> ist Untertyp von SortedMap<K,V>.                                        (2A)"),
                        new Choice(false, "LinkedList<E> implementiert ArrayList<E>                                           (2B)"),
                        new Choice(true, "Queue<E> erweitert Collection<E> um zusätzliche Methoden.                          (2C)"),
                        new Choice(true, "Set<E> verbietet mehrere gleiche Einträge.                                         (2D)"),
                        new Choice(true, "In eine Queue<E> kann man neben add auch mittels offer einfügen.                   (2E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle
            " 1. Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?\n" +
                    "    \n" +
                    "    XXXXXXXXX 'Propagieren einer Ausnahme' bedeutet: 'Ausnahme wird abgefangen'.                 (1A)\n" +
                    "    XXXXXXXXX Ausnahmen vom Typ Error sind nicht überprüft (unchecked).                          (1B)\n" +
                    "    XXXXXXXXX Ausnahmen vom Typ NullPointerException sind überprüft (checked).                   (1C)\n" +
                    "    XXXXXXXXX Das Java-Laufzeitsystem wirft nur überprüfte (checked) Ausnahmen.                  (1D)\n" +
                    "    XXXXXXXXX Gibt es mehrere catch-Blöcke, wird der letzte passende ausgeführt.                 (1E)\n" +
                    "\n" +
                    " 2. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                    "    Java-Collections-Framework zu?\n" +
                    "    \n" +
                    "    XXXXXXXXX TreeSet<E> ist Untertyp von SortedMap<K,V>.                                        (2A)\n" +
                    "    XXXXXXXXX LinkedList<E> implementiert ArrayList<E>                                           (2B)\n" +
                    "    XXXXXXXXX Queue<E> erweitert Collection<E> um zusätzliche Methoden.                          (2C)\n" +
                    "    XXXXXXXXX Set<E> verbietet mehrere gleiche Einträge.                                         (2D)\n" +
                    "    XXXXXXXXX In eine Queue<E> kann man neben add auch mittels offer einfügen.                   (2E)\n" +
                    "\n";

    public static final long UID = 1775044353336427L;

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