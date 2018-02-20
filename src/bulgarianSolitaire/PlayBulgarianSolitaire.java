package bulgarianSolitaire;

public class PlayBulgarianSolitaire {

	public static void main(String[] args) {
		BulgarianSolitaireGame bsg = new BulgarianSolitaireGame();
		
		System.out.println("Starting with piles: " + bsg.printPiles());
		
		int movesMade = 0;
		while(!bsg.isOver()){
			bsg.makeMove();
			System.out.println("Piles are currently: " + bsg.printPiles());
			movesMade ++;
		}
		
		System.out.println("Game ended in " + movesMade + " moves.");
		System.out.println("A game of this size ends in a maximum of 72 moves (9^2 - 9) "
				+ "since 45 is a triangular number (45 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9).");
	}

}
