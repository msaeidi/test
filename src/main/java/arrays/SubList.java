package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubList {

	public static void main(String[] args) {
		// ... Add five integers to an ArrayList.
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		list.add(13);

		// ... Get sub list from 1 to 3.   
		//List.subList(fromIndex, toIndex)
		//List.subList(fromIndex, beforeIndex)
		List<Integer> sub = list.subList(1, 3); //list.get(1),list.get(2)

		// ... Display sub list.
		for (int value : sub) {
		    System.out.println(value);
		}
	    System.out.println();
		for (int value : list.subList(0, 3)) { //list.get(0),list.get(1),list.get(2)
		    System.out.println(value);
		}
	    System.out.println();
		// ... Set the first element in "sub" to -1.
		// This is reflected in the original ArrayList.
		sub.set(0, -1000);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	    System.out.println();

	    System.out.println("min "+Collections.min(list));
	    System.out.println("max "+Collections.max(list));
	    Collections.sort(list, new Comparator<Integer>() {
	    	@Override
	        public int compare(Integer a, Integer b) {
	            return a==b ? 0 : a>b ? 1 : -1;
	        }
	    });
	    
	    System.out.println("max "+Collections.min(list, new Comparator<Integer>() {
	        public int compare(Integer a, Integer b) {
	            return a==b ? 0 : a>b ? -1 : 1;
	        }
	    }));
	    
//        @Override
//        public int compare(Student o1, Student o2) {
//            int i = o1.name.compareTo(o2.name);
//            if (i == 0) {
//                i = o1.age - o2.age;
//            }
//            return i;
//        }
	}

}
