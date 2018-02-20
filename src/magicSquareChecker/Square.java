package magicSquareChecker;

public class Square {
	private final int[] numbers;
	
	public Square(String s){
		String nums[] = s.split(" ");
		this.numbers = new int[nums.length];
		for(int i = 0; i < this.numbers.length; i ++){
			this.numbers[i] = Integer.parseInt(nums[i]);
		}
	}
	
	// check if all numbers were provided
	public boolean isMagic(){
		boolean isMagicSquare = false;
		int nSquared = this.numbers.length;
		if(Math.pow((int) Math.sqrt(nSquared), 2) == nSquared){
			// number is a square
			int[] requiredNumbers = new int[nSquared];
			for(int i = 0; i < nSquared; i++){
				requiredNumbers[i] = i + 1;
			}
			// check that each number from 1 to nsquared is in the numbers provided
			boolean doneChecking = false;
			boolean hasAllNumbers = false;
			while(!doneChecking){
				for(int j = 0; j < requiredNumbers.length; j++){
					boolean foundMatch = false;
					for(int i = 0; i < this.numbers.length; i++){
						if(this.numbers[i] == requiredNumbers[j]){
							if(j == requiredNumbers.length - 1){
								hasAllNumbers = true;
							}
							foundMatch = true;
							break;
						}
					}
					if(hasAllNumbers){
						doneChecking = true;
						break;
					}
					if(!foundMatch){
						doneChecking = true;
						break;
					}
				}
			}
			if(hasAllNumbers){
				// make square
				int rows = (int) Math.sqrt(nSquared);
				int columns = (int) Math.sqrt(nSquared);
				int[][] square = new int[rows][columns];
				int count = 0;
				for(int i = 0; i <= rows - 1; i ++){
					for(int j = 0; j <= columns - 1; j++){
						square[i][j] = this.numbers[count];
						count ++;
					}
				}
				
				// check sums
				int[] rowSums = new int[rows];
				int[] columnSums = new int[columns];
				int[] diagonalSums = new int[2];
				for(int i = 0; i <= rows - 1; i++){
					for(int j = 0; j <= columns - 1; j++){
						rowSums[i] += square[i][j];
					}
				}
				for(int j = 0; j <= columns - 1; j++){
					for(int i = 0; i <= rows - 1; i++){
						columnSums[j] += square[i][j];
					}
				}
				// right to left diagonal
				int index = 0;
				for(int j = columns - 1; j >= 0; j--){
					diagonalSums[0] += square[index][j];
					index++;
				}
				// left to right diagonal (both indices are the same in this direction)
				for(int i = rows - 1; i >= 0; i--){
					diagonalSums[1] += square[i][i];
				}
				
				
				// if both diagonals aren't equal stop checking
				boolean allSumsMatch = diagonalSums[0] == diagonalSums[1];
				if(allSumsMatch){
					int target = diagonalSums[0];
					boolean done = false;
					while(!done){
						for(int i = 0; i <= rowSums.length - 1; i++){
							if(rowSums[i] != target){
								done = true;
								allSumsMatch = false;
								break;
							}
						}
						if(!done){
							for(int i = 0; i <= columnSums.length - 1; i++){
								if(columnSums[i] != target){
									done = true;
									allSumsMatch = false;
									break;
								}
							}
						}
						if(allSumsMatch){
							done = true;
							isMagicSquare = true;
						}
					}
					
				}
				
				
				
			}
			
		}
		
		return isMagicSquare;
	}
}
