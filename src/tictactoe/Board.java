/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author chris_000
 */

/*
This class will hold the board model
so we can use the controller to manipulate the board and the view
can just query from the model.
*/
public class Board {
    private String[][] board = new String[3][3];
    
    public Board(){
        for(int i=0; i<this.board.length;i++){
            for(int j =0; j<this.board[i].length;j++){
                board[i][j]= "-";
            }
        }
    }
    
    public String[][] getBoard(){
        return this.board;
    }
    
    public String getXO(int row,int col){
        return board[row][col];
    }
    
    public void setXO(int row,int col, String xo){
        this.board[row][col] = xo;
    }
}
