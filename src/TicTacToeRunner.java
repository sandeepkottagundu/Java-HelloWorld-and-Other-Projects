import java.util.Scanner;

/**
 * This program runs a Tic-Tac-Toe game. 
 * It prompts the user to set positions on the board and prints out the result.
 * @author Stefanie
 *
 */

public class TicTacToeRunner {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String player = "x";
		TicTacToe game = new TicTacToe();
		boolean done = false;
		while(!done){
			System.out.print(game.toString());
			System.out.print("Row for " + player + " (-1 to exit): ");
			int row = in.nextInt();
			if(row < 0){
				done = true;
			}
			else{
				System.out.print("Column for " + player + ": ");
				int column = in.nextInt();
				game.set(row, column, player);
				if(game.getWinner(player)){
					System.out.print(game.toString());
					System.out.print(player + " has won!");
					done = true;
				}
				else{
					if(player.equals("x")){
						player = "o";
					}
					else{
						player = "x";
					}
				}
			}
		}
		in.close();

	}

}
