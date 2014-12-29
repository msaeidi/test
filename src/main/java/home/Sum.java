package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * The idea is to have like index on sum but in a lazy way HashMap<sum, list of first numbers>
 */
public class Sum {

    private static final int[] arrayOfNumbers = { 88, 109, 232, 154, 55, 13, 43, 67,  
        187, 139, 103, 106, 241, 163, 49, 157, 238, 199, 25, 247, 112, 97,  
        31, 10, 178, 181, 133, 193, 7, 91, 34, 52, 211, 130, 46, 175, 16,  
        148, 22, 100, 151, 82, 19, 64, 205, 235, 229, 4, 94, 214, 244, 61,  
        28, 223, 208, 58, 142, 190, 37, 217, 127, 85, 118, 166, 184, 124,  
        136, 76, 115, 79, 160, 145, 202, 172, 196, 73, 1, 70, 121, 40, 226,  
        169, 220 };  

    private static HashMap<Integer, List<Integer>> sumToFirstNum = new HashMap<Integer, List<Integer>>();
    
	public static void main(String[] args) {
		
		Arrays.sort(arrayOfNumbers);
		/*
		 * This algorithm is based on lazy load or gradual cashing of a mapping from sum to list of possible one side.
		 * Otherwise we need to populate all at once like what we are doing following loops:
//    	for (int i = 0; i < arrayOfNumbers.length; i++) {
//        	for (int j = i; j < arrayOfNumbers.length; j++) {
//        		int sum = arrayOfNumbers[i] + arrayOfNumbers[j];
//        		System.out.println(i +" , " + j + " : " + arrayOfNumbers[i] + " + " + arrayOfNumbers[j] + " = " + sum);
//        		populateMap(sum, arrayOfNumbers[i]);
//        	}
//    	}
		 */
		int sum = 437;
		feasibleSum(sum, 220);
		feasibleSum(sum, 190);
		feasibleSum(sum, 202);
		feasibleSum(sum, 211);
		feasibleSum(sum, 220);
		feasibleSum(sum, 217);
		feasibleSum(sum, 700);
/*		
		maintainSum(437, 220);
		maintainSum(437, 190);
		maintainSum(437, 202);
		maintainSum(437, 211);
		maintainSum(437, 220);
		maintainSum(437, 217);
		maintainSum(437, 700);
*/
		System.out.println("List of populated feasible num for sum=" + sum + ": " + sumToFirstNum.get(sum));//[190, 193, 196, 199, 202, 205, 208, 211, 214, 217]
		System.out.println(sumToFirstNum.get(963));
	}
	
	private static boolean feasibleSum(int sum, int num) {
		String msg = "";
		boolean mapContainsSum = sumToFirstNum.containsKey(sum);
		if (!mapContainsSum || !sumToFirstNum.get(sum).contains(num) && !sumToFirstNum.get(sum).contains(sum-num)) {
			int offset = Arrays.binarySearch(arrayOfNumbers, sum - num);
			if (offset >= 0) {
				if (!mapContainsSum) {
					List<Integer> firsts = new ArrayList<Integer>();
					sumToFirstNum.put(sum, firsts);
					msg = " list entry is created ";
				}
				sumToFirstNum.get(sum).add(num);
				msg = " is matching and is added to the map: " + msg;
			} else {
				System.out.println("Warning: " + sum + " is not feasible sum of " + num + " another array number!");
				return false;
			}
		} else {
			msg = " is already in the map and matching to the sum: ";
		}
		System.out.println(num + " + " + (sum-num) + msg + sum);
		return true;
	}
/*
	private static boolean maintainSum(int sum, int num) {
		boolean sumIsNotInMap = true;
		if (sumToFirstNum.containsKey(sum)) {
			if (sumToFirstNum.get(sum).contains(num)||sumToFirstNum.get(sum).contains(sum-num)) {
				System.out.println(num + " + " + (sum-num) + " is already in the map and matching: " + sum);
				return true;
			} else {
				sumIsNotInMap = false;
			}
		}
		int offset = Arrays.binarySearch(arrayOfNumbers, sum - num);
		if (offset >= 0) {
			if (sumIsNotInMap) {
				List<Integer> firsts = new ArrayList<Integer>();
				sumToFirstNum.put(sum, firsts);
			}
			sumToFirstNum.get(sum).add(num);
			System.out.println(num + " + " + (sum-num) + " is matching and is added to the map: " + sum);
			return true;
		} else {
			System.out.println("Warning: " + sum + " is not feasible sum of " + num + " another array number!");
			return false;
		}
	}

	private static boolean testSum(int sum, int num) {
		if (sumToFirstNum.containsKey(sum) && (sumToFirstNum.get(sum).contains(num)||sumToFirstNum.get(sum).contains(sum-num))) {
			System.out.println(num + " + " + (sum-num) + " is matching: " + sum);
			return true;
		} else {
			int offset = Arrays.binarySearch(arrayOfNumbers, sum - num);
			if (offset >= 0) {
				if (!sumToFirstNum.containsKey(sum)) {
					List<Integer> firsts = new ArrayList<Integer>();
					sumToFirstNum.put(sum, firsts);
				}
				sumToFirstNum.get(sum).add(num);
				System.out.println(num + " + " + (sum-num) + " is matching: " + sum);
				return true;
			} else {
				System.out.println("Warning: " + sum + " is not feasible sum of " + num + " another array number!");
				return false;
			}
		}
	}

	private static void populateMap(int sum, int num) {
		if (!sumToFirstNum.containsKey(sum)) {
			List<Integer> firsts = new ArrayList<Integer>();
			sumToFirstNum.put(sum, firsts);
		}
		sumToFirstNum.get(sum).add(num);
	}
*/
}
