package matrix;

public class ValidSudoku {
	public static void main(String[] args) {

		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		boolean isValidSudoku = isValidSudoku(board);
		System.out.println(isValidSudoku);
	}

	public static boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] boxes = new boolean[9][9];

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (board[r][c] == '.') {
					continue;
				}

				int num = board[r][c] - '1';

				int boxIndex = (r / 3) * 3 + c / 3;

				if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
					return false;
				}
				rows[r][num] = true;
				cols[c][num] = true;
				boxes[boxIndex][num] = true;
			}
		}

		return true;
	}
}
