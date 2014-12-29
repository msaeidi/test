package home;

import java.util.Arrays;

public class Sort {

    private static final int[] arrayOfNumbers = { 88, 109, 232, 154, 55, 13, 43, 67,  
        187, 139, 103, 106, 241, 163, 49, 157, 238, 199, 25, 247, 112, 97,  
        31, 10, 178, 181, 133, 193, 7, 91, 34, 52, 211, 130, 46, 175, 16,  
        148, 22, 100, 151, 82, 19, 64, 205, 235, 229, 4, 94, 214, 244, 61,  
        28, 223, 208, 58, 142, 190, 37, 217, 127, 85, 118, 166, 184, 124,  
        136, 76, 115, 79, 160, 145, 202, 172, 196, 73, 1, 70, 121, 40, 226,  
        169, 220 };  

    private static final int[] orderedNumbers = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82, 85, 88, 91, 94, 97, 100, 103, 106, 109, 112, 115, 118, 121, 124, 127, 130, 133, 136, 139, 142, 145, 148, 151, 154, 157, 160, 163, 166, 169, 172, 175, 178, 181, 184, 187, 190, 193, 196, 199, 202, 205, 208, 211, 214, 217, 220, 223, 226, 229, 232, 235, 238, 241, 244, 247};

    public static void main(String[] args) {
		int[] num = {9, 5, 3, 8, 0, 1, 7, 2, 6, 4};
		System.out.println(Arrays.toString(num));
		mergeBinarySearchSort(num);
		System.out.println(Arrays.toString(num));
		System.out.println("Sorted: " + isSorted(num, true));

		mergeBinarySearchSort(arrayOfNumbers);
		System.out.println(Arrays.toString(arrayOfNumbers));
		System.out.println("Sorted: " + isSorted(arrayOfNumbers, true));

		//mergeSort(num);
		
		recursiveBubbleupSort(num, num.length, false);
		System.out.println("Sorted: " + isSorted(num, false));
		System.out.println(Arrays.toString(num));

		recursiveBubbleupSort(num, num.length, true);
		System.out.println("Sorted: " + isSorted(num, true));
		System.out.println(Arrays.toString(num));
		
		recursiveBubbleupSort(arrayOfNumbers, arrayOfNumbers.length, false);
		System.out.println("Sorted: " + isSorted(arrayOfNumbers, false));
		
		recursiveBubbleupSort(arrayOfNumbers, arrayOfNumbers.length, true);
		System.out.println("Sorted: " + isSorted(arrayOfNumbers, true));
		
		printBinarySearch(229, arrayOfNumbers);

		printBinarySearch(235, arrayOfNumbers);
		
		printBinarySearch(161, arrayOfNumbers);
		
		printBinarySearch(80, arrayOfNumbers);

		printBinarySearch(77, arrayOfNumbers);
		int[] numbers = {0, 11, 22, 33, 44, 55,  66, 77, 88, 99};
		printBinarySearch(77, numbers);
		printBinarySearch(76, numbers);

		Integer[] numb = {0, 11, 22, 33, 44, 55,  66, 77, 88, 99};
		
		System.out.println(BinarySearch(numb, 77));
		System.out.println(BinarySearch(numb, 76));

		//let offset = BinarySearch(numb, x)
		//if offset>=0 => numb(offset) == x
		//else
		//if offset<0 => numb(-offset) < x < numb(-offset+1)

		String[] var = {"array", "available", "binary", "number", "search", "tree"};
		System.out.println(BinarySearch(var, "search")+" : "+var[BinarySearch(var, "search")]);
		System.out.println(BinarySearch(var, "num")+" : "+var[-BinarySearch(var, "num")]);
	}
    
    public static <T extends Comparable<? super T>> int BinarySearch(T[] array, T value) {
    	int low = 0;
    	int high = array.length - 1;
    	int mid;

    	while (low <= high) {
        	mid = (low + high) / 2;
        	if (array[mid].compareTo(value) < 0)
        	  low = mid + 1;
        	else if (array[mid].compareTo(value) > 0)
        	  high = mid - 1;
        	else
        	  return mid;
        }
    	return -high;
    }

    public static int BinarySearch(int num, int[] sortedNums) {
    	int low = 0;
    	int high = sortedNums.length - 1;
    	int mid;

    	while( low <= high ) {
        	mid = ( low + high ) / 2;
        	if (sortedNums[mid] < num)
        	  low = mid + 1;
        	else if (sortedNums[mid] > num)
        	  high = mid - 1;
        	else
        	  return mid;
        }
    	return -high; //-low;
    }

    private static void printBinarySearch(int num, int[] sortedNums) {
		int offset = binarySearch(num, sortedNums);
		System.out.print("Array[" + offset + "] " + ((offset>-1)?": " + sortedNums[offset] + " = " + num : "? " + num));
		if (offset<0) {
			System.out.print("  Array[" + (-offset) + "]: " + sortedNums[-offset]);
			System.out.print("  <  " + num + "  <  ");
			System.out.print("  Array[" + (-offset + 1) + "]: " + sortedNums[-offset +1]);
		}
		System.out.println();
		
		offset = BinarySearch(num, sortedNums);
		System.out.print("Array[" + offset + "] " + ((offset>-1)?": " + sortedNums[offset] + " = " + num : "? " + num));
		if (offset<0) {
			System.out.print("  Array[" + (-offset) + "]: " + sortedNums[-offset]);
			System.out.print("  <  " + num + "  <  ");
			System.out.print("  Array[" + (-offset + 1) + "]: " + sortedNums[-offset +1]);
		}
		System.out.println();
    }
	
	public static void recursiveBubbleupSort(int[] num, int len, boolean asc) {
		if (len > 1) {
			int minmax=0;
			for (int i = 1; i < len; i++) {
				if (asc && (num[minmax] < num[i])||!asc && (num[i] < num[minmax])) {
					minmax = i;
				}
			}
			int minmaxvalue = num[minmax];
			num[minmax] = num[len - 1];
			num[len - 1] = minmaxvalue;
			recursiveBubbleupSort(num, len - 1, asc);
		}
	}
	
	// assume num is sorted from 0 to sortedTo
	private static void mergeSort(int[] num) {
		if (num == null || num.length < 2 ) {
			return;
		}
		for (int sortedto = 1; sortedto < num.length; sortedto++) {
			int from = 0;
			int to = sortedto;
			int val = num[to];
			int mid = (from + to) >>> 1;
			int midVal = num[mid];
//			while (midVal != val) {
			while (num[from] > val || val > num[to] || from >= to) {
				//System.out.println("val: "+val+ "  num["+from+"]: "+ num[from] + "  num["+mid+"]: "+ num[mid] + "  num["+to+"]: "+ num[to] );
				if (midVal > val) {
					to = mid - 1;
					if (to<=from) {
						break;
					}
				} else if (midVal < val) {
					from = mid + 1;
					if (to<=from) {
						break;
					}
				}
				if (num[from] > val || val > num[to] || from >= to) {
					break;
				}
				mid = (from + to) >>> 1;
				midVal = num[mid];
			}
			if (to==from) {
				mid = from;
			}
			for (int i = mid; i < sortedto; i++) {
				num[i+1] = num[i];
			}
			num[mid] = val;
		}
	}

	private static void mergeBinarySearchSort(int[] num) {
		if (num == null || num.length < 2 ) {
			return;
		}
		for (int alreadysortedto = 0; alreadysortedto < num.length - 1; alreadysortedto++) {
			int nextval = num[alreadysortedto + 1];
			int offset = nextValueMergeOffset(num, 0, alreadysortedto, nextval);
			//System.out.println("Before merge: alreadysortedto: "+alreadysortedto + "  offset: "+ offset+": "+Arrays.toString(num)+ " nextval: " + nextval);
			for (int i = alreadysortedto; i >= offset; i--) {
				num[i+1] = num[i];
			}
			num[offset] = nextval;
			//System.out.println("After merge: alreadysortedto: "+alreadysortedto + "  offset: "+ offset+": "+Arrays.toString(num));
		}
	}

	private static int nextValueMergeOffset(int[] num, int from, int to, int val) {//val=7 => mid=4 (5< <8)or num[4] <  <num[5]
		if (to - from < 2) {
			if (val < num[from]) {
				return from;
			} else if (num[to] < val) {
				return to + 1;
			} else {
				return from + 1;
			}
		}
	    int mid = (from + to) >>> 1;
		int midVal = num[mid];
		if (val < midVal) {
			to = mid;
		} else if (midVal < val) {
			from = mid;
		} else {
			return mid;
		}
		return nextValueMergeOffset(num, from, to, val);
	}

	public static int binarySearch(int val, int[] num) {
		return binarySearch(num, 0, num.length - 1, val);
	}

	/*
	 * Assuming num is already sorted
	 */
	private static int binarySearch(int[] num, int from, int to, int val) {//val=7 => mid=4 (5< <8)or num[4] <  <num[5]
		if (to - from < 2) {
			if (num[to] < val) {
				return -to;
			} else {
				return -from;
			}
		}
	    int mid = (from + to) >>> 1;
		int midVal = num[mid];
		if (val < midVal) {
			to = mid;
		} else if (midVal < val) {
			from = mid;
		} else {//found
			return mid;
		}
		return binarySearch(num, from, to, val);
	}

	//	http://www.algolist.net/Algorithms/Binary_search
	//TODO: test this
	private int BinarySearch(int[] array, int left, int right, int value) {
		if (left > right) {
			return -1;
		}
		int middle = (left + right) / 2;
		if (array[middle] == value) {
			return middle;
		} else if (array[middle] > value) {
			return BinarySearch(array, left, middle - 1, value);
		} else {
			return BinarySearch(array, middle + 1, right, value);
		}
	}
	
	private static boolean isSorted(int[] nums, boolean asc) {
		int prevNum = nums[0];
		for (int num: nums) {
			if (asc && (prevNum > num) || !asc && (prevNum < num)) {
				System.out.println(prevNum + " > " + num);
				return false; 
			}
			prevNum = num;
		}
		return true;
	}

//This was trying to do the recursive by loop but did not have time to finish it
//	private static int binarySearch(int[] num, int val) {
//		int from = 0;
//		int to = num.length - 1;
//	    int mid = (from + to) >>> 1;
//		int midVal = num[mid];
//		while (midVal != val) {
//		//System.out.println("val: "+val+ "  num["+from+"]: "+ num[from] + "  num["+mid+"]: "+ num[mid] + "  num["+to+"]: "+ num[to] );
//	    	if (midVal > val) {
//	    		to = mid - 1;
//	    	} else if (midVal < val) {
//	    		from = mid + 1;
//	    	}
//			if (num[from] > val || val > num[to] || from > to) {
//				return - mid;
//			}
//	    	mid = (from + to) >>> 1;
//	    	midVal = num[mid];
//		}
//		return mid;
//	}

}
