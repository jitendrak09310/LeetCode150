package arraystring;

public class ZigzagPattern {

	public static void main(String[] args) {
		String convert = convert("PAYPALISHIRING", 3);
		System.out.println(convert);

	}

	public static String convert(String s, int NumOfRows) {

		// if there is single elment no zigzag is possible.
		// rows are more than the length or elements return same.

		if (NumOfRows == 1 || NumOfRows > s.length()) {
			return s;
		}

		StringBuilder[] rows = new StringBuilder[NumOfRows];

		// initialize for every row.

		for (int i = 0; i < NumOfRows; i++) {
			rows[i] = new StringBuilder();
		}

		// start placing character in first row

		int currentRow = 0;
		int direction = 1;// 1 means move downd and -1 is move up

		for (int j = 0; j < s.length(); j++) {
			// add the current character to its row.
			rows[currentRow].append(s.charAt(j));

			if (currentRow == 0) {
				direction = 1;
			} else if (currentRow == NumOfRows - 1) {
				direction = -1;
			}
			currentRow = currentRow + direction;

		}

		StringBuilder result = new StringBuilder();

		for (StringBuilder row : rows) {
			result.append(row);
		}
		return result.toString();
	}

}
