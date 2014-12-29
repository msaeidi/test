package livenation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Dylan Campbell: LiveNation Screening 2

public class WeekDaysSort {

	public static void main(String[] args) {
		String[] aWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"}; 
		String[] week = aWeek.clone();
		List<String> weekdays = Arrays.asList(week);
		System.out.println(weekdays);  //[Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday]
	    
		//reversing list sequence
		Collections.reverse(weekdays);
		System.out.println(weekdays);  //[Sunday, Saturday, Friday, Thursday, Wednesday, Tuesday, Monday]
		System.out.println(Arrays.asList(week));  //[Sunday, Saturday, Friday, Thursday, Wednesday, Tuesday, Monday]
		
		week = aWeek.clone();
		List<String> days = Arrays.<String> asList(week);
		reverseOrder(days);
		System.out.println(days); //[Sunday, Saturday, Friday, Thursday, Wednesday, Tuesday, Monday]

		String[] reveresedWeek = reverseOfArray(week);
		System.out.println(Arrays.asList(week));  //[Sunday, Saturday, Friday, Thursday, Wednesday, Tuesday, Monday]
		System.out.println(Arrays.asList(reveresedWeek));  //[Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday]
		
		//alphabetic sort
		System.out.println("Sorting:");
	    Arrays.sort(week);
		System.out.println(Arrays.asList(week));  //[Friday, Monday, Saturday, Sunday, Thursday, Tuesday, Wednesday]

		Collections.sort(weekdays);
		System.out.println(weekdays);  //[Friday, Monday, Saturday, Sunday, Thursday, Tuesday, Wednesday]

		//alphabetic sort ascending
		Collections.sort(weekdays, Collections.reverseOrder());
		System.out.println(weekdays);  //[Wednesday, Tuesday, Thursday, Sunday, Saturday, Monday, Friday]
	}
	
	//Generic: Type Parameter (Placeholder)
	public static <T> void reverseOrder(List<T> list) {
		Collections.reverse(list);
	}
	
    //keep the original array
    public static <T> T[] reverseOfArray(T[] array) {
        T[] copy = array.clone();
        Collections.reverse(Arrays.asList(copy));
        return copy;
    }
/*    
    public static <type> type[] reverseOfArray(type[] array) {
        type[] copy = array.clone();
        Collections.reverse(Arrays.asList(copy));
        return copy;
    }
*/
}
