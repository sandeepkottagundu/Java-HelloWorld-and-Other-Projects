package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile {

	public static void main(String[] args) {
		String inputFile = ""; 
		String outputFile = "C:\\Users\\Stefanie\\Documents\\testOut.txt";
		if(args.length >= 1){
			inputFile = args[0];
			if(args.length > 1){
				outputFile = args[1];
			}
		}
		
		try(Scanner in = new Scanner(new File(inputFile)); PrintWriter pw = new PrintWriter(outputFile)){
			while(in.hasNextLine()){
				pw.println(in.nextLine());
			}
			System.out.println("The file has been copied.");
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't find the input file: " + inputFile);
		}
	}

}
