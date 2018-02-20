package appointmentCalendar;

public class AppointmentCalendarTester {

	public static void main(String[] args) {
		AppointmentCalendar cal = new AppointmentCalendar();
		System.out.println(cal.printAppts("12/10/2016"));
		cal.addAppt(new Appointment("12/10/2016", "5:30", "7:30", "Java"));
		Appointment music = new Appointment("12/10/2016", "11:30", "12:30", "Music");
		cal.addAppt(music);
		System.out.println(cal.printAppts("12/10/2016"));
		cal.cancelAppt(music);
		System.out.println(cal.printAppts("12/10/2016"));
	}

}
