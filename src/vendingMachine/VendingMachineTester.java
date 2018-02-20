package vendingMachine;

public class VendingMachineTester {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine(2);
		Product coke = new Product("Coke", 1.25);
		Product nuts = new Product("Nuts", 0.75);
		vm.restock(coke);
		vm.restock(nuts);
		User u = new User(0, 0, 0, 5);
		u.insertCoin(Coin.QUARTER);
		u.insertCoin(Coin.QUARTER);
		u.insertCoin(Coin.QUARTER);
		u.insertCoin(Coin.QUARTER);
		u.insertCoin(Coin.QUARTER);
		if(vm.canSell(coke, u)){
			vm.sell(0);
			System.out.println("Here is your " + coke.getName() + "!");
		}
	}

}
