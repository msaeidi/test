package YP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * finding the first non-repeating character in a string
 */
public class UniqueChar {

	static Map<Character, Integer> charCount;;
	public static void main(String[] args) {

		String inputString = "abcafyhgteyrdrsefghjujkfvhkaduvrscbf";
		System.out.println(firstUniqueChar(null));
		System.out.println(firstUniqueChar(""));
		System.out.println(firstUniqueChar("aa"));
		System.out.println(firstUniqueChar("abccba"));
		System.out.println(firstUniqueChar("ab"));
		System.out.println(firstUniqueChar(inputString));
		System.out.println();

		//populateCharCount(null);
		//populateCharCount("");
		populateCharCount(inputString);
		char chr = uniqueChar(inputString);
		System.out.println(chr);
	}
	
	//trick: Set<Character> nonUniqueSet:  a char is accepted to be the first non-repeating if nonUniqueSet does not contain it.
	public static Character firstUniqueChar(String inputString) {
		if (inputString==null) {
			return null;
		}
		int len = inputString.length();
		Set<Character> nonUniqueSet = new HashSet<Character>();
		for (int i=0; i<len-1; i++) {
			char base = inputString.charAt(i);
			for (int j=i+1; j<len; j++) {
				if (base==inputString.charAt(j)) {
					nonUniqueSet.add(base);
					break;
				}
			}
			//after scanning all the next chars we have an acceptance test
			if (!nonUniqueSet.contains(base)) {
				return base;
			}
		}
		return null;
	}

	public static Character uniqueChar(String inputString) {
		for (char chr : inputString.toCharArray()) {
			if (charCount.containsKey(chr)) {
				if (charCount.get(chr)==1) {
					return chr;
				}
			}
		}
		return null;
	}

	public static void populateCharCount(String inputString) {
		charCount = new HashMap<Character, Integer>();
		if (inputString!=null) {
//		if (inputString!=null||!inputString.equals("")) {
			char[] chars = inputString.toCharArray();
			for (char chr : chars) {
				if (!charCount.containsKey(chr)) {
					charCount.put(chr, 0);
				}
				charCount.put(chr, charCount.get(chr)+1);
			}
		}
	}
}
