package EPTests;

public class WordCount {

	public static void main(String[] args) {

		String sentence = "from for with a for of for to forb aford";
		String word ="for";
		int count = wordCount(sentence, word);
		System.out.println(count);
	}
	public static int wordCount(String sentence, String word) {
		int count = 0;
		String[] sentenceWord = sentence.split(" ");
		for (String senWord : sentenceWord) {
			if (senWord.equals(word)) {
				count++;
			}
		}
		return count;
	}
}
