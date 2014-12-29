package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraySum {

	public static void main(String[] args) {
		Integer[] array = {5,2,7,4,5,3,1,5,9,5,1};
	    List<Integer> aList = Arrays.asList(array);
	    System.out.println(aList);

	    for (int a: aList) {
	    	if (aList.contains(10-a)) {
	    	    System.out.println(a + ", " + (10-a));
	    	}
	    }
	    System.out.println();
	    Set<Integer> aSet = new HashSet<Integer>(aList);
	    System.out.println("aSet :" + aSet);
	    aSet = Collections.unmodifiableSet(aSet);
	    for (int a: aSet) {
	    	if (a>5) {
	    		break;
	    	}
	    	if (aSet.contains(10-a)) {
	    	    System.out.println(a + ", " + (10-a));
	    	}
	    }

	}

}
