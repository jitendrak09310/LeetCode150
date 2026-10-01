package arraystring;

public class RemoveDuplicatesKeepTwoDupMax {

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 2, 2, 3, 3, 3 };

		int count = removeDuplicate(nums);
		System.out.println(count);

	}

	public static int removeDuplicate(int[] nums) {
		int k = 0;
		for (int num : nums) {
			if (k < 2 || num != nums[k - 2]) {
				nums[k++] = num;
			}
		}
		return k;
	}

}
