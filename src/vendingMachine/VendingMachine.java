package vendingMachine;

public class VendingMachine {
	private int capacity;
	private Product[] items;
	private boolean[] emptySlot;
	
	public VendingMachine(int numProducts){
		this.capacity = numProducts;
		this.items = new Product[this.capacity];
		this.emptySlot = new boolean[this.capacity];
	}
	
	public void restock(Product p){
		for(int i = 0; i < this.emptySlot.length; i ++){
			if(this.emptySlot[i]){
				this.emptySlot[i] = true;
				this.items[i] = p;
			}
		}
	}
	
	public void sell(int slotNumber){
		this.items[slotNumber] = null;
		this.emptySlot[slotNumber] = true;
	}
	
	public boolean canSell(Product p, User u){
		return p.getCost() <= u.getAmountPaid();
	}
	
}
