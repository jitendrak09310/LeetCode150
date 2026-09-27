package arraystring;

import java.util.Arrays;

public class MergeSortArray {

	// nums1 and nums 2 -- increasing order --
	// nums1 m elements nums 2 n elements
	// nums1 size m+n --> remaining places are filled with zeroes.

//	problemm -- merge both and result should in sorter order. return nums1 only.

	public static void merge(int nums1[], int m, int nums2[], int n) {
//-1 --> because arrays are zero indexed.. 

		int i = m - 1;// 2
		int j = n - 1;// 2
		int k = m + n - 1; // 3+3-1 = 5

		while (j >= 0) {
			if (i >= 0 && (nums1[i] > nums2[j])) {
				// 3>2
				nums1[k--] = nums1[i--];// i=2-1 = 1 , k = 3-1 =2

			} else {
				nums1[k--] = nums2[j--];// j = 2 k 5,--> j = 1 k =4 --> j =0 k=3 -->
			}
		}
		
		System.out.println(Arrays.toString(nums1));

	}

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int nums1[] = { 1, 2, 3, 0, 0, 0 };
		int nums2[] = { 2, 4, 6 };
		
		merge(nums1, m, nums2, n);

		// expected output -- 1,2,2,3,4,6
	}

}
