package Model;

public abstract class Player{
	
	// attributes
	private Ship[] shiplist;
	private Board playboard;
	
	// constructor
	public Player(){
		shiplist = new Ship[8];
		playboard = new Board();
	}
	
	// methods
	public abstract void setShip(int index, Field[] fields);
        
        
	public void isShip(int x, int y){
	
	}
	
}