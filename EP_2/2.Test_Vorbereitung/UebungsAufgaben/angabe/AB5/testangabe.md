# Übungstest zu Aufgabenblatt 5

## Aufgabenstellung

Gegeben sind folgende Dateien, die nicht geändert werden sollen:
* [DNAIterable](../../src/AB5/Interfaces/DNAIterable.java)
* [DNAIterator](../../src/AB5/Interfaces/DNAIterator.java)

Ändern Sie dann folgende Klassen so, dass sie das gegebene Interface
[DNAIterable](../../src/AB5/Interfaces/DNAIterable.java) implementieren:

* [DinosaurBucketList](../../src/AB5/DinosaurBucketList.java)
* [DinosaurHashMap](../../src/AB5/DinosaurHashMap.java) 
* [Edmontosaurus](../../src/AB5/Edmontosaurus.java)
* [TyrannosaurusRex](../../src/AB5/TyrannosaurusRex.java)

Jedes `DNAIterable`-Objekt liefert mit der Methode `iteratorDNA()` einen Iterator, der über alle 
enthaltenen Dinosaurier iteriert und von jedem Dinosaurier dessen DNA liefert.
Ein einzelner Dinosaurier (Implementierung in den beiden letztgenannten Klassen) ist auch 
`DNAIterable`, wobei hier der Iterator verbraucht ist, nachdem er die DNA dieses Dinosauriers 
geliefert hat.

Sie können Ihre Lösung mithilfe der Klasse [ApplicationTest](../../src/AB5/ApplicationTest.java) überprüfen.
