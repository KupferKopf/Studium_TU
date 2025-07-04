/* DO NOT EDIT */
// This file is required for server side submission checks.

package AB2.Interfaces;

public interface Encoder {

    /**
     * This method encodes a given ASCII character from range [a-z] to its
     * corresponding Braille binary representation.</p>
     *
     * @param asciiChar an ASCII character from the lower case alphabet ['a','z']
     *                  <p>Precondition: (asciiChar>='a') && (asciiChar<='z')</p>
     */
    byte toBinary(char asciiChar);
}

