package randomCodingProblems;

import java.util.ArrayList;
import java.util.List;

public class _randomTest {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		if(list.isEmpty()){
			System.out.println("It really is empty list!");
		}
		
		/**The following line shows that the range for 
		 * Integer is:
		 * -(2 to the power of 31) to (2 to the power of 31) -1
		 * while Long is:
		 * -(2 to the power of 63) to (2 to the power of 63) -1*/
		System.out.println(Integer.MAX_VALUE + "\t" + Integer.MIN_VALUE + "\n" + Long.MAX_VALUE + 
				"\t" + Long.MIN_VALUE + "\n" + Double.MAX_VALUE + "\t" + Double.MIN_VALUE + "\n" +
				Float.MAX_VALUE + "\t" + Float.MIN_VALUE);
	}

}
