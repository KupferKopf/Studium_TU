# EP2 Aufgabenblatt 5

Kernthemen: equals, Hash-Tabelle, Iterator

## Organisatorisches
Abgabe Deadline: 13.05.2025 13:00<br>
Art der Abgabe: git commit & git push<br>
Erzielbare Punkteanzahl: 8

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
In diesem Aufgabenblatt werden Teile der Anwendung aus AB4 weiterentwickelt. Alle Informationen zur Domäne können daher,
wenn benötigt, dem [Angabeblatt von AB4](../AB4/angabe.md) entnommen werden.

## Aufgabenstellung

Ziel dieser Aufgabe ist die Entwicklung eines vereinheitlichten und erweiterbaren Systems zur Speicherung und
Verwaltung simulierter Saurier. Konkret soll eine Hash-Map implementiert werden, die alle in einem Gehege lebenden Tiere
verwaltet. Da Tiere eindeutig über ihre DNA identifiziert werden, wird die Integer-DNA aus AB4
durch eine eigene DNA-Klasse ersetzt, die als Schlüsselwert für das Hashing fungiert. Um den Simulationsentwicklern
des Auftraggebers ein komfortables Arbeiten mit der Hash-Map, aber auch mit einer zu entwickelnden Dinosaurier-Listenklasse
(BucketList) zu ermöglichen, sind zusätzlich (vereinfachte) Iteratoren zur Hash-Map sowie der darin zur Anwendung kommenden
Listenklasse zu entwickeln.

