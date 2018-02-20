package inputOutputExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumPrinter2 {

	public static void main(String[] args){
		double sum = 0;
		try(Scanner input = new Scanner(System.in)){
			System.out.print("Please enter a number: ");
			try{
				while(true){
					String line = input.nextLine();
					if(line.equals("")){
						throw new InputMismatchException("Exiting"); // exit on empty string
					}
					else{
						boolean passedTest = line.matches("[0-9]+\\.*"); //check if line is number
						if(passedTest){
							sum += Double.parseDouble(line); // sum up doubles
						}
						// don't do anything if input wasn't an empty string or a number
					}			
				}
			}
			catch(InputMismatchException e){
				System.out.println("Invalid input.");
			}
		}
		finally{
			System.out.println("Sum = " + sum);
		}
	}

}
