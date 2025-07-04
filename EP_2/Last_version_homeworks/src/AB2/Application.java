package AB2;

import AB2.Interfaces.LineBuffer;

import java.util.Arrays;

/**
 * The Application class serves as the entry point to the program.
 * <p>This class is used to test and demonstrate the functionality of printing text in Braille format
 * using the AdvancedLinePrinter, configured with a BrailleLineBuffer, a BrailleFont and a BrailleEncoder.</p>
 * <p>Any implementation is not subject to examination and assessment by the EP2-Team, but serves as
 * free test hub for students.</p>
 */
public class Application {
    public static void main(String[] args) {

        // example from documentation
        LineBuffer lineBuffer = new BrailleLineBuffer(3, 1.5, 0.3);
        AdvancedLinePrinter lp = new AdvancedLinePrinter(
                new BrailleFont(
                        3,
                        2,
                        'o',
                        '.',
                        new BrailleEncoder()),
                4,
                lineBuffer
        );

/*
        System.out.println(lineBuffer);
        char[][] temp = new char[3][2];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(temp[i], ' ');
        }
        lineBuffer.push(temp);
        //System.out.println(Arrays.deepToString(lineBuffer.renderScanlines(3)));
        System.out.println(lineBuffer);
        lineBuffer.pop();
        System.out.println(lineBuffer);
        //System.out.println(Arrays.deepToString(lineBuffer.renderScanlines(3)));
        lineBuffer.push(temp);
        lineBuffer.push(temp);
        lineBuffer.push(temp);
        System.out.println(lineBuffer);
        lineBuffer.expandBuffer();
        System.out.println(lineBuffer);
        lineBuffer.pop();
        lineBuffer.pop();
        lineBuffer.reduceBuffer();
        System.out.println(lineBuffer);
        char[][] temp_2 = new char[3][2];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(temp_2[i], 'a');
        }
        lineBuffer.push(temp);
        System.out.println(lineBuffer);
        lineBuffer.insert(1,temp_2);
        System.out.println(lineBuffer);
        lineBuffer.pop();
        lineBuffer.pop();
        lineBuffer.pop();
        lineBuffer.insert(0,temp_2);
        System.out.println(lineBuffer);
        lineBuffer.push(temp);
        lineBuffer.push(temp_2);
        System.out.println("-------------");
        System.out.println(lineBuffer);
        lineBuffer.delete(1);
        System.out.println(lineBuffer);
        lineBuffer.clearBuffer();
*/

        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());
        lp.printString("Hello");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString(" World");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        System.out.println("modifying buffer...");
        lp.deleteCharacter(2);
        lp.insertCharacter(2, 'a');
        lp.deleteCharacter(3);
        lp.insertCharacter(3, 'r');
        lp.deleteCharacter(4);
        lp.deleteCharacter(8);
        lp.insertCharacter(5, 'm');
        lp.insertCharacter(6, 'y');
        lp.insertCharacter(7, ' ');
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString("OK");
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();

        // TODO: implementation of any developer specific tests (optional)

    }
}