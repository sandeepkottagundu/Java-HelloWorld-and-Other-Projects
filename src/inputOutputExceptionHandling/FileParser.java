package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
	private int wordCount = 0;
	private int characterCount = 0;
	private int lineCount = 0;
	
	public FileParser(File input) throws FileNotFoundException{
		Scanner wordScanner = new Scanner(input);
		Scanner characterScanner = new Scanner(input);
		Scanner lineScanner = new Scanner(input);
		
		while(wordScanner.hasNext()){
			this.wordCount++;
			wordScanner.next();
		}
		while(lineScanner.hasNextLine()){
			this.lineCount++;
			lineScanner.nextLine();
		}
		
		characterScanner.useDelimiter("");
		while(characterScanner.hasNext()){
			this.characterCount++;
			characterScanner.next();
		}
		
		// close scanners
		wordScanner.close();
		characterScanner.close();
		lineScanner.close();
	}
	
	public int getWordCount(){
		return this.wordCount;
	}
	public int getLineCount(){
		return this.lineCount;
	}
	public int getCharacterCount(){
		return this.characterCount;
	}
}
