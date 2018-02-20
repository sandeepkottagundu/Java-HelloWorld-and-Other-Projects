
public class LetterPrinter {

	public static void main(String[] args) {
		// create and print a letter
		Letter writtenLetter = new Letter("Stefanie", "Bob");
		writtenLetter.addLine("I am sorry.");
		writtenLetter.addLine("We must part.");
		
		System.out.print(writtenLetter.getText());
	}

}
