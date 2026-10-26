package matrix;

import java.util.ArrayList;
import java.util.List;

public class RoatateMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> rotate = spiral(matrix);
		System.out.println("Jitendra");
		System.out.println(rotate);
	}

	public static List<Integer> spiral(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();

		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (left <= right && top <= bottom) {

			for (int col = left; col <= right; col++) {
				result.add(matrix[top][col]);
			}
			top++;

			for (int row = top; row <= bottom; row++) {
				result.add(matrix[row][right]);
			}
			right--;

			if (top <= bottom) {
				for (int col = right; col >= left; col--) {
					result.add(matrix[bottom][col]);
				}
				bottom--;
			}

			if (left <= right) {
				for (int row = bottom; row >= top; row--) {
					result.add(matrix[row][left]);
				}
				left++;
			}

		}

		return result;
	}

}
