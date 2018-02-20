package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConcatenateFiles {

	public static void main(String[] args) {
		String outputFile = "";
		String content = "";
		try{
			if(args.length < 3){
				throw new IllegalArgumentException("Must provide at least 2 files to concatenate and 1 for output.");
			}
			outputFile = args[args.length - 1];// last file name is always the output
			String[] inputFiles = new String[args.length - 1]; 
			for(int i = 0; i < args.length - 1; i ++){
				inputFiles[i] = args[i];
			}
			for(String inputFile : inputFiles){
				try(Scanner in = new Scanner(new File(inputFile)); PrintWriter pw = new PrintWriter(outputFile)){
					while(in.hasNextLine()){
						content += in.nextLine() + "\n";
					}
					pw.write(content);
				} catch (FileNotFoundException e) {
					System.out.println("Can't find the input file: " + inputFile);
				}
			}
			
			System.out.println("The files have been concatenated.");
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		

	}

}
