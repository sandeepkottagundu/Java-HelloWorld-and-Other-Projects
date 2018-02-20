package robotMaze;

public class Maze {
	
	private char[] mazeMap;
	private String[][] mazeMap2D;
	private int rowsNeeded;
	private int columnsNeeded;
	
	public Maze(String mazePlan){
		mazeMap = mazePlan.toCharArray();
		
		// determine dimensions needed
		rowsNeeded = 0;
		columnsNeeded = 0;
		for(int i = 0; i < mazeMap.length; i++){
			if(mazeMap[i] == '\n'){
				rowsNeeded += 1;
			}
			else{
				if(rowsNeeded == 0){
					columnsNeeded += 1;
				}
			}
		}
		
		mazeMap2D = new String[rowsNeeded][columnsNeeded];
		
		// fill map
		int row = 0;
		int column = 0;
		for(int i = 0; i < mazeMap.length; i++){
			if(mazeMap[i] == '\n'){
				row += 1;
				column = 0;
			}
			else{
				mazeMap2D[row][column] = Character.toString(mazeMap[i]);
				column ++;
			}
		}
		
	}
	
	public String startingPoint(){
		String position = "None found"; 
		
		// labeled break (allows to break out of the labeled loop from the nested one)
		search:
		for(int i = 0; i < rowsNeeded; i++){
			for(int j = 0; j < columnsNeeded; j++){
				// ignore the center of the maze since that can't be an entrance
				if(i != 0 && i != rowsNeeded - 1 && j != 0 && j != columnsNeeded - 1){
					continue;
				}
				if(this.mazeMap2D[i][j].equals(" ")){
					position = i + "," + j;
					break search;
				}
			}
		}
		return position;
	}
	
	public String mazeExit(){
		String exit = "None found"; 
		
		// search for exit from bottom right corner since search for entrance starts at opposite corner
		search:
		for(int i = rowsNeeded - 1; i >= 0; i--){
			for(int j = columnsNeeded - 1; j >= 0; j--){
				// ignore the center of the maze since that can't be an exit
				if(i != 0 && i != rowsNeeded - 1 && j != 0 && j != columnsNeeded - 1){
					continue;
				}
				if(this.mazeMap2D[i][j].equals(" ") && !(i + "," + j).equals(this.startingPoint())){
					exit = i + "," + j;
					break search;
				}
			}
		}
		return exit;
	}
	
	public int getWidth(){
		return columnsNeeded;
	}
	
	public int getHeight(){
		return rowsNeeded;
	}
	
	public String toString() {
		String r = "";
		for(int i = 0; i < rowsNeeded; i++){
			for(int j = 0; j < columnsNeeded; j++){
				r = r + mazeMap2D[i][j];
			}
			r = r + "\n";
		}
		return(r);
	}
	
	public boolean isAvailableSpace(String position){
		// supply string in format "0,1"
		String[] indices = position.split(",");
		// available spaces have " "
		return this.mazeMap2D[Integer.parseInt(indices[0])][Integer.parseInt(indices[1])].equals(" ");
	}

}
