package matrix;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
		// [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

	}

	public static void rotate(int[][] matrix) {

		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			int left = 0, right = n - 1;
			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}

	}
}
