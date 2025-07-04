# EP2 Aufgabenblatt 4

Kernthemen: Interface, dynamisches Binden, toString

## Organisatorisches
Abgabe Deadline: 06.05.2025 13:00<br>
Art der Abgabe: git commit & git push<br>
Erzielbare Punkteanzahl: 8

### Allgemeine Hinweise
* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Importieren Sie keine zusätzlichen Pakete und Klassen. Führen Sie keine weiteren eigenen Klassen ein.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie *keine* der vorgegebenen Methodensignaturen. Sie dürfen eigene private Methoden (Helper) einführen, falls benötigt.
* Verändern Sie keine vorgegebenen Programmteile oder Dateien, die mit ```DO NOT EDIT``` gekennzeichnet sind.
* Verändern Sie keine vorgegebenen Variablendeklarationen oder Code-Fragmente, außer den return-Statements in Methoden, die Sie implementieren müssen.
* Sie dürfen zum Kopieren von Arrays die Methode ```System.arraycopy()``` benutzen.
* Sie dürfen zum Erzeugen von Zeichenketten ```java.lang.StringBuilder``` benutzen.
* Sie dürfen in [DinoCorp.java](../../src/AB4/DinoCorp.java) zum Umwandeln von Text (```String```) in Zahlenwerte (```int```) ```Integer.parseInt()``` benutzen.
* Sie dürfen in [DinoCorp.java](../../src/AB4/DinoCorp.java) zum Zerlegen von Text in Partitionen ```String.split()``` benutzen.
* **Achten Sie darauf, dass Ihre Abgabe ausführbar ist. Nicht lauffähige Abgaben werden nicht beurteilt.**

## Information zur Domäne
In diesem Aufgabenblatt sollen grundlegende Bestandteile eines neuen Computerspiels des Unternehmens Schneesturm 
entwickelt werden. Das neue Spiel ist eine Dino-Park-Managementsimulation passend zu einem gerade in Entstehung
befindlichen Kinofilm aus dem Jurassic-Universe. Der Spieler ist Manager der Dino Corporation, die Freizeitparks mit
lebenden Dinosauriern betreibt. Der konkrete Entwicklungsauftrag betrifft Bausteine des Spiele-Back-Ends, welche die
Erzeugung und Verwaltung bzw. Versorgung der simulierten Dinosaurier umsetzen.

## Aufgabenstellung

Ziel dieser Aufgabe ist die Entwicklung eines vereinheitlichten und erweiterbaren Systems zur Erzeugung, Speicherung und
Manipulation unterschiedlicher Saurier. Dazu soll einerseits ein binärer Suchbaum zur Speicherung sowie zum Zugriff auf
individuelle Tiere der Gesamtpopulation und zum anderen ein Skript-gesteuerter Erzeugungsmechanismus für Tiere beliebige Saurier-Spezies
entwickelt werden.

* Der Suchbaum ist mit dynamischem Binden der Methoden der Knotenklassen zu implementieren (siehe dazu
VO bzw. Beispiele aus der VO vom 08.04.2025). Das Traversieren des Baums ist rekursiv zu implementieren.
Beachten Sie, dass der binäre Suchbaum mittels dynamischem Binden zu implementieren ist. Daher darf ```null```
nicht verwendet werden, um das Ende eines Pfades/Astes zu kennzeichnen. Stattdessen ist die Referenz auf einen
(statischen) Knoten des Typs ```EmptyTreeNode``` als Nachfolgerreferenz zu verwenden (```NIL``` in
[EmptyTreeNode.java](../../src/AB4/EmptyTreeNode.java)).

