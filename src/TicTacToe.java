/**
 * A 3x3 tic-tac-toe-board
 */
public class TicTacToe {
	private String[][] board;
	private static final int ROWS = 3;
	private static final int COLUMNS = 3;
	
	/**
	 * Constructs an empty board.
	 */
	
	public TicTacToe(){
		board = new String[ROWS][COLUMNS];
		// Fill with spaces
		for(int i = 0; i < ROWS; i++){
			for(int j = 0; j < COLUMNS; j++){
				board[i][j] = " ";
			}
		}
	}
	
	/**
	 * Sets a field in the board. The field must be unoccupied.
	 * @param i the row index
	 * @param j the column index
	 * @param player the player ("x" or "o")
	 */
	public void set(int i, int j, String player){
		if(board[i][j].equals(" ")){
			board[i][j] = player;
		}
	}
	
	/**
	 * Creates a string representation of the board, such as
	 * |x o|
	 * | x |
	 * |  o|.
	 * @return the string representation
	 */
	public String toString(){
		String r = "";
		for(int i = 0; i < ROWS; i++){
			r = r + "|";
			for(int j = 0; j < COLUMNS; j++){
				r = r + board[i][j];
			}
			r = r + "|\n";
		}
		return(r);
	}
	
	public boolean getWinner(String player){
		int count = 0; 
		boolean hasWon = false;
		// check across rows
		for(int i = 0; i < ROWS; i++){
			for(int j = 0; j < COLUMNS; j++){
				String square = board[i][j];
				if(square.equals(player)){
					count ++;
				}
				else{
					count = 0;
				}
			}
			if(count == 3){
				hasWon = true;
				break;
			}
			else{
				count = 0;
			}
		}
		
		// check across columns
		for(int j = 0; j < COLUMNS; j++){
			for(int i = 0; i < ROWS; i++){
				String square = board[i][j];
				if(square.equals(player)){
					count ++;
				}
				else{
					count = 0;
				}
			}
			if(count == 3){
				hasWon = true;
				break;
			}
			else{
				count = 0;
			}
		}
		
		
		// check the 2 diagonals
		if((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) || 
				board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) && board[1][1].equals(player)){
			hasWon = true;
		}
		
		return(hasWon);
	}

}
