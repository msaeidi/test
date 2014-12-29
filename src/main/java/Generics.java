import java.util.ArrayList;
import java.util.Collection;


public class Generics {

	public static void main(String[] args) {
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<Object>();

		// T inferred to be Object
		fromArrayToCollection(oa, co); 

		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();

		// T inferred to be String
		fromArrayToCollection(sa, cs);  //T[]: String[], Collection<T>: Collection<String>

		// T inferred to be Object
		fromArrayToCollection(sa, co);  //T[]: String[], Collection<T>: Collection<Object>

		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<Number>();

		// T inferred to be Number
		fromArrayToCollection(ia, cn);  //T[]: Integer[], Collection<T>: Collection<Number>

		// T inferred to be Number
		fromArrayToCollection(fa, cn);  //T[]: Float[], Collection<T>: Collection<Number>

		// T inferred to be Number
		fromArrayToCollection(na, cn);  //T[]: Number[], Collection<T>: Collection<Number>

		// T inferred to be Object
		fromArrayToCollection(na, co);  //T[]: Integer[], Collection<T>: Collection<Object>

		// compile-time error:  The T in parameters should have an interface or class from the hierarchy of inheritance or interface extensions or implementations.
		//fromArrayToCollection(na, cs);	
	}

	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
	    for (T o : a) {
	        c.add(o);
	    }
	}
	
	//"collection of unknown": a collection whose element type matches anything. wildcard type
	void printCollection(Collection<?> c) {
	    for (Object e : c) {
	        System.out.println(e);
	    }
	}
	
	//List<? extends Shape> is an example of a bounded wildcard -Shape is the upper bound of the wildcard
	//Map<String, ? extends Person>
}
