package AB1;

import AB1.Interfaces.Font;

import java.util.Arrays;

/**
 * The LinePrinter class is designed to render Braille text representations to standard output
 * using a line buffer and a customizable font.
 *
 * <p>This class implements operations for printing individual Braille characters and strings,
 * both specified by corresponding ASCII characters.</p>
 * <p>All print operations are executed into a line buffer, which can at any time be sent to the system's
 * standard output (console) by calling the {@code flush()} method.
 * Calling the {@code flush()} method also clears the line buffer.</p>
 */
public class LinePrinter {
    // DONE: choose appropriate access modifier (public/private)
    private char[][] lineBuffer;    // buffer that holds output (bitmaps of printed braille characters)

    // DONE: choose appropriate access modifier (public/private)
    private final Font font;        // font used to render output

    // DONE: choose appropriate access modifier (public/private)
    private final int spacing;      // spacing between braille characters (measured in output columns)

    // DONE: choose appropriate access modifier (public/private)
    private int cursorPosition;     // position within the lineBuffer where the next braille character will be printed

    /**
     * Constructs a LinePrinter for rendering printable Braille text.
     * <p>The lineBuffer is allocated by calling the {@code createLineBuffer()} method.</p>
     *
     * @param font       the font that defines the printable representation for characters.
     *                   <p>Precondition: font != null</p>
     * @param lineLength the maximum number of Braille characters the line buffer can hold.
     *                   <p>Precondition: lineLength > 0</p>
     * @param spacing    the number of blank screen spaces (ASCII columns) between Braille characters (bitmaps).
     *                   <p>Precondition: spacing > 0 </p>
     */
    // DONE: choose appropriate access modifier (public/private)
    public LinePrinter(Font font, int lineLength, int spacing) {
        // DONE: implementation
        if(font == null){
            this.font = new BrailleFont(3, 2,'o','.', new BrailleEncoder());
            System.out.println("| LinePrinter Const | Font can't be null -> was set to deafault");
            System.out.println("| LinePrinter Const | height: 3, width: 2, dotSymbol: o, spaceSymbol: ., new BrailleEncoder()");
        } else {
            this.font = font;
        }

        if(spacing > 0){
            this.spacing = spacing;
        }else{
            System.out.println("| LinePrinter Const | spacing needs to be larger then 0 -> was set to default = 1");
            this.spacing = 1;
        }


        if(lineLength > 0){
            createLineBuffer(lineLength, font.getHeight(), font.getWidth());
        }else{
            System.out.println("| LinePrinter Const | LineLength needs to be larger then 0 -> was set to default = 20");
            createLineBuffer(20, font.getHeight(), font.getWidth());
        }




    }


    /**
     * Creates the line buffer for printing Braille text with specified dimensions and spacing, and
     * resets the cursor position to 0.
     * <p>The line buffer's size is derived from the specified maximum number of Braille characters that can be stored
     * within the buffer, the width of the bitmap of a single Braille character, and the sum of spacing between individual
     * characters. Example: A line buffer that can hold up to 5 Braille characters (bitmap width of 2) with 1 row of
     * spacing requires size 14.</p>
     * <p>The line buffer is filled with the space char ' ' (ASCII code 32) during initialization.</p>
     *
     * @param lineLength the maximum number of Braille characters the line buffer can hold.
     *                   <p>Precondition: lineLength > 0</p>
     * @param cellHeight the height of each Braille character cell in rows. Is provided by {@code Font} object.
     *                   <p>Precondition: cellHeight > 0</p>
     * @param cellWidth  the width of each Braille character cell in columns. Is provided by {@code Font} object.
     *                   <p>Precondition: cellWidth > 0</p>
     */
    // DONE: choose appropriate access modifier (public/private)
    private void createLineBuffer(int lineLength, int cellHeight, int cellWidth){
        // DONE: implementation

        if(lineLength > 0){

            if(cellHeight > 0){

                if(cellWidth > 0){

                    int letLength = lineLength*cellWidth; // letter length, length for each symbole
                    int spaLenght = (lineLength*spacing)-spacing; // spaces between length, length for each spacing between the symbolse (1 less then symbole amount)

                    int totLength = letLength + spaLenght;

                    lineBuffer = new char[cellHeight][totLength];

                    for (int i = 0; i < lineBuffer.length; i++) {
                        Arrays.fill(lineBuffer[i], ' ');
                    }

                }else{
                    System.out.println("| CreateLineBuffer | cellWidth needs to be larger then 0");
                }

            }else{
                System.out.println("| CreateLineBuffer | cellHeight needs to be larger then 0");
            }

        }else{
            System.out.println("| CreateLineBuffer | lineLength needs to be larger then 0");
        }
    }

