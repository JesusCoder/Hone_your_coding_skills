package algorithms.medium;

/* Very fruitful, I just made a few small modifications to the previous program, then amazingly, it
 * got accepted on Leetcode! 
 * 
 * First, I changed the counters j to start from i + 1
 * 								and k to start from j + 1;
 * and set both j and k less than len, this is sufficient, if I set j less than len - 1
 * and k less than len - 2, than these three pointers won't traverse thru the whole array.
 * 
 * Then I added this truncating code:
 * 
 * if(sum == target){
						return sum;
					}
					
	This fragment of code breaks the program from executing as soon as the sum of three elements
	equals the target, this way, it actually saves lots time to traverse thru the rest of the array
	which is meaningless, surprisingly, after this, it got accepted!
	
	Praise the Lord!*/

/* Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the
 * three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). */
public class _20150916_3SumClosest_revisit {
	public static int threeSumClosest(int[] num, int target) {
		int len = num.length;
		if(len == 0){
			return 0;
		}
		if(len <= 3){
			int sum = 0;
			for(int i : num){
				sum += i;
			}
			return sum;
		}


		int sum = num[0] + num[1] + num[2];
		int delta = Math.abs(target - sum);
		int minSum = sum;
		int i = 0, j = 0, k = 0;
		/* use the three pointers to indicate three numbers in this array */
		for(i = 0; i < len; i++){
			for(j = i + 1; j < len; j++){
				for(k = j + 1; k < len; k++){

					sum = num[i] + num[j] + num[k];
					if(sum == target){
						return sum;
					}
					if(Math.abs(sum - target) < delta){
						delta = Math.abs(sum - target);
						minSum = sum;
						System.out.println("num[" + i + "] = " + num[i] + 
								"\tnum[" + j + "] = " + num[j] + "\t" + 
								"num[" + k + "] = " + num[k] + "\tminSum = " + minSum);
					}

				}
			}
		}
		return minSum;
	}
	public static void main(String args[]){
		//test case 1 with target 18:
		//		int [] num = new int[]{-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};

		//test case 2 with target -76:
		//				int [] num = new int[]{4,-8,98,-51,73,12,-31,39,87,-16,20,69,18,59,54,44,-58
		//						,40,-36,22,-60,-8,-43,83,88,1,-25,71,-53,33,60,32,61,-5,28,38,-28,45
		//						,25,-68,-60,-87,5,-94,-19,-31,-35,-29,0,24,-62,-84,-7,-94,-89,12,97
		//						,-32,-89,92,-50,-54,-18,12,84,-81,-99,67,24,-4,-88,61,48,-17,-17,-44
		//						,65,-18,-47,68,0,-7,78,36,0,-15,23,-4,1,-74,-64,-53,-82,-10,34,-57,
		//						-93,65,-3,-73,-8,-59,96,35,51,49,92,-8,-4,-100,-64,5,-86,-26,71,60,
		//						-85,-42,-13,-10,17,-11,59,-14,-5,34,-36,24,9,78,48,24,-88,-46,-76,31
		//						,-47,-68,29,34,-97,-69,-41,-87,-42,96,0,-90,51,-55,57,86,-61,41,1,-90
		//						,-9,63,84,-32,80,-15,-12,0,72,-22,-6,-64,94,23,-80,-25,-37,-38,69,12,
		//						-64,-95,-65,5,15,-31,-68,-55,-100,-89,-24,-66,33,-14,-40,-50,-19,-79,-4};

		//test case 4 with target 136
//		int [] num = new int[]{-86,8,0,-79,-23,88,-26,-17,41,70,1,29,3,-52,-30,-31,14,
//				42,4,-52,-77,-39,91,-13,98,41,-16,-8,91,54,50,1,-22,45,30,20,-36,-41,
//				-48,-25,-3,76,69,-38,78,-45,-75,-57,55,-23,65,-23,69,60,85,-95,84,-73,
//				-21,43,35,58,66,6,-49,38,-5,46,-24,23,-23,63,55,-91,80,-73,-53,24,-77,
//				-5,-93,4,2,-71,23,2,-44,-19,33,73,9,-94,41,81,-14,43,27,3,-65,-89,0,
//				-100,-89,-76,95,0,-60,65,-77,85,-29,98,-8,18,41,-93,-64,51,-77,-39,
//				-75,-6,-65,0,-15,66,80,67,-96,26,-57,-43,-76,72,20,-55,-83,95,-65,22,
//				-47,-90,-83,13,6,81,-23,-50,-17,17,100,99,66,-62,-21,76,37,60,-88,64,
//				78,-90,67,-65,-62,55,-87,-75,-79,14,87,-100,-87,9,-98,0,-83,7,29,33,-87,
//				-50,6,-57,28,17,26,4};

		//test case 3 with target 100;
//				int [] num = new int[]{1, 2, 3, 90, 19};
				
				//test case 5 with target -207
				int [] num = new int[]{30,-5,-84,76,65,-77,50,9,-34,72,-79,57,-25,
						-49,-89,70,-7,30,-61,-31,36,-98,15,-76,-8,20,5,17,67,59,5,-6,
						-69,-36,8,87,-41,-29,23,4,51,84,67,86,-99,88,4,83,-97,-34,-52,
						49,-3,-47,82,23,-41,-89,73,-75,17,-41,22,27,-7,22,14,84,-48,9,
						48,62,4,64,-24,81,-66,29,10,72,51,-9,-98,-15,56,-41,-57,-26,86,
						71,-60,-17,38,-80,35,-98,78,17,-66,53,22,-58,63,-39,-39,24,26,
						-91,-53,-44,-53,40,81,39,21,-100,-52,-55,-7,-95,-69,11,-25,-91,
						-37,33,8,88,-97,0,17,27,-90,15,-8,10,95,38,-23,-65,-96};
		System.out.println(threeSumClosest(num, -207));
		System.out.println("Program finished.");
	}
	
