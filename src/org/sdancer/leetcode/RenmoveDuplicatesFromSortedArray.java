package org.sdancer.leetcode;

public class RenmoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A){
		int dup =0;
		int len = A.length;
		for(int i=1;i+dup < len ; i++){
			while((i+dup)< len && A[i-1] == A[i+dup]){
				dup++;
			}
			if(i+dup < len){
				A[i] = A[i+dup];
			}
			
			if(dup!=0){
				A[len - dup] ='\0';
			}
		}
		return len - dup;
	}
	
}
