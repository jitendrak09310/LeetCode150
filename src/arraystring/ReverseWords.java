package arraystring;

import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {
		String str = "The sky is blue";

		String reverseWordsInString = reverseWordsInString(str);
		System.out.println(reverseWordsInString);
	}

	public static String reverseWordsInString(String str) {

		String[] split = str.split("\\s");

		int start = 0;
		int end = split.length - 1;

		while (start < end) {
			String temp = split[end];
			split[end] = split[start];
			split[start] = temp;

			start++;
			end--;
		}
		return String.join(" ", split).trim();
	}

}
