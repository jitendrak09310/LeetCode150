package arraystring;

public class HayStackNeedle {

	public static void main(String[] args) {
		String haystack = "butsadsad", needle = "sad";
		int needleIndex = findNeedleInHayStack(haystack, needle);
		System.out.println(needleIndex);

	}

	public static int findNeedleInHayStack(String haystack, String needle) {

		for (int i = 0; i < haystack.length() - needle.length(); i++) {
			int j = 0;

			while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
				j++;
			}

			if (j == needle.length()) {
				return i;
			}
		}

		return -1;
	}

}
