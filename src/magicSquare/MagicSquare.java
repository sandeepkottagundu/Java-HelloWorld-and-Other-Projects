package magicSquare;

public class MagicSquare {
	private int[][] square;
	private final int COLUMNS;
	private final int ROWS; 
	
	public MagicSquare(int n){
		this.COLUMNS = n;
		this.ROWS = n;
		this.square = new int[n][n];
		this.fillSquare(n);
	}
	
	private void fillSquare(int n){
		// fill bottom middle square with 1
		int r = this.ROWS - 1;
		int c = (this.COLUMNS - 1)/2;
		this.square[r][c] = 1;
		for(int num = 2; num <= n * n; num++){
			// move to right
			c += 1;
			if(c == this.COLUMNS){
				c = 0;
			}
			// move down
			r += 1;
			if(r == this.ROWS){
				r = 0;
			}
			if(square[r][c] == 0){
				// this is a empty spot
				square[r][c] = num;
			}
			else{
				// move to square directly above instead
				if(r == 0){
					r = this.ROWS;
				}
				if(c == 0){
					c = this.COLUMNS;
				}
				r -= 2;
				c -= 1;
				square[r][c] = num;
			}
			
		}
	}
	
	public String toString(){
		String representation = "";
		for(int i = 0; i <= this.ROWS - 1; i++){
			representation += "| ";
			for(int j = 0; j <= this.COLUMNS - 1; j++){
				if(this.square[i][j] < 10){
					representation += " " + this.square[i][j] + " ";
				}
				else{
					representation += this.square[i][j] + " ";
				}
			}
			representation += "|\n";
		}
		return(representation);
	}
}
