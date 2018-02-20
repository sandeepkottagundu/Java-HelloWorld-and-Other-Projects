package airplaneSeating;

public class Airplane {
	private boolean[][] economySeatOccupied;
	private boolean[][] firstClassSeatOccupied;
	
	public Airplane(){
		this.economySeatOccupied = new boolean[15][6];
		this.firstClassSeatOccupied = new boolean[5][4];
	}
	
	public String seatingPlan(){
		String firstClass = "Not available";
		for(boolean[] row : firstClassSeatOccupied){
			int count = 0;
			for(boolean seat : row){
				
				if(count == 2){
					firstClass += " ";
				}
				if(seat){
					firstClass += "X";
				}
				else{
					firstClass += "O";
				}
				count ++;
			}
			firstClass += "\n";
		}
		String economy = "";
		for(boolean[] row : economySeatOccupied){
			int count = 0;
			for(boolean seat : row){
				
				if(count == 3){
					economy += " ";
				}
				
				if(seat){
					economy += "X";
				}
				else{
					economy += "O";
				}
				count ++;
			}
			economy += "\n";
		}
		
		return "First class:\n" + firstClass + "\nEconomy:\n" + economy;
	}
	
	public void assignSeat(String cabin, int row, int seat){
		if(cabin.equals("First Class")){
			this.firstClassSeatOccupied[row][seat] = true;
		}
		else{
			this.economySeatOccupied[row][seat] = true;
		}
	}
	
	public String checkSeatLocation(String cabin, int row, int seat){
		String location = "";
		if(cabin.equals("First Class")){
			if(seat == 0 || seat == 3){
				location += "Window";
			}
			else{
				location += "Aisle";
			}
		}
		else{
			if(seat == 0 || seat == 5){
				location += "Window";
			}
			else if(seat == 2 || seat == 3){
				location += "Aisle";
			}
			else{
				location += "Center";
			}
		}
		return location;
	}
	
