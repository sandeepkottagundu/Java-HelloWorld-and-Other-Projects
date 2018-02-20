package vendingMachine;

public enum Coin {
	PENNY(0.01), NICKEL(0.05), DIME(0.1), QUARTER(0.25);
	private final double VALUE;
	private Coin(double value){
		this.VALUE = value;
	}
	
	public double getValue(){
		return this.VALUE;
	}
}
