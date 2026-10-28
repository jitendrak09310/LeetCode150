package hashmap;

public class Isomorphic {

	public static void main(String[] args) {
		String s = "foo", t = "bar";
		boolean isomorphic = isIsomorphic(s, t);
		System.out.println(isomorphic);

	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] m1 = new int[65536];
		int[] m2 = new int[65536];

		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);

			if (m1[a] != m2[b]) {
				return false;
			}

			m1[a] = b + 1;
			m1[b] = a + 1;
		}

		return true;
	}
}
