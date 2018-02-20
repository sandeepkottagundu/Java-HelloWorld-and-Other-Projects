package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {

	public static void main(String[] args) {
		String dictionaryFile = "C:\\Users\\Stefanie\\Documents\\testWordList.txt";
		try{
			if(args.length < 1){
				throw new IllegalArgumentException("Must provide at least 1 file to check.");
			}
			for(String inputFile : args){
				try(Scanner in = new Scanner(new File(inputFile))){
					boolean found = false;
					String word = "";
					while(in.hasNext()){
						Scanner dictionaryReader = new Scanner(new File(dictionaryFile));
						word = in.next();
						while(dictionaryReader.hasNext()){
							found = word.equals(dictionaryReader.next());
							if(found){
								break;
							}
						}
						if(!found){
							System.out.println(word + " is not spelled correctly.");
						}
						dictionaryReader.close();
					}
				} catch (FileNotFoundException e) {
					System.out.println("Can't find the input file: " + inputFile + " or the dictionary file: " + 
							dictionaryFile);
				}
			}
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

	}

}
