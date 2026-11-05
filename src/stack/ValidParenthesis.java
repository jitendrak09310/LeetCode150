package stack;

import java.util.ArrayDeque;

public class ValidParenthesis {
	public static void main(String[] args) {
		System.out.println(validParenthesis("{[()]}")); // true
		System.out.println(validParenthesis("([)]")); // false
		System.out.println(validParenthesis("((")); // false
		System.out.println(validParenthesis("]"));// false
	}

	public static boolean validParenthesis(String str) {

		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (char c : str.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				char poped = stack.pop();

				if (c == ')' && poped != '(' || c == '}' && poped != '{' || c == ']' && poped != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
