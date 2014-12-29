package home;

public class Search {

    private static final int[] orderedNumbers = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82,
    	85, 88, 91, 94, 97, 100, 103, 106, 109, 112, 115, 118, 121, 124, 127, 130, 133, 136, 139, 142, 145, 148, 151, 154, 157, 160, 163, 166, 169, 172, 175,
    	178, 181, 184, 187, 190, 193, 196, 199, 202, 205, 208, 211, 214, 217, 220, 223, 226, 229, 232, 235, 238, 241, 244, 247};

    public static void main(String[] args) {
		
		printBinarySearch(229, orderedNumbers);
		printBinarySearch(235, orderedNumbers);
		printBinarySearch(100, orderedNumbers);
		printBinarySearch(79, orderedNumbers);
		printBinarySearch(22, orderedNumbers);
		printBinarySearch(160, orderedNumbers);
		printBinarySearch(80, orderedNumbers);
		printBinarySearch(77, orderedNumbers);

		//let offset = BinarySearch(numb, x)
		//if offset>=0 => numb(offset) == x
		//else
		//if offset<0 => numb(-offset) < x < numb(-offset+1)

	}
    
	public static int BinarySearch(int val, int[] num) {
		return BinarySearch(num, 0, num.length - 1, val);
	}

	//	http://www.algolist.net/Algorithms/Binary_search
	public static int BinarySearch(int[] array, int left, int right, int value) {
		if (left > right) {
			return - right;
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


    private static void printBinarySearch(int num, int[] sortedNums) {
		System.out.println();
	
		int offset = BinarySearch(num, sortedNums);
		System.out.print("Array[" + offset + "] " + ((offset>-1)?": " + sortedNums[offset] + " = " + num : "? " + num));
		if (offset<0) {
			System.out.print("  Array[" + (-offset) + "]: " + sortedNums[-offset]);
			System.out.print("  <  " + num + "  <  ");
			System.out.print("  Array[" + (-offset + 1) + "]: " + sortedNums[-offset +1]);
		}
		System.out.println();
    }
	
}
