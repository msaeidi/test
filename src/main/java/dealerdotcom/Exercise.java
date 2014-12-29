package dealerdotcom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mohammad Saeidi
 * @date 5/13/2013
 * @dealer.com
 */
public class Exercise {

	/*
	 * Note: we may input the file name using args of main otherwise please replace it with yours
	 */
	private static final String defaultInputFileName = "C:/Users/MO/KeyAndCounts.txt";
/*
John,2

Jane,3

John,4

Jane,5

*/
/*	
	Would result in the output: "The total for John is 6. The total for Jane is 8."
*/

	/**
	 * @param args
	 */
	public static void main(String[] args) throws MalformedURLException, IOException{
		//The input file name is defaulted if the runtime argument is null 
		String inputFileName = args.length > 0 ? args[0] : defaultInputFileName;
		
		try {
			Map<String, Integer> keyCounts = keyCountsUsingBufferedReader(inputFileName);
			print(keyCounts);
		} catch (Exception e) {
			System.out.println("Exception:  " + e.getMessage());
		}
		try {
			Map<String, Integer> keyCounts = keyCountsUsingScanner(inputFileName);
			print(keyCounts);
		} catch (Exception e) {
			System.out.println("Exception:  " + e.getMessage());
		}
		
/*
 * Palindrome		
 */
		System.out.println("\n");
		String[] palindromes = {"Pop", "Ah, Satan sees Natasha", "I added this for test", "oo", "oh", "a", ""};
		for (String palindrome : palindromes) {
			palindrome(palindrome);
		}
	}

	private static void palindrome(String text) {
		String str = text.toLowerCase().replaceAll("[^a-z0-9]", "");
		System.out.println("'" + text + "' is " + (isPalindromeCharAt(str) ? "" : "not ") + " palindrome using CharAt.");
		System.out.println("'" + text + "' is " + (isPalindromeReverse(str) ? "" : "not ") + " palindrome using Reverse.");
		System.out.println("'" + text + "' is " + (isPalindromeReverseHalf(str) ? "" : "not ") + " palindrome using ReverseHalf.");
		System.out.println("'" + text + "' is " + (isPalindromeRecursive(str) ? "" : "not ") + " palindrome using Recursive.");
		System.out.println("'" + text + "' is " + (isPalindromeCharArray(str) ? "" : "not ") + " palindrome using CharArray.\n");
	}

	/**
	 * @param fileName
	 * @return map of counts of keys Map<String, Integer> using BufferedReader
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static Map<String, Integer> keyCountsUsingBufferedReader(String fileName) throws MalformedURLException, IOException{
		File file = new File(fileName);
	    FileInputStream fis = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
 		Map<String, Integer> keyCounts = new HashMap<String, Integer>();
 		String inputLine;
		while ((inputLine = bufferedReader.readLine()) != null) {
			if (!inputLine.trim().isEmpty()){
				populateCounts(inputLine, keyCounts);				
			}
		}
		bufferedReader.close();
		return keyCounts;
	}
	
	/**
	 * @param fileName
	 * @return map of counts of keys Map<String, Integer> using Scanner
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static Map<String, Integer> keyCountsUsingScanner(String fileName) throws MalformedURLException, IOException{
		FileInputStream fis = new FileInputStream(fileName);
		Scanner scanner = new Scanner(fis, "UTF-8");
		Map<String, Integer> keyCounts = new HashMap<String, Integer>();
		String inputLine;
		while (scanner.hasNextLine()) {
			inputLine = scanner.nextLine();
			if(!inputLine.trim().isEmpty()) {
				populateCounts(inputLine, keyCounts);				
			}
		 }
		return keyCounts;
	}

	private static void populateCounts(String line, Map<String, Integer> keyCounts) {
		String data[] = line.split(",");
		String key = data[0].trim().toLowerCase();
		int value = Integer.valueOf(data[1].trim());
		if (keyCounts.containsKey(key)) {
			value += keyCounts.get(key);
		}
		keyCounts.put(key, value);
	}
	
	private static void print(Map<String, Integer> keyCounts) {
		//Both of the following is doing the same but the generated output is not ordered as it is written in the email: "The total for John is 6. The total for Jane is 8."
		//This will generate: The total for jane is 8. The total for john is 6. 
		//I'm assuming we are not looking for a descending order result, otherwise we need to use Collections.sort()
		System.out.println();
		for (Map.Entry<String, Integer> entry : keyCounts.entrySet()) {
			System.out.print("The total for " + entry.getKey() + " is " + entry.getValue() + ". ");
		}
		System.out.println();
		for (String key : keyCounts.keySet()) {
			System.out.print("The total for " + key + " is " + keyCounts.get(key) + ". ");
		}
	}
	
	public static boolean isPalindromeCharAt(String text) {
		if (text==null) {
			return false;
		}
	    int len = text.length();
		if (len < 1) {
			return true;
		}
	    for( int i = 0; i < len/2; i++ ) {
	        if (text.charAt(i) != text.charAt(len-i-1)) {
	        	return false;
	        }
	    }
	    return true;    
	}
	
	public static boolean isPalindromeReverse(String text) {    
		if (text==null) {
			return false;
		}
		return text.equals(new StringBuffer(text).reverse().toString());
	}	

	public static boolean isPalindromeReverseHalf(String text) {    
		if (text==null) {
			return false;
		}
	    int len = text.length();
		if (len < 2) {
			return true;
		}
		int halflen = len/2;
		return text.substring(0, halflen).equals(new StringBuffer(text.substring(len-halflen, len)).reverse().toString());
	}	

	public static boolean isPalindromeRecursive(String text) {    
		if (text==null) {
			return false;
		}
	    int len = text.length();
		if (len < 2) {
			return true;
		}
	    if (text.charAt(0) != text.charAt(len-1)) {
	        	return false;
	    }
	    return isPalindromeRecursive(text.substring(1, text.length()-1));
	}
	
 	public static boolean isPalindromeCharArray(String text)	{
		if (text==null) {
			return false;
		}
	    int len = text.length();
		if (len < 2) {
			return true;
		}
		char[] wordChar = text.toCharArray();
		for (int i=0; i<len/2; i++) {
			if (wordChar[i]!=wordChar[len-i-1]) {
				return false;
			}
		}
	    return true;
	}

}

