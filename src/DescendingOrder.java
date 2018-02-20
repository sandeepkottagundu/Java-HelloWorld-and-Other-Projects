import java.util.ArrayList;

public class DescendingOrder {
  public static int sortDesc(final int num) {
    String s = Integer.toString(num);
    ArrayList<Integer> digits = new ArrayList<Integer>(s.length());
    for(int i = 0; i < s.length(); i++){
      digits.add((Integer) Character.getNumericValue(s.charAt(i)));
    }
    String newNum = "";
    int count = 0;
    int numDigits = digits.size();
    while(count < numDigits){
	    int max = -1;
	    int maxIndex = -1;
	      for(int i = 0; i < digits.size(); i++){
	        if(digits.get(i) > (Integer) max){
	          max = digits.get(i);
	          maxIndex = i;
	        }
	      }
	    digits.remove(maxIndex);
	    newNum += max;
	    count ++;
    }
    return Integer.parseInt(newNum);
  }
}