package arithmeticTutor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	private int points;
	Scanner in = new Scanner(System.in);
	
	public Player(){
		this.points = 0;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public int answerQuestion() throws InputMismatchException{
		int answer;
		answer = in.nextInt();
		return answer;
	}
	
	public void earnPoints(){
		this.points ++;
	}
	
	public void resetPoints(){
		this.points = 0;
	}
}
