package arrays;

public class DunAndBradstreet {

/*
  
  
Tough I failed in the interview, I like you know about the details so that if you are referring somebody else to them, she or he get prepared and understands type and areas Harris is asking:

What is final and what are different place were it is used? 
-final variable, final method (not overridden), final class not extendible
-final in front of variable passing by value instead of reference in a method call

What are the differences between HashTables and HashMaps? 
-Synchronized and null key

What is Iterators and what is good about them and which situations we should use them? 
-modifying collection in later generates Exception

This is what he asked in the Google document he shared:

        Write a Java “main” method that prints the numbers from 1 to 100, each on its own line.
        But for multiples of three print "Fee" instead of the number
        and for the multiples of five print "Fie" instead of the number.
        For numbers which are multiples of both three
        and five print "Foh" instead of the number.
        For all numbers that contain the digit “7”, regardless of divisibility, print “Fum” instead of the number.
 
  	
 */
	public static void main(String[] args) {
		//Write a Java “main” method that prints the numbers from 1 to 100, each on its own line. 
		//But for multiples of three print "Fee" instead of the number 
		//and for the multiples of five print "Fie" instead of the number. 
		//For numbers which are multiples of both three 
		//and five print "Foh" instead of the number. 
		//For all numbers that contain the digit “7”, regardless of divisibility, print “Fum” instead of the number.

		for (int n=1; n<=100; n++) {
			if (String.valueOf(n).contains("7")) {//test if string value of the number has a 7
			    System.out.println("Fum");
			 } else if (n % 15 == 0) {//test if multiples of 3 and 5
			    System.out.println("Foh");
			 } else if (n % 3 == 0) {//test if multiples of 3
			    System.out.println("Fee");
			 } else if (n % 5 == 0) {// test if multiples of 5
			    System.out.println("Fie");
			 } else {
			    System.out.println(n);
			 }
		}	
	}

}
