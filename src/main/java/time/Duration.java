package time;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DurationFormatUtils;

//DurationFormatUtils
//try{}: SimpleDateFormat.parse("...") Date
//Date.getTime() long milliseconds
public class Duration {

	public static void main(String[] args) {
		String dateStart = "01/14/2012 09:29:58";
//		String dateStop = "01/14/2012 09:30:48";
		String dateStop = "01/15/2013 10:31:48";
 
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 
		Date d1 = null;
		Date d2 = null;
		long diff = 0;
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
		} catch (Exception e) {
			e.printStackTrace();
		}

			//in milliseconds
			diff = d2.getTime() - d1.getTime();
		System.out.println(DurationFormatUtils.formatPeriod(
                d2.getTime(), d1.getTime(), "d 'days' H 'hours' M 'minutes' S 'seconds left'"));		
	}

}
