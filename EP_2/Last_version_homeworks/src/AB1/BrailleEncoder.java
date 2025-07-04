package AB1;

/**
 * This class implements an encoder from ASCII character to Braille binary representation.
 * In Braille binary representation a 2D Braille cell is represented by one byte,
 * where each dot is mapped to one specific bit.
 *
 * <p> The encoder utilizes a lookup table ({@code brailleLUT}) of predefined binary values
 * corresponding to ASCII characters </p>
 */
public class BrailleEncoder implements AB1.Interfaces.Encoder {

    /**
     * Lookup table (LUT) for Braille character encoding.
     *
     * <p>This array holds the Braille cells binary representation for all lower case ASCII letters ('a' to 'z').
     * Index 0 corresponds to letter 'a', index 1 to letter 'b', index 2 to letter 'c' and so on.
     * The binary representation of each letter specifies which dots are set within the letter's Braille cell,
     * a 2x3 dot matrix configuration of specific dots set (1 or 0).</p>
     *
     * The LUT must be used by the class method {@code toBinary}.
     */
    // TODO: choose appropriate access modifier (public/private)
    private static final byte[] brailleLUT = {
            //  a         b        c         d         e         f          g         h         i         j         k         l         m         n         o         p         q         r         s          t        u         v         w         x         y         z
            0b000001, 0b000011, 0b001001, 0b011001, 0b010001, 0b001011, 0b011011, 0b010011, 0b001010, 0b011010, 0b000101, 0b000111, 0b001101, 0b011101, 0b010101, 0b001111, 0b011111, 0b010111, 0b001110, 0b011110, 0b100101, 0b100111, 0b111010, 0b101101, 0b111101, 0b110101

            // TODO: complete the array: add binary representation for letters f-z
            //       for details on the Braille alphabet see
            //       https://de.wikipedia.org/w/index.php?title=Brailleschrift#Systematik_des_Punkteaufbaus
    };

    /**
     * Encoder for ASCII to binary representation of a Braille cell.
     *
     * <p>This method encodes a given ASCII character from range [a-z] to it's
     * corresponding Braille binary representation. The method implementation relies on the lookup table (LUT) {@code brailleLut}. </p>
     *
     * @param asciiChar an ASCII character from the lower case alphabet ['a','z']
     *                  <p>Precondition: (asciiChar>='a') && (asciiChar<='z')</p>
     */
    // TODO: choose appropriate access modifier (public/private)
    @Override
    public byte toBinary(char asciiChar) {
        // TODO: implementation

        if((asciiChar>='a') && (asciiChar<='z')){
            return brailleLUT[asciiChar-97];
        } else if (asciiChar == ' ') {
            return 0b00000;
        }else {
            System.out.println("| toBinary | asciichar (" + asciiChar + ") needs to be between an 'a' and a 'z'");
            return 0;
        }
    }


}
