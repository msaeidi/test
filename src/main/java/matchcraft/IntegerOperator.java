package matchcraft;

import java.util.Collection;
import java.util.List;

public class IntegerOperator implements Operator{

	@Override
	public Integer value(List<Integer> t1, List<Integer> t2) {
		Integer t1max = t1.max();
		Integer t2max = t2.max();
		return t1max > t2max ? t1max : t2max;
	}

	@Override
	public <E> List<Integer> value(List<Integer> c1, List<Integer> c2) {
		// TODO Auto-generated method stub
		return null;
	}


}
