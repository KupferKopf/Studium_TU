package AB4;

// Bitte beantworten Sie die Multiple-Choice-Fragen

public class MCTestAB4 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "J sei ein Referenztyp (Klasse oder Interface), und x sei eine durch\n" +
                        "'W x = new D();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden J, W, D und x zu?",

                        new Choice(true, "'(J)x' liefert Laufzeitfehler wenn D nicht Untertyp von J ist.                (1A)"),
                        new Choice(true, "D ist Untertyp von W.                                                         (1B)"),
                        new Choice(false, "'(J)null' liefert einen Laufzeitfehler.                                       (1C)"),
                        new Choice(false, "'(J)x' ändert den dynamischen Typ von x auf J.                                (1D)"),
                        new Choice(true, "Mit 'D ist Untertyp von J' gilt: '((J)x).getClass() == J.class'               (1E)")
                ),

                new Question(
                        "R und Y seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
                        "fehlerfrei compiliert: 'Y j = new R();  j.s();'\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden R, Y, j und s() zu?",

                        new Choice(true, "Y kann Interface oder Klasse sein.                                            (2A)"),
                        new Choice(true, "R kann kein Interface, sondern muss eine Klasse sein.                         (2B)"),
                        new Choice(true, "Die Methode s() muss in R und Y vorhanden sein.                               (2C)"),
                        new Choice(true, "Durch 'j.s()' wird die Methode in R ausgeführt.                               (2D)"),
                        new Choice(false, "Kommentare zu s() in Y müssen auch auf s() in R zutreffen.                    (2E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. J sei ein Referenztyp (Klasse oder Interface), und x sei eine durch\n" +
            "    'W x = new D();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden J, W, D und x zu?\n" +
            "    \n" +
            "    XXXXXXXXX '(J)x' liefert Laufzeitfehler wenn D nicht Untertyp von J ist.                (1A)\n" +
            "    XXXXXXXXX D ist Untertyp von W.                                                         (1B)\n" +
            "    XXXXXXXXX '(J)null' liefert einen Laufzeitfehler.                                       (1C)\n" +
            "    XXXXXXXXX '(J)x' ändert den dynamischen Typ von x auf J.                                (1D)\n" +
            "    XXXXXXXXX Mit 'D ist Untertyp von J' gilt: '((J)x).getClass() == J.class'               (1E)\n" +
            "\n" +
            " 2. R und Y seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
            "    fehlerfrei compiliert: 'Y j = new R();  j.s();'\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden R, Y, j und s() zu?\n" +
            "    \n" +
            "    XXXXXXXXX Y kann Interface oder Klasse sein.                                            (2A)\n" +
            "    XXXXXXXXX R kann kein Interface, sondern muss eine Klasse sein.                         (2B)\n" +
            "    XXXXXXXXX Die Methode s() muss in R und Y vorhanden sein.                               (2C)\n" +
            "    XXXXXXXXX Durch 'j.s()' wird die Methode in R ausgeführt.                               (2D)\n" +
            "    XXXXXXXXX Kommentare zu s() in Y müssen auch auf s() in R zutreffen.                    (2E)\n" +
            "\n";

    public static final long UID = 2025022769820430L;

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
