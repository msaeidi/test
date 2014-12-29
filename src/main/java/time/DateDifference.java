package time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDifference {

	public static void main(String[] args) {
		 
		String dateStart = "01/14/2012 09:29:58";
		String dateStop = "01/14/2012 09:30:48";
//		String dateStop = "01/15/2013 10:31:48";
 
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 
		Date d1 = null;
		Date d2 = null;
		long diff = 0;
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
 
			//in milliseconds
			diff = d2.getTime() - d1.getTime();
 
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
 
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			
			int[] cycles = {1000, 60, 60, 24};
			int[] difference = new int[4];
			long totalSeconds = (d2.getTime() - d1.getTime()) / 1000;

			int miliSec = cycles[0];
			for (int c = 1; c < 4; c++) {
				difference[c] = (int) totalSeconds / miliSec % cycles[c];
				miliSec = miliSec * cycles[c];
				c++;
			}

 
		} catch (Exception e) {
			e.printStackTrace();
		}
		long secondMiliSec = 1000;
		long minuteMiliSec = 60 * secondMiliSec;
		long hourMiliSec = 60 * minuteMiliSec;
		long daysMiliSec = 24 * hourMiliSec;

		long diffSeconds = diff / secondMiliSec % 60;
		long diffMinutes = diff / minuteMiliSec % 60;
		long diffHours = diff / hourMiliSec % 24;
		long diffDays = diff / daysMiliSec;

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " diffSeconds.");
		
 
	}
}
