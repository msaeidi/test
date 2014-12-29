package Frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OddMultiplicity {

	public static void main(String[] args) {
		Integer[] nums = {31,29,31,30,31,30,31,31,30,31,30,31};
		System.out.println(getOddMultiBySort(nums));		
		System.out.println(getOddMultiByMap(nums));		

	}
	
	//Using sort: O(n*log(n))
	private static Integer getOddMultiBySort(Integer[] nums) {
		Arrays.sort(nums); 
		//System.out.println(Arrays.asList(nums));
		int count = 0;
		Integer current = null;
		for (Integer num: nums) {
			if (num == current) {
				count++;
			} else {
				if (count % 2 == 1) {
					break;
				}
				current = num;
				count = 1;
			}
		}
		return current;
	}
	
	//Using new data structure Map: O(n)
	private static Integer getOddMultiByMap(Integer[] nums) {
		//exception handling
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		int count;
		for (Integer num: nums) {
			if (counts.containsKey(num)) {
				count = counts.get(num);
			} else {
				count = 0;
			}
			counts.put(num, count + 1);
		}
		Integer current = null;
		for (Integer key : counts.keySet()) {
			if (counts.get(key) % 2 == 1) {
				current = key;
				break;
			}
		}
		return current;
	}
	

}
