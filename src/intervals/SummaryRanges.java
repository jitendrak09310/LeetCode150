package intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 })); // [0->2, 4->5, 7]
		System.out.println(summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 })); // [0, 2->4, 6, 8->9]

	}

	public static List<String> summaryRanges(int[] nums) {
		ArrayList<String> result = new ArrayList<>();

		int i = 0;

		while (i < nums.length) {

			int start = nums[i];

			while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
				i++;
			}
			int end = nums[i];

			if (start == end) {
				result.add(String.valueOf(start));
			} else {
				result.add(start + " --> " + end);
			}

			i++;

		}

		return result;

	}

}
