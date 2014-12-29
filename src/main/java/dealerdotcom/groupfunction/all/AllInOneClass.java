package dealerdotcom.groupfunction.all;

import java.util.Arrays;

public class AllInOneClass {

	public static void main(String[] args){

		Function median = new Median();

		int[] iArray = {15, 10, 56, 12, 8, 13};
		System.out.println("Median: " + median.getValue(iArray));

		double[] dArrays = {15., 10., 56., 12., 8., 13.};
		System.out.println("Median: " + median.getValue(dArrays));
	}
}

interface Function {
	public Double getValue(int[] values);
	public Double getValue(double[] values);
}


class Median implements Function{
	@Override
	public Double getValue(int[] values) {
		if (values==null||values.length==0) {
			return null;
		}
		Arrays.sort(values);
		double median;
		int len = values.length;
		if (len % 2 ==0 ) {
			median = (values[len/2] + values[len/2-1])/2;
		} else {
			median = values[len/2];
		}
		return median;
	}
	@Override
	public Double getValue(double[] values) {
		if (values==null||values.length==0) {
			return null;
		}
		Arrays.sort(values);
		double median;
		int len = values.length;
		if (len % 2 ==0 ) {
			median = (values[len/2] + values[len/2-1])/2;
		} else {
			median = values[len/2];
		}
		return median;
	}
}
