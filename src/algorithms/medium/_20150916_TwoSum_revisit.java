package algorithms.medium;

import java.util.HashMap;

/** Given an array of integers, find two numbers such 
 * that they add up to a specific target number. The function twoSum
 * should return indices of the two numbers such that 
 * they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2*/

/*Assume this array is sorted.*/

public class _20150916_TwoSum_revisit {

	/*The major idea of this algorithm is that:
	 *try to find the element that equals or nearest to target/2,
	 *then use two pointers, one on either side of this element, to add
	 *them up, see if they can equal to target, if greater than the target,
	 *decrease the lower pointer, if smaller than the target, increase the
	 *upper pointer, until reaches either end of this array.*/
	private static int binarySearch(int array[], int left, int right, int target)
	{ 
		int middle = (left + right)/2;
		/*This middle is the middle index in the array*/

		if(target/2 == array[middle])
			return middle;
		else
			if (target/2 < array[middle] && left < right - 1)
				/* Have the second condition "left < right - 1"
				 * is very important, it controls the scenario that
				 * when this target/2 doesn't exist in the array,
				 * it searches to the point that it won't be able to
				 * further divide into half, at this scenario, we just
				 * exit this recursive function and return middle.*/
			{
				right = middle;
				return  binarySearch(array, left, right, target);
			}
			else if (target/2 > array[middle] && left < right - 1)
			{
				left = middle;
				return 	binarySearch(array, left, right, target);
			}
			else 
				return middle;}

	public static boolean twoSumFunc(int array[], int target){

		int lower, upper;/*define two pointers (indices) pointing to two numbers, each either side of target/2*/
		lower = binarySearch(array, 0, array.length - 1, target);
		/*Call binarySearch here.*/
		upper = lower + 1;
		if(upper >= array.length)
			return false;
		else 
			while(lower >= 0 && upper < array.length)
			{
				if(array[lower] + array[upper] == target){
					lower +=1;
					upper +=1;
					/*We add both pointers by one to meet this particular problem's
					 * requirement, all index starts from 1 instead of 0.*/
					System.out.println("index1 = " + lower + " index2 = " + upper);
					System.out.println("The elements " + array[lower-1] 
							+ " and " + array[upper-1]+ " sum up to the target.");
					/*Inside this print statement, we decrease the array index by 1
					 * in order to pass in the real index to print out the correct values.*/
					return true;}

				else if (array[lower] + array[upper] < target){
					upper += 1;
				}
				else if (array[lower] + array[upper] > target){
					lower -= 1;
				}
			}
		System.out.println("There are not such elements in the array" +
				" that can sum up to the target.");
		return false;
	}
	
	public static void main(String args[]){
		int [] a = {2, 7, 11, 15, 17, 19, 32, 34, 45, 56, 58, 63, 76, 78, 93};
		int t = 9;
		System.out.println(twoSumFunc(a, t));
	}
	
	/*This is the same question as in twoSum.java,
	 * but this time we used HashMap to solve it, it's much more efficient!
	 *
	 *It was right thru this example did I TRUELY realize the O(1) access time
	 *in HashMap! It's really amazing!*/

	/*The KEY thing to bare in mind is that in HashMap, 
	 *you can only get values using key, NOT the other way around!*/

	/*Using HashMap.get(key) method, you can only put key inside the parenthesis to get its corresponding value,
	 *never the other way around!
	 *
	 *So if you want to traverse all the keys in the HashMap, you need to use a for loop as follows:
	 *
	 *for(int key : HashMap.keySet())
	 *System.out.print(key);
	 *
	 *to print out all its keys in this HashMap.*/


	/*Difference between ASCII code and Unicode:
	 * 
	 *They're two different ways of giving code to each symbol, including metacharacters, numbers, chars, etc.
	 *ASCII: 2 to the power of 8: 256 , means there're possibly 256 unique addresses that can be used to represent stuff.
	 *Unicode: 2 to the power of 16: 65536, means there're possibly 65536 unique address that can be used to represent stuff.*/
	
	public static boolean findTwoNum(int []a, int target)
	{
		HashMap<Integer, Integer> intHashMap = new HashMap();
		/*First Integer is the element value in this array, second Integer is the index of that element.*/
		for(int i = 0; i < a.length; i++){
			intHashMap.put(a[i], i);
		}

		//		for(int i = 0; i < a.length; i++){
		//			System.out.print(intHashMap.get(a[i]) + " ");
		//		}
		//		System.out.print("\n");
		//		for(int key: intHashMap.keySet()){
		//			System.out.print(key + ":" + intHashMap.get(key) + " ");
		//		}
		//		System.out.print("\n");

		for(int i = 0; i < a.length; i++)
		{		
			if(intHashMap.containsKey(target - a[i]) && i != intHashMap.get(target - a[i])){
				/*We have the second condition there to test that it's not adding itself to find the target,
				 *because we first put all values in the array into the HashMap, and then we try to find
				 *such a pair, for example, if target is 30, there's only one 15 in the array, it's possible that
				 *15 added itself to get the target value, but there's actually no other 15 in the array, so
				 *we need to prevent such situations from happening.*/
				System.out.println("index1 = " + (i+1));
				/*The problem requires the index starts from 1, so we added 1 to it.*/
				System.out.println("index2 = " + (intHashMap.get(target - a[i]) + 1));
				return true ;

			}
		}
		{
			System.out.println("No such two elements exist in the array that can add up to the target.");
			return false;
		}
	}
}
