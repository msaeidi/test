package dealerdotcom.groupfunction;

import java.util.Arrays;
import java.util.List;

public class GroupFunction {
	public static void main(String[] args){
		//average,max,mode,sum
		//Mode: Most frequent value in a data set

		//Function avg = new Average();
		//median, range, percentage (calculated using nearest ordinal rank)
		//http://en.wikipedia.org/wiki/Percentile
		//If n is odd then Median (M) = value of ((n + 1)/2)th item term.
		//If n is even then Median (M) = value of [((n)/2)th item term + ((n)/2 + 1)th item term ]/2
		//range: highest-lowest
		//Arrays.sort(array);
		//Arrays.toString(array);
		Function median = new Median();

//		int[] values = {15, 10, 56, 12, 8};
//		System.out.println("Average: " + avg.getFunctionValue(values));
//		System.out.println("Median: " + median.getFunctionValue(values));
//		System.out.println(Arrays.toString(values));

		int[] vals = {15, 10, 56, 12, 8, 13};
//		System.out.println("Average: " + avg.getFunctionValue(vals));
		System.out.println("Median: " + median.getFunctionValue(vals));
//		List<int> object = Arrays.asList(vals);
//		System.out.println("Median: " + median.getFunctionValue(Arrays.asList(vals)));
		double[] values = {15., 10., 56., 12., 8., 13.};
//		System.out.println("Average: " + avg.getFunctionValue(vals));
		System.out.println("Median: " + median.getFunctionValue(values));

		int[] nums = {15, 10};
//		System.out.println("Average: " + avg.getFunctionValue(nums));
		System.out.println("Median: " + median.getFunctionValue(nums));

		int[] num = {15};
//		System.out.println("Average: " + avg.getFunctionValue(num));
		System.out.println("Median: " + median.getFunctionValue(num));
	}
}
