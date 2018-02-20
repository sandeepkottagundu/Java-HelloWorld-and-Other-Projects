
public class CombinationLock {
	private final String FIRST_LETTER;
	private final String SECOND_LETTER;
	private final String THIRD_LETTER;
	private boolean locked;
	private String firstGuess;
	private String secondGuess;
	private String thirdGuess;
	
	
	public enum DialNum {LOCKED, DIAL_ONE, DIAL_TWO, DIAL_THREE};
	DialNum dials;
	
	//constructor to get a locked lock
	public CombinationLock(String a, String b, String c) {
		FIRST_LETTER = a;
		SECOND_LETTER = b;
		THIRD_LETTER = c;
		locked = true;
		dials = DialNum.LOCKED;
		firstGuess = null;
		secondGuess = null;
		thirdGuess = null;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void dial(String a) {
		if(dials == DialNum.LOCKED) {
			firstGuess = a;
			dials = DialNum.DIAL_ONE;
		}
		else if(dials == DialNum.DIAL_ONE) {
			secondGuess = a;
			dials = DialNum.DIAL_TWO;
		}
		else if(dials == DialNum.DIAL_TWO) {
			thirdGuess = a;
			dials = DialNum.DIAL_THREE;
		}
		else{
			dials = DialNum.DIAL_THREE;
		}
	}
	
	public void unlock() {
		if(firstGuess.equals(FIRST_LETTER) && secondGuess.equals(SECOND_LETTER) && thirdGuess.equals(THIRD_LETTER)) {
			locked = false;
		}
	}
	
	public void lock() {
		firstGuess = null;
		secondGuess = null;
		thirdGuess = null;
		locked = true;
		dials = DialNum.LOCKED;
	}
}
