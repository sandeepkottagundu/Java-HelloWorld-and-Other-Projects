import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FunWithDates {

	public static void main(String[] args) {
		// set calendar to today and calculate date and weekday 100 days from today
		GregorianCalendar cal = new GregorianCalendar(); //Today's date
		System.out.println("Today is " + cal.getTime().toString());
		cal.add(Calendar.DAY_OF_YEAR, 100); //100 days from Today
		Date printableDate = cal.getTime();
		System.out.println("In 100 days, it will be " + printableDate.toString());

		// weekday of my next birthday
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, 7);
		cal.set(Calendar.DAY_OF_MONTH, 5);
		// day 1 is Sunday and day 7 is Saturday
		System.out.println("My birthday next year will be on day " + cal.get(Calendar.DAY_OF_WEEK) + " of the week.");
		
		// date that is 10,000 days from my next birthday
		cal.add(Calendar.DAY_OF_YEAR, 10000);
		System.out.println("In 10,000 days from my next birthday, it will be " + cal.getTime());
	}

}
