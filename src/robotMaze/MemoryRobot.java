package robotMaze;

import java.util.ArrayList;
import java.util.Random;

public class MemoryRobot extends Robot {
	/* this robot attempts to escape the maze by remembering all positions that is has previously
	** occupied and never goes back to a position that is knows to be a dead end.
	*/

	ArrayList<String> deadEnds = new ArrayList<String>();
	String lastPosition;
	public MemoryRobot(Maze m) {
		super(m);
		this.deadEnds.add(m.startingPoint());
		this.lastPosition = m.startingPoint();
	}

	@Override
	public void move(Maze m) {
		// Check all available moves then randomly choose
		ArrayList<String> possibleMoves = this.availableMoves(m);
		String positionBeforeMove = this.getPosition();
		if(this.isDeadEnd(possibleMoves)){
			this.deadEnds.add(positionBeforeMove);
			super.setPosition(possibleMoves.get(0));
		}
		else{
			if(this.canMoveStraight(m)){
				this.moveStraight();
			}
			else{
				Random movePicker = new Random();
				String newPosition = possibleMoves.get(movePicker.nextInt(possibleMoves.size()));
				super.changeDirection(newPosition);
				super.setPosition(newPosition);
			}
		}
		this.lastPosition = positionBeforeMove;
		super.madeMove();
		
		
	}

	@Override
	public ArrayList<String> availableMoves(Maze m) {
		// create a string array with all available positions for the next move
		/* Can move up, down, right, or left 1 position
		 * (-1,+0)-- up, (+1,+0)--down, (+0,+1)--right, (+0,-1)--left
		 */

		int row = Integer.parseInt(this.getPosition().split(",")[0]);
		int column = Integer.parseInt(this.getPosition().split(",")[1]);
		
		// check if robot can move in each direction without leaving the maze
		boolean canMoveRight = column < m.getWidth() - 1;
		boolean canMoveLeft = column > 0;
		boolean canMoveDown = row < m.getHeight() - 1;
		boolean canMoveUp = row > 0;
		
		// assign null to the position if can't move there
		String moveRight = canMoveRight ? row + "," + (column + 1) : null;
		String moveUp = canMoveUp ? (row - 1) + "," + column : null;
		String moveDown = canMoveDown ? (row + 1) + "," + column : null;
		String moveLeft = canMoveLeft ? row + "," + (column - 1) : null;
		
		// make array list of available spaces
		ArrayList<String> availableSpaces = new ArrayList<String>();
		if(moveRight != null){
			if(m.isAvailableSpace(moveRight) && !this.deadEnds.contains(moveRight)){
				availableSpaces.add(moveRight);
			}
		}
		if(moveLeft != null){
			if(m.isAvailableSpace(moveLeft) && !this.deadEnds.contains(moveLeft)){
				availableSpaces.add(moveLeft);
			}
		}
		if(moveDown != null){
			if(m.isAvailableSpace(moveDown) && !this.deadEnds.contains(moveDown)){
				availableSpaces.add(moveDown);
			}
		}
		if(moveUp != null){
			if(m.isAvailableSpace(moveUp) && !this.deadEnds.contains(moveUp)){
				availableSpaces.add(moveUp);
			}
		}
		return availableSpaces;
	}

	private boolean isDeadEnd(ArrayList<String> possibleMoves){
		return possibleMoves.size() == 1 && possibleMoves.get(0).equals(this.lastPosition);
	}
	
	private boolean canMoveStraight(Maze m){
		int row = Integer.parseInt(this.getPosition().split(",")[0]);
		int column = Integer.parseInt(this.getPosition().split(",")[1]);
		String newPosition;
		boolean isLegalMove;
		boolean canMoveStraight = false;
		switch(this.getDirectionFacing()){
			case NORTH:
				newPosition = (row - 1) + "," + column;
				isLegalMove = column + 1 <= m.getWidth() - 1 && row - 1 >= 0 && !this.deadEnds.contains(newPosition);
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition);
				break;
			case SOUTH:
				newPosition = (row + 1) + "," + column;
				isLegalMove = column - 1 >= 0 && row + 1 <= m.getHeight() - 1 && !this.deadEnds.contains(newPosition);
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition);
				break;
			case EAST:
				newPosition = row + "," + (column + 1);
				isLegalMove = row + 1 <= m.getHeight() - 1 && column + 1 <= m.getWidth() - 1 
						&& !this.deadEnds.contains(newPosition);
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition);
				break;
			case WEST:
				newPosition = row + "," + (column - 1);
				isLegalMove = row - 1 >= 0 && column - 1 >= 0 && !this.deadEnds.contains(newPosition);
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition);
				break;
		}
		return canMoveStraight;
	}
	
	private void moveStraight(){
		int row = Integer.parseInt(this.getPosition().split(",")[0]);
		int column = Integer.parseInt(this.getPosition().split(",")[1]);
		String newPosition;
		switch(this.getDirectionFacing()){
			case NORTH:
				newPosition = (row - 1) + "," + column;
				super.setPosition(newPosition);
				break;
			case SOUTH:
				newPosition = (row + 1) + "," + column;
				super.setPosition(newPosition);
				break;
			case EAST:
				newPosition = row + "," + (column + 1);
				super.setPosition(newPosition);
				break;
			case WEST:
				newPosition = row + "," + (column - 1);
				super.setPosition(newPosition);
				break;
		}
	}
}
