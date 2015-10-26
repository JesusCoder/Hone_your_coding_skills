package algorithms.easy;

public class _20150918_MoveZeroes {
	/**Cool! I made this one accepted all by myself in less than 20 min, though this is an easy question! Praise the Lord!*/
	public void moveZeroes(int[] nums) {
		int[] newNums = new int[nums.length];
		int counter = 0, j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				newNums[j] = nums[i];
				j++;
			} else {
				counter++;
			}
		}
		while (counter > 0 && j < nums.length) {
			newNums[j] = 0;
			counter--;
			j++;
		}

		print(nums);
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = newNums[i];
		}

		/**
		 * just assigning the new array to the old one like the following line
		 * won't work! I don't understand why! It cannot be pass back to the
		 * main fuction, I was forced to use the above for loop to assign it one
		 * by one. TODO: I need to figure out why!
		 */
		// nums = newNums;
		print(newNums);
	}

	public static void main(String... args) {
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		print(nums);
		_20150918_MoveZeroes test = new _20150918_MoveZeroes();
		test.moveZeroes(nums);
		print(nums);
	}

	private static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		System.out.println();
	}
}
