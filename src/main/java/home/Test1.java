package home;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) throws Exception {
		List<String> result;
        result = new ArrayList<String>();
        combination(null, new String[]{"a", "b", "c", "d", "e"}, result);
        System.out.println(result.size() + ":" + result);
        //result = new String[2^comb.length-1];
        result = new ArrayList<String>();
        combination(null, new String[]{"rap", "rock", "pop"}, result);
        System.out.println(result.size() + ":" + result);
        
        result = new ArrayList<String>();
        combination(null, new String[]{"rap", "rock", "pop", "classic"}, result);
        System.out.println(result.size() + ":" + result);
	}
	
	public static void combination(String[] left, String[] right, List<String> result) {

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

/*
combination([a], [b, c])  >> combination([a, b, c])  i=1
combination([a, b], [c])  >> combination([a, b, c])  i=2

combination([b], [c])  >> combination([b, c])  i=1

 */
/*	
	private static void combination(String[] rest) {//rest[0], rest[1],rest[2]

        int restLength = rest.length;
        String[] newRest = new String[restLength-1];
        for (int i = 1; i < restLength; i++) {
        	newRest[i] = rest[i+1];
        	//System.out.println("combination(" + Arrays.toString(newRest) + ")");
        	//combination(newRest);
        	for (int j = i; j < restLength; j++) {
        		//left=rest[0],rest[1],..rest[i] //right=rest[i+1],...rest[restLength-1]
       			System.out.println("combination(" + Arrays.toString(newLeft) + ", " + Arrays.toString(newRight) + ")");
        	}
        	System.out.println("combination(" + Arrays.toString(newRest) + ")");
        	combination(newRest);//newRest[0],newRest[1]==(rest[1],rest[2])
        }
	}  
*/
	//        String[] subArray = Arrays.copyOfRange(comb, 2, 3);

/*
	private static void combination(String[] left, String[] right) {

		int leftLength = left==null ? 0 : left.length;
		int rightLength = right.length;
        String[] newLeft = new String[leftLength+1];
        for (int i = 0; i < leftLength; i++) {
        	newLeft[i] = left[i];
        }
 		for (int i = 0; i < rightLength; i++) {
			newLeft[leftLength] = right[i];
	        System.out.println(Arrays.toString(newLeft));
			int newRightLength = rightLength - 1 - i;
	        if (newRightLength > 0) {
	        	String[] newRight = new String[newRightLength];
	        	for (int j = 0; j < newRightLength; j++) {
	        		newRight[j] = right[j + i + 1];
	        	}
	        	//System.out.println("combination(" + Arrays.toString(newLeft) + ", " + Arrays.toString(newRight) + ")");
	        	combination(newLeft, newRight);
	        }
	    }
	}  
*/
/*
	private String[][] insertIntoArray(String[] array, String newElem) {
	    String[] newArray = new String[array.length]; 
	    for (int loc=0; loc < array.length; loc++) {
	    	newArray[] = insertIntoArray(array, newElem, loc);
	    }
	    return newArray;
	}
	
	private String[] insertIntoArray(String[] array, String newElem, int loc) {
		String[] newArray = new String[array.length+1];
		int j = 0;
		for (int i=0; i < array.length; i++) {
			if (i==loc) {
				newArray[j] = newElem;
				j++;
			}
	    	newArray[j] = array[i];
	    	j++;
	    }
		return newArray;
	}
*/
}
/*
//		combination(null, new String[]{"a", "b", "c"});
//        System.out.println();

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
        
         
//		String[] comb = new String[]{"rap", "rock", "pop", "classic"};
//		combination(null, comb);
//		System.out.println();


        
*/