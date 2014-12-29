package home;

import java.util.Arrays;

public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String text1 = "Payment received";
		String text2 = "Every cent paid me";
		if (charSortedWord(text1).equals(charSortedWord(text2))) {
			System.out.println("'" + text1 + "' and '" + text2 + "' are Anagrams!");
		}
		
	}

	private static String charSortedWord(String text) {
		char[] word2char = text.toLowerCase().replace(" ", "").toCharArray();
		Arrays.sort(word2char);
		return new String(word2char);
	}
}
