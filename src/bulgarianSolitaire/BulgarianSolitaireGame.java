package bulgarianSolitaire;

import java.util.ArrayList;

public class BulgarianSolitaireGame {
	private static final int DECK_SIZE = 45;
	private ArrayList<Integer> pileSizes;
	
	public BulgarianSolitaireGame(){
		// generate number of piles
		int numPiles = (int) (Math.random() * (BulgarianSolitaireGame.DECK_SIZE - 1) + 1);
		this.pileSizes = new ArrayList<Integer>(numPiles);
		
		// fill piles with cards
		int cardsLeft = BulgarianSolitaireGame.DECK_SIZE;
		int pilesLeft = numPiles;
		
		for(int i = 0; i <= numPiles - 1; i++){
			// add cards to piles
			if(i == numPiles - 1){
				//remaining cards go to last pile
				this.pileSizes.add(cardsLeft);
			}
			else{
				this.pileSizes.add((int) (Math.random() * (cardsLeft - pilesLeft) + 1));
				pilesLeft --;
				cardsLeft -= this.pileSizes.get(i);
			}
		}
	}
	
	public void makeMove(){
		int newPileSize = 0;
		for(int i = 0; i <= this.pileSizes.size() - 1; i ++){
			// take 1 card from each pile and add to a new pile
			newPileSize += 1;
			this.pileSizes.set(i, this.pileSizes.get(i) - 1);
			if(this.pileSizes.get(i) == 0){
				// remove the pile if no cards are left in it and move index back one
				this.pileSizes.remove(i);
				i--;
			}
		}
		this.pileSizes.add(newPileSize);
	}
	
	public boolean isOver(){
		boolean isOver = false;
		int[] requiredSizes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		if(this.pileSizes.size() == requiredSizes.length){
			// only check if over with 9 piles since 1-9 will form 9 piles
			boolean doneChecking = false;
			while(!doneChecking){
				for(int j = 0; j <= requiredSizes.length - 1; j++){
					boolean foundMatch = false;
					for(int i = 0; i <= this.pileSizes.size() - 1; i++){
						if(this.pileSizes.get(i) == requiredSizes[j]){
							if(j == requiredSizes.length - 1){
								// means match was found for all sizes
								isOver = true;
								doneChecking = true;
							}
							foundMatch = true;
							break;
						}
					}
					if(!foundMatch){
						// if no match was found for one of the necessary pile sizes, break bc game is not over
						doneChecking = true;
						break;
					}
				}
			}
		}
		return(isOver);
	}
	
	public String printPiles(){
		return(this.pileSizes.toString());
	}
}
