# EP2 Aufgabenblatt 6

Kernthemen: Sortieren, Sichtweisen vs. Kopien

## Organisatorisches
Abgabe Deadline: 20.05.2025 13:00<br>
Art der Abgabe: git commit & git push<br>
Erzielbare Punkteanzahl: 7

### Allgemeine Hinweise
* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Führen Sie keine weiteren eigenen Klassen ein.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie *keine* der vorgegebenen Methodensignaturen.
* Implementieren Sie keine unnötigen Getter-/Setter-Methoden.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden in vorgegebenen
  Klassen müssen `private` sein.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen.
* Verändern Sie keine vorgegebenen Programmteile oder Dateien, die mit ```DO NOT EDIT``` gekennzeichnet sind.
* Verändern Sie keine vorgegebenen Variablendeklarationen oder Code-Fragmente, außer den return-Statements in Methoden,
  die Sie implementieren müssen.
* **Achten Sie darauf, dass Ihre Abgabe ausführbar ist. Nicht lauffähige Abgaben werden nicht beurteilt.**

## Information zur Domäne
In diesem Aufgabenblatt werden Teile der Anwendung aus AB4 und AB5 weiterentwickelt. Alle Informationen zur Domäne 
können daher, wenn benötigt, dem [Angabeblatt von AB4](../AB4/angabe.md) entnommen werden.

## Aufgabenstellung

Ziel dieser Aufgabe ist die Entwicklung eines vereinheitlichten und erweiterbaren Systems zur Speicherung und
Verwaltung simulierter Saurier. Darüber hinaus soll ein Teil der Spiellogik implementiert werden. 

Konkret soll für die Dino-Park-Simulation eine Kampf-Arena sowie die zugehörige Kampflogik der Dinosaurier samt der
Simulation von Show-Kämpfen implementiert werden. 

Ein Kampf besteht dabei aus einer festen Anzahl von Runden, die durch die Länge der genetisch vorherbestimmten
Aktionsfolge (siehe [ArenaFightingBehavior](../../src/AB6/ArenaFightingBehavior.java) ```BATTLEPLAN_SIZE```)
der Saurier festgelegt wird. Jeder Kämpfer tätigt pro Runde genau eine vorherbestimmte Aktion (die in der Aktionsfolge nächste Aktion).
Diese wird dann mit der vom Gegner ebenfalls getätigten Aktion
verglichen, wobei bestimmte Aktionen über andere siegen. Den Kampf gewinnt jener Saurier, der in der Mehrheit der Runden
des Kampfes die siegreiche Aktion getätigt hat. Ein Kampf kann auch unentschieden enden. Welche Aktion ein Saurier in
welcher Runde tätigt ist im Genom des Sauriers, quasi als Plan, festgelegt. Die verfügbaren Aktionen sind Beissen,
Ausweichen, Peitschenschlag mit dem Schwanz und Nichtstun. Dabei gelten folgende Regeln: 
* Beissen siegt über Peitschenschlag und verliert gegen Ausweichen
* Peitschenschlag siegt über Ausweichen und verliert gegen Beissen
* Ausweichen siegt über Beissen und verliert gegen Peitschenschlag
* Nichtstun unterliegt allen Aktionen außer dem ebenfalls Nichtstun des Gegners

Zur Abwicklung von Dinosaurierkampf-Turnieren dient die Arena, welche einen Pool von Startern (Dinosaurierkämpfer)
erhält, daraus eine Teilnehmerliste (roster), sowie eine Punktetabelle (scoresheet) erstellt, und damit dann ein Turnier
simuliert. Dabei tritt jeder Teilnehmer gegen jeden anderen Teilnehmer an. Erzielte Siege werden in der Punkteliste
eingetragen. Nach Abschluss des Turniers stellt die Arena dann das nach Platzierung sortierte Ergebnis mittels eines
speziellen sortierenden Iterators zur Verfügung.

Zur Verwaltung und Handhabung der simulierten Saurier sollen auch verschiedene Arten von Iteratoren realisiert werden,
die in der Lage sind unterschiedliche Sichten des Grunddatenbestandes zur Verfügung zu stellen.
Diese Iteratoren sollen sowohl in der Lage sein, Filterung als auch Sortierung nach verschiedenen Kriterien
zur Verfügung zu stellen.

