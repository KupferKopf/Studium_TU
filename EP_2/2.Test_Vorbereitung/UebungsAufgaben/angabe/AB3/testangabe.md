# Übungstest 3

## Aufgabenstellung


Erweitern Sie die Klasse [BrailleSymbolTree.java](../../src/AB3/BrailleSymbolTree.java) um 
folgende private Methode:

```
    /**
     * Returns the depth of the subtree rooted at the given node.
     *
     * The depth is the maximal number of nodes along a path from the node to a leaf node 
     * (including 'node' and the leaf node). If the node is null, the depth is 0.
     *
     * This method traverses the subtree recursively, computing the depth of the left and right 
     * subtrees and returning the greater of the two depths, plus one (to account for the 
     * current node).
     *
     * @param node the root of the subtree.
     * @return the depth of the subtree rooted at the given node.
     */
    private int depth(TreeNode node)
```

Definieren Sie weiters in [BrailleSymbolTree.java](../../src/AB3/BrailleSymbolTree.java) 
folgende öffentliche Methode, die obige Methode `depth(TreeNode node)` nutzt:

``` 
    /**
     * Returns the depth of this tree.
     *
     * The depth is defined as the length of the longest path from the root node to a leaf
     * node (including the root node and the leaf node). An empty tree has a depth of 0, and a tree 
     * with only one node (the root) has a depth of 1.
     *
     * @return the maximal depth of the tree.
     */
    public int depth()
```

Testen Sie Ihre Lösung mithilfe der Klasse [ApplicationTest](../../src/AB3/ApplicationTest.java).
Bei einer korrekten Lösung sollte `depth()` den Wert 8 liefern. Variieren Sie die
Schleifenbedingung im Konstruktor von [BrailleSymbolTree.java](../../src/AB3/BrailleSymbolTree.java)
um mit geänderter Anzahl an Knoten (z.B. zwei Knoten) und auch einem leeren Baum zu testen.
    







