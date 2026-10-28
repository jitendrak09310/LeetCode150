package hashmap;

public class RansomNote {

	public static void main(String[] args) {
		String ransomNote = "aa", magazine = "ab";

		boolean canCOnstruct = canCOnstruct(ransomNote, magazine);
		System.out.println(canCOnstruct);
	}

	public static boolean canCOnstruct(String ransomNote, String magazine) {

		int[] freq = new int[26];

		// count letters in magazine
		for (char ch : magazine.toCharArray()) {
			freq[ch - 'a']++;
		}

//		check letters needed for ransomNote
		for (char ch : ransomNote.toCharArray()) {
			freq[ch - 'a']--;

			if (freq[ch - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
