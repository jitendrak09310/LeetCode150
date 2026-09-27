package arraystring;

import java.util.Arrays;

public class RemoveElement {

	// array -- elements 10 -- > remove value and return the remaining elements
	// count.
	// 1,2,3,4,4,5; val - 4 --> Remaining elements counts.

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 4, 5 };
		int val = 4;
		int removeElementReturnCount = removeElementReturnCount(nums, val);
		System.out.println(removeElementReturnCount);

	}

	public static int removeElementReturnCount(int nums[], int val) {

		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k] = nums[i];
				k++;
			}
		}

		

		for (int i = k; i < nums.length; i++) {
			nums[i] = 0;
		}
		System.out.println(Arrays.toString(nums));
		return k;
	}

}
