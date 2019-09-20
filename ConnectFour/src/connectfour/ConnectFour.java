package connectfour;

import java.util.Scanner;
/**
 * COSC3P71 Assign1 2019 Fall/Winter 
 * @author Samantha Laffin(5017538)
 */
public class ConnectFour {
    private char[][] board;
    Scanner in;
    
    public ConnectFour(){
        buildEmptyBoard(6,7);
        addPiece(3,'X');
        addPiece(3,'X');
        addPiece(4,'X');
        drawBoard();
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
     * This method fills every element in the board array with a space char.
     */   
    private void fillEmptyBoard(){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[1].length; j++){ 
                board[i][j] = ' ';
            }
        }
    };
    
    /**
     * This method draws the current board to the console with labels for columns. 
     */
    private void drawBoard(){
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

    private void addPiece(int column, char piece){
        int count = 0;
        while (count<board.length){
            if ((board[count][column-1]!= 'X' 
                || board[count][column-1]!= 'O')
                    & count>board[1].length){
                count++;
            }
        }
        board[count][column-1] = piece;
    };

    private boolean checkWin(char player){

    
        return false;
    };

    private int promptPlayer(){
        System.out.print("1. Look at your surroundings.");
        System.out.print("\t2. Select a Move Decision.");
        System.out.print("\t3. ");
        System.out.println("\t4. ");
        System.out.print("5. ");
        System.out.println("\t0. Quit");
        return in.nextInt();
    };

    public static void main(String[] args){ConnectFour f = new ConnectFour();}
}