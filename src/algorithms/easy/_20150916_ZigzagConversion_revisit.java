/**
 * 
 */
package algorithms.easy;

/** The string "PAYPALISHIRING" is written in a zigzag 
 * pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". */ 

/** I solved this problem all by myself! WITHOUT any hints from online or anyone else!
 * I debugged step by step and finally make it accepted on Leetcode, very excited! */

public class _20150916_ZigzagConversion_revisit {
	public static String convert(String s, int nRows) {
		char [] a = s.toCharArray();
		int len = a.length;
		String res = "";
		if(len == 0)
			return res;
		else{
			if(nRows == 1)
				return s;
			else{
				char[][] workset = new char[nRows][len];
				//I'll use 'j' and 'k' to indicate its indexes
				
				/* Initialize this workset to all blank spaces, otherwise it
				 * will be full of gargabge (not blank spaces)*/
				for(int p = 0; p < nRows; p++){
					for(int q = 0; q < len; q++){
						workset[p][q] = ' ';
					}
				}
				workset[0][0] = a[0];
				//assign a[0] into workset[0][0] to start the following
				//while loop, then inside this while loop, for each time
				//when j == 0, it can start from j == 1
				int j = 0, k = 0, i = 1;
				while(i < len){
					if(j == 0){
						j++;
						for(; j < nRows && i < len; j++, i++){
							System.out.println(a[i]);
							System.out.println("j = " + j + "\t k = " + k);
							workset[j][k] = a[i];
						}
						j--;
						System.out.println("j = " + j + "\t k = " + k);
					}
					else{
						k++;j--;
						for(; j>= 0 && i < len; j--, i++, k++){
							System.out.println(a[i]);
							System.out.println("j = " + j + "\t k = " + k);
							workset[j][k] = a[i];
						}
						j++;k--;
						System.out.println("j = " + j + "\t k = " + k);
					}
				}
				

				for(int p = 0; p < nRows; p++){
					System.out.println();
					for(int q = 0; q < len; q++){
						System.out.print("p = " + p + "\tq = " + q + "\t" + workset[p][q] + "\n");
						if(workset[p][q] != ' '){
							res += workset[p][q];
						}
					}
				}
			}
		}
		System.out.println(res);
		return res;
	}
	public static void main(String args[]){
		String s = "PAYPALISHIRING";
		convert(s, 3);
	}
}
