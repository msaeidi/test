package EPTests;

public class FizzBuzzTest {

	public static void main(String[] args) {
		//what if count is a million
		int count = 50;
		for (int i = 1; i <= count; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}

		for (int i = 1; i <= count; i++) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					System.out.println("FizzBuzz");
				} else {
					System.out.println("Fizz");
				}
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
		
		System.out.println();
		for (int i = 1; i <= count; i++) {
			if (i % 3 > 0 && i % 5 > 0) {
				System.out.print(i);
			} else {
				if (i % 3 == 0) {
					System.out.print("Fizz");
				}
				if (i % 5 == 0) {
					System.out.print("Buzz");
				} 
			}
			System.out.println();
		}

	}
}
