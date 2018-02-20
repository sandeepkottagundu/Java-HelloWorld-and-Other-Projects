package appointmentCalendar;


public class Appointment {
	String apptDate;
	String startTime;
	String endTime;
	String description;
	
	public Appointment(String date, String start, String end, String name){
		this.apptDate = date;
		this.startTime = start;
		this.endTime = end;
		this.description = name;
	}
	
	public String getDate(){
		return this.apptDate;
	}
	
	public String toString(){
		return this.description + " " + this.apptDate + " " + this.startTime + " " + this.endTime;
	}
}
