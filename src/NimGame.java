
public class NimGame {

	public static void main(String[] args) {
		Player human = new Player();
		Player computer = new Player((int) Math.random());
		Pile marblePile = new Pile();
		
		boolean gameOver = false;
		
		System.out.println("The pile for this game has " + marblePile.getSize() + " marbles.");
		
		double goesFirst = Math.random();
		
		if(goesFirst <= 0.5){
			System.out.println("The computer will go first.");
			while(!gameOver){
				System.out.println("~Computer's turn");
				marblePile.removeMarbles(computer.takeTurn(marblePile.getSize()));
				if(marblePile.getSize() == 0){
					System.out.println("You win!");
					gameOver = true;
				}
				else{
					System.out.println("Marbles remaining: " + marblePile.getSize());
					System.out.println("~Your turn");
					marblePile.removeMarbles(human.takeTurn(marblePile.getSize()));
					System.out.println("Marbles remaining: " + marblePile.getSize());
					if(marblePile.getSize() == 0){
						System.out.println("You lose.");
						gameOver = true;
					}
				}
			}
			
		}
		else{
			System.out.println("You will go first.");
			while(!gameOver){
				System.out.println("~Your turn");
				marblePile.removeMarbles(human.takeTurn(marblePile.getSize()));
				System.out.println("Marbles remaining: " + marblePile.getSize());
				if(marblePile.getSize() == 0){
					System.out.println("You lose.");
					gameOver = true;
				}
				else{
					System.out.println("~Computer's turn");
					marblePile.removeMarbles(computer.takeTurn(marblePile.getSize()));
					System.out.println("Marbles remaining: " + marblePile.getSize());
					if(marblePile.getSize() == 0){
						System.out.println("You win!");
						gameOver = true;
					}
				}
			}
		}

	}

}
