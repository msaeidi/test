package EPTests;

import junit.framework.TestCase;

public class WordCountTest extends TestCase {

	public void test1() {
		String word ="for";
		String sentence = "for for a forforb";
		
		int count = WordCount.wordCount(sentence, word);
		
		TestCase.assertEquals(2, count);
	}
	public void test2() {
		String word ="for";
		String sentence = "for for a for for b";
		
		int count = WordCount.wordCount(sentence, word);
		
		TestCase.assertEquals(4, count);
	}
}
