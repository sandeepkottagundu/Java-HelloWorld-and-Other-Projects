import java.util.Scanner;


public class ComboLockTester {

	public static void main(String[] args) {
		//instantiate new lock
		CombinationLock cl = new CombinationLock("A", "B", "C");
		if(cl.isLocked()) {
			System.out.println("Currently locked.");
		}
		else {
			System.out.println("Unlocked!");
		}
		while(cl.isLocked()) {
			//enter in code
			System.out.println("Please enter the combo");
			Scanner input = new Scanner(System.in);
			int tracker = 1;
			while(input.hasNext()) {
				while(tracker <= 3) {
					cl.dial(input.next());
					tracker ++;
				}
				break;
			}
			tracker = 1;

			//try to unlock
			cl.unlock();
			
			//print result
			if(cl.isLocked()) {
				System.out.println("Currently locked.");
				//reset lock
				cl.lock();
			}
			else {
				System.out.println("Unlocked!");
				input.close();
			}
			
			
		}
		//re-lock if we were successful
		if(!cl.isLocked()){
			cl.lock();
			System.out.println("Lock has been reset.");
		}
	}

}
