package home;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//http://tinyurl.com/tinyindexes
//https://code.stypi.com/yuman/Fibonacci.java
public class Fibonacci {
	
	//Map based cashing implementation
	public static Map<Integer,Integer> fi = new HashMap<Integer,Integer>();
	
	public static Map<Integer,Integer> fci = new ConcurrentHashMap<Integer,Integer>();
	
	public static Map<Integer,BigInteger> fib = new HashMap<Integer,BigInteger>();
	
	//Array based cashing implementation
	public static BigInteger[] fiboBigInteger= new BigInteger[300];
	
	public static Integer lastValue;

	public static int[] fibo = new int[47]; //45: 1134903170,  46: 1836311903,  47: > Integer.MAX_VALUE: 2147483647
	 
	public static long[] fiboLong = new long[93]; //91: 4660046610375530309, 	92: 7540113804746346429,  93: > Long.MAX_VALUE:9223372036854775807

	public static Integer lastIndex;
	
	public static void main(String args[]) throws Exception {
		
		for (int i=0; i<47; i++){System.out.println(i + " " + fiboLoopIntegerArray(i));};
		lastIndex = null;

		for (int i=0; i<93; i++){System.out.println(i + " " + fiboLoopLongArray(i));};
		lastIndex = null;

		for (int i=0; i<200; i++){System.out.println(i + " " + fiboLoopBigIntegerArray(i));};
		//System.out.println(fibo(10));
/*
		Setting the Nursery
		-Xns
		Optimally, you should try to make the nursery as large as possible while still keeping the garbage collection pause times acceptably low. This is particularly important if your application is creating a lot of temporary objects.
		The maximum size of a nursery cannot exceed 95% of the maximum heap size.

		Setting initial and minimum heap size
		-Xms
		Oracle recommends setting the minimum heap size (-Xms) equal to the maximum heap size (-Xmx) to minimize garbage collections.

		Setting maximum heap size
		-Xmx
		Setting a low maximum heap value compared to the amount of live data decrease performance by forcing frequent garbage collections.
*/

		System.out.println(System.getProperties());
		//USER_MEM_ARGS

		System.out.println(System.getProperty("MyValue"));
		
		System.out.println(System.getProperty("MyArg"));

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
		//Object[] temparray2 = new Object[(int)(Integer.MAX_VALUE / 7)];//OK on -Xmx2048m
		//temparray2=null;
//		int n=19600;
//		int n=23000;
		int n=1000000;
		BigInteger fnm1 = BigInteger.ZERO;
		BigInteger fnm2 = BigInteger.ONE;
		BigInteger fnm = null;
		for (int i=2; i<=n; i++) {
			//try {
				fnm = fnm1.add(fnm2);
			//} catch (Exception ex) {
			//	ex.printStackTrace();
			//}
			fnm1 = fnm2;
			fnm2 = fnm;
			if (i>22392) {
				System.out.println(i+": "+ fnm.toString().length()); 
				//System.out.println(i+": "+ fnm1); 
				//System.out.println(i+": "+ fnm2); 
				if (i==22398) {
					//return;
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
	
	/*
	 * The BEST algorithm		
	 */
	//loop but using array cached ones and calculate and populate rest if needed
	public static int fiboLoopIntegerArray(int n) throws Exception{
	    if (n < 0) {
	        throw new Exception("n should not be negative");
	    }
	    if (lastIndex == null) { //initialize
	    	fibo[0]= 0;
	    	fibo[1]= 1;
	    	lastIndex = 1;
	    }
	    if (n > lastIndex) { // new and needs calculation
			for (int i = lastIndex; i < n ; i++) {
				int f = fibo[i] + fibo[i-1];
				if (f < 0) {
			        throw new Exception("The sequence exceeds the Integer limit of " + Integer.MAX_VALUE);
				}
				fibo[i+1] = f;
			}
		    lastIndex = n;
	    }
		return fibo[n];
	}
	
	//Integer.MAX_VALUE =  2147483647
	//Integer.MIN_VALUE = -2147483648
	//Long.MAX_VALUE =  9223372036854775807
	//Long.MIN_VALUE = -9223372036854775808
	public static long fiboLoopLongArray(int n) throws Exception{
	    if (n < 0) {
	        throw new Exception("n should not be negative");
	    }
	    if (lastIndex == null) { //initialize
	    	fiboLong[0]= 0;
	    	fiboLong[1]= 1;
	    	lastIndex = 1;
	    }
	    if (n > lastIndex) { // new and needs calculation
			for (int i = lastIndex; i < n ; i++) {
				long f = fiboLong[i] + fiboLong[i-1];
				if (f < 0) {
			        throw new Exception("The sequence exceeds the Long limit of " + Long.MAX_VALUE);
				}
				fiboLong[i+1] = f;
			}
		    lastIndex = n;
	    }
		return fiboLong[n];
	}
	
	public static BigInteger fiboLoopBigIntegerArray(int n) throws Exception{
	    if (n < 0) {
	        throw new Exception("n should not be negative");
	    }
	    if (lastIndex == null) { //initialize
	    	fiboBigInteger[0] = BigInteger.ZERO;
	    	fiboBigInteger[1] = BigInteger.ONE;
	    	lastIndex = 1;
	    }
	    if (n > lastIndex) { // new and needs calculation
			for (int i = lastIndex; i < n ; i++) {
				fiboBigInteger[i+1] = fiboBigInteger[i].add(fiboBigInteger[i-1]);
			}
		    lastIndex = n;
	    }
		return fiboBigInteger[n];
	}
	
	//Recursive but using cached ones
	public static int fibo(int n) throws Exception{
	    if (n < 0) {
	        throw new Exception("n should not be negative");
	    }
		if (n <= 2)
			fibo[n]= n;
	 
		if(fibo[n] > 0)
			return fibo[n];
		else
			fibo[n] = fibo(n-1) + fibo(n-2);
		return fibo[n];
	}
	
	public static int f(int n) throws Exception{
	    if (n < 0) {
	        throw new Exception("n should not be negative");
	    }
	    if (n < 2) {
	        return n;
	    } 
	    if (fi.containsKey(n)) {
	        return fi.get(n);
	    }
	    int num = f(n-1) + f(n-2);
	    fi.put(n, num);
	    return num;
	}

	public static BigInteger fib(int n) throws Exception{
	    if (n<0) {
	        return null;
	    }
	    if (fib.containsKey(n)) {
	        return fib.get(n);
	    }
	    if (n==0) {
		    fib.put(n, BigInteger.ZERO);
	        return BigInteger.ZERO;
	    } 
	    if (n==1) {
		    fib.put(n, BigInteger.ONE);
	        return BigInteger.ONE;
	    } 
	    BigInteger num = fib(n-1).add(fib(n-2));
	    fib.put(n, num);
	    return num;
	}

	//int max value: 2147483647
	public static BigInteger fbi(int n) throws Exception{
	    
		if (n<0) {
	        return null;
	    }
	    if (lastValue==null) {
	    	fiboBigInteger[0] = BigInteger.ZERO;
	    	fiboBigInteger[1] = BigInteger.ONE;
	    	lastValue = 1;
	    	
	    }
	    if (n<=lastValue) {
	        return fiboBigInteger[n];
	    }
//		BigInteger value = null;
//	    if (n==0) {
//	    	value = BigInteger.ZERO;
//	    	fbi[n] = value;
//	    	lastValue = n;
//	        return value;
//	    } 
//	    if (n==1) {
//	    	value = BigInteger.ONE;
//	    	fbi[n] = value;
//	    	lastValue = n;
//	        return value;
//	    } 
	    BigInteger num = fbi(n-1).add(fbi(n-2));
    	fiboBigInteger[n] = num;
    	lastValue = n;
	    return num;
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

