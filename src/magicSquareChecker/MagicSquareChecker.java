package magicSquareChecker;

import java.util.Scanner;

public class MagicSquareChecker {

	public static void main(String[] args) {
		System.out.print("Enter numbers to check if they form a magic square (type any non-digit to end input): ");
		Scanner input = new Scanner(System.in);
		String numbers = "";
		while(input.hasNextInt()){
			if(numbers.equals("")){
				numbers += input.nextInt();
			}
			else{
				numbers += " " + input.nextInt();
			}
		}
		input.close();
		Square s = new Square(numbers);
		if(s.isMagic()){
			System.out.println("This is a magic square!");
		}
		else{
			System.out.println("This is not a magic square.");
		}
	}

}
