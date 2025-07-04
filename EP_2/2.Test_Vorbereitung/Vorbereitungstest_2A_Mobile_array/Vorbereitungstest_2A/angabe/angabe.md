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
Horizontale Trägerstäbe (`Stick`) tragen Hängeelemente, die einfache Dekorationen (`Decoration`) 
oder weitere Mobile-Elemente (`Mobile`) sein können. In dieser Aufgabe gibt es als konkrete 
Dekorationen nur Sterne (`Star`). 
Daraus ergibt sich eine rekursive, hierarchische Baumstruktur in der Sterne (`Star`) die Blattknoten 
bilden und Trägerstäbe (`Stick`) Knoten mit mindestens 2 Nachfolgern. In Mobiles kann die 
Anzahl der auf den Trägerstäben befestigten Hängeelemente variieren (Baum mit variabler 
Verzweigungsbreite).

Die folgende Zeichnung zeigt ein Beispiel eines Mobiles mit drei Trägerstäben. Als Dekorationen 
kommen nur Sterne (`*`) vor. Die Zahlen stellen die Gewichte der Komponenten dar. Das 
Gesamtgewicht des Mobiles ist 40. 

```txt
                       |
                +------5------+----+
                |             |    |
       +--------2--+--+       *    *
       |           |  |       12   5
       |           |  *
       *           |  2
       7           |
                +--1--+
                |     |
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
* [Stick.java](../src/Stick.java)
* [StickSet.java](../src/StickSet.java)
* [StarIterable.java](../src/StarIterable.java)
* [StarIterator.java](../src/StarIterator.java)
* [StickBreaksException.java](../src/StickBreaksException.java)

Im Praxisteil des Tests sollen die hier aufgelisteten Dateien bearbeitet werden:

* [Star.java](../src/Star.java)
* [Stick.java](../src/Stick.java)
* [StickBreaksException.java](../src/StickBreaksException.java)

### Teilaufgabe 1 (maximal 25 Punkte)

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die
Datei `MCTest2.java` und befolgen Sie die Anweisungen aus den Kommentaren in der Datei. Wenn Sie
`MCTest2.java` ausführen, bekommen Sie eine Fehlermeldung, falls inhaltlich relevante Textteile
verändert wurden; ohne Fehler werden Ihre Antworten auf die Fragen aufgelistet.

### Teilaufgabe 2 (maximal 75 Punkte)

Lösen Sie den Praxisteil. Vervollständigen Sie dazu die Klassen [Stick.java](../src/Stick.java),
[Star.java](../src/Star.java) und [StickBreaksException.java](../src/StickBreaksException.java) 
gemäß der in den Spezifikationen in den entsprechenden Dateien.

English translation: Solve the practical programming part. Complete the classes 
[Stick.java](../src/Stick.java), [Star.java](../src/Star.java) and 
[StickBreaksException.java](../src/StickBreaksException.java) 
according to the specifications given in their respective files.

Vervollständigen Sie die Klassen in den oben aufgelisteten Dateien bitte wie in den Kommentaren
beschrieben an den mit `TODO` gekennzeichneten Stellen. Alle anderen gegebenen Dateien (außer
`MCTest2.java` und `ApplicationTest2.java`) sind bereits vollständig und dürfen nicht verändert
werden.

Die Klasse `ApplicationTest2` enthält Testfälle mit Soll-Ausgaben als Kommentare. Neben diesen
Testfällen müssen auch alle Kommentare in den gefragten Klassen zutreffen. Die Klasse
`ApplicationTest2` fließt nicht in die Beurteilung ein, Sie können diese Datei nach Belieben ändern.
