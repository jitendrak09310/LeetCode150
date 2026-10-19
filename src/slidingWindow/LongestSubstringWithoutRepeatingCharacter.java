package slidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		String s = "abcabcbb";

		int findLongestSubstring = findLongestSubstring(s);
		System.out.println(findLongestSubstring);
	}

	public static int findLongestSubstring(String s) {

		HashSet<Character> set = new HashSet<>();

		int left = 0;
		int maxLength = 0;

		for (int right = 0; right < s.length(); right++) {
			char current = s.charAt(right);
			while (set.contains(current)) {
				set.remove(s.charAt(left));
				left++;
			}

			set.add(current);

			maxLength = Math.max(maxLength, right - left + 1);

		}

		return maxLength;

	}

}
