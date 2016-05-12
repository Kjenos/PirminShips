/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tagroebe
 */
public class GameModel {
    // attributes
    public enum GameState {SelectPlayerMode,EnterOpponentIP,WaitingForOpponent,PlacingShips,PlayerTurn,PostGame}
    public enum PlayerMode {NotSet,SinglePlayer,MultiPlayer}
    
    private PlayerMode playerMode = PlayerMode.NotSet;
    private GameState gameState = GameState.SelectPlayerMode;
    private Player local;
    private Player opponent;

    // constructor
    public GameModel(){
        local = new HumanPlayer() {};
    }

    // methods 
    
    //Sets the Playermode. "1 Player" will set playermode to singleplayer. "2 Players" will set the playermode to multiplayer. Else playermode will be set to NotSet.
    public void setPlayerMode(String playerMode)
    {
        switch(playerMode){
            case "1 Player":
                this.playerMode = PlayerMode.SinglePlayer;
                opponent = new ComputerPlayer();
                break;
            case "2 Players":
                this.playerMode = PlayerMode.MultiPlayer;
                opponent = new HumanPlayer();
                break;
            default:
                this.playerMode = PlayerMode.NotSet;
        }
    }
    
    //Gets the Playermode (SinglePlayer, MultiPlayer, NotSet)
    public PlayerMode getPlayerMode(){
        return playerMode;
    }
    
    //Sets the GameState
    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }
    
    //Returns the current GameState
    public GameState getGameState(){
        return gameState;
    }
}
