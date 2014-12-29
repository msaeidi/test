package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayLists {

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(new Integer[]{1,5,2,7,4,4});
		System.out.println(intList);
		//System.out.println(Arrays.asList(new Integer[]{1,5,2,7,4}));
		
		Integer[] in = {1,5,2,7,4, 4};
	    System.out.println(Arrays.asList(in));
	    
	    
		List<String> strList = Arrays.asList(new String[]{"Equity Derivatives", "Eqity Index Arbitrage" , "Mutual Fund" , "Mutual Fund"});
		System.out.println(strList);
		//System.out.println(Arrays.asList(new String[]{"Equity Derivatives", "Eqity Index Arbitrage" , "Mutual Fund"}));


//		List<String> strList = new ArrayList<String>(10);
//		Collections.addAll(strList, "Equity Derivatives", "Eqity Index Arbitrage" , "Mutual Fund");
//		System.out.println(strList);

//		String[] strArray = {"equity", "stocks", "gold", "foriegn exchange", "fixed income", "futures", "options"}; 
//	    Collections.adaddAll(strList, strArray);
//	    System.out.println(strList);
	    
	    String [] anArray = new String[strList.size()];
	    strList.toArray(anArray);
	    System.out.println(Arrays.asList(anArray));

	    strList = Collections.unmodifiableList(strList);
	    //list is sequenced having possibly duplicates
	    //set elements are unique
	    //list to set
	    Set<String> aSet = new HashSet<String>(strList);
	    System.out.println("set :" + aSet);
	    aSet = Collections.unmodifiableSet(aSet);
	    
	    //set to list
	    List<String> aList = new ArrayList<String>(aSet);
	    System.out.println("list: " + aList);

	    
	    
		// initial a Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Jan");
		map.put("2", "Feb");
		map.put("3", "Mar");
		map.put("4", "Apr");
		map.put("5", "May");
		map.put("6", "Jun");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}

		for (Object key : map.keySet()) {
			System.out.println("Key : " + key.toString() + " Value : " + map.get(key));
		}

		// Map -> Set -> Iterator -> Map.Entry -> troublesome
		Iterator<?> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			System.out.println("The key is: " + mapEntry.getKey()
				+ ",value is :" + mapEntry.getValue());
		}
		Date today = new Date();
		
		long[] time = timeBetweenTowDates(new Date(), today);
		
	 /*
	  * 

Ordered lists of element (unique or not)
Conform to Java's interface named List
Can be accessed by index

    LinkedList
    ArrayList

Lists of unique elements:
Conform to Java's interface named Set
Can not be accessed by index

    HashSet (unordered)
    LinkedHashSet (ordered)
    TreeSet (sorted by natural order or by provided comparator)

Both interfaces Set and List conform to Java's interface named Collection



======================
	
List:

Lists generally allow duplicate objects. Lists must be ordered, and are therefore accessible by index.

Implementation classes include: ArrayList, LinkedList, Vector
Set:

Sets do not allow duplicate objects. Most implementations are unordered, but it is implementation specific.

Implementation classes include: HashSet (unordered), LinkedHashSet (ordered), TreeSet (ordered by natural order or by provided comparator)

	  */
	}
	public static long[] timeBetweenTowDates(Date fromDate, Date toDate) {
	    long[] dif = new long[4];
	    long difTime = toDate.getTime() - fromDate.getTime();
	    long miliSeconds = toDate.getTime() - fromDate.getTime();
	    miliSeconds = 10000000;
	    long seconds = miliSeconds /1000;
	    long minutes = seconds /60;
	    long hours = minutes / 60;
	    long days = hours /24;
	    dif[0] = days;
	    dif[1] = hours - days * 24;
	    dif[2] = minutes - hours * 60;
	    dif[3] = seconds - minutes * 60;

	    return dif;
	    
	}
    public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
