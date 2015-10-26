package algorithms.medium;

/* Given an array of non-negative integers, you are initially 
 * positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false. */

public class _20150916_JumpGame_revisit {
	public static boolean canJump(int[] A) {
		int len = A.length;
		if (len == 0 || len == 1) {
			return true;
		}
		int val = A[0];
		int index = 0;
		while (index < len) {
			index += val;
			if (index >= len) {
				return true;
			}
			val = A[index];
			System.out.println("index = " + index + "\tval = " + val);
			if (index == len - 1)
				return true;
			else if (val == 0 && index != len - 1) {
				return false;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		int[] a = new int[] { 2, 3, 1, 8, 4 };
		System.out.println(canJump(a));
	}
}
