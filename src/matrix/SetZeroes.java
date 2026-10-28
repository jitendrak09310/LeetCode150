package matrix;

public class SetZeroes {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);
		for (int[] num : matrix) {
			for (int val : num) {
				System.out.print(val + " ");
			}
			System.out.println();

		}
	}

	public static void setZeroes(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		boolean firstRowZero = false, firstColZero = false;

//		1 check the first row first column
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		for (int j = 0; j < m; j++) {
			if (matrix[j][0] == 0) {
				firstColZero = true;
				break;
			}
		}

//		using first row and first col as markers
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// zero cells
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}

		if (firstColZero) {
			for (int j = 0; j < m; j++) {
				matrix[j][0] = 0;
			}
		}

	}

}
