package Model;

public class Board{
	
	// attributes
	private Field[][] board;
	
	// constructor
	public Board(){
		board = new Field[10][10];
                for(int i = 0; i < 10 ; i++){
                    for(int e = 0; e < 10; e++){
                        board[i][e] = new Field(i,e);
                    }
                }
	}
        
	// methods
        
}