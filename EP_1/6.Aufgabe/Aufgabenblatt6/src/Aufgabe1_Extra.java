/*
    Aufgabe 1) Zweidimensionale Arrays und Rekursion - Game "TicTacToe"
*/

import codedraw.CodeDraw;
import codedraw.EventScanner;
import codedraw.MouseClickEvent;

import java.util.Scanner;

public class Aufgabe1_Extra {

    // Für den Extra Punkt hab ich das ganze mal koppiert einfach um ne sichere/Funktonierende Version zu haben
    // Tschuldigung für die verspätung aber bonus musste fertig gemacht werden
    static int depth = 0;
    static int[][] position;
    static int count = 0;

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int size = 600;
        CodeDraw myDrawObj = new CodeDraw(size, size);

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
                //twoPlayer = false; //true ... human vs. human, false ... human vs. computer
                gamemode = true;

                System.out.println("Wie Schwer darfs den sein");
                answer = input.next();
                try {
                    depth = Integer.parseInt(answer);
                }
                catch (NumberFormatException e) {
                    depth = 4;
                    System.out.println("Dann Spielst halt auf Stuffe 4");
                }

                position = new int[depth][2];

            } else {
                System.out.println("? was willst jetzt Spielen ?");
            }
        }


        boolean player = true; //(1Player) human = true, computer = false, (2Player) human1 = true, human2 = false
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

                int[] move = minimax(gameBoard,player,depth, myDrawObj);

                gameBoard[move[0]][move[1]] = 'O';

                myDrawObj.show(10000);
                myDrawObj.clear();
                drawGameBoard(myDrawObj, gameBoard);

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

    private static int[] minimax(char[][] gameBoard, boolean player, int depth_start, CodeDraw myDrawObj) {

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
                    System.out.println();
                    int current_depth = depth-depth_start;
                    System.out.println(current_depth);
                    position[current_depth][0] = i;
                    position[current_depth][1] = j;

                    if(current_depth == 1){
                        count++;
                    }
                    System.out.println(count);


                    //System.out.println("Postions in minimax: " + position[current_depth][0] + " | " + position[current_depth][1]);
                    drawGameBoardLevels(myDrawObj, gameBoard, depth_start);
                    myDrawObj.show();


                    if(checkIfWinner(gameBoard, true)){
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = -1;
                    } else if (checkIfWinner(gameBoard, false)) {
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = 1;
                    } else if (checkIfFull(gameBoard) || depth_start-1 == 0) {
                        retArray[0] = i;
                        retArray[1] = j;
                        retArray[2] = 0;
                    } else {
                        int[] tempArray = minimax(gameBoard, !player, depth_start-1, myDrawObj);

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

        double width = myDrawObj.getWidth();
        double heigth = myDrawObj.getHeight();


        //muss ja nur einmal den ramen machen
        //myDrawObj.setLineWidth(2);
        myDrawObj.drawSquare(1,1,myDrawObj.getWidth()-2);
        myDrawObj.setLineWidth(1);

        //vertical lines
        myDrawObj.drawLine((width/3)*2, 0, (width/3)*2, heigth); // 400,0,400,600
        myDrawObj.drawLine( width /3, 0, width /3, heigth); // 200,0,200,600

        //horizontal lines
        myDrawObj.drawLine(0, (heigth/3)*2, width, (heigth/3)*2); // 0,400,600,400
        myDrawObj.drawLine(0, heigth/3, width, heigth/3); // 0,200,600,200


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

    public static void drawGameBoardLevels(CodeDraw myDrawObj, char[][] gameBoard,int current_depth){

        double game_width = myDrawObj.getWidth(); // quatratisch -> brauchen nur breite

        int difference_depth = depth - current_depth;
        //System.out.println(difference_depth);

        //System.out.println("Postions in draw: " + position[difference_depth][0] + " | " + position[difference_depth][1]);

        double board_width = game_width/ (Math.pow(3, 1 + difference_depth));
        double tile_width = game_width/ (Math.pow(3, 2 + difference_depth));
        System.out.println("Board:" + board_width + " Tile: " + tile_width + " DifferenceDepth: " + (difference_depth+1));

        double verschiebung_x = 0;
        double verschiebung_y = 0;
        for (int i = 0; i < difference_depth+1; i++) {

            double temp_width = game_width/ (Math.pow(3, 1 + i));

            System.out.println("Tiefe: " + (i+1) + " Posi: " + position[i][0] + " Posj: " + position[i][1]);
            verschiebung_y += position[i][0] * temp_width;
            verschiebung_x += position[i][1] * temp_width;

            System.out.println(verschiebung_x);
            System.out.println(verschiebung_y);
        }



        //vertical lines
        myDrawObj.drawLine(verschiebung_x + tile_width, verschiebung_y, verschiebung_x + tile_width, verschiebung_y + board_width);
        myDrawObj.drawLine(verschiebung_x + (tile_width*2), verschiebung_y, verschiebung_x + (tile_width*2), verschiebung_y + board_width);

        //horizontal lines
        myDrawObj.drawLine(verschiebung_x, verschiebung_y + tile_width, verschiebung_x + board_width, verschiebung_y + tile_width);
        myDrawObj.drawLine(verschiebung_x, verschiebung_y + (tile_width*2), verschiebung_x + board_width, verschiebung_y + (tile_width*2));


        for (int i = 0; i < gameBoard.length; i++) {

            for (int j = 0; j < gameBoard.length; j++){
                if(gameBoard[i][j] == 'X'){
                    //1. linie
                    myDrawObj.drawLine(verschiebung_x + (tile_width * j), verschiebung_y + (tile_width * i), verschiebung_x + tile_width + (tile_width * j), verschiebung_y + tile_width + (tile_width * i));

                    //2. linie
                    myDrawObj.drawLine(verschiebung_x + (tile_width * j), verschiebung_y + tile_width + (tile_width * i), verschiebung_x + tile_width + (tile_width * j), verschiebung_y + (tile_width * i));

                } else if (gameBoard[i][j] == 'O') {
                    double center = tile_width / 2;
                    //Kreis zeichen
                    myDrawObj.drawCircle(center + verschiebung_x + tile_width * j, center + verschiebung_y + tile_width * i, center*0.98);

                }
            }

        }

    }


}









/*Just a keep save bevor trying something

    public static void drawGameBoardLevels(CodeDraw myDrawObj, char[][] gameBoard, int reihe, int spalte ,int current_depth){

        double game_width = myDrawObj.getWidth(); // quatratisch -> brauchen nur breite

        int fix_depth = depth - current_depth;
        //if 0 dann bin ich bei 200x200 pro raster
        //bei 1 bin ich bei 66x66 pro raster
        //bei 2 bin ich bei 22x22
        System.out.println("Fix Depth: " + fix_depth + " Max Depth: " + depth + " Current Depth: " + current_depth);


        double board_width = game_width/ (Math.pow(3, 1 + fix_depth));
        System.out.println("Board Width: " + board_width);




        double two_above_width = game_width / Math.pow(3, fix_depth);
        double one_above_width = game_width / Math.pow(3,fix_depth+1); // 200
        double current_width = game_width / Math.pow(3, fix_depth+2); // 66.6
        System.out.println("Row:   " + row + " Coloume: " + coloum);
        System.out.println("Reihe: " +  reihe + " Spalte: " + spalte);
        //System.out.println(one_above_width);
        //System.out.println(current_width);
        double h_ver = spalte * one_above_width + coloum * two_above_width; //horizontale verschiebung / S*200;
        //System.out.println("H_ver: " + h_ver);
        double v_ver = reihe * one_above_width + row * two_above_width; //vertikale verschiebung / R*200;
        //System.out.println("V_Ver: " + v_ver);
        double first = current_width; // 66,6
        double second = current_width * 2; // 2 * 66,6
        System.out.println();

        double one_square = 0;



        //vertical lines
        // 1 * 66.6 + spalte * 200, reihe * 200, 1 * 66.6 + spalte * 200, (Reihe + 1) * 200
        myDrawObj.drawLine(first + h_ver , v_ver, first + h_ver, (reihe+1)*one_above_width);
        // 2 * 66.6 + spalte * 200, reihe * 200, 2 * 66.6 + spalte * 200, (Reihe + 1) * 200
        myDrawObj.drawLine(second + h_ver, v_ver, second + h_ver, (reihe+1)*one_above_width);

        //horizontal lines
        // spalte * 200, 1 * 66.6 + reihe * 200, (spalte + 1) * 200, 1 * 66.6 + reihe * 200
        myDrawObj.drawLine(h_ver, first + v_ver, (spalte+1) * one_above_width,  first + v_ver);
        // spalte * 200, 2 * 66.6 + reihe * 200, (spalte + 1) * 200, 2 * 66.6 + reihe * 200
        myDrawObj.drawLine(h_ver, second + v_ver, (spalte+1) * one_above_width, second + v_ver);


        for (int i = 0; i < gameBoard.length; i++) {

            for (int j = 0; j < gameBoard.length; j++){
                if(gameBoard[i][j] == 'X'){
                    //1. linie
                    myDrawObj.drawLine(h_ver + j * first, v_ver + i * first, h_ver + (1+j) * first, v_ver + (1+i) * first);

                    //2. linie
                    myDrawObj.drawLine(h_ver + j * first, v_ver + (1+i) * first, h_ver + (1+j) * first, v_ver + i * first);

                } else if (gameBoard[i][j] == 'O') {
                    double center = first / 2;
                    //Kreis zeichen
                    myDrawObj.drawCircle(center + j * first + h_ver , center + i * first + v_ver , center*0.98);

                }
            }

        }

    }





*/