* Der Erzeugungsmechanismus folgt dem [Factory Method Pattern](https://en.wikipedia.org/wiki/Factory_method_pattern) sowie
dem [Abstract Factory Pattern](https://en.wikipedia.org/wiki/Abstract_factory_pattern), wobei ein genaues Verständnis
dieser Entwurfsmuster zur Lösung der Aufgabe nicht zwingend erforderlich ist, wenn der Dokumentation des Codes strikt
gefolgt wird.

* Zur Vereinfachung wird das Skript, welches faktisch ein Produktionsplan für die Dino Corporation ist, als Array von
Stings im Speicher gehalten, wobei jeder String einer Zeile entspricht. Syntaktisch sind diese Zeilen wie folgt aufgebaut:
  * Beginnt eine Zeile mit dem Zeichen ```#```, ist dies der Befehl, eine bestimmte Dinosaurierbrutstätte (Factory), von
  denen es zumindest eine pro Spezies gibt, zu aktivieren. Alle auf ```#``` folgenden Buchstaben sind die Bezeichnung der 
  Factory. Beispiel: Die Zeile "#TREX" aktiviert eine Fabrik mit der Bezeichnung TREX, welche ab sofort für die Erzeugung
  neuer Saurier zuständig ist.
  * Alle anderen Zeilen sind Produktionsanweisungen für einzelne Dinosaurier. Dabei werden diese Zeilen mit dem
  Trennzeichen ```!``` in zwei Partitionen geteilt. Die erste (der Teil vor dem Trennzeichen) enthält den Namen des
  Tieres, die zweite (der Teil hinter dem Trennzeichen) dessen als Integer codierte DNA (für diese Aufgabe ist dies ein
  beliebiger Wert). Mehr als ein Trennzeichen je
  Zeile ist nicht zulässig. Das so spezifizierte Tier wird mit dieser Anweisung in der gerade aktiven Dinosaurierbrutstätte
  (Factory) erzeugt, und der Population hinzugefügt. Beispiel: Die Zeile "Daisy!8" weist die Corporation an, in der
  aktiven Factory einen Saurier mit dem Namen Daisy und der DNA 0x00000008 zu erzeugen und im Suchbaum abzuspeichern. Die
  Spezies (z.B. Tyrannosaurus Rex) wird daher durch die zuvor irgendwann aktivierte spezifischen Fabrik (beispielsweise TREX)
  bestimmt.

Zur Lösung der Aufgabenstellung ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie der Kommentare im
Quellcode anzupassen und zu vervollständigen. Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit 
```@TODO``` gekennzeichnet.

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [EmptyTreeNode.java](../../src/AB4/EmptyTreeNode.java)
* [NonEmptyTreeNode.java](../../src/AB4/NonEmptyTreeNode.java)
* [TyrannosaurusRex.java](../../src/AB4/TyrannosaurusRex.java)
* [Edmontosaurus.java](../../src/AB4/Edmontosaurus.java)
* [TRexFactory.java](../../src/AB4/TRexFactory.java)
* [EdSFactory.java](../../src/AB4/EdSFactory.java)
* [DinoCorp.java](../../src/AB4/DinoCorp.java)
* [Application.java](../../src/AB4/Application.java)
* [MCTestAB4.java](../../src/AB4/MCTestAB4.java)

Darüber hinaus erhalten Sie wieder ein Paket/Verzeichnis [Interfaces](../../src/AB4/Interfaces) mit
Interface-Definitionen. Diese sind für Ihre Implementierungsarbeit nun relevant, dürfen aber wie gewohnt nicht verändert
werden, da diese auch (wie bisher) zur Überprüfung Ihrer Abgabe notwendig sind.

Die Hauptklasse der Anwendung, also der Einstiegspunkt in die Anwendungslogik, ist die Klasse
[Application](../../src/AB4/Application.java). Dort sind in der Methode ```Application.main()``` alle notwendigen Objekte
zu erzeugen und aufzurufen, um die Funktionsweise der Anwendung zu demonstrieren. So sind bereits verschiedene
Anwendungsfälle für unterschiedliche Testaufrufe vorgegeben. Weitere Anwendungs- wie auch etwaige selbst entwickelte
Testfälle sollen dort ebenfalls implementiert werden.


### Teilaufgabe 1

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die Datei [MCTestAB4.java](../../src/AB4/MCTestAB4.java)
und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Führen Sie diese Datei dann zur Kontrolle aus.
Eine Auswertung Ihrer Ergebnisse kann nach Einreichung Ihrer Abgabe Server-seitig erfolgen.

### Teilaufgabe 2
Vergleichen Sie die Spezifikation (Java Doc) von Methoden in den Interface-Definitionen mit jener der zugehörigen 
Methoden in den konkreten Klassen. Überlegen Sie, was die Unterschiede bedeuten bzw. welchen Zweck diese haben.

### Teilaufgabe 3

Implementieren Sie die mit ```TODO: implementation``` gekennzeichneten Methoden.
Testen Sie jede einzelne Klasse gewissenhaft, auch jene Methoden die vom Beispielcode in ```Application.main()```
nicht aufgerufen werden.
Vergleichen Sie die von Ihrer Implementierung gemachten Berechnungen bzw. Ausgaben mit
bekannten oder manuell berechneten Werten. Sie dürfen dazu in der Datei [Application.java](../../src/AB4/Application.java) 
Änderungen nach Belieben vornehmen. Diese Datei muss für eine erfolgreiche Abgabe zwar ausführbar sein, wird aber nicht
zur Bewertung herangezogen.


#### Beispielausgabe

Bei korrekter Implementierung aller TODOs bewirkt folgender Code bei Aufruf von [Application.main()](../../src/AB4/Application.java)

```java
public class Application {
    public static void main(String[] args) {
        // build the corporation with an empty dino population
        AbstractTreeNode animals = new EmptyTreeNode();
        DinoCorp corp = new DinoCorp(animals);

        // setup of two factories, one for Tyrannosaurus rex, one for Edmontosaurus
        corp.registerFactory(new TRexFactory(), "TREX");
        corp.registerFactory(new EdSFactory(), "EDMONTOSAURUS");

        // create the production "script"
        String[] executiveOrders = {
                "#TREX",
                "Mom!200",
                "Tick!456",
                "Trick!123",
                "Track!7",
                "#EDMONTOSAURUS",
                "Donald!1",
                "Daisy!8"
        };
        corp.setOrders(executiveOrders);

        // start production by executing the production script
        int oid = 0;
        while (corp.processNextOrder()) {
            System.out.println("order " + executiveOrders[oid++] + " executed.");
        }
        System.out.println();

        // feeding time
        System.out.println("All new and hungry dinos...");
        System.out.println("Angry dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.ANGRY));
        System.out.println("Sad dinos:" + corp.countAnimalsByMood(Dinosaur.Happiness.SAD));
        System.out.println("Happy dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.HAPPY));

        System.out.println("Feed some meat...");
        corp.feed(Dinosaur.Food.MEAT);
        System.out.println("Angry dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.ANGRY));
        System.out.println("Sad dinos:" + corp.countAnimalsByMood(Dinosaur.Happiness.SAD));
        System.out.println("Happy dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.HAPPY));

        System.out.println("Feed some plants...");
        corp.feed(Dinosaur.Food.PLANTS);
        System.out.println("Angry dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.ANGRY));
        System.out.println("Sad dinos:" + corp.countAnimalsByMood(Dinosaur.Happiness.SAD));
        System.out.println("Happy dinos: " + corp.countAnimalsByMood(Dinosaur.Happiness.HAPPY));
        System.out.println();

        System.out.println("Today's cast:");
        // dump dinos to console utilizing the flatten() method
        Dinosaur[] flattened = animals.flatten();
        for (Dinosaur dino : flattened) {
            System.out.println(dino);
        }
    }
}
```
folgende Ausgabe am Bildschirm:

```txt
order #TREX executed.
order Mom!200 executed.
order Tick!456 executed.
order Trick!123 executed.
order Track!7 executed.
order #EDMONTOSAURUS executed.
order Donald!1 executed.
order Daisy!8 executed.

All new and hungry dinos...
Angry dinos: 4
Sad dinos:0
Happy dinos: 2
Feed some meat...
Angry dinos: 0
Sad dinos:2
Happy dinos: 4
Feed some plants...
Angry dinos: 4
Sad dinos:0
Happy dinos: 2

Today's cast:
Edmontosaurus Joe [OK]
TRex Jim [DANGER]
Edmontosaurus Elvis [OK]
TRex Mom [DANGER]
TRex Jack [DANGER]
```



