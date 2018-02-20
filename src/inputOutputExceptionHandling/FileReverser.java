package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReverser {

	public static void main(String[] args) {
		try{
			if(args.length != 1){
				throw new IllegalArgumentException("Must provide at 1 file to reverse.");
			}
			String inputFile = args[0];
			String content = "";
			try(Scanner in = new Scanner(new File(inputFile))){
				in.useDelimiter(""); // read by character
				while(in.hasNext()){
					content += in.next();
				}
				char[] charArray = content.toCharArray();
				content = "";
				// reverse contents
				for(int i = charArray.length - 1; i >= 0; i--){
					content += charArray[i];
				}
				// write to same file
				PrintWriter out = new PrintWriter(inputFile);
				out.write(content);
				out.close();
				System.out.println("The file has been reversed.");
				
			} catch (FileNotFoundException e) {
				System.out.println("Can't find the input file: " + inputFile);
			}
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

	}

}
