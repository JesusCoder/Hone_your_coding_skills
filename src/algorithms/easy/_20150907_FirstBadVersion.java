package algorithms.easy;

public class _20150907_FirstBadVersion extends _20150814_VersionControl {
	/**This problem is just to use binary search to find the first one that is bad version.
	 * I'll implement it direclty in Leetcode OJ.*/
	
	//this one does not work, I ran out of patience and simply copied one from online.
//	public int firstBadVersion(int n) {
//		int start = 1, middle = n / 2, end = n;
//		if (isBadVersion(start)) {
//			return start;
//		} else if (isBadVersion(middle)) {
//			end = middle - 1;
//			middle = (start + end) / 2;
//		} else {
//			start = middle + 1;
//			middle = (start + end) / 2;
//		}
//		return start;
//	}
	
	//binary search
	public int firstBadVersion(int n) {
	    if(n < 1) {
	        return 0;
	    }
	    int start = 0;
	    int end = n;
	    while(start + 1 < end) {
	        int mid = start + (end - start)/2;
	        if(isBadVersion(mid)) {
	            end = mid;
	        }
	        else {
	            start = mid;
	        }
	    }
	    if(isBadVersion(start)) {
	        return start;
	    }
	    else if (isBadVersion(end)) {
	        return end;
	    }
	    return 0;
	}

}
