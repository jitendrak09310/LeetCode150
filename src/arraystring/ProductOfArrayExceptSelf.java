package arraystring;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4 };
		int[] findProduct = findProduct(nums);
		System.out.println(Arrays.toString(findProduct));

	}

	public static int[] findProduct(int nums[]) {
		// prefix, suffix sum..

		int n = nums.length;

		int answer[] = new int[n];

		// step 1 store prefix products.
		answer[0] = 1;

		for (int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] * nums[i - 1];
		}

		// multiply by suffix product.
		int suffix = 1;
		for (int i = n - 1; i >= 0; i--) {

			answer[i] = answer[i] * suffix;
			suffix = suffix * nums[i];
		}

		return answer;
	}

};