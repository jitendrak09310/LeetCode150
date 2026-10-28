package matrix;

public class GameOfLife {

	public static void main(String[] args) {

		int board[][] = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);

		for (int[] num : board) {
			for (int val : num) {
				System.out.print(val + " ");
			}
			System.out.println();

		}

	}

	public static void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		System.out.println(m);
		System.out.println(n);

		// 8 directions: up-left, up, up-right, left, right, down-left, down, down-right
		int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		// Pass 1: mark transitions using the encoding
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				int liveNeighbors = 0;

				for (int[] d : dirs) {
					int ni = i + d[0];
					int nj = j + d[1];

					if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
						if (board[ni][nj] == 1 || board[ni][nj] == 2) {
							liveNeighbors++;
						}
					}
				}

				if (board[i][j] == 1) {
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						board[i][j] = 2; // alive -> dead
					}
				} else {
					if (liveNeighbors == 3) {
						board[i][j] = 3; // dead -> alive
					}
				}
			}
		}

		// Pass 2: convert encoded values to final 0 / 1
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 2) {
					board[i][j] = 0;
				} else if (board[i][j] == 3)
					board[i][j] = 1;
			}
		}
	}
}
