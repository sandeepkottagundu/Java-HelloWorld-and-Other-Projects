package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TabReplacer {

	public static void main(String[] args) {
		try{
			if(args.length < 1){
				throw new IllegalArgumentException("Must provide at 1 file to replace tabs.");
			}
			int tabWidth;
			String inputFile;
			if(args[0].contains("-t")){
				tabWidth = Integer.parseInt(args[1]);
				inputFile = args[2];
			}
			else{
				tabWidth = 3;
				inputFile = args[0];
			}
			String content = "";
			try(Scanner in = new Scanner(new File(inputFile))){
				while(in.hasNextLine()){
					char[] charArray = in.nextLine().toCharArray();
					for(int i = 0; i < charArray.length; i++){
						if(charArray[i] == '\t'){
							content += new String(new char[tabWidth - (content.length() % tabWidth)]).replace("\0", " ");
						}
						else{
							content += charArray[i];
						}
						
					}
				}
				
				// write to same file
				PrintWriter out = new PrintWriter(inputFile);
				out.write(content);
				out.close();
				System.out.println("Tabs have been turned to spaces of specified width.");
				
			} catch (FileNotFoundException e) {
				System.out.println("Can't find the input file: " + inputFile);
			}
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

	}

}
