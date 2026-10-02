package arraystring;

import java.util.Arrays;

public class RotateAnArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotateArray(nums, k);

	}

	public static void rotateArray(int[] nums, int k) {

		int n = nums.length;

		nums = swap(nums, 0, k - 1);
		nums = swap(nums, k, n-1);
		nums = swap(nums, 0, n - 1);

		System.out.println(Arrays.toString(nums));
	}

	public static int[] swap(int nums[], int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
		return nums;
	}

}
