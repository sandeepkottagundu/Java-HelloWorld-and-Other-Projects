package robotMaze;

import java.util.ArrayList;

public abstract class Robot {
	private String position;
	private int movesMade;
	public enum Direction { NORTH, SOUTH, EAST, WEST };
	private Direction facing; 
	
	public Robot(Maze m){
		// initialize the starting position to first open spot
		this.movesMade = 0;
		this.position = m.startingPoint();
		
		// determine initial direction robot is facing
		if(this.position.split(",")[0].equals("0")){
			/* robot is starting on the first row so it is entering from the top 
			** and therefore facing South
			*/
			this.facing = Direction.SOUTH;
		}
		else if(this.position.split(",")[1].equals("0")){
			/* robot is starting on the first column so it is entering from the left 
			** and therefore facing East
			*/
			this.facing = Direction.EAST;
		}
		else if(Integer.parseInt(this.position.split(",")[0]) == m.getHeight() - 1){
			/* robot is starting on the last row so it is entering from the bottom 
			** and therefore facing North
			*/
			this.facing = Direction.NORTH;
		}
		else{
			/* robot is starting on the last column so it is entering from the right 
			** and therefore facing West
			*/
			this.facing = Direction.WEST;
		}
	}
	
	// accessor methods
	public String getPosition(){
		return this.position;
	}
	public Direction getDirectionFacing(){
		return this.facing;
	}
	public int getMovesMade(){
		return this.movesMade;
	}
	public Direction potentialNewDirection(String newPosition){
		int oldRow = Integer.parseInt(this.getPosition().split(",")[0]);
		int oldColumn = Integer.parseInt(this.getPosition().split(",")[1]);
		int newRow = Integer.parseInt(newPosition.split(",")[0]);
		int newColumn = Integer.parseInt(newPosition.split(",")[1]);
		
		Direction d;
		
		if(oldRow < newRow){
			// bot will move down so it is will face South
			d = Direction.SOUTH;
		}
		else if(oldRow > newRow){
			// bot will move up so it is will face North
			d = Direction.NORTH;
		}
		else if(oldColumn < newColumn){
			// bot will move right so it is will face East
			d = Direction.EAST;
		}
		else{
			d = Direction.WEST;
		}
		
		return d;
	}
	
	// set methods
	public void setPosition(String newPosition){
		this.position = newPosition;
	}
	public void madeMove(){
		this.movesMade++;
	}
	public void changeDirection(String newPosition){
		int oldRow = Integer.parseInt(this.getPosition().split(",")[0]);
		int oldColumn = Integer.parseInt(this.getPosition().split(",")[1]);
		int newRow = Integer.parseInt(newPosition.split(",")[0]);
		int newColumn = Integer.parseInt(newPosition.split(",")[1]);
		
		if(oldRow < newRow){
			// bot moved down so it is now facing South
			this.facing = Direction.SOUTH;
		}
		else if(oldRow > newRow){
			// bot moved up so it is now facing North
			this.facing = Direction.NORTH;
		}
		else if(oldColumn < newColumn){
			// bot moved right so it is now facing East
			this.facing = Direction.EAST;
		}
		else{
			this.facing = Direction.WEST;
		}
		
		
	}
	
	// method to check if the robot has escaped
	public boolean hasEscaped(Maze m){
		return this.position.equals(m.mazeExit());
	}
	
	public abstract void move(Maze m);
	public abstract ArrayList<String> availableMoves(Maze m);
}
