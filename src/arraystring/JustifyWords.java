package arraystring;

import java.util.ArrayList;
import java.util.List;

public class JustifyWords {

	public static void main(String[] args) {
		String words[] = { "What", "must", "be", "acknowledgment", "shall", "be" };
		int maxWidth = 16;
		List<String> fullJustifyWords = fullJustify(words, maxWidth);
		System.out.println(fullJustifyWords);

	}

	public static List<String> fullJustify(String[] words, int maxWidth) {

		List<String> result = new ArrayList<>();

		int i = 0;
		int n = words.length;

		while (i < n) {
			int j = i;
			int totalLetters = 0;

			/// greedly pack .. pack as many as you can pack.
			while (j < n && totalLetters + words[j].length() + (j - i) <= maxWidth) {
				totalLetters += words[j].length();
				j++;
			}

			int numOfWords = j - i;
			int numberOfGaps = numOfWords - 1;

			StringBuilder line = new StringBuilder();

			// last line or the line containing only one word.
			if (j == n || numberOfGaps == 0) {
				for (int k = i; k < j; k++) {
					line.append(words[k]);

					if (k < j - 1) {
						line.append(' ');
					}

				}
//				add remaining spaces on the right.

				while (line.length() < maxWidth) {
					line.append(' ');
				}

			} else {
//fully justify a normal line . create normal line.
				int totalSpaces = maxWidth - totalLetters;
				int spacesPerGap = totalSpaces / numberOfGaps;
				int extraSpaces = totalSpaces % numberOfGaps;

				for (int k = i; k < j; k++) {
					line.append(words[k]);

					if (k < j - 1) {
						int spaces = spacesPerGap;

						// left gap recieves extra spaces
						if (k - i < extraSpaces) {
							spaces++;
						}

						for (int space = 0; space < spaces; space++) {
							line.append(' ');
						}

					}
				}
			}
			result.add(line.toString());
			// start processing the next line
			i = j;
		}

		return result;

	}

}
