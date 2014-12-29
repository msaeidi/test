package dealerdotcom.groupfunction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Median implements Function{
	@Override
	public Double getFunctionValue(int[] values) {
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
	public Double getFunctionValue(double[] values) {
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
	public BigDecimal getFunctionValue(List<BigDecimal> values) {
		if (values==null||values.size()==0) {
			return null;
		}
		Collections.sort(values);
		BigDecimal median;
		int len = values.size();
		if (len % 2 ==0 ) {
			median = (values.get(len/2).add(values.get(len/2-1))).divide(new BigDecimal(2));
		} else {
			median = values.get(len/2);
		}
		return median;
	}
}
