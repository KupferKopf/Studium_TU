# Übungstest zu Aufgabenblatt 7

## Aufgabenstellung

Überschreiben Sie in der Klasse [BJHand](../../src/AB7/BJHand.java) die Methoden `equals` und `hashCode` gemäß folgender Spezifikationen:

```
/**
 * Checks whether the specified object is equal to this hand.
 * 
 * The specified object is considered equal if:
 * - It is not null and of type 'BJHand'.
 * - each of its cards has the same number of occurrences (equal cards) in 'this'.
 *
 * For example, the hands (c1, c2, c2) and (c2, c1, c1) are **not** equal,
 * because the cards (c1 and c2) do not have the same number of occurrences. 
 *
 * In contrast, the hands (c1, c2, c2) and (c2, c1, c2) are equal beacuse both cards
 * (c1 and c2) have the same number of occurrences.
 *
 * @param o the object to compare with the current instance.
 * @return true if the two objects are equal; false otherwise.
 */
public boolean equals(Object o)

/**
 * Returns the hash code of 'this'.
 *
 * @return the hash code of 'this'.
 */
public int hashCode()
```

Achten Sie darauf, dass die Implementierung von `hashCode` zu `equals` passt. 

Sie können Ihre Lösung mithilfe der Klasse [ApplicationTest](../../src/AB7/ApplicationTest.java) überprüfen.





