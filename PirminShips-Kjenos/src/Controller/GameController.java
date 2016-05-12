/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.*;
import View.*;
import Model.*;
import Model.GameModel.GameState;
import Model.GameModel.PlayerMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author tagroebe
 */
public class GameController {
    private StartView startView;
    private ShipPlacementView shipPlacementView;
    private SearchOpponentView searchOpponentView;
    
    private GameModel model;
    
    
    public GameController(GameModel model){
        
        //Get the Model
        this.model = model;
        
        //Initialize all views
        InitializeStartView();
        InitializeSearchOpponentView();
        InitializeShipPlacementView();
        
        //Start the Game with StartView
        ChangeGameState(GameState.SelectPlayerMode);
    }
    
    
    
    class PlayerModeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //Save the chosen GameMode in the model
            model.setPlayerMode(e.getActionCommand());
            System.out.println("GameModel.PlayerMode = " + model.getPlayerMode());
            
            //Close StartView
            startView.setVisible(false);
            
            //Open new View depending on chosen PlayerMode
            if (model.getPlayerMode() == PlayerMode.SinglePlayer) {
                ChangeGameState(GameState.PlacingShips);
            }
            else{
                ChangeGameState(GameState.EnterOpponentIP);
            }
          
        }
    }
    
    class BackToMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){           
            //Close current view and go back to StartView
            ChangeGameState(GameState.SelectPlayerMode);   
        }
    }
    
    
    //The following methods are used to initialize all views (they only have to be called once
    
    //Initializes the Start View
    private void InitializeStartView(){
        startView = new StartView();
        startView.addPlayerModeListener(new PlayerModeListener());
        
    }
    
    //Initializes the SearchOpponentView
    private void InitializeSearchOpponentView() {
        searchOpponentView = new SearchOpponentView();
        searchOpponentView.addBackToMenuListener(new BackToMenuListener());
    }
    
    //Initializes the ShipPlacementView
    private void InitializeShipPlacementView(){
        shipPlacementView = new ShipPlacementView();
        shipPlacementView.addBackToMenuListener(new BackToMenuListener());
    
    }
    
    //Changes the Game State in the model and accordingly switches between the views
    private void ChangeGameState(GameState gameState){
        
        //Change GameState in the model
        model.setGameState(gameState);
        
        //Set all views invisible
        startView.setVisible(false);
        searchOpponentView.setVisible(false);
        shipPlacementView.setVisible(false);
        
        if (gameState == GameState.SelectPlayerMode) {
            startView.setVisible(true);
        }
        else if(gameState == GameState.EnterOpponentIP){
            searchOpponentView.setVisible(true);
        }
        else if(gameState == GameState.PlacingShips){
            shipPlacementView.setVisible(true);
        }
    }
}
