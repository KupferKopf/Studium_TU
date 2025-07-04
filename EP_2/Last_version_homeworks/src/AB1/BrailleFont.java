package AB1;

import AB1.Interfaces.Encoder;

import java.util.Arrays;

/**
 * The {@code BrailleFont} class represents a set of printable Braille characters of type {@code byte[][]} and corresponding
 * mappings from ASCII characters ({@code char}) to this set.
 * <p>All printable characters are initialized at construction time and are of equal size (monospaced).</p>
 */
public class BrailleFont implements AB1.Interfaces.Font {

    // DONE: choose appropriate access modifier (public/private)
    private final int height;   // height of characters

    // DONE: choose appropriate access modifier (public/private)
    private final int width;    // width of characters (remark: font is monospaced)

    /**
     * A 3-dimensional array containing printable Braille characters (bitmaps) in ascending alphabetic order.
     * <p>In detail, it is an array of 2-dimensional matrices (bitmaps):
     * {@code lowerCaseLetters[index of character][bitMap row][bitmap column]}. Each bitmap contains dot and space symbols
     * according to the letter's Braille cell configuration.</p>
     * <p>The array does not include representations for non-letter characters or capital letters.
     * Other characters, such as white space, are handled separately.</p>
     *
     */
    // DONE: choose appropriate access modifier (public/private)
    private final char[][][] lowerCaseLetters;    // bitmaps for all lowercase letters

    /**
     * Represents the white space character .
     * <p>This array provides a printable representation (bitmap) of a white space within Braille texts.</p>
     * <p>The array is initialized during the construction of the {@code BrailleFont} object.</p>
     */
    // DONE: choose appropriate access modifier (public/private)
    private final char[][] whiteSpace;    // bitmap for the white space character (contains space symbols only)


    /**
     * Constructs a {@code BrailleFont} object and calculates the font's bitmaps.
     *
     * @param height        number of lines of font's characters (bitmap height)
     * @param width         number of columns of font's characters (bitmap width)
     * @param dotSymbol     the character used to represent a filled cell (dot) within a character's bitmap.
     * @param spaceSymbol   the character used to represent an empty cell (space) within a character's bitmap.
     * @param encoder       the Braille encoder ({@code class BrailleEncoder}) used to calculate the font's bitmaps at construction time.
     *                      <p>Precondition: (encoder != null)</p>
     */
    // TODO: choose appropriate access modifier (public/private)
    public BrailleFont(int height, int width, char dotSymbol, char spaceSymbol, Encoder encoder) {
        // TODO: implementation
        this.height = height;
        this.width = width;

        whiteSpace = new char[height][width];
        for (int i = 0; i < whiteSpace.length; i++) {
            Arrays.fill(whiteSpace[i], spaceSymbol);
        }

        lowerCaseLetters = new char[26][height][width];

        for (int i = 0; i < 26; i++) {

            char currentChar = (char)('a'+i);
            byte val = encoder.toBinary(currentChar);

            for (int j = width-1; j >= 0; j--) { // 2 times
                for (int k = height-1; k >= 0; k--) { // 3 times

                    if(val%2 == 1){
                        lowerCaseLetters[i][k][j] = dotSymbol;
                    }else{
                        lowerCaseLetters[i][k][j] = spaceSymbol;
                    }
                    val = (byte)(val >> 1);

                }
            }
        }


    }


    /**
     * Retrieves a bitmap ({@code char[][]}) of a given ASCII character.
     *
     * @param character the ASCII character for which a printable character will be returned.
     * @return a bitmap ({@code char[][]}) that corresponds to the given ASCII character.
     *         For letters, it returns the corresponding lowercase printable character from array {@code lowerCaseLetters[]}.
     *         For non-letters, it returns the representation of a white space ({@code whiteSpace}).
     */
    // TODO: choose appropriate access modifier (public/private)
    @Override
    public char[][] getBitmap(char character) {
        // TODO: implementation

        if((character>='a') && (character<='z')){
            for (int i = 0; i < lowerCaseLetters.length; i++) {

                if(i == character-97){
                    return lowerCaseLetters[i];
                }
            }
        }else{
            return whiteSpace;
        }
        return null;
    }

    /**
     * Returns the font's height.
     *
     * @return the number of rows of a character's bitmap.
     */
    // DONE: choose appropriate access modifier (public/private)
    @Override
    public int getHeight(){
        // DONE: implementation
    	return this.height;
    }
    /**
     * Returns the font's width (the font is monospaced).
     *
     * @return the number of columns of a character's bitmap.
     */
    // DONE: choose appropriate access modifier (public/private)
    @Override
    public int getWidth(){
        // DONE: implementation
        return this.width;
    }
}