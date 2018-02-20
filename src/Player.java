import java.util.Scanner;



public class Player {
	public enum PlayerType {HUMAN, STUPID_COMPUTER, SMART_COMPUTER};
	PlayerType pType;
	
	public Player(){
		pType = PlayerType.HUMAN;
	}
	
	public Player(int randomNum){
		if(randomNum == 0){
			pType = PlayerType.STUPID_COMPUTER;
		}
		else{
			pType = PlayerType.SMART_COMPUTER;
		}
	}
	
	public int takeTurn(int pileSize){
		int take = 1;
		if(pType == PlayerType.HUMAN){
			Scanner input = new Scanner(System.in);
			boolean valid = false;
			while(!valid){
				System.out.println("How many marbles do you want to take?");
				take = input.nextInt();
				if(take <= pileSize/2 || take == 1){
					valid = true;
				}
			}
			//input.close();
		}
		else if(pType == PlayerType.STUPID_COMPUTER){
			take = Math.max((int) (Math.random() * (pileSize/2 - 1) + 1), 1);
		}
		else{// smart computer
			// if pile size is a power of 2 - 1 the use stupid computer strategy
			if((pileSize + 1 & (pileSize)) == 0){
				take = Math.max((int) (Math.random() * (pileSize/2 - 1) + 1), 1);
			}
			else{
				boolean legalMove = false;
				take = pileSize/2;
				while(!legalMove){
					if(take > 0 && ((take + 1 & (take)) == 0)){
						legalMove = true;
					}
					else{
						take --;
						if(take == 0){
							take = 1;
							legalMove = true;
						}
					}
				}
			}
		}
		return(take);
	}
}
