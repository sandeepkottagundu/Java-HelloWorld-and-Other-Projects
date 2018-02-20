package arithmeticTutor;

import java.util.Random;

public class Tutor {
	public enum level{ LEVEL_1, LEVEL_2, LEVEL_3 };
	private level tutoringLevel;
	private int correctAnswer;
	private String question;
	
	public Tutor(){
		this.tutoringLevel = level.LEVEL_1;
		this.correctAnswer = -1;
		this.question = "";
	}
	
	public void levelUp(){
		switch(tutoringLevel){
		case LEVEL_1:
			this.tutoringLevel = level.LEVEL_2;
			break;
		case LEVEL_2:
			this.tutoringLevel = level.LEVEL_3;
			break;
		case LEVEL_3:
			break; // do nothing since this should end session
		default:
			break; // do nothing since this shouldn't be possible
		}
	}
	
	public String askQuestion(){
		Random numGen = new Random();
		int x = numGen.nextInt(10);
		if(this.tutoringLevel == level.LEVEL_1){
			int y = numGen.nextInt(10 - x);
			this.question = x + " + " + y + " = ";
			this.correctAnswer = x + y;
		}
		else if(this.tutoringLevel == level.LEVEL_2){
			int y = numGen.nextInt(10);
			this.question = x + " + " + y + " = ";
			this.correctAnswer = x + y;
		}
		else{
			int y = numGen.nextInt(10);
			if(x - y < 0){
				this.question = y + " - " + x + " = ";
				this.correctAnswer = y - x;
			}
			else{
				this.question = x + " - " + y + " = ";
				this.correctAnswer = x - y;
			}
		}
		return this.question;
	}
	
	public boolean isCorrectAnswer(int answer){
		return this.correctAnswer == answer;
	}
	
	public int getCorrectAnswer(){
		return this.correctAnswer;
	}
	
	public boolean isLastLevel(){
		return this.tutoringLevel == level.LEVEL_3;
	}
}
