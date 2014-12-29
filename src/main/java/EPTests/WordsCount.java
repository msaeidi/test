package EPTests;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WordsCount {

	//Show count of each word in a given sentence in each line of output while maintaining order of words in the sentence.
	public static void main(String[] args) {
		String sentence = "   I am a Boy   I am a   ";
		System.out.println("sentence: '" + sentence + "'");

		String trimmedSentence = sentence.trim().replaceAll("\\s+", " ");
		//String trimmedSentence = sentence.trim().replaceAll(" +", " ");
		System.out.println("Trimmed sentence: '" + trimmedSentence + "'");
		
		String[] words = trimmedSentence.split(" ");
		System.out.println("Number of words are: " + words.length);

		Map<String, Integer> wordCount = new LinkedHashMap<String, Integer>();
//		for (String word: words) {
//		    if (wordCount.containsKey(word)) {
//		        wordCount.put(word, wordCount.get(word) + 1);
//		    } else {
//		        wordCount.put(word, 1);
//		    }
//		}
//
		for (String word: words) {
		    wordCount.put(word, wordCount.containsKey(word) ? wordCount.get(word) + 1 :1);
		}

		for (Entry<String, Integer> e: wordCount.entrySet()) {
		    System.out.println("Count of : '"+e.getKey()+"' = "+e.getValue());
		}  	
	}

}
