package airplaneSeating;

public class AirplaneSeatAssigner {

	public static void main(String[] args) {
		Airplane a = new Airplane();
		a.assignSeat("First Class", 0, 1);
		a.assignSeat("First Class", 0, 0);
		a.assignSeat("First Class", 1, 2);
		a.assignSeat("First Class", 4, 3);
		a.assignSeat("Economy", 0, 1);
		a.assignSeat("Economy", 0, 0);
		a.assignSeat("Economy", 1, 2);
		a.assignSeat("Economy", 4, 3);
		
		System.out.println(a.bookAvailableSeats("First Class", "Window", 2));
		System.out.println(a.bookAvailableSeats("First Class", "Window", 1));
		System.out.println(a.bookAvailableSeats("First Class", "Aisle", 2));
		System.out.println(a.bookAvailableSeats("First Class", "Aisle", 1));
		System.out.println(a.bookAvailableSeats("Economy", "Window", 2));
		System.out.println(a.bookAvailableSeats("Economy", "Window", 1));
		System.out.println(a.bookAvailableSeats("Economy", "Window", 3));
		System.out.println(a.bookAvailableSeats("Economy", "Aisle", 1));
		System.out.println(a.bookAvailableSeats("Economy", "Aisle", 2));
		System.out.println(a.bookAvailableSeats("Economy", "Aisle", 3));
		System.out.println(a.bookAvailableSeats("Economy", "Center", 3));
    	System.out.println(a.bookAvailableSeats("Economy", "Center", 2));
		System.out.println(a.bookAvailableSeats("Economy", "Center", 1));
		System.out.println(a.seatingPlan());
	}

}
