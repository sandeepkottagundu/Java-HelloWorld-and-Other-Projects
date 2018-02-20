package robotMaze;

import java.util.ArrayList;
import java.util.Random;

public class RightHandRuleRobot extends Robot {
	// this robot attempts to escape the maze by always keeping its right hand to the wall

	public RightHandRuleRobot(Maze m) {
		super(m);
	}

	@Override
	public void move(Maze m) {
		// Check all available moves then randomly choose
		if(this.canMoveStraight(m)){
			this.moveStraight();
		}
		else{
			ArrayList<String> possibleMoves = this.availableMoves(m);
			Random movePicker = new Random();
			String newPosition = possibleMoves.get(movePicker.nextInt(possibleMoves.size()));
			super.changeDirection(newPosition);
			super.setPosition(newPosition);
		}
		
		super.madeMove();
	}

	@Override
	public ArrayList<String> availableMoves(Maze m) {
		// robot should move straight until it needs to turn
		int row = Integer.parseInt(this.getPosition().split(",")[0]);
		int column = Integer.parseInt(this.getPosition().split(",")[1]);
		
		// check if robot can move in each direction without leaving the maze 
		// and keeping right hand on wall
		boolean canMoveRight = column < m.getWidth() - 1;
		boolean canMoveLeft = column > 0;
		boolean canMoveDown = row < m.getHeight() - 1;
		boolean canMoveUp = row > 0;
		
		// assign null to the position if can't move there
		String moveRight = canMoveRight ? row + "," + (column + 1) : null;
		String moveUp = canMoveUp ? (row - 1) + "," + column : null;
		String moveDown = canMoveDown ? (row + 1) + "," + column : null;
		String moveLeft = canMoveLeft ? row + "," + (column - 1) : null;
		String moveDiagonalUpRight = canMoveRight && canMoveUp ? (row - 1) + "," + (column + 1) : null;
		String moveDiagonalDownRight = canMoveRight && canMoveDown ? (row + 1) + "," + (column + 1) : null;
		String moveDiagonalUpLeft = canMoveLeft && canMoveUp ? (row - 1) + "," + (column - 1) : null;
		String moveDiagonalDownLeft = canMoveLeft && canMoveDown ? (row + 1) + "," + (column - 1) : null;
		
		// make array list of available spaces where robot has right hand on wall and doesn't do a 180
		ArrayList<String> availableSpaces = new ArrayList<String>();
		if(moveRight != null){
			if(m.isAvailableSpace(moveRight) && this.wallOnRight(m, moveRight)){
				availableSpaces.add(moveRight);
			}
		}
		if(moveLeft != null){
			if(m.isAvailableSpace(moveLeft) && this.wallOnRight(m, moveLeft)){
				availableSpaces.add(moveLeft);
			}
		}
		if(moveDown != null){
			if(m.isAvailableSpace(moveDown) && this.wallOnRight(m, moveDown)){
				availableSpaces.add(moveDown);
			}
		}
		if(moveUp != null){
			if(m.isAvailableSpace(moveUp) && this.wallOnRight(m, moveUp)){
				availableSpaces.add(moveUp);
			}
		}
		if(moveUp != null && (moveDiagonalUpRight != null || moveDiagonalUpLeft != null)){
			// the robot is at a corner and should still consider moving by changing directions to keep hand on wall
			if(m.isAvailableSpace(moveUp)){
				availableSpaces.add(moveUp);
			}
		}
		if(moveDown != null && (moveDiagonalDownRight != null || moveDiagonalDownLeft != null)){
			if(m.isAvailableSpace(moveDown)){
				availableSpaces.add(moveDown);
			}
		}
		if(moveLeft != null && (moveDiagonalUpLeft != null || moveDiagonalDownLeft != null)){
			if(m.isAvailableSpace(moveLeft)){
				availableSpaces.add(moveLeft);
			}
		}
		if(moveRight != null && (moveDiagonalUpRight != null || moveDiagonalDownRight != null)){
			if(m.isAvailableSpace(moveRight)){
				availableSpaces.add(moveRight);
			}
		}
		return availableSpaces;
	}
	
	private boolean wallOnRight(Maze m, String moveToPosition){
		boolean isWall = false;
		String rightHandPosition;
		int row = Integer.parseInt(moveToPosition.split(",")[0]);
		int column = Integer.parseInt(moveToPosition.split(",")[1]);
		boolean isLegalMove;
		switch(this.potentialNewDirection(moveToPosition)){
			case NORTH:
				rightHandPosition = row + "," + (column + 1);
				isLegalMove = column + 1 <= m.getWidth() - 1;
				isWall = !m.isAvailableSpace(rightHandPosition) && isLegalMove;
				break;
			case SOUTH:
				rightHandPosition = row + "," + (column - 1);
				isLegalMove = column - 1 >= 0;
				isWall = !m.isAvailableSpace(rightHandPosition) && isLegalMove;
				break;
			case EAST:
				rightHandPosition = (row + 1) + "," + column;
				isLegalMove = row + 1 <= m.getHeight() - 1;
				isWall = !m.isAvailableSpace(rightHandPosition) && isLegalMove;
				break;
			case WEST:
				rightHandPosition = (row - 1) + "," + column;
				isLegalMove = row - 1 >= 0;
				isWall = !m.isAvailableSpace(rightHandPosition) && isLegalMove;
				break;
		}
		return isWall;
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
				isLegalMove = column + 1 <= m.getWidth() - 1 && row - 1 >= 0;
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition) && this.wallOnRight(m, newPosition);
				break;
			case SOUTH:
				newPosition = (row + 1) + "," + column;
				isLegalMove = column - 1 >= 0 && row + 1 <= m.getHeight() - 1;
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition) && this.wallOnRight(m, newPosition);
				break;
			case EAST:
				newPosition = row + "," + (column + 1);
				isLegalMove = row + 1 <= m.getHeight() - 1 && column + 1 <= m.getWidth() - 1;
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition) && this.wallOnRight(m, newPosition);
				break;
			case WEST:
				newPosition = row + "," + (column - 1);
				isLegalMove = row - 1 >= 0 && column - 1 >= 0;
				canMoveStraight = isLegalMove && m.isAvailableSpace(newPosition) && this.wallOnRight(m, newPosition);
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
