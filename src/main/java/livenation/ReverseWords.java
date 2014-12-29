package livenation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

//Dylan Campbell: LiveNation Screening 2

public class ReverseWords {
/*
The java.util.Arrays class has static methods for sorting arrays, both arrays of primitive types and object types. The sort method can be applied to entire arrays, or only a particular range. For object types you can supply a comparator to define how the sort should be performed.
Method	Description
Arrays sort methods
Arrays.sort(pa);	Sorts the elements of the array of a primitive type into ascending order using their natural ordering.
Arrays.sort(pa, from, to); 	Sorts the elements pa[from]...pa[to-1] of a primitive type. into ascending order.
Arrays.sort(oa);	Sorts the elements of the array of an object type into ascending order, using the order defined by Comparable interface, which defines the compareTo method. Note that many Java classes such as String (but not StringBuffer), Double, BigInteger, etc implement Comparable.
Arrays.sort(oa, from, to); 	Sorts the elements of the array, in the range from...to of an object type into ascending order.
Arrays.sort(oa, comp);	Sorts the elements of the array of an object type into ascending order, using the Comparator comp.
Arrays.sort(oa, from, to, comp); 	Sorts the elements of the array, in the range from...to of an object type into ascending order using the Comparator comp.
 */
	public static void main(String[] args) {
		Float f= new Float(3.1);
		Integer ii = new Integer(1);
		long m=2;
		System.out.println(""+(m+f+ii));
		System.out.println(""+m+f+ii);
		System.out.println(""+m+" "+f+" "+ii);

		double[] lengths = {120.0, 0.5, 0.0, 999.0, 77.3};
		System.out.println("0 lengths: "+Arrays.toString(lengths));
		
		String text = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday";
		System.out.println("weekdaystext: " + text);
		String[] weekdayArray = text.split(" ");
		int len = weekdayArray.length;
		for (short i=0; i<len; i++) {
			System.out.print(weekdayArray[len-i-1] + " ");
		}
		System.out.println();

		String reverse = "";
		for (String wday : weekdayArray) {
			reverse = wday + " " + reverse;
		}
		System.out.println("reverse: " + reverse);

		for (int i=weekdayArray.length-1; i>-1; i--) {
			System.out.print(weekdayArray[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(lengths);
		System.out.println("1 Arrays.sort(lengths): "+Arrays.toString(lengths));
	        
		String[] weekArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"}; 
		System.out.println("2 weekArray: "+Arrays.toString(weekArray));

		List<String> weekList = Arrays.asList(weekArray);
		System.out.println("3 weekList: " + weekList);

		Collections.reverse(weekList); //This will reverse the list members
		System.out.println("4 Collections.reverse(weekList): " + weekList);

		Arrays.sort(weekArray);
		System.out.println("5 Arrays.sort(weekArray): "+Arrays.toString(weekArray));
		
		weekArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"}; 
		System.out.println("6 weekArray: "+Arrays.toString(weekArray));
		
		List<String> weekdayList = Arrays.asList(weekArray);
		System.out.println("7 weekdayList: "+weekdayList);
	    
		Collections.sort(weekdayList, Collections.reverseOrder());
		System.out.println("8 sort Collections.reverseOrder(): "+weekdayList);
		
		//Collections.reverse not applicable to arrays
		Collections.reverse(weekdayList);
		System.out.println("9 Collections.reverse(weekdayList): "+weekdayList);

		weekArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"};
		System.out.println("9.3: "+ Arrays.asList(reverseOfArray(weekArray)));
		
		reverseTheArray(weekArray);
		System.out.println("9.7: "+ Arrays.asList(weekArray));
		
		weekArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"};
		Collections.reverse(Arrays.asList(weekArray));
		System.out.println("9.8: "+ Arrays.asList(weekArray));
		
//		weekArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"};
//		Arrays.reverse(weekArray);
//		System.out.println("9.9: "+ Arrays.asList(weekArray));

		weekArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" , "Saturday", "Sunday"};
		System.out.println("10: "+reverse(weekArray));
		
		main2(null);
		   //Scanner input=new Scanner(System.in);
		   //System.out.println("Enter String: ");
		    String st="abcdedcba";
		    String str[]=st.split("");
		    String reversedSt="";
		    for(int i=str.length-1;i>=0;i--){
		    reversedSt+=str[i];
		    }
		    System.out.println("11 Reversed String is: "+reversedSt);
		    
			main3(null);

	}

	public static String reverse (String[] s){

	    String reverse = "";
	    for(int i = (s.length -1); i>=0; i--) {
	    	reverse = reverse + s[i] + " ";
	    }
	    return reverse;
	}
	
	public void reverseA(String[] s) {  
	     if(s == null || s.length <= 1) {  
	         return;  
	     }  
	     String temp = null;
	     for(int i = s.length, j = 0; i > j; i--,j++){  
	          temp = s[j];  
	          s[j] = s[i];  
	          s[i] = temp;    
	     }  

	}

	public String reverse(String s) {
	    String reverseStringVariable = "";
	    for (int i = s.length() - 1; i != -1; i--) {
	        reverseStringVariable += s.charAt(i);
	    }
	    return reverseStringVariable;
	}
	
    public static void main2(String args[]) {
        
        //quick wasy to reverse String in Java - Use StringBuffer
        String word = "HelloWorld";
        String reverse = new StringBuffer(word).reverse().toString();
        System.out.printf(" original String : %s , reversed String %s  %n", word, reverse);
     
        //another quick to reverse String in Java - use StringBuilder
        word = "WakeUp";
        reverse = new StringBuilder(word).reverse().toString();
        System.out.printf(" original String : %s , reversed String %s %n", word, reverse);
     
        //one way to reverse String without using StringBuffer or StringBuilder is writing
        //own utility method
        word = "Band";
        reverse = reverseS(word);
        System.out.printf(" original String : %s , reversed String %s %n", word, reverse);
    }  
 
 
    public static String reverseS(String source){
        if(source == null || source.isEmpty()){
            return source;
        }      
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }
     
        return reverse;
    }

    public static String reverseSTR(String s) {

    	if(s.length() == 1) {
    		return s;
    	} else {
    		return s.charAt(s.length()-1)+reverseSTR(s.substring(1, s.length()-1))+s.charAt(0);
    	}
   }
    
   //Recursion 
    public String reverseRecursion(String str) {
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    
   // swapping a StringBuffer 
    public String reverseCharAt(String str) {
        if ((null == str) || (str.length()  <= 1 )) {
            return str;
        }
        StringBuffer result = new StringBuffer(str);
        for (int i = 0; i < (str.length() / 2); i++) {
            int swapIndex = str.length() - 1 - i;
            char swap = result.charAt(swapIndex);
            result.setCharAt(swapIndex, result.charAt(i));
            result.setCharAt(i, swap);
        }
        return result.toString();
    }
    
    //swapping an array:
        public String reverseSwap(String str) {
            if ((null == str) || (str.length() <= 1)) {
                return str;
            }
            char[] chars = str.toCharArray();
            int right = chars.length - 1;
            for (int left = 0; left < right; left++) {
                char swap = chars[left];
                chars[left] = chars[right];
                chars[right--] = swap;
            }
            return new String(chars);
        }
        
       //appending to a StringBuffer 
        public String reverseAppend(String str) {
            if ((null == str) || (str.length() <= 1)) {
                return str;
            }
            StringBuffer reverse = new StringBuffer(str.length());
            for (int i = str.length() - 1; i >= 0; i--) {
              reverse.append(str.charAt(i));
            }
            return reverse.toString();
        }
        
        public static void main3(String args[]) {
            
            //quick wasy to reverse String in Java - Use StringBuffer
            String word = "Hello World last";
            System.out.println(StringUtils.reverse(word));
            System.out.println();
            String reverse = reverseWords(word);
            System.out.printf(" original String : %s , reversed String %s  %n", word, reverse);
        }

        public static String reverseWords(String sentence) {
            return StringUtils.reverseDelimited(StringUtils.reverse(sentence), ' ');
        }

        public static <T> void reverseTheArray(T[] array) {
            Collections.reverse(Arrays.asList(array));
        }

        //keep the original array
        public static <T> T[] reverseOfArray(T[] array) {
            T[] copy = array.clone();
            Collections.reverse(Arrays.asList(copy));
            return copy;
        }

//http://codemonkeyism.com/java-interview-questions-write-a-string-reverser-and-use-recursion/
//http://hectorea.com/blog/programming-interview-22-reversing-words-not-the-letters/#
//http://www.giftsandfreeadvice.com/free_advice/59-words-that-spell-the-same-backwards-and-forwards-palindromes/ 
}
