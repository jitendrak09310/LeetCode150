package arraystring;

public class JumpGame2 {

	public static void main(String[] args) {
		int nums[] = { 2, 3, 1, 0, 0, 2, 3, 4 };
		// find the minimum jump to reach the end
		int jumps = jumps(nums);

		System.out.println(jumps);

	}

	public static int jumps(int[] nums) {

		int jumps = 0, maxReach = 0, currentEnd = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			maxReach = Math.max(maxReach, i + nums[i]);
			if (i == currentEnd) {
				jumps++;
				currentEnd = maxReach;
			}
		}
		return jumps;
	}

}
