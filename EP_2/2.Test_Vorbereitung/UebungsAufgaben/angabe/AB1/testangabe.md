# Übungstest 1

Geben Sie hier die Namen und Matrikelnummern der Studierenden an, die den Übungstest gemeinsam machen:

_Matrikelnummer1, Name1_

_Matrikelnummer2, Name2_

(_Matrikelnummer3, Name3_)




## Aufgabenstellung

Ändern Sie die Klasse [LinePrinter.java](../../src/AB1/LinePrinter.java) so um, dass sie folgende
zusätzliche Methode zur Verfügung stellt.

```
/**
 * Returns a new line printer with the same 'font', 'lineLength' and 'spacing' as 'this', but 
 * its line buffer containing only the first 'n' characters of the current line of 'this'.
 */
 public LinePrinter copyFront(int n) {
     // TODO: implement method.
     
 }
```

Testen Sie Ihre Lösung mithilfe der Klasse [ApplicationTest](../../src/AB1/ApplicationTest.java). 
Bei einer korrekten Lösung wird folgende Ausgabe erzeugt:

```txt
o.    o.    o.    o.    o.    ..    .o    o.    o.    o.    oo
oo    .o    o.    o.    .o    ..    oo    .o    oo    o.    .o
..    ..    o.    o.    o.    ..    .o    o.    o.    o.    ..
o.    o.    o.
oo    .o    o.
..    ..    o.
.o    o.    .o    .o
oo    .o    o.    oo
o.    ..    o.    o.
```       







