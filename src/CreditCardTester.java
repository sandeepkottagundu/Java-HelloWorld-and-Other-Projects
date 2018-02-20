import javax.swing.JOptionPane;


public class CreditCardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "";
		
		// validate the input
		boolean valid = false;
		int attempts = 1; 
		while(!valid){
			if(attempts == 1){
				input = JOptionPane.showInputDialog("Enter an 8 digit credit card number for check sum:");
			}
			else{
				input = JOptionPane.showInputDialog("(Please try again.) Enter an 8 digit credit card number for check sum:");
			}
			attempts ++;
			
			// if clicked cancel, quit program
			if(input == null){
				System.out.println("You have quit.");
				break;
			}
			// only run checks if the info is entered
			if(!input.isEmpty()){
				// check that all characters are digits
				for(int i = 0; i < input.length(); i ++){
					if(!Character.isDigit(input.charAt(i))){
						break;
					} // break out of check if any characters are not digits
					if(i == input.length() - 1 && input.length() == 8){
						valid = true;
					} // if all characters are digits (meaning we are at last index), check length is a match
				}
			}
			
			
		}
		
		// instantiate the credit card object and test its validity
		if(valid){
			CreditCard cc = new CreditCard(input);
			String result = cc.checkSum();
			System.out.println(result);
		}
		
	}

}
