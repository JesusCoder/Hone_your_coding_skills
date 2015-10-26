/**
 * 
 */
package algorithms.easy;

/* Implemented this program all by myself, pretty easy to do it. Good job! */
/* Implement strStr(). 
 * Returns a pointer to the first occurrence of needle in haystack, 
 * or null if needle is not part of haystack. */

public class _20150916_ImplementStrStr_revisit {
	public static String strStr(String haystack, String needle) {
	       if(needle.length() > haystack.length()){
	    	   return null;
	       }
	       else if(haystack.length() == needle.length()){
	    	   if(haystack.equals(needle)){
	    		   return haystack;
	    	   }
	    	   else
	    	   {
	    		   return null;
	    	   }
	       }
	       else{
	    	   int start = 0;
	    	   for(; start < haystack.length() - needle.length(); start++){
	    		   if(haystack.substring(start, start + needle.length()).equals(needle)){
	    			   return haystack.substring(start);
	    		   }
	    	   }
	    	   return null;
	       }
    }
	public static void main(String args[]){
	String haystack = "abcdefg";
	String needle = "cde";
	System.out.println(strStr(haystack, needle));
	}
}

