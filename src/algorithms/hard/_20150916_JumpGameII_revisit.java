package algorithms.hard;

/* Given an array of non-negative integers, 
 * you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. 
 (Jump 1 step from index 0 to 1, then 3 steps to the last index.) */

/* Finally made this code accepted on Leetcode after countless trial and error, but I didn't
 * give up and didn't ask for any help or seek solutions online. */

/* The tricky part in this problem is that before each jump, you must determine where is the
 * point that can bring you the largest jump distance, here's my algorithm to implement this idea:
 * 
 * Before each jump, set the variable "max" to the value of the current element, then check
 * the sum of the value of each element within the jump range of the current element AND its distance
 * between the current element and itself, then always jump to this point. */

public class _20150916_JumpGameII_revisit {
	public static int jump(int[] A) {
		int jumps = 0;
		int len = A.length;
		if (len == 0 || len == 1)
			return jumps;
		else if (len == 2) {
			return 1;
		} else {
			int val = A[0];
			int index = 0;
			if (val == 0)
				return jumps;
			while (index < len) {
				int max = A[index];
				if (max + index >= len - 1) {
					jumps++;
					return jumps;
				}
				System.out.println("max = " + max + "\tval = " + val
						+ "\tindex = " + index + "\tjumps = " + jumps);
				int tempMax = 0;
				int tempMaxIndex = 0;
				tempMax = A[index + 1];
				for (int i = 0; i < val; i++) {// here's another tricky part:
												// must set i = 0 as starting
												// point
					if (i + index >= len - 1) {
						jumps++;
						return jumps;
					}
					if (i + A[index + i + 1] >= tempMax) {// when set i = 0 as
															// starting point,
															// then here must
															// add 1
						tempMax = A[index + i + 1] + i;
						tempMaxIndex = index + i + 1;
					}
				}
				System.out.println("tempMax = " + tempMax);
				if (tempMax >= max) {// here must be great than or equal, equal
										// is very important!
					max = tempMax;
					index = tempMaxIndex;
				}
				val = A[index];
				jumps++;
				System.out.println("val = " + val + "\tindex = " + index
						+ "\tjumps = " + jumps);
			}
		}
		return jumps;
	}

	public static void main(String args[]) {
		int[] a = new int[] { 2, 3, 1, 1, 2, 5, 1, 20 };
		System.out.println(jump(a));

	}
}
