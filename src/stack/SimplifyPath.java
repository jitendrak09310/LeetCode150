package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SimplifyPath {

	public static void main(String[] args) {
		String path = "/home//foo/";
		String simplifyPath = simplifyPath(path);

		System.out.println(simplifyPath);
	}

	public static String simplifyPath(String path) {

		ArrayDeque<String> stack = new ArrayDeque<>();
		String[] split = path.split("/");
		System.out.println(Arrays.toString(split));
		for (String part : path.split("/")) {

			if (part.isEmpty() || part.equals(".")) {
				continue;
			}

			if (part.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pollLast();
				}
			} else {
				stack.addLast(part);
			}
		}

		if (stack.isEmpty()) {
			return "/";
		}
		System.out.println(stack);

		StringBuilder sb = new StringBuilder();
		for (String dir : stack) {
			sb.append('/').append(dir);
		}

		return sb.toString();
	}

}
