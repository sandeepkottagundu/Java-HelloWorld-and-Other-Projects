import javax.swing.JOptionPane;

public class DialogChoice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] options = new String[] {"Open Duolingo", "Speak in French"};
	    JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an option",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	    JOptionPane.showMessageDialog(null,  "Lo siento pero es que no puedo :(", "Error", 
	    		JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}

}
