/**
Totally had no clue, used two algorithm, both from discuss.
The latter one seems easier to follow.
 * 
 */
package algorithms.easy;

import java.util.BitSet;

/**
 * @author SteveSun
 *
 */
public class _20150814_CountPrime {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countPrimes(5) + "\nThe end.");
        System.out.println(countPrimes2(7) + "\nThe end.");
    }

    public static int countPrimes(int n) {
        int count = 0;
        boolean[] nums = new boolean[n];
        for (int i = 2; i < nums.length; i++) {
            System.out.println("nums[" + i + "] is: " + nums[i]);
            if (!nums[i]) {
                count++;
                for (int j = 2 * i; j < nums.length; j = j + i) {
                    nums[j] = true;
                }
            }
        }
        return count;
    }

    /**
     * Totally had no clue, used the answer from discuss board. BitSet is a
     * class in java sdk since 1.0 version, upon constructions, all bits are set
     * to false.
     */
    public static int countPrimes2(int n) {
        if (n <= 2)
            return 0;
        BitSet compounds = new BitSet(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (compounds.get(i) == false) {
                count++;
                for (int j = i + i; j < n; j += i)
                    compounds.set(j);
            }
        }
        return count;
    }
}
