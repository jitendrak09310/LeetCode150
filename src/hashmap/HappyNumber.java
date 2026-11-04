package hashmap;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		boolean happyNumber = happyNumber(19);
		System.out.println(happyNumber);
	}

	public static boolean happyNumber(int n) {

		HashSet<Integer> seen = new HashSet<>();
		while (n != 1) {
			if (!seen.add(n)) {
				return false;
			}
			n = getNext(n);
		}
		return true;
	}

	private static int getNext(int n) {
		int sum = 0;

		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}

		return sum;

	}
}
