package hashmap;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 })); // 4
		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 })); // 9
		System.out.println(longestConsecutive(new int[] { 1, 0, 1, 2 }));
	}

	public static int longestConsecutive(int[] nums) {

		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		int longest = 0;

		for (int num : set) {
			if (!set.contains(num - 1)) {
				int current = num;
				int length = 1;
				while (set.contains(current + 1)) {
					current++;
					length++;
				}
				longest = Math.max(length, longest);
			}

		}

		return longest;
	}
}
