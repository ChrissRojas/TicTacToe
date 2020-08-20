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
public class Player {
    private String XO = "";
    private boolean turn;
    
    public Player(String xo){
        this.XO=xo;
    }
    
    public String getXO(){
        return this.XO;
    }
    
    public void setXO(String c){
        this.XO = c;
    }
    public boolean getTurn(){
        return this.turn;
    }
    
    public void setTurn(boolean t){
        this.turn = t;
    }
}
