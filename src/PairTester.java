import javax.swing.JOptionPane;


public class PairTester {

	public static void main(String[] args) {
		//collect numbers
		String input = JOptionPane.showInputDialog("Enter you first number");
		double firstNumber = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Enter you second number");
		double secondNumber = Double.parseDouble(input);
		
		//show choices
		Pair p = new Pair(firstNumber, secondNumber);
		System.out.println("You have selected " + firstNumber + " and " + secondNumber);
		
		//print stats
		System.out.println("The sum is " + p.getSum());
		System.out.println("The difference is " + p.getDifference());
		System.out.println("The product is " + p.getProduct());
		System.out.println("The average is " + p.getAvg());
		System.out.println("The distance is " + p.getDistance());
		System.out.println("The max is " + p.getMax());
		System.out.println("The min is " + p.getMin());
	}

}
