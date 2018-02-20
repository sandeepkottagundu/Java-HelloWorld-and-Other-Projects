package arithmeticTutor;

import java.util.InputMismatchException;

public class ArithmeticGame {

	public static void main(String[] args) {
		Tutor t = new Tutor();
		Player p = new Player();
		boolean stillPlaying = true;
		
		System.out.println("Welcome to arithmetic tutoring! Enter any non-integer to quit.");
		
		try{
			while(stillPlaying){
				// ask question
				System.out.print(t.askQuestion());
				
				// two attempts per question
				int attempts = 0;
				while(attempts < 2){
					attempts++;
					if(t.isCorrectAnswer(p.answerQuestion())){
						System.out.println("Correct!");
						p.earnPoints();
						break;
					}
					else{
						if(attempts == 2){
							System.out.println("The correct answer was: " + t.getCorrectAnswer());
						}
						else{
							System.out.println("Try again");
						}
					}					
				}
				
				// check if need to level up the tutoring
				if(p.getPoints() == 5 && t.isLastLevel()){
					stillPlaying = false;
					System.out.println("Congratulations, you beat the game!");
				}
				else if(p.getPoints() == 5){
					t.levelUp();
					System.out.println("Leveling up...");
					p.resetPoints();
				}
			}
		} catch(InputMismatchException e){
			System.out.println("Not a valid input. Quitting...");
			stillPlaying = false;
		}
			
			
			
	}

}
