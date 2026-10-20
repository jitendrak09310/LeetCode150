package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstringStartingIndex {

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = { "foo", "bar" };
		List<Integer> result = findSubstring(s, words);
		System.out.println(result);

	}

	public static List<Integer> findSubstring(String s, String[] words) {

		ArrayList<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}

		int wordLen = words[0].length();
		int wordCount = words.length;

		int totalLen = wordLen * wordCount;

		if (s.length() < totalLen) {
			return result;
		}
// count the required frequency of each word.
		HashMap<String, Integer> wordFreq = new HashMap<>();

		for (String word : words) {
			wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
		}

		// trying each possible starting index..

		for (int offset = 0; offset < wordLen; offset++) {

			int left = offset;
			int count = 0;

			HashMap<String, Integer> seen = new HashMap<>();

			for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
				String word = s.substring(right, right + wordLen);

				// if Word is not required reset the window..

				if (!wordFreq.containsKey(word)) {
					seen.clear();
					count = 0;
					left = right + wordLen;
					continue;
				}

				seen.put(word, seen.getOrDefault(word, 0) + 1);
				count++;

//				shrink the window if word appears too many times
				while (seen.get(word) > wordFreq.get(word)) {

					String leftWord = s.substring(left, left + wordLen);

					seen.put(leftWord, seen.get(leftWord) - 1);

					count--;

					left += wordLen;
				}

				// found all required words.
				if (count == wordCount) {
					result.add(left);

					// move left for contiue searching for overlapping mathces
					String leftWord = s.substring(left, left + wordLen);
					seen.put(leftWord, seen.get(leftWord) - 1);
					count--;
					left += wordLen;
				}

			}

		}

		return result;

	}

}
