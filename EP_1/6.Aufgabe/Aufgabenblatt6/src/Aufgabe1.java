/*
    Aufgabe 1) Zweidimensionale Arrays und Rekursion - Game "TicTacToe"
*/

import codedraw.*;
import java.util.Scanner;

public class Aufgabe1 {

    static int count = 0;

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int size = 600;
        CodeDraw myDrawObj = new CodeDraw(size, size);

        //muss ja nur einmal den ramen machen
        //myDrawObj.setLineWidth(2);
        myDrawObj.drawSquare(1,1,myDrawObj.getWidth()-2);
        myDrawObj.setLineWidth(1);

        //vertical lines
        myDrawObj.drawLine(((double) myDrawObj.getWidth() /3)*2, 0, ((double) myDrawObj.getWidth() /3)*2,  myDrawObj.getWidth()); // 400,0,400,600
        myDrawObj.drawLine((double) myDrawObj.getWidth() /3, 0, (double) myDrawObj.getWidth() /3,  myDrawObj.getWidth()); // 200,0,200,600

        //horizontal lines
        myDrawObj.drawLine(0, ((double) myDrawObj.getWidth() /3)*2, myDrawObj.getWidth(), ((double) myDrawObj.getWidth() /3)*2); // 0,400,600,400
        myDrawObj.drawLine(0, (double) myDrawObj.getWidth() /3, myDrawObj.getWidth(), (double) myDrawObj.getWidth()/3); // 0,200,600,200



        myDrawObj.setTitle("Tic Tac Toe");
        EventScanner myEventSC = myDrawObj.getEventScanner();

        char[][] gameBoard = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        drawGameBoard(myDrawObj, gameBoard);

        System.out.println("PVP oder PVC?");
        boolean gamemode = false;
        boolean twoPlayer = false;
        while(!gamemode) {
            String answer = input.next();
            if (answer.equals("PVP")) {
                 twoPlayer = true; //true ... human vs. human, false ... human vs. computer
                gamemode = true;
            } else if (answer.equals("PVC")) {
                 twoPlayer = false; //true ... human vs. human, false ... human vs. computer
                gamemode = true;
            } else {
                System.out.println("? was willst jetzt Spielen ?");
            }
        }

        boolean player = true; //(1Player) human = true, computer = false, (2Player) human1 = true, human2 = false
        int maxDepth = 2;
        boolean gameRunning = true;


