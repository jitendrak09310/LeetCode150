package arraystring;

import java.util.Arrays;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String str = "Jitendra Loves coding";
		int lengthOfLastWord = lengthOfLastWord(str);
		System.out.println(lengthOfLastWord);
	}

	public static int lengthOfLastWord(String str) {

		String[] split = str.split("\\s");
		System.out.println(Arrays.toString(split));

		String lastWord = split[split.length - 1];
		int length = lastWord.length();
		return length;
	}

}
