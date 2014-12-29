package home;

public class BinarySearch {

	public static void main(String[] args) {
        int SIZE = 8;
        Integer[] a = new Integer [ SIZE ];
        for (int i = 0; i < SIZE; i++)
            a[i] = i * 2;

        for (int i = 0; i < SIZE * 2; i++)
            System.out.println("Found " + i + " at " + BinarySearch(a, i));
	}

	//let offset = BinarySearch(numb, x)
	//if offset>=0 => numb(offset) == x
	//else
	//if offset<0 => numb(-offset) < x < numb(-offset+1)

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
}
