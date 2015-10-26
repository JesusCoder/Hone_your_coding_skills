package algorithms.medium;

import java.util.HashSet;
import java.util.Set;

public class _20150814_WordBreak {
    /**
     * some initial thoughts: iterate thru all possible substring combinations
     * of s, for each combination see if there is such a string in wordDict, if
     * there's one, return true immediately, otherwise, after going thru all
     * possible substring combinations, return false.
     *
     * stopped halfway when trying to implement my own algorithm, cannot really
     * impl it. So I ended up using a solution from discuss.
     *
     * This is a very clever way of tackling this problem: It uses a boolean
     * array to hold each result of each possible word break/string combination,
     * if there is one that such wordDict set fit, it breaks immediately and
     * returns. if after it iterates thru the whole string, not finding such a
     * possibility, it will just return f[len+1].
     *
     */
    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leet0code", wordDict));
        System.out.println("program ended.");
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len + 1];
        f[0] = true;
        for (int i = 1; i < len + 1; i++) {
            System.out.println("Enters outer for loop: " + i + " time;");
            for (int j = 0; j < i; j++) {
                System.out.println("Enters inner for loop: " + j + " time;");
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    System.out
                            .println("Enters if statement with this substring(j,i): "
                                    + s.substring(j, i));
                    f[i] = true;
                    break;
                }
            }
        }
        return f[len];
    }

}
