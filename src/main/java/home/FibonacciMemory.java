package home;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//http://tinyurl.com/tinyindexes
//https://code.stypi.com/yuman/Fibonacci.java
public class FibonacciMemory {
	public static Map<Integer,Integer> fi = new HashMap<Integer,Integer>();
	
	public static Map<Integer,Integer> fci = new ConcurrentHashMap<Integer,Integer>();
	
	public static Map<Integer,BigInteger> fib = new HashMap<Integer,BigInteger>();
	
	public static BigInteger[] fbi= new BigInteger[10000000];
	
	public static Integer lastValue;
	
	public static void main(String args[]) {
/*
  		In mathematics, the Fibonacci numbers or Fibonacci sequence are the numbers in the following integer sequence:
			0, 1, 1, 2, 3, 5, 8, 13, ...
			In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
			F(n) = F(n-1) + F(n-2)
			Design a Java class the has a function
			public int fib(int n)
			that returns the n-th Fibonacci number.
			For computational efficiency, make use of previously calculated results. For example, for
			f(101), make use of a previous call of fib(90).
			If fib(101) has been called, no calculation is needed for fib(90).

			If the function is to be exposed as a web service, address the scalability and concurrency considerations.
 */
		   //System.out.println(f(10)); 
		   //System.out.println(f(46)); 
		   //System.out.println(Integer.MAX_VALUE);
		   //30: 832040
		   //40: 102334155
		   //45: 1134903170
		   //46: 1836311903
		   //47: -1323752223
		   //[-2,147,483,648, 2,147,483,647]
		   //System.out.println(fib(1000)); //100: 354224848179261915075
		   //1000: 43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875
		   //System.out.println(fib(10000)); 
		   //System.out.println(fbi(10458)); 
		   //System.out.println(fbi(10462));
		//System.out.println(fbi(10468));
		//System.out.println(fbi(10469));
		//System.out.println(fbi(10470));
//		Exception in thread "main" java.lang.StackOverflowError
//		at java.lang.Integer.intValue(Unknown Source)
//		at home.Fibonacci.fbi(Fibonacci.java:101)
//		at home.Fibonacci.fbi(Fibonacci.java:117)

		//System.out.println(fib(1000000)); //overflow
/*
		System.out.println(fiboLoop(0));
		System.out.println(fiboLoop(1));
		System.out.println(fiboLoop(2));
		System.out.println(fiboLoop(3));
		System.out.println(fiboLoop(4));
		System.out.println(fiboLoop(5));
		System.out.println(fiboLoop(10));
*/
		//A Java byte array can hold up to 2^31-1 values, if there is that much contiguous memory available.
		//Each array can hold a maximum of Integer.MAX_VALUE values
		
		/**
		 * If you have the source code for the java classes, checkout java.util.ArrayList.class (line 190):
	     * The maximum size of array to allocate.
	     * Some VMs reserve some header words in an array.
	     * Attempts to allocate larger arrays may result in
	     * OutOfMemoryError: Requested array size exceeds VM limit
	     */ 		//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
		
		//Maximum number of elements of an array is 2^31-1 = 2147483647
		
		System.out.println("valid = " + (int)(Integer.MAX_VALUE / 8.35918377)); //256901116
		System.out.println("invalid = " + (int)(Integer.MAX_VALUE / 8.35918376));
		//Object[] temparray = new Object[(int)(Integer.MAX_VALUE / 8.35918377)];
		//Object[] temparray1 = new Object[(int)(Integer.MAX_VALUE / 8.35918376)];
		Object[] temparray2 = new Object[(int)(Integer.MAX_VALUE / 7)];//OK on -Xmx2048m
		temparray2=null;
//		int n=19600;
		int n=23000;
//		int n=1000000;
		BigInteger fnm1 = BigInteger.ZERO;
		BigInteger fnm2 = BigInteger.ONE;
		BigInteger fnm = null;
		for (int i=2; i<=n; i++) {
			try {
				fnm = fnm1.add(fnm2);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			fnm1 = fnm2;
			fnm2 = fnm;
			if (i>22393) {
				System.out.println(i+": "+ fnm); 
				//System.out.println(i+": "+ fnm1); 
				//System.out.println(i+": "+ fnm2); 
				if (i==22395) {
					return;
				}
				
			}
		}
		System.out.println(fnm + " : "+ fnm1 + " : "+ fnm2); 

		System.out.println(n+": " + fnm + " : "+ fnm1 + " : "+ fnm2); 

//		System.out.println(fiboLoop(191428));//198316
//		System.out.println(fiboLoop(200000));
//		198315
//		198316
//		Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//			at java.math.BigInteger.add(Unknown Source)
//			at java.math.BigInteger.add(Unknown Source)
//			at home.Fibonacci.fiboLoop(Fibonacci.java:159)
//			at home.Fibonacci.main(Fibonacci.java:68)
		//System.out.println(fiboLoop(1000000));

	}
	

	//int max value: 2147483647
	public static BigInteger fiboLoop(int n) throws Exception{
	    // for given n look if fib does not contain the fibo so we need to start from the last already calculated to n 
	    if (n<0) {
	        return null;
	    }
	    if (!fib.containsKey(n)) {
		    //length of map says which one in the last.
		    int m = fib.size();
		    if (m==0) {
		    	fib.put(0, BigInteger.ZERO);
			    fib.put(1, BigInteger.ONE);
			    m=2;
		    }
			for (int i=m; i<=n; i++) {
			   System.out.println(i); 

			   fib.put(i, fib.get(i-1).add(fib.get(i-2)));
		    }
	    }
		return fib.get(n);
	}
}

