package org.sdancer.leetcode;

import java.util.Arrays;

/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        boolean first=true;;
        for(int i=0; i<A.length;i++){
        	if(A[i] == target){
        		if(first){
        			res[0] = i;
        			first = false;
        		}
        		res[1] = i;
        	}
        		
        }
        return res;
    }
    
    public static void main(String[] args){
    	SearchForARange s = new SearchForARange();
    	int[] A = {5, 7, 7, 8, 8, 10};
    	int target = 8;
    	int[] res = s.searchRange(A, target);
    	for(int x:res){
    		System.out.print(x+"\t");
    	}
    }
}
