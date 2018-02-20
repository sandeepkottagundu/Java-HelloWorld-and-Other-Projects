
public class Pair {
	private double firstNum;
	private double secondNum;
	
	//constructor
	public Pair(double aFirst, double aSecond) {
		firstNum = aFirst;
		secondNum = aSecond;
	}
	
	public double getSum() {
		return firstNum + secondNum;
	}
	
	public double getDifference() {
		return secondNum - firstNum;
	}
	
	public double getProduct() {
		return firstNum * secondNum;
	}
	
	public double getAvg() {
		return this.getSum()/2;
	}
	
	public double getDistance() {
		return Math.abs(this.getDifference());
	}
	
	public double getMax() {
		return Math.max(firstNum, secondNum);
	}
	
	public double getMin() {
		return Math.min(firstNum, secondNum);
	}
}
