package inputOutputExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumPrinter {

	public static void main(String[] args) {
		double sum = 0;
		try(Scanner input = new Scanner(System.in)){
			System.out.print("Please enter a number: ");
			try{
				while(input.hasNext()){
					sum += input.nextDouble();
				}
			}
			catch(InputMismatchException e){
				System.out.println("Please input a number.");
				try(Scanner in = new Scanner(System.in)){
					while(in.hasNext()){
						sum += in.nextDouble();
					}
				}
				catch(InputMismatchException x){
					System.out.println("Not a valid input");
				}
			}
		}
		finally{
			System.out.println("Sum = " + sum);
		}
		

	}

}
