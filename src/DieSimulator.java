import java.util.Random;

public class DieSimulator {

	public static void main(String[] args) {
		// rolls a 6-sided die
		Random die = new Random();
		int roll = die.nextInt(6) + 1;
		System.out.print(roll);
	}

}
