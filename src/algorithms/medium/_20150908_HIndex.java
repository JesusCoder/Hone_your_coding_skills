package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import TreeUtils.CommonUtils;

public class _20150908_HIndex {
	
	//give up on this one, didn't work it out
//	public static int hIndex(int[] citations) {
//		Arrays.sort(citations);
//		
//		
//		List<Integer> reversedIndices = new ArrayList<Integer>();
//		for(int i = 1; i <= citations.length; i++){
//			reversedIndices.add(0, i);
//		}
//		
//		Map<Integer, Integer> map = new HashMap<>();
//		for(int i = 1; i <= citations.length; i++){
//			map.put(citations[i-1], reversedIndices.get(i-1));
//		}
//		
//		for (int i : map.values()) {
//			CommonUtils.print(i + " ");
//		}
//		
//		for(int i : map.keySet()){
//			while(i <= map.get(i)){
//				
//			}
//		}
//		
//		return 1;
//	}
	
	//copied this one from discuss:
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;

        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
    }
	
	public static void main(String... args){
		int[] citations = new int[6];
		citations = new int[]{2, 5, 6, 9, 10, 12, 15};
		System.out.println(hIndex(citations));
	}

}
