
public class CreditCard {
	private final String CC_NUMBER;
	
	public CreditCard(String num){
		CC_NUMBER = num;
	}
	
	public String getNumber(){
		return CC_NUMBER;
	}
	
	public String checkSum(){
		String number = getNumber();
		int length = number.length();
		
		// get sum of either other digit starting from right with the check digit
		int sumReverseSkip = 0;
		for(int i = length - 1; i > 0; i = i - 2){
			sumReverseSkip += Character.getNumericValue(number.charAt(i));
		}
		
		// get doubles of each number not included above, then add together their digits
		
		int[] doubles = new int[length/2];
		for(int i = 0; i < length; i += 2){
			int index = i/2;
			doubles[index] = 2 * Character.getNumericValue(number.charAt(i));
		} // gets doubles of every other digit
		
		String digits = "";
		for(int i = 0; i < doubles.length; i ++){
			digits += doubles[i];
		} // pull out the digits into a string
		
		int doubleSkipDigits = 0;
		for(int i = 0; i < digits.length(); i ++){
			doubleSkipDigits += Character.getNumericValue(digits.charAt(i));
		}
		
		// sum the results of the above
		int checkSum = sumReverseSkip + doubleSkipDigits;
		
		// check if valid (ends in 0 --> divisible by 10)
		if(checkSum % 10 == 0){
			return "This credit card is valid.";
		}
		else{
			// calculate the value of the check digit that would have made the number valid
			int mod = checkSum % 10;
			int difference = 10 - mod;
			int lastDigit = Character.getNumericValue(number.charAt(length - 1));
			int validSum;
			if(difference > 5){
				validSum = checkSum - mod;
			}
			else if(difference == 5){
				if(lastDigit < 5){
					validSum = checkSum + mod;
				}
				else{
					validSum = checkSum - mod;
				}
			}
			else{
				validSum = checkSum + difference;
			}
			
			int missing = validSum - checkSum;
			int checkDigit = lastDigit + missing;
			
			if(checkDigit < 0){
				validSum = validSum + 10;
				missing = validSum - checkSum;
				checkDigit = lastDigit + missing;
			}
			return "This is not a valid credit card. A check digit of " + checkDigit + " would fix it.";
		}
		
	}
}
