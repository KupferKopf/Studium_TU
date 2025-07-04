# EP2 Vorbereitungstest 2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt erfolgen.
* Verändern Sie keine der vorgegebenen Methodensignaturen.
* Implementieren Sie keine unnötigen Getter-/Setter-Methoden.
* Alle Objektvariablen müssen `private` sein.
* Von Ihnen zusätzlich erstellte Methoden in vorgegebenen Klassen müssen `private` sein. 
  Das gilt aber nicht für das Überschreiben von Methoden.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen (Lambdas sind aber erlaubt).
* Auch für teilweise korrekte Lösungen werden Punkte vergeben.
* Sie dürfen zur Lösung dieser Aufgabe auf das Java-Collections-Framework und andere 
  standardmäßig vorhandene Interfaces und Klassen zurückgreifen.

## Information zur Domäne

Ein Mobile (`Mobile`) ist ein hängender Zimmerschmuck mit rekursiv verschachtelter Struktur:
Horizontale Trägerstäbe (`BalancedStick`) tragen an jedem der beiden Enden jeweils ein
Hängeelement, das eine einfache Dekorationen (`Decoration`) oder ein weiteres
Mobile-Element (`Mobile`) sein kann. In dieser Aufgabe gibt es als konkrete Dekorationen
nur Sterne (`Star`). Daraus ergibt sich eine rekursive, hierarchische Baumstruktur in der Sterne
(`Star`) die Blattknoten bilden und Trägerstäbe (`Stick`) Knoten mit genau 2 Nachfolgern.
Entscheidend ist die mechanische Ausbalancierung jedes einzelnen Stabs: Die beiden Hängeelemente
müssen dasselbe Gewicht haben.

Die folgende Zeichnung zeigt ein Beispiel eines Mobiles mit drei Trägerstäben. Als Dekorationen 
kommen nur Sterne (`*`) vor. Die Zahlen stellen die Gewichte der Komponenten dar. Das 
Gesamtgewicht des Mobiles ist 40. 

```txt
             |
         +---2---+
         |       |
      +--2--+    *
      |     |    16
      *  +--1--+
      7  |     |
         *     *
         3     3 
```

## Aufgabenstellung

Die für diesen Test relevanten Dateien sind:

* [ApplicationTest2.java](../src/ApplicationTest2.java)
* [MCTest2.java](../src/MCTest2.java)
* [Mobile.java](../src/Mobile.java)
* [Decoration.java](../src/Decoration.java)
* [Star.java](../src/Star.java)
* [BalancedStick.java](../src/BalancedStick.java)
* [StarCollection.java](../src/StarCollection.java)
* [StarIterable.java](../src/StarIterable.java)
* [StarIterator.java](../src/StarIterator.java)
* [UnbalancedException.java](../src/UnbalancedException.java)

Im Praxisteil des Tests sollen die hier aufgelisteten Dateien bearbeitet werden:

* [Star.java](../src/Star.java)
* [BalancedStick.java](../src/BalancedStick.java)
* [UnbalancedException.java](../src/UnbalancedException.java)

### Teilaufgabe 1 (maximal 25 Punkte)

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die
Datei `MCTest2.java` und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Wenn Sie
`MCTest2.java` ausführen, bekommen Sie eine Fehlermeldung, falls inhaltlich relevante Textteile
verändert wurden; ohne Fehler werden Ihre Antworten auf die Fragen aufgelistet.

### Teilaufgabe 2 (maximal 75 Punkte)

Lösen Sie den Praxisteil. Vervollständigen Sie dazu die Klassen 
[BalancedStick.java](../src/BalancedStick.java), [Star.java](../src/Star.java) und 
[UnbalancedException.java](../src/UnbalancedException.java) 
gemäß der in den Spezifikationen in den entsprechenden Dateien.

English translation: Solve the practical programming part. Complete the classes
[BalancedStick.java](../src/BalancedStick.java),
[Star.java](../src/Star.java) and [UnbalancedException.java](../src/UnbalancedException.java) 
according to the specifications given in their respective files.

Vervollständigen Sie die Klassen in den oben aufgelisteten Dateien bitte wie in den Kommentaren
beschrieben an den mit `TODO` gekennzeichneten Stellen. Alle anderen gegebenen Dateien (außer
`MCTest2.java` und `ApplicationTest2.java`) sind bereits vollständig und dürfen nicht verändert
werden.

Die Klasse `ApplicationTest2` enthält Testfälle mit Soll-Ausgaben als Kommentare. Neben diesen
Testfällen müssen auch alle Kommentare in den gefragten Klassen zutreffen. Die Klasse
`ApplicationTest2` fließt nicht in die Beurteilung ein, Sie können diese Datei nach Belieben ändern.
