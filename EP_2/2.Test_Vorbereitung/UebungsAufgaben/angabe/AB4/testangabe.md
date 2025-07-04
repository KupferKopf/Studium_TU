# Übungstest 5

Geben Sie hier die Namen und Matrikelnummern der Studierenden an, die den Übungstest gemeinsam machen:

_Matrikelnummer1, Name1_

_Matrikelnummer2, Name2_

(_Matrikelnummer3, Name3_)




## Aufgabenstellung

Definieren Sie eine neue Klasse `NonEmptyLeafTreeNode`, die
das Interface [AbstractTreeNode](../../src/AB4/Interfaces/AbstractTreeNode.java) implementiert. 
Diese Klasse repräsentiert einen Baumknoten, der einen Dinosaurier (nicht ``null``) speichert und keinen 
Kindknoten hat. Die Klasse soll anstelle von [NonEmptyTreeNode](../../src/AB4/NonEmptyTreeNode.java) 
eingesetzt werden, wenn beide Kindknoten ``NIL`` wären. Hinweis: Sie können diese Klasse erzeugen,
in dem Sie die Klassendefinition aus [NonEmptyTreeNode](../../src/AB4/NonEmptyTreeNode.java) 
kopieren und anpassen.

Ändern Sie den Konstruktor der Klasse [NonEmptyTreeNode](../../src/AB4/NonEmptyTreeNode.java)
so, dass linker und rechter Kindknoten beim Erzeugen angegeben werden muss (Parameter:
``Dinosaur value, AbstractTreeNode left, AbstractTreeNode right``). Vorbedingungen sollen 
sicherstellen, dass zumindest ein Kindknoten nicht ``NIL`` ist. Dadurch sind in der Klasse auch 
weitere Vereinfachungen möglich.

Führen Sie auch in der Klasse [EmptyTreeNode](../../src/AB4/EmptyTreeNode.java) entsprechende 
Änderungen durch (hier müssen in `store` jetzt Blattknoten (`NonEmptyLeafTreeNode`)  erzeugt
werden).

Sie können Ihre Lösung mithilfe der Klasse [ApplicationTest](../../src/AB4/ApplicationTest.java)
testen. Dabei sollte folgende Ausgabe entstehen:

```txt
[Edmontosaurus Elvis [OK], TRex Mom [DANGER], TRex Jack [DANGER]]
class AB4.NonEmptyTreeNode
class AB4.NonEmptyTreeNode
class AB4.EmptyTreeNode
class AB4.NonEmptyLeafTreeNode
class AB4.NonEmptyLeafTreeNode
```





