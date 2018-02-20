package postalCode;

public class PostalCode {
	private final int zipCode;
	private final String postalBarCode;
	
	public PostalCode(int num){
		this.zipCode = num;
		this.postalBarCode = this.encode();
	}
	
	public PostalCode(String barCode){
		this.postalBarCode = barCode;
		this.zipCode = this.decode();
	}
	
	private String encode(){
		String number = "" + this.zipCode;
		int sumDigits = 0;
		for(int i = 0; i < number.length(); i++){
			sumDigits += Character.getNumericValue(number.charAt(i));
		}
		int checkDigit = 10 - (sumDigits % 10);
		String r = "|";
		char[] num = ("" + this.zipCode + checkDigit).toCharArray();
		for(int i = 0; i < num.length; i++){
			char digit = num[i];
			if(digit == '1'){
				r += ":::||";
			}
			else if(digit == '2'){
				r += "::|:|";
			}
			else if(digit == '3'){
				r += "::|||";
			}
			else if(digit == '4'){
				r += ":|::|";
			}
			else if(digit == '5'){
				r += ":|:|:";
			}
			else if(digit == '6'){
				r += ":||::";
			}
			else if(digit == '7'){
				r += "|::::";
			}
			else if(digit == '8'){
				r += "|::||";
			}
			else if(digit == '9'){
				r += "|:|::";
			}
			else{// digit is 0
				r += "||:::";
			}
		}
		r += "|"; //frame with last pipe
		return r;
	}
	
	private int decode(){
		String numberBars = this.postalBarCode.substring(1, this.postalBarCode.length() - 1); // remove framing "|"s
		numberBars = numberBars.substring(0, numberBars.length() - 6); // remove check digit
		numberBars = numberBars.replaceAll(":", "0");
		numberBars = numberBars.replaceAll("\\|", "1"); // change to 1's and 0's
		
		String[] numCode = new String[5];
		for(int i = 0; i < numCode.length; i++){
			numCode[i] = numberBars.substring(i*5, i*5 + 4);
		}
		
		String zip = "";
		for(int i = 0; i < numCode.length; i++){
			String num = numCode[i];
			int sum = 7 * Character.getNumericValue(num.charAt(0)) + 4 * Character.getNumericValue(num.charAt(1))
					+ 2 * Character.getNumericValue(num.charAt(2)) + 1 * Character.getNumericValue(num.charAt(3));
			if(sum == 11){
				zip += "0";
			}
			else{
				zip += sum;
			}
		}
		
		int r = Integer.parseInt(zip);
		return r;
	}
	
	public int getZipCode(){
		return this.zipCode;
	}
	
	public String getPostalBarCode(){
		return this.postalBarCode;
	}
}
