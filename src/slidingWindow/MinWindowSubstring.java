package slidingWindow;

public class MinWindowSubstring {

	public static void main(String[] args) {

		String s = "ADOBECODEBANC", t = "ABC";

		String minWindowString = minWindow(s, t);
		System.out.println(minWindowString);

	}

	public static String minWindow(String s, String t) {

		if (s.length() < t.length()) {
			return "";
		}

		int[] need = new int[128];
		for (char c : t.toCharArray()) {
			need[c]++;
		}
		int left = 0;
		int right = 0;
		int required = t.length();

		int minLength = Integer.MAX_VALUE;

		int start = 0;

		while (right < s.length()) {

			char c = s.charAt(right);
			if (need[c] > 0) {
				required--;
			}
			need[c]--;
			right++;

			while (required == 0) {
				if (right - left < minLength) {
					minLength = right - left;
					start = left;
				}

				char leftChar = s.charAt(left);

				need[leftChar]++;

				if (need[leftChar] > 0) {
					required++;
				}

				left++;
			}

		}

		return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
	}

}
