package YP;

import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Random;

public class CollabeditTest {
	//Oracle partition, query optimization , explain plan, 
	//interface and abstract class
	//public Boolean isPalindrome(String str)
	//Given a random number generator 1 to 5 create a random number between 1 to 7)
	//Generate 7 numbers and add them together it should some from 1*7=7 to 5*7=35 
	//Devide the sum by 7 
	//?Map<String,Integer> how java gets the value for a given key (key.hashcode -> pointer index-> array of values
	//http://math.hws.edu/javanotes/c10/s3.html
	public static void main(String[] args) {

//		Map<String,Integer> map = new HashMap<String,Integer>();
//		map.put("A", 10);
//		map.get("A");
//		indexFor(4, 5);
		Integer sumI[]=new Integer[7];
		Arrays.fill(sumI, 0);
		//Integer sum[]=new Integer[]{0,0,0,0,0,0,0};
//		int sum[]=new int[7]; //no need to initialize
		Random random = new Random();
		for (int i=0; i<1000000; i++) {
//			byte r = random1to7(random);
//			sum[r-1]++;
			sumI[random1to7(random)-1]++;
			//System.out.println(random1to7());
		}
		System.out.println(Arrays.asList(sumI));

		//for (int i: sum) {	System.out.println(i);	} // for int we can't use Arrays.asList(...)

//		System.out.println(Arrays.asList(new Short[]{1,5,2,7,4,4}));
//		System.out.println(Arrays.asList(new Integer[]{1,5,2,7,4,4}));
//		System.out.println(Arrays.asList(new Byte[]{1,5,2,7,4,4}));
	}
	
	private static byte random1to7(Random random) {
		byte one=1;
		byte sum=1;
		for (byte i=0; i<7; i++) {
			sum += random1to5(random);
		}
		return (byte) (one + sum % 7);
	}

	private static byte random1to5(Random random) {
		return (byte) random(random, 1,5);
	}

	private static int random(Random random, int from, int to) {
		return random.nextInt(to-from+1) + from;
//		int generated = random.nextInt(to-from+1) + from;
//		System.out.println(generated);
//		return generated;
	}
	
    static int indexFor(int h, int length) {
        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
        return h & (length-1);
    }
}
