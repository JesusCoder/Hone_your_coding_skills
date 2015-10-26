package algorithms.medium;

/* Copied this algorithm online, it's a pure math problem, didn't make it by myself. */
/* 思路：
1 求出所有的排序，直到k为止。至少Java会超时。
2 数学，找规律，不好想！  参考 http://fisherlei.blogspot.com/2013/04/leetcode-permutation-sequence-solution.html
假设有n个元素，第K个permutation是
a1, a2, a3, .....   ..., an
那么a1是哪一个数字呢？

那么这里，我们把a1去掉，那么剩下的permutation为
a2, a3, .... .... an, 共计n-1个元素。 n-1个元素共有(n-1)!组排列，那么这里就可以知道

设变量K1 = K
a1 = K1 / (n-1)!
// 第一位的选择下标

同理，a2的值可以推导为
K2 = K1 % (n-1)!
a2 = K2 / (n-2)!

。。。。。
K(n-1) = K(n-2) /2!
a(n-1) = K(n-1) / 1!

an = K(n-1) */

/* The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive. */

public class _20150916_PermutationSequence_revisit {

	public static String getPermutation(int n, int k) {
		int[] nums = new int[n + 1];
		int permcount = 1;
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1; // put 1, 2, 3 ... n into nums[]
			permcount *= (i + 1);
		}

		k--;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			permcount = permcount / (n - i);
			int idx = k / permcount;// the index that this position should
									// choose
			sb.append(nums[idx]);
			// left shift nums[] by one bit
			for (int j = idx; j < n - i; j++) {
				nums[j] = nums[j + 1];
			}
			k %= permcount;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// System.out.println(fact(7));
		System.out.println(getPermutation(3, 5));
		System.out.println("Program finished.");
	}
	/*
	 * Initially I wrote this factorial function for my own program, but it
	 * didn't work, so this function is not used in the current main method.
	 */
	private static int fact(int n) {
		int res = 0;
		if (n <= 1) {
			return n;
		}
		res = n * fact(n - 1);
		return res;
	}
}
