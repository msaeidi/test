package home;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "tofoodie";
		String str2 = "toody";
		String matches = longestMatchingChars(str1, str2);
		System.out.println("'" + matches + "' is the longest common substring between '" + str1 + "' & '" + str2 +"'");
	}
	static String longestMatchingChars(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		int[][] match = new int[sc.length][tc.length];
		int maxMatch = 0;
		int maxI = 0;
		for (int i=0; i<sc.length; i++) {
			for (int j=0; j<tc.length; j++) {
				if (sc[i]==tc[j]) {
					if (i>0 && j>0) {
						match[i][j] = match[i-1][j-1];
					}
					match[i][j] += 1;
					if (maxMatch < match[i][j]) {
						maxMatch = match[i][j];
						maxI = i + 1 - maxMatch;
					}
				}
			}
			
		}
		//System.out.println("Matching: " + maxI + " chars: " + s.substring(maxI, maxI + maxMatch));
		return s.substring(maxI, maxI + maxMatch);
	}

}
