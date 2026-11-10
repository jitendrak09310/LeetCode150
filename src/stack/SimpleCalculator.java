package stack;

import java.util.*;

public class SimpleCalculator {

	public static void main(String[] args) {
//		String s = "(1+(4+5+2)-3)+(6+8)";
		String s = "1 + 1";

		int result = calculate(s);

		System.out.println(result);

	}

	public static int calculate(String s) {
		Deque<Integer> stack = new ArrayDeque<>();
		int result = 0;
		int sign = 1;
		int num = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			switch (ch) {
			case '+': {
				result += sign * num;
				num = 0;
				sign = 1;
				break;
			}
			case '-': {
				result += sign * num;
				num = 0;
				sign = -1;
				break;
			}
			case '(': {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
				break;
			}
			case ')': {
				result += sign * num;
				num = 0;
				result *= stack.pop();
				result += stack.pop();
				sign = 1;
				break;
			}
			case ' ':
				break;
			default:
				num = num * 10 + (ch - '0');
			}
		}

		return result + sign * num;
	}
}
