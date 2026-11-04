package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		print(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })); // [1,6] [8,10] [15,18]
		print(merge(new int[][] { { 1, 4 }, { 4, 5 } })); // [1,5]
		print(merge(new int[][] { { 4, 7 }, { 1, 4 } }));
	}

	public static int[][] merge(int[][] intervals) {

		if (intervals.length == 0) {
			return new int[0][];
		}
		// sort by start to compare..

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new ArrayList<>();

		int[] current = intervals[0];
		result.add(current);

		for (int i = 1; i < intervals.length; i++) {
			int[] next = intervals[i];

			// check for overlapping..
			if (next[0] <= current[1]) {
				current[1] = Math.max(next[1], current[1]);
			} else {
				current = next;
				result.add(current);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

	private static void print(int[][] arr) {
		for (int[] in : arr) {
			System.out.print(Arrays.toString(in) + " ");
		}
		System.out.println();
	}

}
