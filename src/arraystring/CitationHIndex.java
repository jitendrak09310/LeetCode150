package arraystring;

public class CitationHIndex {

	public static void main(String[] args) {

		int citations[] = { 3, 0, 6, 1, 5 };
		int hIndex = hIndex(citations);
		System.out.println(hIndex);
	}

	public static int hIndex(int[] citations) {

		int n = citations.length;

		for (int h = n; h >= 0; h--) {// reverse loop because it prevents looping all elements.
			int count = 0;
			for (int citation : citations) {
				if (citation >= h) {
					count++;
				}

				if (count >= h) {
					return h;
				}
			}
		}
		return 0;
	}

}