	/* Originally I was going to solve this following leetcode problem here, but my algorithm is buggy,
	 * 
	 * it can pass 105/119 test cases 
	 * 
	 * on Leetcode but failed the test case in the main program here,
	 * because of the fundamental defect in my algorithm, I always bundle two elements together,
	 * this is the source of the bug, the three elements can be completely allocated away from each other,
	 * so I'll rewrite my program in another Java class. */
	public static int threeSumClosest_myOwnTrial(int[] num, int target) {
		int len = num.length;
		if(len == 0){
			return 0;
		}
		if(len <= 3){
			int sum = 0;
			for(int i : num){
				sum += i;
			}
			return sum;
		}

		int sum = num[0] + num[1] + num[2];
		int minSum = sum;
		int delta = Math.abs(sum - target);
		int i, j;
		/* use these two pointers to traverse this array, the pointer i
		 * points two adjacent numbers in the array, i.e. the ith number
		 * and the (i+1)th number while the pointer j moves around to point
		 * to the third number. */
		for(i = 0; i < len - 1; i++){
			int twoSum = num[i] + num[i+1];
			for(j = 0; j < len; j++){
				if(j != i && j != (i+1)){
					sum = twoSum + num[j];
					if(Math.abs(sum - target) < delta){
						delta = Math.abs(sum - target);
						minSum = sum;
					System.out.println("num[" + i + "] = " + num[i] + "\tnum[" + (i+1) +"] = " + num[i+1]
				+ "\tnum[" + j + "]" + num[j] + "\tdelta = " + delta + "\tminSum = " + minSum);
					}
				}
			}	
		}

		return minSum;
	}
	
	
	/* OMG, this program runs perfectly, I believe it can tackle all cases and return the correct result,
	 * but the problem is that it's not efficient enought so that it gets rejected on Leetcode b/c it
	 * exceeds runtime limit!
	 * 
	 * I'll write a completely new program in another Java class! */
	public static int threeSumClosest_myOwnTrialII(int[] num, int target) {
		int len = num.length;
		if(len == 0){
			return 0;
		}
		if(len <= 3){
			int sum = 0;
			for(int i : num){
				sum += i;
			}
			return sum;
		}


		int sum = num[0] + num[1] + num[2];
		int delta = Math.abs(target - sum);
		int minSum = sum;
		int i = 0, j = 0, k = 0;
		/* use the three pointers to indicate three numbers in this array */
		for(i = 0; i < len; i++){
			for(j = 0; j < len; j++){
				if(i != j){
					for(k = 0; k < len; k++){
						if(i != j && i != k && j != k){
							sum = num[i] + num[j] + num[k];
							if(Math.abs(sum - target) < delta){
								delta = Math.abs(sum - target);
								minSum = sum;
								System.out.println("num[" + i + "] = " + num[i] + 
										"\tnum[" + j + "] = " + num[j] + "\t" + 
										"num[" + k + "] = " + num[k] + "\tminSum = " + minSum);
							}
						}
					}
				}
			}
		}
		return minSum;
	}
}
