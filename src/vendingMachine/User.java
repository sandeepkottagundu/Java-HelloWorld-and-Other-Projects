package vendingMachine;

public class User {
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;
	private double wallet;
	
	public User(int startingPennies, int startingNickels, int startingDimes, int startingQuarters){
		this.pennies = startingPennies;
		this.nickels = startingNickels;
		this.dimes = startingDimes;
		this.quarters = startingQuarters;
		this.wallet = this.pennies * Coin.PENNY.getValue() + this.nickels * Coin.NICKEL.getValue() +
				this.dimes * Coin.DIME.getValue() + this.quarters * Coin.QUARTER.getValue();
	}
	
	public void insertCoin(Coin c){
		if(c.getValue() == 0.01){
			this.pennies--;
		}
		else if(c.getValue() == 0.05){
			this.nickels--;
		}
		else if(c.getValue() == 0.1){
			this.dimes--;
		}
		else{
			this.quarters--;
		}
	}
	
	public double getAmountPaid(){
		double pre = this.wallet;
		double post = this.pennies * Coin.PENNY.getValue() + this.nickels * Coin.NICKEL.getValue() +
				this.dimes * Coin.DIME.getValue() + this.quarters * Coin.QUARTER.getValue();
		double paid = pre - post;
		this.wallet = post;
		return paid;
	}
	
	public void ejectChange(){
		double returnAmount = this.wallet - (this.pennies * Coin.PENNY.getValue() + this.nickels * Coin.NICKEL.getValue() +
				this.dimes * Coin.DIME.getValue() + this.quarters * Coin.QUARTER.getValue());
		if(returnAmount/Coin.QUARTER.getValue() > 1){
			this.quarters += Math.floor(returnAmount/Coin.QUARTER.getValue());
			returnAmount -= Math.floor(returnAmount/Coin.QUARTER.getValue()) * Coin.QUARTER.getValue();
		}
		if(returnAmount/Coin.DIME.getValue() > 1){
			this.dimes += Math.floor(returnAmount/Coin.DIME.getValue());
			returnAmount -= Math.floor(returnAmount/Coin.DIME.getValue()) * Coin.DIME.getValue();
		}
		if(returnAmount/Coin.NICKEL.getValue() > 1){
			this.nickels += Math.floor(returnAmount/Coin.NICKEL.getValue());
			returnAmount -= Math.floor(returnAmount/Coin.NICKEL.getValue()) * Coin.NICKEL.getValue();
		}
		if(returnAmount > 0){
			this.pennies += returnAmount;
			returnAmount = 0;
		}
	}
}