Zur Lösung der Aufgabenstellung ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie der Kommentare im
Quellcode anzupassen und zu vervollständigen. Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit 
```@TODO``` gekennzeichnet.

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [Arena.java](../../src/AB6/Arena.java)
* [ArenaFightingBehavior.java](../../src/AB6/ArenaFightingBehavior.java)
* [ArenaBattleSimulation.java](../../src/AB6/ArenaBattleSimulation.java)
* [TournamentResultIterator.java](../../src/AB6/TournamentResultIterator.java)
* [DinosaurFilteringIterator.java](../../src/AB6/DinosaurFilteringIterator.java)
* [FemaleSelector.java](../../src/AB6/FemaleSelector.java)
* [MaleSelector.java](../../src/AB6/MaleSelector.java)
* [TyrannosaurusRex.java](../../src/AB6/TyrannosaurusRex.java)
* [Edmontosaurus.java](../../src/AB6/Edmontosaurus.java)
* [Application.java](../../src/AB6/Application.java)
* [MCTestAB6.java](../../src/AB6/MCTestAB6.java)

Darüber hinaus erhalten Sie wieder ein Paket/Verzeichnis [Interfaces](../../src/AB6/Interfaces) mit
Interface-Definitionen und ein Paket/Verzeichnis mit vorgefertigtem Code [Provided](../../src/AB6/Provided). 
Diese sind für Ihre Implementierungsarbeit relevant, dürfen aber wie gewohnt nicht verändert
werden.

Die Hauptklasse der Anwendung, also der Einstiegspunkt in die Anwendungslogik, ist die Klasse
[Application](../../src/AB6/Application.java). Dort sind in der Methode ```Application.main()``` alle notwendigen Objekte
zu erzeugen und aufzurufen, um die Funktionsweise der Anwendung zu demonstrieren. So sind bereits verschiedene
Anwendungsfälle für unterschiedliche Testaufrufe vorgegeben. Weitere Anwendungs- wie auch etwaige selbst entwickelte
Testfälle sollen dort ebenfalls implementiert werden.


### Teilaufgabe 1

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die Datei [MCTestAB6.java](../../src/AB6/MCTestAB6.java)
und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Führen Sie diese Datei dann zur Kontrolle aus.
Eine Auswertung Ihrer Ergebnisse kann nach Einreichung Ihrer Abgabe Server-seitig erfolgen.

### Teilaufgabe 2

Implementieren Sie die mit ```TODO: implementation``` gekennzeichneten Methoden.
Testen Sie jede einzelne Klasse gewissenhaft, auch jene Methoden die vom Beispielcode in ```Application.main()```
nicht aufgerufen werden.
Vergleichen Sie die von Ihrer Implementierung gemachten Berechnungen bzw. Ausgaben mit
bekannten oder manuell berechneten Werten. Sie dürfen dazu in der Datei [Application.java](../../src/AB6/Application.java) 
Änderungen nach Belieben vornehmen. Diese Datei muss für eine erfolgreiche Abgabe zwar ausführbar sein, wird aber nicht
zur Bewertung herangezogen.


#### Beispielausgabe

Bei korrekter Implementierung aller TODOs bewirkt folgender Code bei Aufruf von [Application.main()](../../src/AB6/Application.java)

