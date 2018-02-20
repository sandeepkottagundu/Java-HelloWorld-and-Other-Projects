package actionListenerExamples;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonViewer {
	private static final int FRAME_WIDTH = 100;
	private static final int FRAME_HEIGHT = 110;
	
	public static void main(String[] args) {
		 JFrame frame = new JFrame();
		 JButton buttonA = new JButton("Click me!");
		 JButton buttonB = new JButton("Click me!");
		 JPanel panel = new JPanel();
		 JLabel labelA = new JLabel("A: ");
		 JLabel labelB = new JLabel("B: ");
		 panel.add(labelA);
		 panel.add(buttonA);
		 panel.add(labelB);
		 panel.add(buttonB);
		 frame.add(panel);
		 
		 class ClickListener implements ActionListener{
			 int n = 0;
			 String buttonName;
			 
			 public ClickListener(String name){
				 buttonName = name;
			 }
			 
			 public void actionPerformed(ActionEvent event){
				 n++;
				 
				 System.out.println(buttonName + " was clicked " + n + " times.");
			 }
		 }
		 
		 ActionListener listenerA = new ClickListener("Button A");
		 buttonA.addActionListener(listenerA);
		 ActionListener listenerB = new ClickListener("Button B");
		 buttonB.addActionListener(listenerB);
		 
		 frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);

	}

}
