package twopointers;

public class CheckSubsequence {

	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		boolean isSubsequence = isSubsequence(s, t);
		System.out.println(isSubsequence);
	}

	public static boolean isSubsequence(String s, String t) {

		int i = 0;
		int j = 0;

		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
			}
			j++;
		}

		return i == s.length();
	}

}
