package home;

public class Permutation {

	//http://hectorea.com/blog/programming-interview-4-is-palindrome/
	public static void main(String[] args) {
		String word = "Reconocer";
		Permutation(word.toCharArray(), 0);
		//System.out.print(word + " is Palindrome " + isPalindrome(word));
		word = "Correr";
		//System.out.print(word + " is Palindrome " + isPalindrome(word));
	}
	
	public static void Permutation(char[] input, int current) {

	    if (current == input.length - 1)
	    {
//	        Console.WriteLine(input);
	        return;
	    }
	 
	    Permutation(input, current + 1);
	 
	    for (int i = current+1; i < input.length; i++)
	    {
	        char temp = input[current];
	 
	        input[current] = input[i];
	        input[i] = temp;
	 
	        Permutation(input, current+1);
	    }
	}
}
