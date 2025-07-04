# Übungstest 2

Geben Sie hier die Namen und Matrikelnummern der Studierenden an, die den Übungstest gemeinsam machen:

_Matrikelnummer1, Name1_

_Matrikelnummer2, Name2_

(_Matrikelnummer3, Name3_)




## Aufgabenstellung

Erweitern Sie die Klasse [AdvancedLinePrinter](../../src/AB2/AdvancedLinePrinter.java) um folgende Methode:

```
    /**
     * Compares the printed lengths of 'this' and 'other'. The printed length of an 'AdvancedLinePrinter' object
     * is the length of the rendered scanlines of the internal line buffer. The method returns -1 if the printed
     * length of 'this' is lower than the printed length of 'other', and 1 in the opposite case. If both printed
     * lengths are equal, 0 is returned.
     *
     * @param other The AdvancedLinePrinter object to compare with.
     * @return -1 if the printed length of 'this' is lower than the printed length of 'other', 
     *         1 if it is greater, and 0 if both printed lengths are equal.
     */
    public int comparePrintedLength(AdvancedLinePrinter other)
```
Testen Sie Ihre Lösung mithilfe der Klasse [ApplicationTest](../../src/AB2/ApplicationTest.java). 







