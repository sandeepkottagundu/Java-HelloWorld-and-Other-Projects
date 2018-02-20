package inputOutputExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

public class FileStatsPrinter {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			File selectedFile = chooser.getSelectedFile();
			try{
				FileParser fp = new FileParser(selectedFile);
				System.out.println("This file has " + fp.getCharacterCount() + " characters, " + fp.getWordCount() + 
						" words, and " + fp.getLineCount() + " lines.");
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}


	}

}
