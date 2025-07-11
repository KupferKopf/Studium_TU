package AB3;

import AB3.Interfaces.List;
import AB3.Interfaces.ListBuffer;
import AB3.Provided.ListNode;


/**
 * The {@code BrailleListBuffer} class provides a buffer for storing and manipulating a sequence of Braille
 * characters using a linked list. Each Braille character is represented as a bitmap contained within
 * {@code ListNode} objects. The buffer allows common operations such as adding nodes, removing nodes, inserting at
 * specific positions, and rendering the buffer contents as formatted scanlines.
 */
public class BrailleListBuffer implements ListBuffer {
    private static final char SPACE_SYMBOL=' ';
    private List list;    // can store a reference to a BrailleLinkedList


    /**
     * Constructs a new {@code BrailleListBuffer} object using the provided list.
     *
     * @param list the underlying {@code List} object used for storing and manipulating Braille characters.
     *             This list is expected to contain {@code ListNode} objects, where each node represents
     *             a Braille character as a bitmap.
     */
    BrailleListBuffer(List list) {  // Hint: pass your BrailleLinkedList to this constructor
        this.list = list;
    }

    /**
     * Returns the number of elements in the underlying list buffer.
     *
     * @return the number of elements in the list.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Adds a new Braille character, represented as a 2-dimensional character array bitmap,
     * to the end of the underlying list buffer.
     *
     * @param bitmap a 2-dimensional array of characters representing the element to be added.
     *               This bitmap corresponds to a Braille character.
     */
    @Override
    public void push(char[][] bitmap) {
        ListNode temp = new ListNode(bitmap);
        list.addLast(temp);
    }

    /**
     * Removes and retrieves the last Braille character bitmap from the underlying list.
     * If the list is empty, this method returns {@code null}.
     *
     * @return a 2-dimensional character array representing the Braille bitmap of the removed element,
     * or {@code null} if the list is empty.
     */
    @Override
    public char[][] pop() {
        if(list == null) return null;
        ListNode temp = list.removeLast();
        return temp.getBitmap();
    }

    /**
     * Inserts a new Braille character bitmap at the specified position in the underlying list buffer.
     * If the provided bitmap is null, the method does not perform any action.
     *
     * @param position the index at which the new Braille character bitmap will be inserted.
     * @param bitmap   a 2-dimensional array of characters representing the Braille character
     *                 to be inserted.
     */
    @Override
    public void insert(int position, char[][] bitmap) {
        if(bitmap!=null){
            ListNode temp = new ListNode(bitmap);
            list.insert(temp, position);
        }
    }

    /**
     * Removes and retrieves the Braille character bitmap stored at the specified position
     * in the underlying list buffer. If the position is invalid or no element exists at the
     * specified index, it returns {@code null}.
     *
     * @param position the index of the element to be removed from the list.
     * @return a 2-dimensional character array representing the Braille bitmap of the removed element,
     *         or {@code null} if the list is empty.
     */
    @Override
    public char[][] delete(int position) {
        if(position < 0 || position > size()) return null;
        else{
            ListNode delete = list.remove(position);
            return delete.getBitmap();
        }
    }

    /**
     * Clears the underlying list buffer.
     *
     * <p>This method invokes the {@code clear} method on the underlying list,
     * ensuring the buffer is emptied of all stored Braille character bitmaps.</p>
     */
    @Override
    public void clearBuffer() {
        list.clear();
    }

    /**
     * Renders the contents of the buffer into an array of strings, each representing a scanline.
     * Characters in the buffer are aligned horizontally with spacing between them.
     *
     * @param spacing the number of spaces (ASCII code 32) to insert between consecutive characters from the buffer
     *                in the rendered output.
     *                Precondition: ( spacing >= 0 )
     * @return an array of strings, where each string represents a scanline of the combined buffered characters.
     * Returns {@code null} if the buffer is empty.
     */
    @Override
    public String[] renderScanlines(int spacing) {

        String[] line = new String[3];

        for(int i = 0; i < list.size(); i++){

            char[][] bitmap = list.get(i).getBitmap();
            String space = "";
            for (int j = 0; j < spacing; j++) {
                space += SPACE_SYMBOL;
            }

            line[0] += bitmap[0][0] + bitmap[0][1] + space;
            line[1] += bitmap[1][0] + bitmap[1][1] + space;
            line[2] += bitmap[2][0] + bitmap[2][1] + space;

        }

        return line;
    }
}
