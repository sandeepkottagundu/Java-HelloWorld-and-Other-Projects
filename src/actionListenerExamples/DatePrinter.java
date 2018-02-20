package actionListenerExamples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;

public class DatePrinter {

	public static void main(String[] args) {
		final int DELAY = 1000; // milliseconds

		class TimeListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				Date now = new Date();
				System.out.println(now);
			}
		}
		ActionListener listener = new TimeListener();
		Timer t = new Timer(DELAY, listener);
		t.start();
		
		while(true){
			// keep alive to keep printing
		}
		
	}

}
