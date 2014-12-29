package dealerdotcom.groupfunction;

import java.math.BigDecimal;
import java.util.List;

public class Average implements Function{
//	Average(){}
	
	@Override
	public Double getFunctionValue(int[] values) {
		if (values==null||values.length==0) {
			return null;
		}
		double avg = 0;
		for (int value: values){
			avg += value;
		}
		return avg/values.length;
	}

	@Override
	public Double getFunctionValue(double[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getFunctionValue(List<BigDecimal> values) {
		// TODO Auto-generated method stub
		return null;
	}
}
