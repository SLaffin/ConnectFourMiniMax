package connectfour;

import java.util.Scanner;
/**
 * COSC3P71 Assign1 2019 Fall/Winter 
 * @author Samantha Laffin(5017538)
 */
public class ConnectFour {
    private char[][] board;
    private int numPlayers;
    Scanner in;
    
    public ConnectFour(){
        in = new Scanner(System.in);
        startIntroduction();
    };
    
    /**
    * This method adds a piece to the lowest place in the selected column. Column-1 and count-1 used for zero based indexing.
    */
    private void addPiece(int column, char piece){
        int count = 0;
        while (board[count][column-1]!= 'X' 
                || board[count][column-1]!= 'O'){
                count++;
            }            
        // ERROR CHECKING
        if (count == 0){
            System.out.println("column full, please select a different column");
        } else {
            board[count-1][column-1] = piece;
        }
    };
    
    /**
     * This method builds an empty char array board and fills each element with a space character.
     * @param x The number of rows.
     * @param y The number of columns.
     */
    private void buildEmptyBoard(int x, int y){
        board = new char[x][y];          
        fillEmptyBoard();
    };
    
   
    
    /**
     * This method draws the current board to the console with labels for columns. 
     */
    private void displayBoard(){
        //creating the numeric labels
        System.out.print(" ");
        for(int k=0; k<board[1].length; k++){
            System.out.print((k+1)+" ");
        }
        //printing the current board with columns
        System.out.println();
        for (int i=0; i<board.length; i++){
            System.out.print("|");
            for (int j=0; j<board[1].length; j++){                
                System.out.print(board[i][j]+"|");
            }
        System.out.println();
        }        
    };
    
     /**
     * This method fills every element in the board array with a space char.
     */   
    private void fillEmptyBoard(){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[1].length; j++){ 
                board[i][j] = ' ';
            }
        }
    };
    
    private void humanPlayerTurn(char playerPiece){
        System.out.println("Please select a colum to place a piece.(1,2,3,etc.)");
        int columnSelected = in.nextInt();
        addPiece(columnSlected, playerPiece);
        displayBoard();
    };
    
    private void aiPlayerTurn(char player piece){
        // evaluate board w minimax to return column
        //place piece
        //displayBoard
    };
    
    private int promptPlayer(){
        System.out.print("1. Play new game");
        System.out.print("\t2. Select a Move Decision.");
        System.out.print("\t3. ");
        System.out.println("\t4. ");
        System.out.print("5. ");
        System.out.println("\t0. Quit");
        return in.nextInt();
    };
    

    private void scoreBoard(char playerPiece){
        int twos = 0;
        int threes = 0;
        int fours = 0;
        //score rows
        int consecCount = 0; //counting consecutive pieces in a row
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[1].length; j++){  
                if (board[i][j]==playerPiece){
                    consecCount++;
                } else {
                    if (consecCount == 2){ 
                            System.out.println("Scored a two");
                            twos++;
                    }
                    if (consecCount == 3){ 
                            System.out.println("Scored a three");
                            threes++;
                    }
                    if (consecCount>=4){ 
                            System.out.println("Scored a four");
                            fours++;
                            break;
                    }
                } //else             
            } //j-for
        } // i-for
        //score columns
        for (int i=0; i<board[1].length; i++){
            for (int j=0; j<board.length; j++){  
                
            }
        }
        //score diagonals        
    };
    
    private void fillDebuggingBoard(){
        buildEmptyBoard();
        fillEmptyBoard();
        addPiece(2,'X');
        addPiece(2,'X');
        addPiece(2,'O');
        addPiece(2,'X');
        addPiece(2,'X');
        addPiece(3,'X');
        addPiece(3,'O');
        addPiece(3,'O');
        addPiece(4,'O');
        addPiece(4,'X');
        addPiece(4,'O');
        addPiece(4,'X');
        addPiece(5,'O');
        addPiece(5,'O');
        addPiece(5,'X');
        addPiece(6,'O');
        addPiece(6,'O');
        addPiece(6,'O');
        addPiece(6,'O');
        addPiece(6,'O');
        displayBoard();        
    };
    
    private void randomFill(){
        buildEmptyBoard();
        fillEmptyBoard();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if ( java.lang.Math.random() < 5.0 ){
                    addPiece(i,'X');
                } else{ 
                    addPiece(i,'O');
                }
            }
        }
        displayBoard();
    };
    
    
    private void startIntroduction(){
        System.out.println("Let's play Connect Four!");
        System.out.println("Please Select the number of human players(0,1, or 2)");
        int response = in.nextInt();
        while (response != 0 && response != 1 && response != 2 ){
            System.out.println("Sorry, that is not valid, please select 0,1, or 2.");
            response = in.nextInt();
        }
        numPlayers = response;
        System.out.println(response+" human players slected!");
        System.out.println("Would you like the standard size(1)  or custom sized(2) board?");
        int choice = in.nextInt();
        switch(choice){
            case 1:
                buildEmptyBoard(6,7);
                System.out.println("Standard board created.");
                drawBoard();                                                //TESTING
                break;
            case 2:
                System.out.println("How many rows would you like?");
                int customRow = in.nextInt();
                System.out.println("How many columns would you like?");
                int customColumn = in.nextInt();
                buildEmptyBoard(customRow, customColumn);
                System.out.println("Custom Board Created.");
                drawBoard();                                                //TESTING
                break;
            default:
                System.out.println("Sorry, that is not valid.");
                System.out.println("Please select 1 for a standard board, or 2 for a custom board.");
        }       
        System.out.println("Lets start the game!");
        
    }   

    public static void main(String[] args){ConnectFour f = new ConnectFour();}
}
