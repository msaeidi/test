package EPTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class TwoListsTest {
	//find members in the first list than does not exist in second list
	public static void main(String[] args) {
		
	    List<Integer> list1 = Arrays.asList(new Integer[] { 999995, 999996, 999997, 999998, 999999, 1000000});
	    List<Integer> list2 = new ArrayList<Integer>();
	    for (int i=0; i < 1000000 - 4; i++) {
	    	list2.add(i);
	    }
	    
	    //a: using Apache ColectionUtils
	    long t1 = System.currentTimeMillis();
	    Collection<?> list1MinusList2 = CollectionUtils.subtract(list1, list2);
	    t1 = System.currentTimeMillis() - t1;
	    System.out.println(list1MinusList2);

	    //b: using no library
	    long t2 = System.currentTimeMillis();
		List<Integer> result = list1MinusList2ForLargeList2(list1, list2);
	    t2 = System.currentTimeMillis() - t2;
		System.out.println(result);

		//fastest
		long t3 = System.currentTimeMillis();
		result = list1MinusList2ForLargeList1(list1, list2);
	    t3 = System.currentTimeMillis() - t3;
		System.out.println(result);
		
		System.out.println(t1); //slowest 78 millisecond
		System.out.println(t2); //medium 62 millisecond
		System.out.println(t3); //fastest: 16 millisecond
		
	}

	//remove technique:
	public static List<Integer> list1MinusList2ForLargeList2(List<Integer> list1, List<Integer> list2) {
		List<Integer> result = new ArrayList<Integer>(list1);
		for (Integer i : list2) {
			if (result.contains(i)) {
				result.remove(i);
			}
		}
		return result;
	}
	
	public static List<Integer> list1MinusList2ForLargeList1(List<Integer> list1, List<Integer> list2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Integer i : list1){
			if (!(list2.contains(i))){
				result.add(i);
			}
		}
		return result;
	 }
}
