package postalCode;

import java.util.Scanner;

public class PostalCodeCreator {

	public static void main(String[] args) {
		System.out.print("Please provide a zip code or a bar code: ");
		Scanner input = new Scanner(System.in);
		PostalCode p;
		if(input.hasNextInt()){
			p = new PostalCode(input.nextInt());
			System.out.println("The postal bar code is: " + p.getPostalBarCode());
		}
		else{
			p = new PostalCode(input.next());
			System.out.println("The zip code is: " + p.getZipCode());
		}

		input.close();
		
		

	}

}