	public String bookAvailableSeats(String cabin, String preference, int partySize){
		String bookingStatus = "";
		if(cabin.equals("First Class")){
			if(preference.equals("Window")){
				if(partySize == 1){
					boolean booked = false;
					for(int i = 0; i < firstClassSeatOccupied.length; i++){
						for(int j = 0; j < firstClassSeatOccupied[i].length; j++){
							if(this.checkSeatLocation("First Class", i, j).equals("Window") 
									&& !this.firstClassSeatOccupied[i][j]){
								this.assignSeat("First Class", i, j);
								bookingStatus += "Success";
								booked = true;
								break;
							}
						}
						if(booked){
							break;
						}
					}
				}
				else{
					for(int i = 0; i < firstClassSeatOccupied.length; i++){
						if((!this.firstClassSeatOccupied[i][0] && !this.firstClassSeatOccupied[i][1])){
							this.assignSeat("First Class", i, 0);
							this.assignSeat("First Class", i, 1);
							break;
						}
						else if(!(this.firstClassSeatOccupied[i][2] && this.firstClassSeatOccupied[i][3])){
							this.assignSeat("First Class", i, 2);
							this.assignSeat("First Class", i, 3);
							break;
						}
					}
				}
				
			}
			else{
				if(partySize == 1){
					boolean booked = false;
					for(int i = 0; i < firstClassSeatOccupied.length; i++){
						for(int j = 0; j < firstClassSeatOccupied[i].length; j++){
							if(this.checkSeatLocation("First Class", i, j).equals("Aisle") 
									&& !this.firstClassSeatOccupied[i][j]){
								this.assignSeat("First Class", i, j);
								bookingStatus += "Success";
								booked = true;
								break;
							}
						}
						if(booked){
							break;
						}
					}
				}
				else{
					for(int i = 0; i < firstClassSeatOccupied.length; i++){
						if((!this.firstClassSeatOccupied[i][0] && !this.firstClassSeatOccupied[i][1])){
							this.assignSeat("First Class", i, 0);
							this.assignSeat("First Class", i, 1);
							break;
						}
						else if(!(this.firstClassSeatOccupied[i][2] && this.firstClassSeatOccupied[i][3])){
							this.assignSeat("First Class", i, 2);
							this.assignSeat("First Class", i, 3);
							break;
						}
					}
				}
			}
		}
		else{
			if(preference.equals("Window")){
				if(partySize == 1){
					boolean booked = false;
					for(int i = 0; i < economySeatOccupied.length; i++){
						for(int j = 0; j < economySeatOccupied[i].length; j++){
							if(this.checkSeatLocation("Economy", i, j).equals("Window") 
									&& !this.economySeatOccupied[i][j]){
								this.assignSeat("Economy", i, j);
								bookingStatus += "Success";
								booked = true;
								break;
							}
						}
						if(booked){
							break;
						}
					}
				}
				else if(partySize == 2){
					for(int i = 0; i < economySeatOccupied.length; i++){
						if((!this.economySeatOccupied[i][0] && !this.economySeatOccupied[i][1])){
							this.assignSeat("Economy", i, 0);
							this.assignSeat("Economy", i, 1);
							break;
						}
						else if(!(this.economySeatOccupied[i][4] && this.economySeatOccupied[i][5])){
							this.assignSeat("Economy", i, 4);
							this.assignSeat("Economy", i, 5);
							break;
						}
					}
				}
				else{
					for(int i = 0; i < economySeatOccupied.length; i++){
						if((!this.economySeatOccupied[i][0] && !this.economySeatOccupied[i][1]
								&& !this.economySeatOccupied[i][2])){
							this.assignSeat("Economy", i, 0);
							this.assignSeat("Economy", i, 1);
							this.assignSeat("Economy", i, 2);
							break;
						}
						else if((!this.economySeatOccupied[i][3] && !this.economySeatOccupied[i][4]
								&& !this.economySeatOccupied[i][5])){
							this.assignSeat("Economy", i, 3);
							this.assignSeat("Economy", i, 4);
							this.assignSeat("Economy", i, 5);
							break;
						}
					}
				}
			}
			else if(preference.equals("Aisle")){
				if(partySize == 1){
					boolean booked = false;
					for(int i = 0; i < economySeatOccupied.length; i++){
						for(int j = 0; j < economySeatOccupied[i].length; j++){
							if(this.checkSeatLocation("Economy", i, j).equals("Aisle") 
									&& !this.economySeatOccupied[i][j]){
								this.assignSeat("Economy", i, j);
								bookingStatus += "Success";
								booked = true;
								break;
							}
						}
						if(booked){
							break;
						}
					}
				}
				else if(partySize == 2){
					for(int i = 0; i < economySeatOccupied.length; i++){
						if((!this.economySeatOccupied[i][1] && !this.economySeatOccupied[i][2])){
							this.assignSeat("Economy", i, 1);
							this.assignSeat("Economy", i, 2);
							break;
						}
						else if((!this.economySeatOccupied[i][3] && !this.economySeatOccupied[i][4])){
							this.assignSeat("Economy", i, 3);
							this.assignSeat("Economy", i, 4);
							break;
						}
					}
				}
				else{
					for(int i = 0; i < economySeatOccupied.length; i++){
						if((!this.economySeatOccupied[i][0] && !this.economySeatOccupied[i][1]
								&& !this.economySeatOccupied[i][2])){
							this.assignSeat("Economy", i, 0);
							this.assignSeat("Economy", i, 1);
							this.assignSeat("Economy", i, 2);
							break;
						}
						else if((!this.economySeatOccupied[i][3] && !this.economySeatOccupied[i][4]
								&& !this.economySeatOccupied[i][5])){
							this.assignSeat("Economy", i, 3);
							this.assignSeat("Economy", i, 4);
							this.assignSeat("Economy", i, 5);
							break;
						}
					}
				}
			}
			else{
				if(partySize == 1){
					boolean booked = false;
					for(int i = 0; i < economySeatOccupied.length; i++){
						for(int j = 0; j < economySeatOccupied[i].length; j++){
							if(this.checkSeatLocation("Economy", i, j).equals("Center") 
									&& !this.economySeatOccupied[i][j]){
								this.assignSeat("Economy", i, j);
								bookingStatus += "Success";
								booked = true;
								break;
							}
						}
						if(booked){
							break;
						}
					}
				}
				else if(partySize == 2){
					for(int i = 0; i < economySeatOccupied.length; i++){
						if((!this.economySeatOccupied[i][0] && !this.economySeatOccupied[i][1])){
							this.assignSeat("Economy", i, 0);
							this.assignSeat("Economy", i, 1);
							break;
						}
						else if((!this.economySeatOccupied[i][1] && !this.economySeatOccupied[i][2])){
							this.assignSeat("Economy", i, 1);
							this.assignSeat("Economy", i, 2);
							break;
						}
						else if((!this.economySeatOccupied[i][3] && !this.economySeatOccupied[i][4])){
							this.assignSeat("Economy", i, 3);
							this.assignSeat("Economy", i, 4);
							break;
						}
						else if((!this.economySeatOccupied[i][4] && !this.economySeatOccupied[i][5])){
							this.assignSeat("Economy", i, 4);
							this.assignSeat("Economy", i, 5);
							break;
						}
					}
				}
				else{
					for(int i = 0; i < economySeatOccupied.length; i++){
						if((!this.economySeatOccupied[i][0] && !this.economySeatOccupied[i][1]
								&& !this.economySeatOccupied[i][2])){
							this.assignSeat("Economy", i, 0);
							this.assignSeat("Economy", i, 1);
							this.assignSeat("Economy", i, 2);
							break;
						}
						else if((!this.economySeatOccupied[i][3] && !this.economySeatOccupied[i][4]
								&& !this.economySeatOccupied[i][5])){
							this.assignSeat("Economy", i, 3);
							this.assignSeat("Economy", i, 4);
							this.assignSeat("Economy", i, 5);
							break;
						}
					}
				}
			}
		}
		return bookingStatus;
	}
}
