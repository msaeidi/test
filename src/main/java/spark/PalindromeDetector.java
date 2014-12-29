package spark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class PalindromeDetector {
	
	public static void main(String[] args) {
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		dateFormat.setLenient(false);

		Calendar calS = Calendar.getInstance();
		calS.set(0, 1, 1);
		Date startDate = calS.getTime();
		
		Calendar calE = Calendar.getInstance();
		calE.set(5000, 1, 1);
		Date endDate = calE.getTime();

		Set<Date> dates = getPalindromeDates(startDate, endDate);
		//for (Date date : dates) {
		//	System.out.println(dateFormat.format(date));
		//}
		System.out.println(dates.size());
		
		dates = getPalindromeDatesBetween(startDate, endDate);
		System.out.println(dates.size());
	}
	
	public static Set<Date> getPalindromeDates(Date start, Date end){
		
		/*Problem statement: Given a start and end date return a
		distinct set of
		Dates in chronological order(inclusive of start and end
		dates) that,
		when formated as MMddyyyy, are palindromes. A palindrome is
		a
		string that reads the same forwards and backwards, for
		example:
		Nov 2, 2011 (11022011). You may add additional methods to
		this class
		if you choose, however this method's signature should remain
		unmodified*/
		
		/* Solution 1:
		 * Check exceptions: start>end should return empty set
		 * Loop from start year to end year
		 * See if reverse of year is feasible mount and day in the year
		 * 
		 */
		
		Set<Date> dates = new LinkedHashSet<Date>();
		if (start==null || end==null || start.after(end)) {
			return dates;
		}

		int[] monthDays = {31,29,31,30,31,30,31,31,30,31,30,31};
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		dateFormat.setLenient(false);
		int startYear = yearOf(start);
		int endYear = yearOf(end);
		
		for (int year = startYear; year < endYear + 1; year++) {
			int[] y = new int[4];
			int q = 10000;
			int rest = year;
			for (int i = 0; i < 4; i++) {
				rest %= q;
				q /= 10;
				y[i] = rest / q;
			}

			int mm = 10*y[3] + y[2];
			int dd = 10*y[1] + y[0];
			if (mm > 12 || mm == 0 || dd > monthDays[mm-1] || dd == 0) {
				continue;
			}
			String dateString = "" + y[3] + y[2] + y[1] + y[0] + year;
			try {
				Date date = dateFormat.parse(dateString);
				if (date.before(start) || date.after(end)) {
					continue;
				}
				dates.add(date);
			} catch (ParseException e) {
			}  
		}
		return dates;
	}

	public static Set<Date> getPalindromeDatesBetween(Date start, Date end){
		
		Set<Date> dates = new LinkedHashSet<Date>();
		if (start==null || end==null || start.after(end)) {
			return dates;
		}

		int[] monthDays = {31,29,31,30,31,30,31,31,30,31,30,31};
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		dateFormat.setLenient(false);
		int startYear = yearOf(start);
		int endYear = yearOf(end);
		
		for (int mm = 1; mm < 13; mm++) {
			for (int dd = 1; dd < monthDays[mm-1] + 1; dd++) {
				String mmdd = (mm < 10 ? "0" : "") + mm + (dd < 10 ? "0" : "") + dd;
				String yyyy = (new StringBuffer(mmdd)).reverse().toString();
				int year = Integer.valueOf(yyyy);
				if (year < startYear || year > endYear) continue;
				try {
					Date date = dateFormat.parse(mmdd + yyyy);
					if (date.before(start) || date.after(end)) {
						continue;
					}
					dates.add(date);
				} catch (ParseException e) {
				}  
			}
		}
		return dates;
	}

	private static int yearOf(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
}
