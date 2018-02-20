package appointmentCalendar;

import java.util.ArrayList;

public class AppointmentCalendar {
	ArrayList<Appointment> appts = new ArrayList<Appointment>();
	
	public AppointmentCalendar(){
		
	}
	
	public void addAppt(Appointment a){
		appts.add(a);
	}
	
	public void cancelAppt(Appointment a){
		appts.remove(a);
	}
	
	public String printAppts(String date){
		String apptsOnDate = "Appointments for " + date + ":";
		for(Appointment a : appts){
			if(a.getDate() == date){
				apptsOnDate += "\n" + a.toString();
			}
		}
		return apptsOnDate;
	}
}
