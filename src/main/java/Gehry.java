
public class Gehry {

	public static void main(String[] args) {
		System.out.println(num("123"));
		System.out.println(num("-1230"));
		System.out.println(num(null));
	}
	
	public static long num(String numString) {
		if (numString==null||numString=="") {
			return 0;
		}
		long num = 0;
		boolean negative = false;
		int digit = 0;
		int len = numString.length();
		for (int i=0; i < len; i++) {
			char c = numString.charAt(i);
			if (c=='-') {
				negative = true;
				continue;
			} else if (c=='+') {
				continue;
			}
			switch (c) {
			case '0': 
				digit=0;
				break;
			case '1': 
				digit=1;
				break;
			case '2': 
				digit=2;
				break;
			case '3': 
				digit=3;
				break;
			}
			num = 10*num + digit;
		}
		return negative ? -num : num;
	}

}
