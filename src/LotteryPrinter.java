import java.util.Arrays;
import java.util.Random;

public class LotteryPrinter {

	public static void main(String[] args) {
		// pick 6 numbers to play lottery
		Random generator = new Random();
		int[] pick = new int[6];
		for(int i = 0; i < 6; i++){
			pick[i] = generator.nextInt(50) + 1;
		}
		System.out.println("Play " + Arrays.toString(pick) + " to win the lottery!");
	}
}
