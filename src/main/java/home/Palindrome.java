package home;

public class Palindrome {

	//http://hectorea.com/blog/programming-interview-4-is-palindrome/
	public static void main(String[] args) {
		
		palindrome("reconocer");
		palindrome("saippuakivikauppias");
		palindrome("kuulilennuteetunneliluuk");
		palindrome("resrer");
		palindrome("dad");
		palindrome("ss");
		palindrome("r");
		palindrome("");
		palindrome(null);
		System.out.print(isPalindrome(123454321)+"\n");
		System.out.print(isPalindromeCharAt(123454321)+"\n");
	}

	private static void palindrome(String word) {
		System.out.print(word + " is PalindromeCharAt " + isPalindromeCharAt(word) + "\n");
		System.out.print(word + " is PalindromeReverse " + isPalindromeReverse(word) + "\n");
		System.out.print(word + " is PalindromeReverseHalf " + isPalindromeReverseHalf(word) + "\n");
		System.out.print(word + " is PalindromeRecursive " + isPalindromeRecursive(word) + "\n");
		System.out.print(word + " is Palindrome " + isPalindrome(word) + "\n");
	}

	public static boolean isPalindromeCharAt(String word) {
		if (word==null) {
			return false;
		}
	    int len = word.length();
		if (len < 1) {
//		if (len < 2) {
			return true;
		}
	    for( int i = 0; i < len/2; i++ ) {
	        if (word.charAt(i) != word.charAt(len-i-1)) {
	        	return false;
	        }
	    }
	    return true;    
	}
	
	public static boolean isPalindromeReverse(String word) {    
		if (word==null) {
			return false;
		}
		return word.equals(new StringBuffer(word).reverse().toString());
	}	

	public static boolean isPalindromeReverseHalf(String word) {    
		if (word==null) {
			return false;
		}
	    int len = word.length();
		if (len < 2) {
			return true;
		}
		int halflen = len/2;
		return word.substring(0, halflen).equals(new StringBuffer(word.substring(len-halflen, len)).reverse().toString());
	}	

	public static boolean isPalindromeRecursive(String word) {    
		if (word==null) {
			return false;
		}
	    int len = word.length();
		if (len < 2) {
			return true;
		}
	    if (word.charAt(0) != word.charAt(len-1)) {
	        	return false;
	    }
	    return isPalindromeRecursive(word.substring(1, word.length()-1));
	}
	
 	public static boolean isPalindrome(String word)	{
		if (word==null) {
			return false;
		}
	    int len = word.length();
		if (len < 2) {
			return true;
		}
		char[] wordChar = word.toCharArray();
		for (int i=0; i<len/2; i++) {
			if (wordChar[i]!=wordChar[len-i-1]) {
				return false;
			}
		}
	    return true;
	}
 	
    public static boolean isPalindromeCharAt(int number) {
    	return isPalindromeCharAt(Integer.toString(number));
    }
    public static boolean isPalindrome(int number) {
        int[] digit = digit(number);
        int len = digit.length;
		for (int i=0; i<len/2; i++) {
			if (digit[i]!=digit[len-i-1]) {
				return false;
			}
		}
	    return true;
    }
    //Integer.parseInt()
    
    public static int[] digit(int number) {
    	int tens = (int)Math.log10(number);
        int num = number;
        int[] digit = new int[tens+1];
        int i=0;
    	while (num > 0) {
            int temp = num/10;
            digit[i] = num-10*temp;
            i++;
            num = temp;
        }
    	return digit;
    }
}
