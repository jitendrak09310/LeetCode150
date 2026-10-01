package arraystring;

public class MajorityElement {

	public static void main(String[] args) {
		int nums[] = { 2, 2, 1, 1, 1, 2, 2 };// n/2 > 4
		
		//boyer moore voting algorithm
		
		int findMajorityElement = findMajorityElement(nums);
		System.out.println(findMajorityElement);
	}

	public static int findMajorityElement(int[] nums) {

		int count = 0;
		int candidate = 0;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			if (num == candidate) {
				count++;
			} else {
				count--;
			}
		}

		return candidate;
	}

}
