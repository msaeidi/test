package home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaTest {

	private static final String inputFile = "C:/Users/MO/KeyAndCounts.txt";

	public static void main(String[] args) {
		try {
			getKeyCounts();
		} catch (FileNotFoundException e) {
			System.out.println("file Not found exception received and msg is "+e.getMessage());
			//throw userDefinedException and log it
		}
		//isPalindrome("Ah, Satan sees Natasha");

	}
	
	/**
	 * This method reads file located on c drive. 
	 * Adds the value if key exist in Map or
	 * add new key and value pair, if key doesn't exist in map
	 * @throws FileNotFoundException
	 */
	private static void getKeyCounts() throws FileNotFoundException{
	    //System.setProperty("file.encoding", "UTF-8");
	    //FileReader fileReader = new FileReader(inputFile);
	    FileInputStream fis = new FileInputStream(inputFile);
	    //InputStream inputStream = null;
		 //Scanner is used to read a file
		 Scanner scanner = new Scanner(fis, "UTF-8");
		 //scanner..useDelimiter(System.getProperty("file.encoding")); 
		 //Initialize the map
		 Map<String, Integer> sumOfKeys = new HashMap<String, Integer>();
		 while (scanner.hasNextLine()) {
			 String keyCount = scanner.next();
			 System.out.println(keyCount);
			 System.out.print(keyCount);
			 String data[] = keyCount.split(",");
			 //Check if key exist in map
			 if (sumOfKeys.containsKey(data[0].toLowerCase())) {
				 Integer value = sumOfKeys.get(data[0].toLowerCase());
				 value = value + Integer.valueOf(data[1]);
				 sumOfKeys.put(data[0].toLowerCase(), value);
			 } else {
				 //Key doesn't exist, add the new key and value to map.
				 sumOfKeys.put(data[0].toLowerCase(), Integer.valueOf(data[1]));
			 }
		 }
	
		 //print out total of keys from map.
		 for (Map.Entry<String, Integer> entryMap : sumOfKeys.entrySet()) {
			 System.out.println("The " + entryMap.getKey() + " value is " + entryMap.getValue());
		 }
	}
	
	/**
	 * This method check that given string is palindrome or not
	 * @param str
	 */
	private static void isPalindrome(String str) {
//		if (StringUtils.isNotEmpty(str)){
			//Replacing non alpha numeric with empty space.
			str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
			//Using string builder to reverse the string.
			StringBuilder sb = new StringBuilder(str).reverse();
			//compare with string for equality check.
			System.out.println(str.equals(sb.toString()));
//		}
	}

}
