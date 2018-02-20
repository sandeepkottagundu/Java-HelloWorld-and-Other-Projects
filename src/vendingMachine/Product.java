package vendingMachine;

public class Product {
	private String name;
	private double cost;
	
	public Product(String name, double cost){
		this.name = name;
		this.cost = cost;
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getCost(){
		return this.cost;
	}
}
