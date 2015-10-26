/**
 * 
 */
package algorithms.medium;

import java.util.HashMap;
/* Leetcode: Given an array of integers, 
 * every element appears three times except for one. Find that single one.
 * 
 * I implemented this code all by myself! Hooray! */

public class _20150918_SingleNumberII_revisit {
	public static int singleNumber(int[] A) {
		int res;
		int len = A.length;
                if(len == 1)
                    return A[0];
                else if(len <= 3)
			return 0;
		HashMap<Integer, Integer> map = new HashMap();
		for(int i = 0; i < len; i++){
			if(!map.containsKey(A[i])){
				map.put(A[i], 1);
			}
			else if(map.get(A[i]) == 1){
				map.put(A[i], map.get(A[i]) + 1);
			}
			else if(map.get(A[i]) == 2){
				map.remove(A[i]);
			}
		}
		int [] temp = new int[len];
		int counter = 0;
		for(int i : map.keySet()){
			temp[counter++] = i;
		}
		res = temp[0];
		return res;
	}
	public static void main(String... args){
		int [] a = new int[]{1, 2, 3, 3, 2, 1, 4, 4, 1, 3, 2};
		System.out.println(singleNumber(a));
	}
}
