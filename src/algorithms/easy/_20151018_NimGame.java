package algorithms.easy;

/**I copied both algorithms from discuss.*/
public class _20151018_NimGame {
/**This is because to win, the number can be anything but a factor of 4.*/
	public boolean canWinNim(int n) {
        return n%4 != 0;
    }
	
	/**Or, another way to look at this:*/
	public boolean canWinNim_alternative_way(int n) {
        if(n<=3) 
            return true;
        if(n%4==0)
            return false;
        return true;

    }
}