* Die zu implementierende [DinosaurHashMap](../../src/AB5/DinosaurHashMap.java) soll dem Prinzip des [Closed addressing bzw. Separate chaining](https://en.wikipedia.org/wiki/Hash_table#Separate_chaining) folgen.
  Dabei werden potenzielle Kollisionen zwischen verschiedenen Objekten, die an derselben Position im Array der Hash-Map
  gespeichert werden müssten, vermieden, indem das Daten-Array der Hash-Map keine einzelnen Objekte, sondern Buckets (hier
  sind dies Listen), von Objekten (eben alle, die an denselben Index im Array sollen) speichert.
  Um die Zugriffsgeschwindigkeit der Hash-Map durch langsames lineares Suchen innerhalb eines Buckets nicht allzu sehr zu
  beeinträchtigen, muss die Hash-Map reorganisiert werden, sobald ein Bucket zu viele Objekte enthält. Dieser Vorgang,
  bei dem das Daten-Array der Hash-Map vergrößert (die Anzahl der Buckets erhöht) und der Inhalt der alten Buckets neu
  einsortiert wird, wird als Rehashing bezeichnet.

* Der Listeniterator [DinosaurListIterator](../../src/AB5/DinosaurListIterator.java) für die [DinosaurBucketList](../../src/AB5/DinosaurBucketList.java) soll die Liste
  vom Wurzelknoten (head) weg, hin bis zum Endknoten (Tail), abarbeiten.
  Der [DinosaurHashMapIterator](../../src/AB5/DinosaurHashMapIterator.java) muss keine spezifische Ordnung/Reihenfolge beim
  Verarbeiten der Elemente der Hash-Map einhalten. Vielmehr kann die Verarbeitungsreihenfolge von der Implementierung des
  Iterators festgelegt werden.

Zur Lösung der Aufgabenstellung ist das vorgegebene Code-Skelett entsprechend dieser Angabe sowie der Kommentare im
Quellcode anzupassen und zu vervollständigen. Der Übersichtlichkeit halber sind relevante Stellen im Quellcode mit
```@TODO``` gekennzeichnet.

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [DinosaurDNA.java](../../src/AB5/DinosaurDNA.java)
* [DinosaurBucketList.java](../../src/AB5/DinosaurBucketList.java)
* [DinosaurListIterator.java](../../src/AB5/DinosaurListIterator.java)
* [DinosaurHashMap.java](../../src/AB5/DinosaurHashMap.java)
* [DinosaurHashMapIterator.java](../../src/AB5/DinosaurHashMapIterator.java)
* [TyrannosaurusRex.java](../../src/AB5/TyrannosaurusRex.java)
* [Edmontosaurus.java](../../src/AB5/Edmontosaurus.java)
* [Application.java](../../src/AB5/Application.java)
* [MCTestAB5.java](../../src/AB5/MCTestAB5.java)

Darüber hinaus erhalten Sie wieder ein Paket/Verzeichnis [Interfaces](../../src/AB5/Interfaces) mit
Interface-Definitionen und ein Paket/Verzeichnis mit vorgefertigtem Code [Provided](../../src/AB5/Provided).
Diese sind für Ihre Implementierungsarbeit relevant, dürfen aber wie gewohnt nicht verändert
werden.

Die Hauptklasse der Anwendung, also der Einstiegspunkt in die Anwendungslogik, ist die Klasse
[Application](../../src/AB5/Application.java). Dort sind in der Methode ```Application.main()``` alle notwendigen Objekte
zu erzeugen und aufzurufen, um die Funktionsweise der Anwendung zu demonstrieren. So sind bereits verschiedene
Anwendungsfälle für unterschiedliche Testaufrufe vorgegeben. Weitere Anwendungs- wie auch etwaige selbst entwickelte
Testfälle sollen dort ebenfalls implementiert werden.


### Teilaufgabe 1

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die Datei [MCTestAB5.java](../../src/AB5/MCTestAB5.java)
und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Führen Sie diese Datei dann zur Kontrolle aus.
Eine Auswertung Ihrer Ergebnisse kann nach Einreichung Ihrer Abgabe Server-seitig erfolgen.

### Teilaufgabe 2

Implementieren Sie die mit ```TODO: implementation``` gekennzeichneten Methoden.
Testen Sie jede einzelne Klasse gewissenhaft, auch jene Methoden die vom Beispielcode in ```Application.main()```
nicht aufgerufen werden.
Vergleichen Sie die von Ihrer Implementierung gemachten Berechnungen bzw. Ausgaben mit
bekannten oder manuell berechneten Werten. Sie dürfen dazu in der Datei [Application.java](../../src/AB5/Application.java)
Änderungen nach Belieben vornehmen. Diese Datei muss für eine erfolgreiche Abgabe zwar ausführbar sein, wird aber nicht
zur Bewertung herangezogen.


#### Beispielausgabe

Bei korrekter Implementierung aller TODOs bewirkt folgender Code bei Aufruf von [Application.main()](../../src/AB5/Application.java)

```java
public class Application {
    public static void main(String[] args) {

      Dinosaur dino;

      // check dino DNA
      System.out.println(new DinosaurDNA(5));
      System.out.println();

      // add some dinosaurs to the hashmap
      System.out.println("Storing some dinosaurs in the hashmap...");
      DinosaurHashMap map = new DinosaurHashMap(4, 4);
      for (int i = 0; i < 10; i++) {
        dino = map.put(new TyrannosaurusRex(new DinosaurDNA(i), "TRex_" + i));
        System.out.println((dino != null) ? "Error: store should return null for new nodes" : "dino TRex_" + i + " was stored.");
        dino = map.put(new Edmontosaurus(new DinosaurDNA(i + 16), "Edmont_" + i));
        System.out.println((dino != null) ? "Error: store should return null for new nodes" : "dino Edmont_" + i + " was stored.");
      }
      System.out.println();

      // check the size of the hashmap
      System.out.println("Checking hashmap size...");
      System.out.println("Size: " + map.size());
      System.out.println();

      // find dinosaurs in the hashmap
      System.out.println("Finding some dinosaurs in the hashmap...");
      dino = map.get(new DinosaurDNA(1));
      System.out.println((dino != null) ? dino + " was found." : "Error: find returned null");
      dino = map.get(new DinosaurDNA(3));
      System.out.println((dino != null) ? dino + " was found." : "Error: find returned null");
      dino = map.get(new DinosaurDNA(33));
      System.out.println((dino != null) ? dino + "Error: an unknown dino was found." : "OK: find for unknown dino returned null");
      System.out.println();

      // now remove dinosaurs from the hashmap
      System.out.println("Removing some dinosaurs from the hashmap...");
      dino = map.remove(new DinosaurDNA(1));
      System.out.println((dino != null) ? "removed dino, length=" + map.size() : "Error: removed dino should not be null after removing a dinosaur.");
      dino = map.remove(new DinosaurDNA(3));
      System.out.println((dino != null) ? "removed dino, length=" + map.size() : "Error: removed dino should not be null after removing a dinosaur.");
      dino = map.remove(new DinosaurDNA(666));
      System.out.println((dino == null) ? "OK: unknown dino can not be removed, length=" + map.size() : "Error: dino should be unknown...");
      System.out.println();

      // test the hashmap iterator
      System.out.println("Test hashmap iterator...");
      System.out.println("Order of dinos may vary here, as this iterator's order is implementation specific.");
      DinosaurHashMapIterator mapIterator = map.iterator();
      while (mapIterator.hasNext()) {
        System.out.println(mapIterator.next());
      }
      System.out.println();

      // now clear the hashmap
      System.out.println("Clearing the hashmap...");
      map.clear();
      System.out.println("Size: " + map.size());
      System.out.println();

      // test find and remove on an empty map
      System.out.println("Test find and remove on empty map...");
      dino = map.get(new DinosaurDNA(33));
      System.out.println((dino != null) ? dino + "Error: a dino was found in an empty map!" : "OK: find in empty map returned null");
      dino = map.remove(new DinosaurDNA(1));
      System.out.println((dino == null) ? "OK: remove dino from empty map returned null, length=" + map.size() : "Error: remove from empty map returned a dino!");
      System.out.println();

      // test the hashmap iterator on an empty map
      System.out.println("Test hashmap iterator... (should not produce any output)");
      mapIterator = map.iterator();
      while (mapIterator.hasNext()) {
        System.out.println(mapIterator.next());
      }
      System.out.println();

    }
}
```
folgende Ausgabe am Bildschirm:

```txt
DNA: 101 (5)

Storing some dinosaurs in the hashmap...
dino TRex_0 was stored.
dino Edmont_0 was stored.
dino TRex_1 was stored.
dino Edmont_1 was stored.
dino TRex_2 was stored.
dino Edmont_2 was stored.
dino TRex_3 was stored.
dino Edmont_3 was stored.
dino TRex_4 was stored.
dino Edmont_4 was stored.
dino TRex_5 was stored.
dino Edmont_5 was stored.
dino TRex_6 was stored.
dino Edmont_6 was stored.
dino TRex_7 was stored.
dino Edmont_7 was stored.
dino TRex_8 was stored.
dino Edmont_8 was stored.
dino TRex_9 was stored.
dino Edmont_9 was stored.

Checking hashmap size...
Size: 20

Finding some dinosaurs in the hashmap...
TRex TRex_1 [DANGER] was found.
TRex TRex_3 [DANGER] was found.
OK: find for unknown dino returned null

Removing some dinosaurs from the hashmap...
removed dino, length=19
removed dino, length=18
OK: unknown dino can not be removed, length=18

Test hashmap iterator...
Order of dinos may vary here, as this iterator's order is implementation specific.
TRex TRex_0 [DANGER]
Edmontosaurus Edmont_0 [OK]
TRex TRex_8 [DANGER]
Edmontosaurus Edmont_8 [OK]
Edmontosaurus Edmont_1 [OK]
TRex TRex_9 [DANGER]
Edmontosaurus Edmont_9 [OK]
TRex TRex_2 [DANGER]
Edmontosaurus Edmont_2 [OK]
Edmontosaurus Edmont_3 [OK]
TRex TRex_4 [DANGER]
Edmontosaurus Edmont_4 [OK]
TRex TRex_5 [DANGER]
Edmontosaurus Edmont_5 [OK]
TRex TRex_6 [DANGER]
Edmontosaurus Edmont_6 [OK]
TRex TRex_7 [DANGER]
Edmontosaurus Edmont_7 [OK]

Clearing the hashmap...
Size: 0

Test find and remove on empty map...
OK: find in empty map returned null
OK: remove dino from empty map returned null, length=0

Test hashmap iterator... (should not produce any output)

```