    /**
     * Retrieves the ASCII character array representing a specific row in the line buffer.
     *
     * @param index the zero-based index of the row to retrieve.
     *              <p>Precondition: (index >= 0) && (index < lineBuffer.length)</p>
     * @return the ASCII character array of the specified row.
     */
    // TODO: choose appropriate access modifier (public/private)
    public char[] getLineBufferRow(int index){
        // Done: implementation
        if(index >= 0 && index < lineBuffer.length){
            return lineBuffer[index].clone();
        }else{
            System.out.println("| getLineBufferRow | index (" + index + ") needs to be shorter then lineBuffer.length (" + lineBuffer.length + ")");
            return null;
        }
    }


    /**
     * Clears the line buffer by creating a new one and resetting the cursor position.
     */
    // DONE: choose appropriate access modifier (public/private)
    private void clearLine(){
        // DONE: implementation
        int height = lineBuffer.length;
        int width = lineBuffer[0].length;

        lineBuffer = new char[height][width];
        cursorPosition = 0;
    }

    /**
     * Prints a single Braille character into the line buffer at the cursor's position.
     * <p>The method retrieves a printable Braille representation (bitmap) of the given ASCII character from {@code font} and
     * writes it into the line buffer, considering current cursor position and spacing.</p>
     * <p>If the cursor exceeds the line buffer's length (buffer overflow), the method does not write to the
     * line buffer, but simply returns.</p>
     * <p>The cursor position is incremented by 1 after the character is written into the line buffer successfully.</p>
     *
     * @param character an ASCII character to be converted to a printable Braille representation
     *                  and printed into the line buffer.
     */
    // TODO: choose appropriate access modifier (public/private)
    public void printCharacter(char character){
        // TODO: implementation
        char[][] bitMap = font.getBitmap(character);
        int currentCur = cursorPosition;

        for(int i = 0; i < font.getHeight(); i++){

            cursorPosition = currentCur;
            for(int j = 0; j < font.getWidth(); j++){

                if(cursorPosition < lineBuffer[i].length) {
                    lineBuffer[i][cursorPosition] = bitMap[i][j];
                    cursorPosition++;
                }
            }
        }
        cursorPosition += spacing;

    }

    /**
     * Prints a string starting at the cursor's position by iterating over its characters and passing one by one to the
     * {@code printCharacter} method.
     *
     * @param string the string to be printed.
     */
    // TODO: choose appropriate access modifier (public/private)
    public void printString(String string){
        // DONE: implementation
        String currString = string.toLowerCase();

        for (int i = 0; i < currString.length(); i++) {
            printCharacter(currString.charAt(i));
        }
        System.out.println();
    }

    /**
     * Flushes the content of the line buffer by printing each row to the standard output,
     * and then clearing the buffer by calling {@code clearLine()}.
     */
    // DONE: choose appropriate access modifier (public/private)
    public void flush(){
        // DONE: implementation
        for (int i = 0; i < lineBuffer.length; i++) {
            for (int j = 0; j < lineBuffer[i].length; j++) {
                System.out.print(lineBuffer[i][j]);
            }
            System.out.println();
        }
        clearLine();
    }
}