        while (!myDrawObj.isClosed() && gameRunning) {
            if (myEventSC.hasMouseClickEvent()) { // Player move
                char symbole = ' ';
                boolean placed = false;
                if(player){
                    symbole = 'X';
                }else{
                    symbole = 'O';
                }

                MouseClickEvent mCLEvent = myEventSC.nextMouseClickEvent(); // mCLEvent -> Mouse Click Event
                int xCord = mCLEvent.getX();
                int yCord = mCLEvent.getY();
                // Cords können zwischen 0 und 600 sein und wenn sie müssen in eines der 9 felder passen
                //   0/0 - 200/200 | 200/0   - 400/200 | 400/0   - 600/200 |
                // 0/200 - 200/400 | 200/200 - 400/400 | 400/200 - 600/400 |
                // 0/400 - 200/600 | 200/400 - 400/600 | 400/400 - 600/600 |

                if((xCord <= 200 && yCord <= 200) && gameBoard[0][0] == ' '){ // top left
                    gameBoard[0][0] = symbole;
                    placed = true;
                }else if((xCord >= 400 && yCord <= 200) && gameBoard[0][2] == ' ') { // top right
                    gameBoard[0][2] = symbole;
                    placed = true;
                } else if ((xCord <= 200 && yCord >= 400) && gameBoard[2][0] == ' ') { // bottom left
                    gameBoard[2][0] = symbole;
                    placed = true;
                } else if ((xCord >= 400 && yCord >= 400) && gameBoard[2][2] == ' ') { // bottom right
                    gameBoard[2][2] = symbole;
                    placed = true;
                } else if ((xCord <= 200 && yCord >= 200) && gameBoard[1][0] == ' ') { // middle left
                    gameBoard[1][0] = symbole;
                    placed = true;
                } else if ((xCord >= 400 && yCord <= 400) && gameBoard[1][2] == ' ') { // middle right
                    gameBoard[1][2] = symbole;
                    placed = true;
                } else if ((yCord <= 200 && xCord >= 200) && gameBoard[0][1] == ' ') { // top middle
                    gameBoard[0][1] = symbole;
                    placed = true;
                } else if ((yCord >= 400 && xCord <= 400 ) && gameBoard[2][1] == ' ') { // bottom middle
                    gameBoard[2][1] = symbole;
                    placed = true;
                } else if (gameBoard[1][1] == ' '){ // middle middle
                    gameBoard[1][1] = symbole;
                    placed = true;
                }

                if(checkIfWinner(gameBoard, player)){
                    if(player){
                        System.out.println("Player 1 wins");
                        gameRunning = false;
                    }else{
                        System.out.println("Player 2 wins");
                        gameRunning = false;
                    }
                }

                if(placed) player = !player;
            } else if (!twoPlayer && !player) { // Computer move

                int[] move = minimax(gameBoard,player,4, myDrawObj);

                gameBoard[move[0]][move[1]] = 'O';

                if(checkIfWinner(gameBoard, player)){
                    System.out.println("Computer wins");
                    gameRunning = false;
                }

                player = true;
            } else {
                myEventSC.nextEvent();
            }
            drawGameBoard(myDrawObj, gameBoard);
            if(checkIfFull(gameBoard) && gameRunning) {
                System.out.println("Unendschieden");
                gameRunning = false;
            }

        }

