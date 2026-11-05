package stack;

import java.util.ArrayDeque;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {

		EvaluateReversePolishNotation s = new EvaluateReversePolishNotation();
		System.out.println(s.evalRPN(new String[] { "2", "1", "+", "3", "*" })); // 9
		System.out.println(s.evalRPN(new String[] { "4", "13", "5", "/", "+" })); // 6
		System.out.println(
				s.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" })); // 22
	}

	public static int evalRPN(String[] tokens) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (String token : tokens) {
			switch (token) {
			case "+": {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a + b);
				break;
			}
			case "-": {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
				break;
			}
			case "*": {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a * b);
				break;
			}
			case "/": {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
				break;
			}
			default:
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();

	}
}
