import javax.swing.JOptionPane;

public class DialogViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog("What is your name?");
		System.out.println("Hello " + name);
		System.exit(0);
	}

}
