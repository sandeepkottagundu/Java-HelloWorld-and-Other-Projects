package robotMaze;

import java.util.ArrayList;
import java.util.Random;

public class RandomRobot extends Robot {
	// this robot makes random moves in an attempt to escape the given maze

	public RandomRobot(Maze m) {
		super(m);
	}

	@Override
	public void move(Maze m) {
		// Check all available moves then randomly choose
		ArrayList<String> possibleMoves = this.availableMoves(m);
		Random movePicker = new Random();
		super.setPosition(possibleMoves.get(movePicker.nextInt(possibleMoves.size())));
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
			if(m.isAvailableSpace(moveRight)){
				availableSpaces.add(moveRight);
			}
		}
		if(moveLeft != null){
			if(m.isAvailableSpace(moveLeft)){
				availableSpaces.add(moveLeft);
			}
		}
		if(moveDown != null){
			if(m.isAvailableSpace(moveDown)){
				availableSpaces.add(moveDown);
			}
		}
		if(moveUp != null){
			if(m.isAvailableSpace(moveUp)){
				availableSpaces.add(moveUp);
			}
		}
		return availableSpaces;
	}
	

}
