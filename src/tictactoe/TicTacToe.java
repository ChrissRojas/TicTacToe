/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


/**
 *
 * @author chris_000
 */
public class TicTacToe extends Application{
    private Controller cont;
    private Board newBoard;
    private Player player1;
    private Player player2;
    
    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        player1 = new Player("X");
        player2 = new Player("O");
        newBoard = new Board();
        cont = new Controller(newBoard,player1,player2);
        
        
        GridPane root = new GridPane();
        GridPaneCons(root);
        addButtons(root);
        buttonActions(root);
        root.setGridLinesVisible(true);
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
    public void GridPaneCons(GridPane grid){ //Sets height and width
        for(int i=0; i<3;i++){
            RowConstraints row = new RowConstraints(100); 
            ColumnConstraints col = new ColumnConstraints(100);
            grid.getRowConstraints().add(row);
            grid.getColumnConstraints().add(col);
        }
    }
    
    public void addButtons(GridPane grid){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Button button = new Button("-");
                button.setMaxHeight(100);
                button.setMaxWidth(100);
                grid.add(button, i, j);
            }
        }
    }
    
    public void buttonActions(GridPane grid){
        for(Node node:grid.getChildren()){
            if(node instanceof Button){
                ((Button) node).setOnAction((ActionEvent event)->{
                    //System.out.println(((Button) node).getText());
                    if(((Button)node).getText().equals("-")){
                        ((Button)node).setText(cont.currentPlayer().getXO());
                        int row =grid.getRowIndex(node);
                        int col =grid.getColumnIndex(node);
                        cont.updateBoard(row, col);
                        cont.updateTurn();
                        if(cont.winner()==true){
                            System.out.println("Winner");
                        }
                        cont.PrintBoard();
                        
                    }
                });
            }
        }
    }
    
}
