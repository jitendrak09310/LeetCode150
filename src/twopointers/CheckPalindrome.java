package twopointers;

public class CheckPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		boolean checkPalindrome = checkPalindrome(s);
		System.out.println(checkPalindrome);
	}

	public static boolean checkPalindrome(String s) {
		char[] charArray = s.toCharArray();

		int start = 0;
		int end = charArray.length - 1;
		while (start < end) {
			while (start < end && !Character.isLetterOrDigit(charArray[start])) {
				start++;
			}
			while (start < end && !Character.isLetterOrDigit(charArray[end])) {
				end--;
			}

			if (Character.toLowerCase(charArray[start]) != Character.toLowerCase(charArray[end])) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
