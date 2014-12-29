package matchcraft;

import java.util.List;

public interface Operator {
	//public <E> Collection<E> value(Collection<E> c1, Collection<E> c2);
	public <E> List<E> value(List<E> c1, List<E> c2);
	public <E> E getValue(List<E> c1, List<E> c2);
}
