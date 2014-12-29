package livenation;

public class Print1to100 {

	public static void main(String[] args) {
		for (int n=1; n<=100; n++){
			boolean print = true;
		    if (n%3==0) {
	    	    System.out.print("Fizz");
	    	    print = false;
		    }
	    	if (n%5==0) {
	    		System.out.print("Buzz");
	    	    print = false;
	    	}
		    if (print) {
		    	System.out.println(n);
		    } else {
		    	System.out.println(); 
		    }
		}
	}

}
