package YP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumSearch {

	public static void main(String[] args) {
		int[] nums = {4,5,2,10,8};
		int sum = 12;
		//only one
		int first = -1;
		boolean found=false;
		for (int n=0; n < nums.length; n++) {
			first = nums[n];
			for (int m=n; m < nums.length; m++) {
				if (first+nums[m]==sum) {
					found = true;
					break;
				}
			}
			if (found) break;
		}
		System.out.println("for sum=" + sum + " ,first: " +first);

		//only one but with map
		//sums is a mapping from sum to the first number, the second is just sum minus first
		Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
		for (int n=0; n < nums.length; n++) {
			for (int m=n; m < nums.length; m++) {
				int s = nums[n] + nums[m];
				if (!sums.containsKey(s)) {
					sums.put(s, nums[n]);
				}
			}
		}
		//{16=8, 18=10, 4=2, 20=10, 6=4, 7=5, 8=4, 9=4, 10=5, 12=4, 13=5, 14=4, 15=5}
		System.out.println("Map: for sum="+sum+" ,first: " + (sums.containsKey(sum) ? sums.get(sum) : "None"));

		sum=5;
		System.out.println("Map: for sum="+sum+" ,first: " + (sums.containsKey(sum) ? sums.get(sum) : "None"));
		
		//many as a set with map
		Map<Integer, Set<Integer>> sumMap = new HashMap<Integer, Set<Integer>>();
		for (int n=0; n < nums.length; n++) {
			first = nums[n];
			for (int m=n; m < nums.length; m++) {
				int s = first + nums[m];
				if (!sumMap.containsKey(s)) {
					sumMap.put(s, new HashSet<Integer>());
				}
				sumMap.get(s).add(first);
			}
		}

		//{16=[8], 18=[10], 4=[2], 20=[10], 6=[4], 7=[5], 8=[4], 9=[4], 10=[2, 5], 12=[2, 4], 13=[5], 14=[4], 15=[5]}
		System.out.println("Set: for sum="+sum+" ,firsts: " + (sumMap.containsKey(sum) ? sumMap.get(sum) : "[]"));

		sum=12;
		System.out.println("Set: for sum="+sum+" ,firsts: " + (sumMap.containsKey(sum) ? sumMap.get(sum) : "[]"));
	}
}
