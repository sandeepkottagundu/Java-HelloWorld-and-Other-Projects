
public class Pile {
	private int numMarbles;
	
	public Pile(){
		numMarbles = (int) (Math.random() * 90 + 10);
	}
	
	public int getSize(){
		return(numMarbles);
	}
	
	public void removeMarbles(int n){
		numMarbles = numMarbles - n;
	}
}