        boolean again = false;
        while(!again){

            System.out.println("Noch ne runde?");
            String answer = input.next();
            if (answer.equals("JA")) {
                myDrawObj.close();
                main(args);
                again = true;
            } else if (answer.equals("NEIN")) {
                myDrawObj.close();
                again = true;
            } else {
                System.out.println("was soll das jetzt heißen?");
            }

        }
    }

    private static int[] minimax(char[][] gameBoard, boolean player, int depth, CodeDraw myDrawObj) {

        int[] retArray = new int[3];

        if(player){
            retArray[2] = Integer.MAX_VALUE;
        }else{
            retArray[2] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard[i].length; j++){

                if(gameBoard[i][j] != 'X' && gameBoard[i][j] != 'O'){

                    if(player){
                        gameBoard[i][j] = 'X';
                    }else{
                        gameBoard[i][j] = 'O';
                    }

                    count++;
                    System.out.println(count);

                    if(checkIfWinner(gameBoard, true)){
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = -1;
                    } else if (checkIfWinner(gameBoard, false)) {
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = 1;
                    } else if (checkIfFull(gameBoard) || depth-1 == 0) {
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = 0;
                    } else {
                        int[] tempArray = minimax(gameBoard, !player, depth-1, myDrawObj);

                        if(player){
                            if(tempArray[2] < retArray[2]){
                                retArray[0] = tempArray[0];
                                retArray[1] = tempArray[1];
                                retArray[2] = tempArray[2];
                            }
                        }
                        if(!player){
                            if(tempArray[2] > retArray[2]){
                                retArray[0] = tempArray[0];
                                retArray[1] = tempArray[1];
                                retArray[2] = tempArray[2];
                            }
                        }
                    }

                    gameBoard[i][j] = ' ';
                    myDrawObj.clear();
                    drawGameBoard(myDrawObj, gameBoard);
                    myDrawObj.show();
                    //System.out.println("X: " + retArray[0] + " | Y: " + retArray [1] + " | Val: " + retArray[2] + " | Depth: " + depth);
                }
            }
        }
        return retArray;
    }

    private static boolean checkIfFull(char[][] gameBoard) {
        int count = 0;
        for (char[] rows : gameBoard){
            for(char val : rows){
                if(val != ' '){
                    count ++;
                }
            }
        }
        if(count == 9){
            return true;
        }else{
            return false;
        }
    }

    private static boolean checkIfWinner(char[][] gameBoard, boolean player) {

        if(player){

            //Verticals
            for (int i = 0; i < gameBoard.length; i++) {
                int countX = 0;//counts fuer die einzelnen Zeichen
                for (int j = 0; j < gameBoard.length; j++) {

                    if(gameBoard[i][j] == 'X'){
                        countX++;
                    }
                }

                if(countX == 3 && player){ // player 1 wins
                    return true;
                }

            }

            //Horizontals
            for (int i = 0; i < gameBoard.length; i++) {
                //counts fuer die einzelnen Zeichen
                int countX = 0;
                for (int j = 0; j < gameBoard.length; j++) {

                    if(gameBoard[j][i] == 'X'){
                        countX++;
                    }
                }
                if(countX == 3 && player){ // player 1 wins
                    return true;
                }
            }

            //Schraeg
            if(((gameBoard[0][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][2] == 'X') || (gameBoard[0][2] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][0] == 'X')) && player){
                return true;
            }


        }else{

            //Verticals
            for (int i = 0; i < gameBoard.length; i++) {
                //counts fuer die einzelnen Zeichen
                int countO = 0;
                for (int j = 0; j < gameBoard.length; j++) {

                    if (gameBoard[i][j] == 'O') {
                        countO++;
                    }
                }

                if (countO == 3 && !player) { // player 2 wins
                    return true;
                }

            }

            //Horizontals
            for (int i = 0; i < gameBoard.length; i++) {
                //counts fuer die einzelnen Zeichen
                int countO = 0;

                for (int j = 0; j < gameBoard.length; j++) {

                    if (gameBoard[j][i] == 'O') {
                        countO++;
                    }
                }

                if (countO == 3 && !player) { // player 2 wins
                    return true;
                }
            }

            //Schraeg
            if (((gameBoard[0][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][2] == 'O') || (gameBoard[0][2] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][0] == 'O'))) {
                return true;
            }
        }
        return false;
    }

    private static void drawGameBoard(CodeDraw myDrawObj, char[][] gameBoard) {

        int width = myDrawObj.getWidth();
        int heigth = myDrawObj.getHeight();


        //muss ja nur einmal den ramen machen
        //myDrawObj.setLineWidth(2);
        myDrawObj.drawSquare(1,1,myDrawObj.getWidth()-2);
        myDrawObj.setLineWidth(1);

        //vertical lines
        myDrawObj.drawLine(((double) myDrawObj.getWidth() /3)*2, 0, ((double) myDrawObj.getWidth() /3)*2,  myDrawObj.getWidth()); // 400,0,400,600
        myDrawObj.drawLine((double) myDrawObj.getWidth() /3, 0, (double) myDrawObj.getWidth() /3,  myDrawObj.getWidth()); // 200,0,200,600

        //horizontal lines
        myDrawObj.drawLine(0, ((double) myDrawObj.getWidth() /3)*2, myDrawObj.getWidth(), ((double) myDrawObj.getWidth() /3)*2); // 0,400,600,400
        myDrawObj.drawLine(0, (double) myDrawObj.getWidth() /3, myDrawObj.getWidth(), (double) myDrawObj.getWidth()/3); // 0,200,600,200


        for (int i = 0; i < gameBoard.length; i++) {

            for (int j = 0; j < gameBoard.length; j++){
                if(gameBoard[i][j] == 'X'){
                    //1. linie
                    myDrawObj.drawLine(j*200, i*200, 200+(j*200), 200+(i*200));

                    //2. linie
                    myDrawObj.drawLine(j*200, 200+(i*200), 200+(j*200), i*200);

                } else if (gameBoard[i][j] == 'O') {

                    //Kreis zeichen
                    myDrawObj.drawCircle(100+(j*200), 100+(i*200), 98);

                }
            }

        }
        myDrawObj.show();
    }

}
