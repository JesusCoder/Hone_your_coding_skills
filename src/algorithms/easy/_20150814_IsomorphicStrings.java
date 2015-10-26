package algorithms.easy;

/**I made it! Super excited, completely out of my own mind, I came up with the algorithm, 
 * and then implemented it in 25 mins, then it got accepted! Cool! Praise the Lord!*/
import java.util.HashMap;
import java.util.Map;

public class _20150814_IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println("The end.");
    }

    public static void printOutHashMap(Map<Character, Character> hashMap) {
        for (Map.Entry<Character, Character> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        System.out.println("That's the end of the Map entries.");
    }

    public static boolean isIsomorphic(String s, String t) {
        // since we can assume s and t are of equal length, so we only need to
        // assert one of them for these two edge cases
        if (s.length() == 0 || s.length() == 1) {
            System.out.println("Both s and t are of length 0 or 1");
            return true;
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Map<Character, Character> mapper = new HashMap<Character, Character>();
        mapper.put(sCharArray[0], tCharArray[0]);
        for (int i = 1, j = 1; i < s.length() && j < t.length(); i++, j++) {
            if (mapper.containsKey(sCharArray[i])) {
                if (mapper.get(sCharArray[i]).equals(tCharArray[j])) {
                    continue;
                } else {
                    return false;
                }
            }
            if (!mapper.containsKey(sCharArray[i])) {
                if (mapper.containsValue(tCharArray[j])) {
                    return false;
                } else {
                    mapper.put(sCharArray[i], tCharArray[j]);
                }
            }
        }
        printOutHashMap(mapper);
        System.out.println("exits the for loop.");
        return true;
    }
}