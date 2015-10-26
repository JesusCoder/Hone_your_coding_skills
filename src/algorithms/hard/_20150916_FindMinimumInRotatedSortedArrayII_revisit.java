package algorithms.hard;

/*** Very excited to get this problem accepted all by myself! Although it's super easy.
 But it's been a while since I last time coded a Leetcode problem. I went through the
 algorithm brainstorming, debugging and all procedures without going online for help!
 Hooray! Praise the Lord!
 
 Leetcode newly added problem:
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */

public class _20150916_FindMinimumInRotatedSortedArrayII_revisit {
	public static int findMin(int[] num) {
		if (num.length == 1) {
			return num[0];
		}
		int startIndex = 0;
		int lastIndex = num.length - 1;
		if (num[startIndex] < num[lastIndex]) {
			return num[startIndex];
		}
		int halfIndex = lastIndex / 2;
		while (halfIndex != lastIndex || halfIndex != startIndex) {
			if (num[halfIndex] > num[halfIndex + 1]) {
				return num[halfIndex + 1];
			} else if (num[halfIndex] < num[lastIndex]) {
				// search the first half sub-array
				lastIndex = halfIndex;
				halfIndex = (startIndex + lastIndex) / 2;
			} else if (num[halfIndex] > num[lastIndex]) {
				// search the second half sub-array
				startIndex = halfIndex + 1;
				halfIndex = (startIndex + lastIndex) / 2;
			}
		}
		if (num[halfIndex] > num[halfIndex + 1]) {
			return num[halfIndex + 1];
		} else
			return num[halfIndex];
	}

	public static void main(String... args) {
		int num[] = new int[] { 4, 5, 6, 7, 8, 9, 10, -1, 0, 1, 2 };
		System.out.println(findMin(num));
		System.out.println("Program ended.");
	}

}
