package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAnalyzer {

	public static void main(String[] args) {
		int totalWords = 0;
		int totalCharacters = 0;
		int totalLines = 0;
		try(Scanner in = new Scanner(System.in)){//this will automatically close the scanner
			boolean done = false;
			while(!done){
				System.out.print("Enter a file: ");
				File inputFile = new File(in.next());
				try{
					FileParser fp = new FileParser(inputFile);
					totalWords += fp.getWordCount();
					totalCharacters += fp.getCharacterCount();
					totalLines += fp.getLineCount();
				}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Unable to find the specified file.");
					done = true;
				}
			}	
		}
		finally{
			System.out.println("The file(s) contain(s) " + totalCharacters + " characters, " + totalWords + 
					" words, and " + totalLines + " lines.");
		}

	}

}
