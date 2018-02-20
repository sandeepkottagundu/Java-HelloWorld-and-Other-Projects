package quizAdministrator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Quizzer {
	private String quizFile;
	private int correctAnswers;
	
	public Quizzer(String filename){
		this.correctAnswers = 0;
		this.quizFile = filename;
	}
	
	public void startTest() throws IOException{
    	Scanner in = new Scanner(System.in);
		String answer = "";
		try(BufferedReader br = new BufferedReader(new FileReader(this.quizFile))) {
			String line;
			while ((line = br.readLine()) != null) {
			    if(line.equals("T")){
			    	System.out.println(br.readLine());
		    		answer = in.next();
		    		String correctAnswer = br.readLine();
		    		if(answer.equalsIgnoreCase(correctAnswer)){
		    			this.correctAnswers ++;
		    			System.out.println("That's correct");
		    		}
		    		else{
		    			System.out.println("The correct answer was " + correctAnswer);
		    		}
		    		line = br.readLine();
			    }
			    else if(line.equals("S")){
			    	System.out.println(br.readLine());// print questions
			    	String correctAnswer = "";
			    	boolean answersPrinted = false;
			    	while(!answersPrinted){
			    		line = br.readLine();
			    		if(line.isEmpty()){
			    			answersPrinted = true;
			    			break;
			    		}
			    		else{
			    			System.out.println(line.substring(2));
				    		if(line.substring(0,1).equals("+")){
				    			correctAnswer = line.substring(2);
				    		}
			    		}
			    	}
		    		answer = in.next();
		    		if(answer.trim().equalsIgnoreCase(correctAnswer)){
		    			this.correctAnswers ++;
		    			System.out.println("That's correct");
		    		}
		    		else{
		    			System.out.println("The correct answer was " + correctAnswer);
		    		}
			    }
			    else if(line.equals("M")){
			    	System.out.println(br.readLine());// print questions
			    	String correctAnswer = "";
			    	boolean answersPrinted = false;
			    	while(!answersPrinted){
			    		line = br.readLine();
			    		if(line.isEmpty()){
			    			answersPrinted = true;
			    			break;
			    		}
			    		else{
			    			System.out.println(line.substring(2));
				    		if(line.substring(0,1).equals("+")){
				    			correctAnswer += line.substring(2);
				    		}
			    		}
			    	}
		    		answer = in.next();
		    		if(answer.trim().equalsIgnoreCase(correctAnswer)){
		    			this.correctAnswers ++;
		    			System.out.println("That's correct");
		    		}
		    		else{
		    			System.out.println("The correct answer was " + correctAnswer);
		    		}
			    }
			    else if(line.equals("N")){
			    	System.out.println(br.readLine());
		    		answer = in.next();
		    		double correctAnswer = Double.parseDouble(br.readLine());
		    		if(correctAnswer*1.05 >= Double.parseDouble(answer) && 
		    				correctAnswer*.95 <= Double.parseDouble(answer)){
		    			this.correctAnswers ++;
		    			System.out.println("That's correct");
		    		}
		    		else{
		    			System.out.println("The correct answer was " + correctAnswer);
		    		}
			    }
		    }
			System.out.println("Your final score is " + this.correctAnswers);
			in.close();
		}
	}

}
