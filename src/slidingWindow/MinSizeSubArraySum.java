package slidingWindow;

public class MinSizeSubArraySum {

	public static void main(String[] args) {
		int nums[] = { 2, 3, 1, 2, 4, 3 };
		int target = 7;
		int findMinWindowSizeForTarget = findMinWindowSizeForTarget(nums, target);
		System.out.println(findMinWindowSizeForTarget);
	}

	public static int findMinWindowSizeForTarget(int nums[], int target) {
		int sum = 0;
		int left = 0;
		int maxLength = Integer.MAX_VALUE;

		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];

			while (sum >= target) {
				maxLength = Math.min(maxLength, right - left + 1);

				sum -= nums[left];
				left++;
			}
		}

		return maxLength == Integer.MAX_VALUE ? 0 : maxLength;
	}
}
