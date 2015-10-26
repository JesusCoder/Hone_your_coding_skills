package algorithms.medium;

import java.util.Stack;

public class _20150914_BasicCalculator {

	public static int calculateMyOwnVersionDidNotWork(String s) {
		String filteredStr = filter(s);
		return doCalculate(filteredStr);
	}
	
	private static int doCalculate(String filteredStr) {
		if (filteredStr == null || filteredStr.length() == 0) {
			return 0;
		}
		// we get the first number first
		int j = 0, firstNumber = 0;
		while (j < filteredStr.length()
				&& !filteredStr.substring(j, j + 1).equals("+")
				&& !filteredStr.substring(j, j + 1).equals("-")) {
			j++;
			firstNumber = Integer.valueOf(filteredStr.substring(0, j));
		}

		int result = firstNumber, currentNum = 0, initialI = j;
		String currentSign = "";
		while (j < filteredStr.length()) {
			if (filteredStr.substring(j, j + 1).equals("+")) {
				currentSign = "+";
				j++;
			} else {
				currentSign = "-";
				j++;
			}
			initialI = j;
			while (j < filteredStr.length()
					&& !filteredStr.substring(j, j + 1).equals("+")
					&& !filteredStr.substring(j, j + 1).equals("-")) {
				j++;
				currentNum = Integer
						.valueOf(filteredStr.substring(initialI, j));
			}
			if (currentSign.equals("+")) {
				result += currentNum;
			} else {
				result -= currentNum;
			}
		}
		;
		return result;
	}

	private static String filter(String s) {
		String filteredStr = s.replace(" ", "")
				.replace("(", "")
				.replace(")", "");
		return s.equals(filteredStr) ? s : filteredStr;
	}

	public static void main(String[] args) {
//		String expr = "1 + 1";
//		String expr = "1 - 1";
//		String expr = "123 + 1";
//		String expr = "2-1 + 2";
//		String expr = "(1+(4+5+2)-3)+(6+8)";
//		String expr = "1-(3+5-2+(3+19-(3-1-4+(9-4-(4-(1+(3)-2)-5)+8-(3-5)-1)-4)-5)-4+3-9)-4-(3+2-5)-10";
		
		/**
		 * my own algorithm passed all above test cases but failed the following
		 * one, then I realized that there's a severe bug in my algorithm: the
		 * addition and subtraction need to happen in sequence, then I looked
		 * online, using stack is a common solution, then I just copied the
		 * answer from there. But many of the sub-logic is identical to my own, like
		 * using a while loop to get more than one-digit numbers.
		 */
		String expr = "2-(5-6)";

		System.out.println(filter(expr));
		
		System.out.println(calculate(expr));
	}

	public static int calculate(String s) {
		Stack<String> stack = new Stack<String>();
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				continue;
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int j = i + 1;
				while (j < s.length()) {
					if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
						j++;
						continue;
					} else
						break;
				}
				stack.push(s.substring(i, j));
				i = j - 1;
			} else if (s.charAt(i) == ')') {
				int temp = 0;
				while (!stack.peek().equals("(")) {
					String value = stack.pop();
					String sign = "+";
					if (!stack.isEmpty() && !stack.peek().equals("("))
						sign = stack.pop();
					switch (sign) {
					case "+":
						temp += Integer.valueOf(value);
						break;
					case "-":
						temp -= Integer.valueOf(value);
						break;
					}
				}
				if (stack.peek().equals("("))
					stack.pop();
				stack.push(String.valueOf(temp));
			} else {
				stack.push(s.substring(i, i + 1));
			}
		}
		while (!stack.isEmpty()) {
			String value = stack.pop();
			String sign = "+";
			if (!stack.isEmpty())
				sign = stack.pop();
			switch (sign) {
			case "+":
				result += Integer.valueOf(value);
				break;
			case "-":
				result -= Integer.valueOf(value);
				break;
			}
		}
		return result;
	}

}
