import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ImageGreeter {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		URL imageLocation = new URL("http://www.horstmann.com/bigjava/duke.gif");
		JOptionPane.showMessageDialog(null, "Hello", "Title", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
		System.exit(0);
	}

}
