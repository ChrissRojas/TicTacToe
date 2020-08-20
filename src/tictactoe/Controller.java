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
public class Controller {
    private Board board;
    private Player player1;
    private Player player2;
    
    public Controller(Board b,Player p1,Player p2){
        this.board = b;
        this.player1 = p1;
        this.player2 =p2;
        startState();
    }
    
    public Player currentPlayer(){
        if(player1.getTurn()==true){
            return player1;
        }else{
            return player2;
        }
    }
    
    public void updateTurn(){
        if(currentPlayer()==player1){
            currentPlayer().setTurn(false);
            player2.setTurn(true);
        }else{
            currentPlayer().setTurn(false);
            player1.setTurn(true);
        }
    }
    
    public void updateBoard(int row,int column){
        this.board.setXO(row, column, currentPlayer().getXO());
    }
    
    public void PrintBoard(){
        for(int i=0;i<board.getBoard().length;i++){
            for(int j=0;j<board.getBoard()[i].length;j++){
                System.out.print(board.getBoard()[i][j]);
            }
        }
    }
    
    public boolean compareChars(String s1, String s2, String s3){
        return ((!s1.equals("-")) && s1.equalsIgnoreCase(s2) && s2.equalsIgnoreCase(s3));
    }
    
    public boolean compareD(){
        return compareChars(board.getBoard()[0][0],board.getBoard()[1][1],board.getBoard()[2][2])||
                compareChars(board.getBoard()[0][2],board.getBoard()[1][1],board.getBoard()[2][1]);
    }
    public boolean compareRows(){
        for(int i=0;i<3;i++){
            return (compareChars(board.getBoard()[i][0],board.getBoard()[i][1],board.getBoard()[i][2]));
        }
        return false;
    }
    
    public boolean compareColumns(){
        for(int i =0; i<3;i++){
            return (compareChars(board.getBoard()[0][i],board.getBoard()[1][i],board.getBoard()[2][i]));
        }
        return false;
    }
    
    public boolean winner(){
        return(compareD()||compareRows()||compareColumns());
    }
    
    public void startState(){
        player1.setTurn(true);
        player2.setTurn(false);
    }
   
    
    
    
}
