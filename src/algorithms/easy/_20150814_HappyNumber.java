package algorithms.easy;

/**My logic didn't work out, some bug in my logic, went online and found out it's actually pretty
 * simple.*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _20150814_HappyNumber {
	public static boolean isHappyFromOnline(int n){
		Set<Integer> set = new HashSet<Integer>();
		set.add(n);
		while(n != 1){
			int result = 0;
			while(n != 0){
				result += (int) Math.pow(n%10, 2);
				n /= 10;
			}
			if(!set.add(result)){
				return false;
			}
			set.add(result);
			n = result;
		}
		return true;
	}

	public static boolean isHappy(int n) {
		if(n == 1 || n == 0){
			return true;
		}
		else{
			int number = n;
			int squareSum = n;
			//use a hashtable, key is the square sum while value is the actual number whose digits are squared to sum
			//if both key and value match an entry in the map, that means we come back to from a loop, 
			//then we declare this number is NOT happy
			Map<Integer, Integer> resultStore = new HashMap<Integer, Integer>();
			resultStore.put(null, null);
			System.out.println("Before entering while loop.");
			while(squareSum != 1 && (!resultStore.containsKey(squareSum) && !resultStore.containsValue(number))){
				System.out.println("Truly entered while loop.");
				number = squareSum;//assign squareSum to number to begin a new while loop
				List<Integer> list = putNumberIntoDigitList(number);
				squareSum = calculateSquareSum(list);
				resultStore.put(squareSum, number);
				System.out.println("put " + squareSum + " and " + number + " into resultStore");
			}
			System.out.println("squareSum is: " + squareSum + " before ending program.");
			return false;	
		}
	}

	private static List<Integer> putNumberIntoDigitList(int n){
		List<Integer> list = new ArrayList<Integer>();
		if(n < 10){
			list.add(n);
		}
		else{
			while(n > 0){
				System.out.println("n is now: " + n);
				list.add(n%10);
				n = n/10;
			}	
		}
		return list;
	}

	private static int calculateSquareSum(List<Integer> list){
		int squareSum = 0;
		for(int num : list){
			squareSum += num*num;
		}
		return squareSum;
	}

	
	public static void main(String[] args) {
		System.out.println("Program started.");
//		System.out.println(isHappy(19));
		
		System.out.println(isHappyFromOnline(222));
		
		System.out.println("Program ended.");
	}

}
