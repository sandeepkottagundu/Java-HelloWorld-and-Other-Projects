
public class Letter {
	private String from;
	private String to;
	private String body = "";
	
	//constructor
	public Letter(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	//method to add lines
	public void addLine(String line) {
		body = body.concat("\n").concat(line);
	}
	
	// method to get the full text of the letter
	public String getText() {
		String intro = "Dear " + to + ":";
		String signature = "Sincerely,\n\n" + from;
		String fullMessage = intro + "\n\n\n" + body + "\n\n" + signature;
		return fullMessage;
	}
}
