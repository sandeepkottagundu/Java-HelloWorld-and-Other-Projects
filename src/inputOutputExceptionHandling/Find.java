package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Find {

	public static void main(String[] args) {
		String keyword = "";
		try{
			if(args.length < 2){
				throw new IllegalArgumentException("Must provide at least 1 keyword and 1 file to search.");
			}
			keyword = args[0];// keyword is always first
			String[] inputFiles = new String[args.length - 1]; 
			for(int i = 1; i < args.length; i ++){
				inputFiles[i - 1] = args[i];
			}
			for(String inputFile : inputFiles){
				try(Scanner in = new Scanner(new File(inputFile))){
					boolean found = false;
					String line = "";
					while(in.hasNextLine()){
						line = in.nextLine();
						found = line.contains(keyword);
						if(found){
							System.out.println(inputFile + ": " + line);
						}
					}
				} catch (FileNotFoundException e) {
					System.out.println("Can't find the input file: " + inputFile);
				}
			}
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

	}

}
