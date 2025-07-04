/**
 * Leaf node of a mobile. The actual decoration of a mobile.
 * Please, do not change this interface definition!
 */
public interface Decoration extends Mobile {

    /**
     * Returns {@code true} only if {@code this == obj} (i.e., in case of identity).
     *
     * @return {@code true} only if {@code this == obj} (i.e., in case of identity).
     */
    @Override
    boolean equals(Object obj);
}

