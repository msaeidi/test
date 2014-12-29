package dealerdotcom.groupfunction;

import java.math.BigDecimal;
import java.util.List;

public interface Function {
	public Double getFunctionValue(int[] values);
	public Double getFunctionValue(double[] values);
	public BigDecimal getFunctionValue(List<BigDecimal> values);
}