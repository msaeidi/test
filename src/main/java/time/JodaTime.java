package time;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.Weeks;
import org.joda.time.Years;

public class JodaTime {

	public static void main(String[] args) {

		String dateStart = "01/14/2012 09:29:58";
//		String dateStop = "01/14/2012 09:30:48";
		String dateStop = "01/15/2013 10:31:48";
//String dateStart = "01/01/2000 05:30";
//String dateStop = "02/02/2001 06:31";

SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//http://stackoverflow.com/questions/15967646/java-joda-api-not-working
Date d1 = null;
Date d2 = null;

try {
    d1 = format.parse(dateStart);
    d2 = format.parse(dateStop);

    DateTime dt1 = new DateTime(d1);
    DateTime dt2 = new DateTime(d2);

    System.out.println(Years.yearsBetween(dt1, dt2).getYears() + " years, ");
    System.out.println(Months.monthsBetween(dt1, dt2).getMonths() % 52 + " months, ");
    System.out.println(Weeks.weeksBetween(dt1, dt2).getWeeks() % 4 + " weeks, ");
    System.out.println(Days.daysBetween(dt1, dt2).getDays() % 7 + " days, ");
    System.out.println(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
    System.out.println(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");

    Period period = new Period(dt1, dt2);
    //Period period = new Period(dt.getTime(), d2.getTime());
    System.out.println(period.getYears() + " years, ");
    System.out.println(period.getMonths() + " months, ");


 } catch (Exception e) {
    e.printStackTrace();
 }

}

}