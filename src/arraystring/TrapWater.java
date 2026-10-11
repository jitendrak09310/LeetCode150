package arraystring;

public class TrapWater {

	public static void main(String[] args) {

		int height[] = { 4, 2, 0, 3, 2, 5 };
		int findTrapppedWater = findTrapppedWater(height);
		System.out.println(findTrapppedWater);
	}

	public static int findTrapppedWater(int height[]) {

		int n = height.length;

		int leftMax[] = new int[n];
		int rightMax[] = new int[n];

		leftMax[0] = height[0];

		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		rightMax[n - 1] = height[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		int trappedWater = 0;

		for (int i = 0; i < n; i++) {
			trappedWater += Math.min(leftMax[i], rightMax[i] - height[i]);
		}

		return trappedWater;
	}

}
