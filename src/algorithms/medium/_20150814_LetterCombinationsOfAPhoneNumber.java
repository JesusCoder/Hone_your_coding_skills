package algorithms.medium;

/** Abandoned my own algorithm, not implementable with it.
 * I'm going to use the one on discuss: 
 * { @link https://leetcode.com/discuss/29404/easy-understand-java-solution} 
 * Need to digest this solution further. */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _20150814_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23") + "\nThe end!");
    }

    public static List<String> letterCombinations(String digits) {
        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<String>();

        if (digits.length() == 0)
            return result;

        result.add("");
        for (int i = 0; i < digits.length(); i++)
            result = combine(digitletter[digits.charAt(i) - '0'], result);

        return result;
    }

    /** This is the key to the algorithm online. I need to understand it! */
    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < digit.length(); i++)
            for (String x : l)
                result.add(x + digit.charAt(i));

        return result;
    }

    @Deprecated
    public List<String> deprecatedLetterCombinations(String digits) {
        // Map<Character, ArrayList<Character>> map = generateMap();
        // List<String> result = new ArrayList<String>();
        // char[] digitsArray = digits.toCharArray();

        return null;
    }

    @Deprecated
    private static Map<Character, ArrayList<Character>> generateMap() {
        Map<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();

        ArrayList<Character> list2 = new ArrayList<Character>();
        list2.add('a');
        list2.add('b');
        list2.add('c');
        map.put('2', list2);

        ArrayList<Character> list3 = new ArrayList<Character>();
        list3.add('d');
        list3.add('e');
        list3.add('f');
        map.put('3', list3);

        ArrayList<Character> list4 = new ArrayList<Character>();
        list4.add('g');
        list4.add('h');
        list4.add('i');
        map.put('4', list4);

        ArrayList<Character> list5 = new ArrayList<Character>();
        list5.add('j');
        list5.add('k');
        list5.add('l');
        map.put('5', list5);

        ArrayList<Character> list6 = new ArrayList<Character>();
        list6.add('m');
        list6.add('n');
        list6.add('o');
        map.put('6', list6);

        ArrayList<Character> list7 = new ArrayList<Character>();
        list7.add('p');
        list7.add('q');
        list7.add('r');
        list7.add('s');
        map.put('7', list7);

        ArrayList<Character> list8 = new ArrayList<Character>();
        list8.add('t');
        list8.add('u');
        list8.add('v');
        map.put('8', list8);

        ArrayList<Character> list9 = new ArrayList<Character>();
        list9.add('w');
        list9.add('x');
        list9.add('y');
        list9.add('z');
        map.put('9', list9);

        return map;

    }
}
