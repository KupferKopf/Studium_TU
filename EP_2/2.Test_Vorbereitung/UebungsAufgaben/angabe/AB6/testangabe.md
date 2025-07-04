# Übungstest zu Aufgabenblatt 6

## Aufgabenstellung

Implementieren Sie in [DinosaurCollection](../../src/AB6/Provided/DinosaurCollection.java) folgende 
Methode, die ein Objekt vom Typ `DinosaurSet` 
(siehe [DinosaurSet](../../src/AB6/Interfaces/DinosaurSet.java)) zurückgibt.

```
    /**
     * Returns a {@code DinosaurSet}-view of this collection, in which only the elements
     * of this collection are contained that pass the test by {@code filterCriterion}. A call 
     * to returned set's {@code add} method will only accept elements that fulfill 
     * the specified {@code filterCriterion} (also see specification of {@code add} 
     * in {@link DinosaurSet}).
     *
     * @return a filtered {@code DinosaurSet}-view of this set.
     */
    public DinosaurSet getFilteredSetView(Predicate filterCriterion)
```

_Hinweise:_

* Sie können eine neue Klasse als Untertyp von `DinosaurSet` erstellen.
* Achten Sie darauf, dass diese Klasse als Sichtweise und nicht als Kopie implementiert ist.

Implementieren Sie weiters eine neue Klasse `EdmontoSelector`,
die [Predicate](../../src/AB6/Interfaces/Predicate.java) implementiert und deren Methode `test`
genau dann `true` liefert, wenn der angegebene Dinosaurier vom Typ `Edmontosaurus` ist. Diese
Klasse wird von [ApplicationTest](../../src/AB6/ApplicationTest.java) genutzt.
Sie können Ihre Lösung mithilfe der Klasse [ApplicationTest](../../src/AB6/ApplicationTest.java)
überprüfen.