```java
public class Application {
  public static void main(String[] args) {

    // create some meaningful dino dna
    int geneticCodeAllrounder = (0b0001 << 20) | (0b1110010011100100 << 4) | 0b0001; // uniqueID, battlePlan, male
    int geneticCodeGandhi = (0b0010 << 20) | (0b0000000000000000 << 4) | 0b0001; // uniqueID, battlePlan, male
    int geneticCodeCyclone = (0b0011 << 20) | (0b1010011010100110 << 4) | 0b0001; // uniqueID, battlePlan, male
    int geneticCodeMuncher = (0b0100 << 20) | (0b0011111100111111 << 4) | 0b0001; // uniqueID, battlePlan, male
    int geneticCodeBrainiac = (0b0101 << 20) | (0b1110110111111001 << 4) | 0b0000; // uniqueID, battlePlan, female
    int geneticCodeLunatic = (0b0111 << 20) | (0b1101110111011101 << 4) | 0b0000; // uniqueID, battlePlan, female

    DinosaurCollection population = new DinosaurCollection(); // list of all participants

    population.store(new Edmontosaurus(new DinosaurDNA(geneticCodeLunatic), "Ms. Luna"));
    population.store(new Edmontosaurus(new DinosaurDNA(geneticCodeCyclone), "Typhoon D."));
    population.store(new TyrannosaurusRex(new DinosaurDNA(geneticCodeAllrounder), "Mr. Big"));
    population.store(new Edmontosaurus(new DinosaurDNA(geneticCodeGandhi), "Gandhi"));
    population.store(new TyrannosaurusRex(new DinosaurDNA(geneticCodeMuncher), "Morris the Muncher"));
    population.store(new TyrannosaurusRex(new DinosaurDNA(geneticCodeBrainiac), "Mrs. Brainiac"));

    System.out.println("Setting up the 2025 International Dino Games with " + population.size() + " participants...");

    System.out.println("Female participants:");
    DinosaurFilteringIterator femaleDinoIterator = population.filteringIterator(new FemaleSelector());
    while (femaleDinoIterator.hasNext()) {
      System.out.println("   " + femaleDinoIterator.next().getName());
    }

    System.out.println("Male participants:");
    DinosaurFilteringIterator maleDinoIterator = population.filteringIterator(new MaleSelector());
    while (maleDinoIterator.hasNext()) {
      System.out.println("   " + maleDinoIterator.next().getName());
    }
    System.out.println();

    // setting up the arena
    Arena arena = new Arena(new ArenaBattleSimulation(), population);

    // run the tournament
    System.out.println("Let's get ready to rumble...");
    arena.runTournament();

    // print the results
    TournamentResultIterator resultIterator = arena.getResultIterator();
    System.out.println("Results:");
    int position = 1;
    while (resultIterator.hasNext()) {
      System.out.println("Rank " + position++ + ": " + resultIterator.next().getName());
    }
  }
}
```
folgende (hier gekürzte) Ausgabe am Bildschirm:

```txt
Setting up the 2025 International Dino Games with 6 participants...
Female participants:
   Ms. Luna
   Mrs. Brainiac
Male participants:
   Typhoon D.
   Mr. Big
   Gandhi
   Morris the Muncher

Let's get ready to rumble...
# Ms. Luna vs. Typhoon D.
  Round 0: DODGE vs. TAIL_WHIP => TAIL_WHIP wins.
  Round 1: BITE vs. DODGE => DODGE wins.
  Round 2: DODGE vs. TAIL_WHIP => TAIL_WHIP wins.
  Round 3: BITE vs. TAIL_WHIP => BITE wins.
  Round 4: DODGE vs. TAIL_WHIP => TAIL_WHIP wins.
  Round 5: BITE vs. DODGE => DODGE wins.
  Round 6: DODGE vs. TAIL_WHIP => TAIL_WHIP wins.
  Round 7: BITE vs. TAIL_WHIP => BITE wins.
Winner: Typhoon D.

# Ms. Luna vs. Mr. Big
  Round 0: DODGE vs. NONE => DODGE wins.
  Round 1: BITE vs. DODGE => DODGE wins.
  Round 2: DODGE vs. TAIL_WHIP => TAIL_WHIP wins.
  Round 3: BITE vs. BITE => draw
  Round 4: DODGE vs. NONE => DODGE wins.
  Round 5: BITE vs. DODGE => DODGE wins.
  Round 6: DODGE vs. TAIL_WHIP => TAIL_WHIP wins.
  Round 7: BITE vs. BITE => draw
Winner: Mr. Big

...
several lines were removed here to shorten this text
...

# Morris the Muncher vs. Mrs. Brainiac
  Round 0: BITE vs. DODGE => DODGE wins.
  Round 1: BITE vs. TAIL_WHIP => BITE wins.
  Round 2: BITE vs. BITE => draw
  Round 3: NONE vs. BITE => BITE wins.
  Round 4: BITE vs. DODGE => DODGE wins.
  Round 5: BITE vs. BITE => draw
  Round 6: BITE vs. TAIL_WHIP => BITE wins.
  Round 7: NONE vs. BITE => BITE wins.
Winner: Mrs. Brainiac

Results:
Rank 1: Mrs. Brainiac
Rank 2: Ms. Luna
Rank 3: Typhoon D.
Rank 4: Mr. Big
Rank 5: Morris the Muncher
Rank 6: Gandhi
```


