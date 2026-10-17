package twopointers;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {

		int numbers[] = { 1, 2, 7, 11, 15 };
		int target = 9;

		int[] twoSumTarget = twoSumTarget(numbers, target);
		System.out.println(Arrays.toString(twoSumTarget));

	}

	public static int[] twoSumTarget(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int sum = nums[left] + nums[right];

			if (sum == target) {
				return new int[] { left + 1, right + 1 };
			}

			if (sum < target) {
				left++;
			} else {
				right--;
			}

		}

		return new int[] { -1, -1 };
	}

}
