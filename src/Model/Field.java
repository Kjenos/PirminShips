package Model;

public class Field{
	
	// attributes
	public enum State {water, water_hit, ship, ship_hit}
	private int x;
	private int y;
	private State state;
	
	// constructor
	public Field(int x, int y){
            this.x = x;
            this.y = y;
            state = State.water;
	}
	
	// methods
	public void setState(State s){
            this.state = s;
	}
	
	public State getState(){
            return (this.state);
	}
        public void setX(int x){
            if(x < 10 && x >= 0){
                this.x = x;
            }
        }
        public int getX(){
            return (this.x);
        }
        public void setY(int y){
            if(y < 10 && y >= 0){
                this.y = y;
            }
        }
         public int getY(){
            return (this.y);
        }
}