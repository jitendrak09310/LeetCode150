package twopointers;

public class MaxWaterContainer {
	public static void main(String[] args) {

		int heights[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxArea = maxArea(heights);
		System.out.println(maxArea);

	}

	public static int maxArea(int heights[]) {

		int start = 0;
		int end = heights.length - 1;

		int maxArea = 0;

		while (start < end) {
			int width = end - start;
			int minheight = Math.min(heights[start], heights[end]);

			maxArea = Math.max(maxArea, minheight * width);

			if (heights[start] < heights[end]) {
				start++;
			} else {
				end--;
			}

		}

		return maxArea;
	}

}
