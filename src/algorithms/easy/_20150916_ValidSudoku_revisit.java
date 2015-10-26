/**
 * 
 */
package algorithms.easy;

/** Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, 
 * where empty cells are filled with the character '.'.*/

/** My algorith: check three times:
 * first time, check if each column is valid;
 * second time, check if each row is valid;
 * third time, check if each small block is valid
 * 
 * But I got stuck: after the first traversal, the num[] values cannot be erased and reused,
 * can someone help me out please?!? 
 * 
 * I figured this problem out all by myself, I was inspired all of a sudden after one night sleep,
 * I moved 
 * 	boolean [] num = new boolean[10];
 * this statement inside of each loop, so that each time, a completely new boolean array is
 * initialized, then I don't need to worry about if they can be erased or not, and eventually
 * this code got accepted on Leetcode! Hooray! */

public class _20150916_ValidSudoku_revisit {
	public static boolean isValidSudoku(char[][] board) {
		int row = board.length;
		int col = board[0].length;
		
		/* check each column first, see if each column has distinct '.' and 0 to 9 */
		for(int j = 0; j < col; j++){
			boolean [] num = new boolean[10];
			/* use this array's indexes to indicate '.', '0', '1', '2', until '9' */

			for(boolean elem : num){
				elem = false;//set them to false after each row is traversed
			}
			for(int i = 0; i < row; i++){
				if(board[i][j] == '.'){//it should allow multiple '.' in one row
					num[0] = true;
				}
				else{
					System.out.print(Character.getNumericValue(board[i][j]) + " ");
					if(num[Character.getNumericValue(board[i][j])] == true)
						return false;					
					else
						num[Character.getNumericValue(board[i][j])] = true;
				}
			}
			for(boolean elem : num){
				System.out.print(elem + " ");
			}
			System.out.println();
		}
		
		System.out.println("It passes the column check, now begins the row check.\n");
		/* if it can pass the above test, then check if each row has distinct '.' and 0 to 9 */
		for(int i = 0; i < row; i++){
			boolean [] num = new boolean[10];
			/* use this array's indexes to indicate '.', '0', '1', '2', until '9' */

			for(boolean elem : num){
				elem = false;//set them to false after each row is traversed
			}
			for(int j = 0; j < col; j++){
				if(board[i][j] == '.'){//it should allow multiple '.' in one row
					num[0] = true;
				}
				else{
					System.out.print(Character.getNumericValue(board[i][j]) + " ");
					if(num[Character.getNumericValue(board[i][j])] == true)
						return false;					
					else
						num[Character.getNumericValue(board[i][j])] = true;
				}
			}
			for(boolean elem : num){
				System.out.print(elem + " ");
			}
			System.out.println();
		}
//		/* if it can pass the above test, then we test if each block has distinct 0~9 and '.' */
//		System.out.println("It passes the row check, now begins the block check.\n");
//		int rowStart = 0, colStart = 0;
//		int i = rowStart, j = colStart;
//		while(i <= 9 && j != 9){
//			boolean [] num = new boolean[10];
//			/* use this array's indexes to indicate '.', '0', '1', '2', until '9' */
//
//			for(boolean elem : num){
//				elem = false;//initialize them to false after each small block is traversed
//			}
//			for(i = rowStart; i < rowStart+3; i++){
//				for(j = colStart; j < colStart + 3; j++){
//					System.out.println("i = " + i + "\tj = " + j);
//					if(board[i][j] == '.'){//it should allow multiple '.' in one row
//						num[0] = true;
//					}
//					else{
//						if(num[Character.getNumericValue(board[i][j])] == true)
//							return false;					
//						else
//							num[Character.getNumericValue(board[i][j])] = true;
//					}
//				}
//			}
//			for(boolean elem : num){
//				System.out.print(elem + " ");
//			}
//			System.out.println();
//			if(i == 3 && j == 3){
//				colStart += 3;
//			}
//			else if(i == 3 && j ==6){
//				colStart += 3;
//			}
//			else if(i == 3 && j == 9){
//				rowStart += 3;
//				colStart = 0;
//				j--;
//			}
//			else if(i == 6 && j == 3){
//				colStart +=3;
//			}
//			else if(i == 6 && j == 6){
//				colStart += 3;
//			}
//			else if(i == 6 && j == 9){
//				rowStart += 3;
//				colStart = 0;
//				j--;
//			}
//			else if(i == 9 && j == 3){
//				colStart += 3;
//			}
//			else if(i == 9 && j == 6){
//				colStart += 3;
//			}
//		}
		return true;
	}
	public static void main(String args[]){
		char[][] board = new char[][]{
				{'4', '3', '5', '2', '6', '9', '7', '8', '1'},
				{'6', '8', '2', '5', '7', '1', '4', '9', '3'},
				{'1', '9', '7', '8', '3', '4', '5', '6', '2'},
				{'8', '2', '6', '1', '9', '5', '3', '4', '7'},
				{'3', '7', '4', '6', '8', '2', '9', '1', '5'},
				{'9', '5', '1', '7', '4', '3', '6', '2', '8'},
				{'5', '1', '9', '3', '2', '6', '8', '7', '4'},
				{'2', '4', '8', '9', '5', '7', '1', '3', '6'},
				{'7', '6', '3', '4', '1', '8', '2', '5', '9'},
		};
		System.out.println(isValidSudoku(board));
	}
}
