package magicSquare;

import java.util.Scanner;

public class MagicSquareCreator {

	public static void main(String[] args) {
		System.out.print("Please enter an odd number: ");
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int dimension = 1;
		while(!valid){
			dimension = input.nextInt();
			if(dimension % 2 == 0){
				System.out.println("Please input an odd number.");
			}
			else{
				valid = true;
			}
		}
		input.close();
		
		MagicSquare ms = new MagicSquare(dimension);
		System.out.println(ms.toString());
		
		
	}

}
