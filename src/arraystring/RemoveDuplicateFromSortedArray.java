package arraystring;

public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {
		int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };// 0 1 2 3 4

		// remove duplicates
		// order of elements should remain same.
		// remaining unique elements count.
		int count = removeDuplicate(nums);
		System.out.println(count);
	}

	public static int removeDuplicate(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		int k = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[k - 1]) {
				nums[k] = nums[i];//
				k++;
			}
		}
		return k;
	}

}