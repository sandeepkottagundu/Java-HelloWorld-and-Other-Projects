package robotMaze;

public class MazeRunner {
	
	public static void main(String[] args) {
		String mazePlan = "* *******\n" + 
			   		  	  "*     * *\n" + 
				          "* ***** *\n" +
					      "* * *   *\n" +
				          "* * *** *\n" +
					      "*   *   *\n" +
				          "*** * * *\n" +
					      "*     *  \n" +
				          "******* *\n";
		Maze m = new Maze(mazePlan); 
		System.out.println("Maze to complete:\n" + m.toString());
		
		Robot randoBot = new RandomRobot(m);
		Robot rightHandBot = new RightHandRuleRobot(m);
		Robot memBot = new MemoryRobot(m);
		
		while(!randoBot.hasEscaped(m)){
			randoBot.move(m);
		}
		while(!rightHandBot.hasEscaped(m)){
			rightHandBot.move(m);
		}
		while(!memBot.hasEscaped(m)){
			memBot.move(m);
		}
		int randomRobotMovesMade = randoBot.getMovesMade();
		int rightHandRobotMovesMade = rightHandBot.getMovesMade();
		int memoryRobotMovesMade = memBot.getMovesMade();
		
		// print results of all robots
		System.out.println("The random robot finished the maze in " + randomRobotMovesMade + " moves.");
		System.out.println("The right hand rule robot finished the maze in " + rightHandRobotMovesMade + " moves.");
		System.out.println("The memory robot finished the maze in " + memoryRobotMovesMade + " moves.");
		
		// indicate which robot had the best strategy
		int minMovesTaken = Math.min(memoryRobotMovesMade, Math.min(randomRobotMovesMade, rightHandRobotMovesMade));
		System.out.println("\n");
		if(minMovesTaken == memoryRobotMovesMade){
			System.out.println("The memory robot had the best strategy.");
		}
		else if(minMovesTaken == rightHandRobotMovesMade){
			System.out.println("The right hand rule robot had the best strategy.");
		}
		else{
			System.out.println("The random robot had the best strategy.");
		}

	}

}
