package hashmap;

import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		String pattern = "abba", s = "dog cat cat dog";
		boolean checkWordPattern = checkWordPattern(pattern, s);
		System.out.println(checkWordPattern);

	}

	public static boolean checkWordPattern(String pattern, String s) {

		String[] wordArr = s.split(" ");
		HashMap<Character, String> m1 = new HashMap<Character, String>();
		HashMap<String, Character> m2 = new HashMap<String, Character>();
		if (pattern.length() != wordArr.length) {
			return false;
		}

		for (int i = 0; i < wordArr.length; i++) {
			String word = wordArr[i];
			char ch = pattern.charAt(i);

			if (m1.containsKey(ch) && !m1.get(ch).equals(word)) {
				return false;
			}

			if (m2.containsKey(word) && !m2.get(word).equals(ch)) {
				return false;
			}

			m1.put(ch, word);
			m2.put(word, ch);
		}
		return true;
	}

}
