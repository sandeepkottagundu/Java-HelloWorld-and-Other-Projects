
public class FibonacciGenerator {
	private int fold1;
	private int fold2;
	
	public FibonacciGenerator(){
		fold1 = 1;
		fold2 = 0;
	}
	
	public int nextNumber(){
		int fnew = this.fold1 + this.fold2;
		this.fold2 = this.fold1;
		this.fold1 = fnew;
		return(fold2);
	}
}
