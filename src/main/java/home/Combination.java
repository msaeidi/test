package home;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

	public static void main(String[] args) throws Exception {
		
		printCombinationof(new String[]{"a"});

        printCombinationof(new String[]{"a", "b"});

        printCombinationof(new String[]{"a", "b", "c"});

        printCombinationof(new String[]{"a", "b", "c", "d"});

        printCombinationof(new String[]{"a", "b", "c", "d", "e"});

        printCombinationof(new String[]{"rap", "rock", "pop"});

        printCombinationof(new String[]{"rap", "rock", "pop", "classic"});


		List<String> result;
        result = new ArrayList<String>();
        combination(null, new String[]{"a"}, result);
        System.out.println(result.size() + ":" + result);

        result = new ArrayList<String>();
        combination(null, new String[]{"a", "b"}, result);
        System.out.println(result.size() + ":" + result);
        
        result = new ArrayList<String>();
        combination(null, new String[]{"a", "b", "c"}, result);
        System.out.println(result.size() + ":" + result);
        
        result = new ArrayList<String>();
        combination(null, new String[]{"a", "b", "c", "d"}, result);
        System.out.println(result.size() + ":" + result);
        
        result = new ArrayList<String>();
        combination(null, new String[]{"a", "b", "c", "d", "e"}, result);
        System.out.println(result.size() + ":" + result);
 
        result = new ArrayList<String>();
        combination(null, new String[]{"rap", "rock", "pop"}, result);
        System.out.println(result.size() + ":" + result);
        
        result = new ArrayList<String>();
        combination(null, new String[]{"rap", "rock", "pop", "classic"}, result);
        System.out.println(result.size() + ":" + result);
	}

	private static void printCombinationof(String[] words) {
		List<String[]> results = new ArrayList<String[]>();
        combination(words, results);
        int size =  (int) Math.pow(2, words.length) - 1;
        if(results.size()!=size) {
            System.out.println("Error: results.size() = " + results.size() + " is not equal to Math.pow(2, words.length) - 1 = " + size);
        }
        System.out.println(results.size() + ":");
        for (String[] result : results) {
            System.out.println(Arrays.asList(result));
        }
	}
//Written by me (Mohammad)	
	private static void combination(String[] words, List<String[]> results) {
        results.add(new String[]{words[0]});
		int newWordsLength = words.length - 1;
        if (newWordsLength > 0) {
            String[] newWords = new String[newWordsLength];
            System.arraycopy(words, 1, newWords, 0, newWordsLength);
    		List<String[]> newResults = new ArrayList<String[]>();
        	combination(newWords, newResults);
            results.addAll(newResults);
        	for (String[] result : newResults) {
	        	int newResultLength = result.length + 1;
        		String[] newResult = new String[newResultLength]; 
	            System.arraycopy(result, 0, newResult, 1, result.length);
	            newResult[0] = words[0];
	            results.add(newResult);
        	}
       }
	}  
//Extracted originally but simplified and re-factored by me (Mohammad)
	private static void combination(String[] left, String[] right, List<String> result) {

		int leftLength = left==null ? 0 : left.length;
		int rightLength = right.length;
        String[] newLeft = new String[leftLength + 1];
        if (leftLength > 0) {
            System.arraycopy(left, 0, newLeft, 0, leftLength);
        }
 		for (int i = 0; i < rightLength; i++) {
			newLeft[leftLength] = right[i];
	        //System.out.println(Arrays.toString(newLeft));
            result.add(Arrays.toString(newLeft));
			int newRightLength = rightLength - 1 - i;
	        if (newRightLength > 0) {
	        	String[] newRight = new String[newRightLength];
	            System.arraycopy(right, i + 1, newRight, 0, newRightLength);
	        	//System.out.println("combination(" + Arrays.toString(newLeft) + ", " + Arrays.toString(newRight) + ")");
	        	combination(newLeft, newRight, result);
	        }
	    }
	}  
}
